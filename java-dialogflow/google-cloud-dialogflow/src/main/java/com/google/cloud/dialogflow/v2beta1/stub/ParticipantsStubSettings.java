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

package com.google.cloud.dialogflow.v2beta1.stub;

import static com.google.cloud.dialogflow.v2beta1.ParticipantsClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.ParticipantsClient.ListParticipantsPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.ParticipantsClient.ListSuggestionsPagedResponse;

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
import com.google.api.gax.rpc.StreamingCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2beta1.AnalyzeContentRequest;
import com.google.cloud.dialogflow.v2beta1.AnalyzeContentResponse;
import com.google.cloud.dialogflow.v2beta1.BidiStreamingAnalyzeContentRequest;
import com.google.cloud.dialogflow.v2beta1.BidiStreamingAnalyzeContentResponse;
import com.google.cloud.dialogflow.v2beta1.CompileSuggestionRequest;
import com.google.cloud.dialogflow.v2beta1.CompileSuggestionResponse;
import com.google.cloud.dialogflow.v2beta1.CreateParticipantRequest;
import com.google.cloud.dialogflow.v2beta1.GetParticipantRequest;
import com.google.cloud.dialogflow.v2beta1.ListParticipantsRequest;
import com.google.cloud.dialogflow.v2beta1.ListParticipantsResponse;
import com.google.cloud.dialogflow.v2beta1.ListSuggestionsRequest;
import com.google.cloud.dialogflow.v2beta1.ListSuggestionsResponse;
import com.google.cloud.dialogflow.v2beta1.Participant;
import com.google.cloud.dialogflow.v2beta1.StreamingAnalyzeContentRequest;
import com.google.cloud.dialogflow.v2beta1.StreamingAnalyzeContentResponse;
import com.google.cloud.dialogflow.v2beta1.SuggestArticlesRequest;
import com.google.cloud.dialogflow.v2beta1.SuggestArticlesResponse;
import com.google.cloud.dialogflow.v2beta1.SuggestFaqAnswersRequest;
import com.google.cloud.dialogflow.v2beta1.SuggestFaqAnswersResponse;
import com.google.cloud.dialogflow.v2beta1.SuggestKnowledgeAssistRequest;
import com.google.cloud.dialogflow.v2beta1.SuggestKnowledgeAssistResponse;
import com.google.cloud.dialogflow.v2beta1.SuggestSmartRepliesRequest;
import com.google.cloud.dialogflow.v2beta1.SuggestSmartRepliesResponse;
import com.google.cloud.dialogflow.v2beta1.Suggestion;
import com.google.cloud.dialogflow.v2beta1.UpdateParticipantRequest;
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
 * Settings class to configure an instance of {@link ParticipantsStub}.
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
 * of createParticipant:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ParticipantsStubSettings.Builder participantsSettingsBuilder =
 *     ParticipantsStubSettings.newBuilder();
 * participantsSettingsBuilder
 *     .createParticipantSettings()
 *     .setRetrySettings(
 *         participantsSettingsBuilder
 *             .createParticipantSettings()
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
 * ParticipantsStubSettings participantsSettings = participantsSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ParticipantsStubSettings extends StubSettings<ParticipantsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/dialogflow")
          .build();

  private final UnaryCallSettings<CreateParticipantRequest, Participant> createParticipantSettings;
  private final UnaryCallSettings<GetParticipantRequest, Participant> getParticipantSettings;
  private final PagedCallSettings<
          ListParticipantsRequest, ListParticipantsResponse, ListParticipantsPagedResponse>
      listParticipantsSettings;
  private final UnaryCallSettings<UpdateParticipantRequest, Participant> updateParticipantSettings;
  private final UnaryCallSettings<AnalyzeContentRequest, AnalyzeContentResponse>
      analyzeContentSettings;
  private final StreamingCallSettings<
          StreamingAnalyzeContentRequest, StreamingAnalyzeContentResponse>
      streamingAnalyzeContentSettings;
  private final StreamingCallSettings<
          BidiStreamingAnalyzeContentRequest, BidiStreamingAnalyzeContentResponse>
      bidiStreamingAnalyzeContentSettings;
  private final UnaryCallSettings<SuggestArticlesRequest, SuggestArticlesResponse>
      suggestArticlesSettings;
  private final UnaryCallSettings<SuggestFaqAnswersRequest, SuggestFaqAnswersResponse>
      suggestFaqAnswersSettings;
  private final UnaryCallSettings<SuggestSmartRepliesRequest, SuggestSmartRepliesResponse>
      suggestSmartRepliesSettings;
  private final UnaryCallSettings<SuggestKnowledgeAssistRequest, SuggestKnowledgeAssistResponse>
      suggestKnowledgeAssistSettings;
  private final PagedCallSettings<
          ListSuggestionsRequest, ListSuggestionsResponse, ListSuggestionsPagedResponse>
      listSuggestionsSettings;
  private final UnaryCallSettings<CompileSuggestionRequest, CompileSuggestionResponse>
      compileSuggestionSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<
          ListParticipantsRequest, ListParticipantsResponse, Participant>
      LIST_PARTICIPANTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListParticipantsRequest, ListParticipantsResponse, Participant>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListParticipantsRequest injectToken(
                ListParticipantsRequest payload, String token) {
              return ListParticipantsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListParticipantsRequest injectPageSize(
                ListParticipantsRequest payload, int pageSize) {
              return ListParticipantsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListParticipantsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListParticipantsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Participant> extractResources(ListParticipantsResponse payload) {
              return payload.getParticipantsList();
            }
          };

  private static final PagedListDescriptor<
          ListSuggestionsRequest, ListSuggestionsResponse, Suggestion>
      LIST_SUGGESTIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListSuggestionsRequest, ListSuggestionsResponse, Suggestion>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSuggestionsRequest injectToken(
                ListSuggestionsRequest payload, String token) {
              return ListSuggestionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSuggestionsRequest injectPageSize(
                ListSuggestionsRequest payload, int pageSize) {
              return ListSuggestionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSuggestionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSuggestionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Suggestion> extractResources(ListSuggestionsResponse payload) {
              return payload.getSuggestionsList();
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
          ListParticipantsRequest, ListParticipantsResponse, ListParticipantsPagedResponse>
      LIST_PARTICIPANTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListParticipantsRequest, ListParticipantsResponse, ListParticipantsPagedResponse>() {
            @Override
            public ApiFuture<ListParticipantsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListParticipantsRequest, ListParticipantsResponse> callable,
                ListParticipantsRequest request,
                ApiCallContext context,
                ApiFuture<ListParticipantsResponse> futureResponse) {
              PageContext<ListParticipantsRequest, ListParticipantsResponse, Participant>
                  pageContext =
                      PageContext.create(
                          callable, LIST_PARTICIPANTS_PAGE_STR_DESC, request, context);
              return ListParticipantsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListSuggestionsRequest, ListSuggestionsResponse, ListSuggestionsPagedResponse>
      LIST_SUGGESTIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSuggestionsRequest, ListSuggestionsResponse, ListSuggestionsPagedResponse>() {
            @Override
            public ApiFuture<ListSuggestionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSuggestionsRequest, ListSuggestionsResponse> callable,
                ListSuggestionsRequest request,
                ApiCallContext context,
                ApiFuture<ListSuggestionsResponse> futureResponse) {
              PageContext<ListSuggestionsRequest, ListSuggestionsResponse, Suggestion> pageContext =
                  PageContext.create(callable, LIST_SUGGESTIONS_PAGE_STR_DESC, request, context);
              return ListSuggestionsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to createParticipant. */
  public UnaryCallSettings<CreateParticipantRequest, Participant> createParticipantSettings() {
    return createParticipantSettings;
  }

  /** Returns the object with the settings used for calls to getParticipant. */
  public UnaryCallSettings<GetParticipantRequest, Participant> getParticipantSettings() {
    return getParticipantSettings;
  }

  /** Returns the object with the settings used for calls to listParticipants. */
  public PagedCallSettings<
          ListParticipantsRequest, ListParticipantsResponse, ListParticipantsPagedResponse>
      listParticipantsSettings() {
    return listParticipantsSettings;
  }

  /** Returns the object with the settings used for calls to updateParticipant. */
  public UnaryCallSettings<UpdateParticipantRequest, Participant> updateParticipantSettings() {
    return updateParticipantSettings;
  }

  /** Returns the object with the settings used for calls to analyzeContent. */
  public UnaryCallSettings<AnalyzeContentRequest, AnalyzeContentResponse> analyzeContentSettings() {
    return analyzeContentSettings;
  }

  /** Returns the object with the settings used for calls to streamingAnalyzeContent. */
  public StreamingCallSettings<StreamingAnalyzeContentRequest, StreamingAnalyzeContentResponse>
      streamingAnalyzeContentSettings() {
    return streamingAnalyzeContentSettings;
  }

  /** Returns the object with the settings used for calls to bidiStreamingAnalyzeContent. */
  public StreamingCallSettings<
          BidiStreamingAnalyzeContentRequest, BidiStreamingAnalyzeContentResponse>
      bidiStreamingAnalyzeContentSettings() {
    return bidiStreamingAnalyzeContentSettings;
  }

  /** Returns the object with the settings used for calls to suggestArticles. */
  public UnaryCallSettings<SuggestArticlesRequest, SuggestArticlesResponse>
      suggestArticlesSettings() {
    return suggestArticlesSettings;
  }

  /** Returns the object with the settings used for calls to suggestFaqAnswers. */
  public UnaryCallSettings<SuggestFaqAnswersRequest, SuggestFaqAnswersResponse>
      suggestFaqAnswersSettings() {
    return suggestFaqAnswersSettings;
  }

  /** Returns the object with the settings used for calls to suggestSmartReplies. */
  public UnaryCallSettings<SuggestSmartRepliesRequest, SuggestSmartRepliesResponse>
      suggestSmartRepliesSettings() {
    return suggestSmartRepliesSettings;
  }

  /** Returns the object with the settings used for calls to suggestKnowledgeAssist. */
  public UnaryCallSettings<SuggestKnowledgeAssistRequest, SuggestKnowledgeAssistResponse>
      suggestKnowledgeAssistSettings() {
    return suggestKnowledgeAssistSettings;
  }

  /**
   * Returns the object with the settings used for calls to listSuggestions.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public PagedCallSettings<
          ListSuggestionsRequest, ListSuggestionsResponse, ListSuggestionsPagedResponse>
      listSuggestionsSettings() {
    return listSuggestionsSettings;
  }

  /**
   * Returns the object with the settings used for calls to compileSuggestion.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<CompileSuggestionRequest, CompileSuggestionResponse>
      compileSuggestionSettings() {
    return compileSuggestionSettings;
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

  public ParticipantsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcParticipantsStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonParticipantsStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(ParticipantsStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ParticipantsStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ParticipantsStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected ParticipantsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createParticipantSettings = settingsBuilder.createParticipantSettings().build();
    getParticipantSettings = settingsBuilder.getParticipantSettings().build();
    listParticipantsSettings = settingsBuilder.listParticipantsSettings().build();
    updateParticipantSettings = settingsBuilder.updateParticipantSettings().build();
    analyzeContentSettings = settingsBuilder.analyzeContentSettings().build();
    streamingAnalyzeContentSettings = settingsBuilder.streamingAnalyzeContentSettings().build();
    bidiStreamingAnalyzeContentSettings =
        settingsBuilder.bidiStreamingAnalyzeContentSettings().build();
    suggestArticlesSettings = settingsBuilder.suggestArticlesSettings().build();
    suggestFaqAnswersSettings = settingsBuilder.suggestFaqAnswersSettings().build();
    suggestSmartRepliesSettings = settingsBuilder.suggestSmartRepliesSettings().build();
    suggestKnowledgeAssistSettings = settingsBuilder.suggestKnowledgeAssistSettings().build();
    listSuggestionsSettings = settingsBuilder.listSuggestionsSettings().build();
    compileSuggestionSettings = settingsBuilder.compileSuggestionSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for ParticipantsStubSettings. */
  public static class Builder extends StubSettings.Builder<ParticipantsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateParticipantRequest, Participant>
        createParticipantSettings;
    private final UnaryCallSettings.Builder<GetParticipantRequest, Participant>
        getParticipantSettings;
    private final PagedCallSettings.Builder<
            ListParticipantsRequest, ListParticipantsResponse, ListParticipantsPagedResponse>
        listParticipantsSettings;
    private final UnaryCallSettings.Builder<UpdateParticipantRequest, Participant>
        updateParticipantSettings;
    private final UnaryCallSettings.Builder<AnalyzeContentRequest, AnalyzeContentResponse>
        analyzeContentSettings;
    private final StreamingCallSettings.Builder<
            StreamingAnalyzeContentRequest, StreamingAnalyzeContentResponse>
        streamingAnalyzeContentSettings;
    private final StreamingCallSettings.Builder<
            BidiStreamingAnalyzeContentRequest, BidiStreamingAnalyzeContentResponse>
        bidiStreamingAnalyzeContentSettings;
    private final UnaryCallSettings.Builder<SuggestArticlesRequest, SuggestArticlesResponse>
        suggestArticlesSettings;
    private final UnaryCallSettings.Builder<SuggestFaqAnswersRequest, SuggestFaqAnswersResponse>
        suggestFaqAnswersSettings;
    private final UnaryCallSettings.Builder<SuggestSmartRepliesRequest, SuggestSmartRepliesResponse>
        suggestSmartRepliesSettings;
    private final UnaryCallSettings.Builder<
            SuggestKnowledgeAssistRequest, SuggestKnowledgeAssistResponse>
        suggestKnowledgeAssistSettings;
    private final PagedCallSettings.Builder<
            ListSuggestionsRequest, ListSuggestionsResponse, ListSuggestionsPagedResponse>
        listSuggestionsSettings;
    private final UnaryCallSettings.Builder<CompileSuggestionRequest, CompileSuggestionResponse>
        compileSuggestionSettings;
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
      definitions.put(
          "retry_policy_2_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_3_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_8_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(60000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(220000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(220000L))
              .setTotalTimeoutDuration(Duration.ofMillis(220000L))
              .build();
      definitions.put("retry_policy_2_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(220000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(220000L))
              .setTotalTimeoutDuration(Duration.ofMillis(220000L))
              .build();
      definitions.put("no_retry_3_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(60000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(1800000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(1800000L))
              .setTotalTimeoutDuration(Duration.ofMillis(1800000L))
              .build();
      definitions.put("retry_policy_8_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createParticipantSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getParticipantSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listParticipantsSettings = PagedCallSettings.newBuilder(LIST_PARTICIPANTS_PAGE_STR_FACT);
      updateParticipantSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      analyzeContentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      streamingAnalyzeContentSettings = StreamingCallSettings.newBuilder();
      bidiStreamingAnalyzeContentSettings = StreamingCallSettings.newBuilder();
      suggestArticlesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      suggestFaqAnswersSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      suggestSmartRepliesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      suggestKnowledgeAssistSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSuggestionsSettings = PagedCallSettings.newBuilder(LIST_SUGGESTIONS_PAGE_STR_FACT);
      compileSuggestionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createParticipantSettings,
              getParticipantSettings,
              listParticipantsSettings,
              updateParticipantSettings,
              analyzeContentSettings,
              suggestArticlesSettings,
              suggestFaqAnswersSettings,
              suggestSmartRepliesSettings,
              suggestKnowledgeAssistSettings,
              listSuggestionsSettings,
              compileSuggestionSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(ParticipantsStubSettings settings) {
      super(settings);

      createParticipantSettings = settings.createParticipantSettings.toBuilder();
      getParticipantSettings = settings.getParticipantSettings.toBuilder();
      listParticipantsSettings = settings.listParticipantsSettings.toBuilder();
      updateParticipantSettings = settings.updateParticipantSettings.toBuilder();
      analyzeContentSettings = settings.analyzeContentSettings.toBuilder();
      streamingAnalyzeContentSettings = settings.streamingAnalyzeContentSettings.toBuilder();
      bidiStreamingAnalyzeContentSettings =
          settings.bidiStreamingAnalyzeContentSettings.toBuilder();
      suggestArticlesSettings = settings.suggestArticlesSettings.toBuilder();
      suggestFaqAnswersSettings = settings.suggestFaqAnswersSettings.toBuilder();
      suggestSmartRepliesSettings = settings.suggestSmartRepliesSettings.toBuilder();
      suggestKnowledgeAssistSettings = settings.suggestKnowledgeAssistSettings.toBuilder();
      listSuggestionsSettings = settings.listSuggestionsSettings.toBuilder();
      compileSuggestionSettings = settings.compileSuggestionSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createParticipantSettings,
              getParticipantSettings,
              listParticipantsSettings,
              updateParticipantSettings,
              analyzeContentSettings,
              suggestArticlesSettings,
              suggestFaqAnswersSettings,
              suggestSmartRepliesSettings,
              suggestKnowledgeAssistSettings,
              listSuggestionsSettings,
              compileSuggestionSettings,
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
          .createParticipantSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getParticipantSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listParticipantsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateParticipantSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .analyzeContentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .suggestArticlesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .suggestFaqAnswersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .suggestSmartRepliesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .suggestKnowledgeAssistSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listSuggestionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .compileSuggestionSettings()
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

    /** Returns the builder for the settings used for calls to createParticipant. */
    public UnaryCallSettings.Builder<CreateParticipantRequest, Participant>
        createParticipantSettings() {
      return createParticipantSettings;
    }

    /** Returns the builder for the settings used for calls to getParticipant. */
    public UnaryCallSettings.Builder<GetParticipantRequest, Participant> getParticipantSettings() {
      return getParticipantSettings;
    }

    /** Returns the builder for the settings used for calls to listParticipants. */
    public PagedCallSettings.Builder<
            ListParticipantsRequest, ListParticipantsResponse, ListParticipantsPagedResponse>
        listParticipantsSettings() {
      return listParticipantsSettings;
    }

    /** Returns the builder for the settings used for calls to updateParticipant. */
    public UnaryCallSettings.Builder<UpdateParticipantRequest, Participant>
        updateParticipantSettings() {
      return updateParticipantSettings;
    }

    /** Returns the builder for the settings used for calls to analyzeContent. */
    public UnaryCallSettings.Builder<AnalyzeContentRequest, AnalyzeContentResponse>
        analyzeContentSettings() {
      return analyzeContentSettings;
    }

    /** Returns the builder for the settings used for calls to streamingAnalyzeContent. */
    public StreamingCallSettings.Builder<
            StreamingAnalyzeContentRequest, StreamingAnalyzeContentResponse>
        streamingAnalyzeContentSettings() {
      return streamingAnalyzeContentSettings;
    }

    /** Returns the builder for the settings used for calls to bidiStreamingAnalyzeContent. */
    public StreamingCallSettings.Builder<
            BidiStreamingAnalyzeContentRequest, BidiStreamingAnalyzeContentResponse>
        bidiStreamingAnalyzeContentSettings() {
      return bidiStreamingAnalyzeContentSettings;
    }

    /** Returns the builder for the settings used for calls to suggestArticles. */
    public UnaryCallSettings.Builder<SuggestArticlesRequest, SuggestArticlesResponse>
        suggestArticlesSettings() {
      return suggestArticlesSettings;
    }

    /** Returns the builder for the settings used for calls to suggestFaqAnswers. */
    public UnaryCallSettings.Builder<SuggestFaqAnswersRequest, SuggestFaqAnswersResponse>
        suggestFaqAnswersSettings() {
      return suggestFaqAnswersSettings;
    }

    /** Returns the builder for the settings used for calls to suggestSmartReplies. */
    public UnaryCallSettings.Builder<SuggestSmartRepliesRequest, SuggestSmartRepliesResponse>
        suggestSmartRepliesSettings() {
      return suggestSmartRepliesSettings;
    }

    /** Returns the builder for the settings used for calls to suggestKnowledgeAssist. */
    public UnaryCallSettings.Builder<SuggestKnowledgeAssistRequest, SuggestKnowledgeAssistResponse>
        suggestKnowledgeAssistSettings() {
      return suggestKnowledgeAssistSettings;
    }

    /**
     * Returns the builder for the settings used for calls to listSuggestions.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public PagedCallSettings.Builder<
            ListSuggestionsRequest, ListSuggestionsResponse, ListSuggestionsPagedResponse>
        listSuggestionsSettings() {
      return listSuggestionsSettings;
    }

    /**
     * Returns the builder for the settings used for calls to compileSuggestion.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<CompileSuggestionRequest, CompileSuggestionResponse>
        compileSuggestionSettings() {
      return compileSuggestionSettings;
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
    public ParticipantsStubSettings build() throws IOException {
      return new ParticipantsStubSettings(this);
    }
  }
}
