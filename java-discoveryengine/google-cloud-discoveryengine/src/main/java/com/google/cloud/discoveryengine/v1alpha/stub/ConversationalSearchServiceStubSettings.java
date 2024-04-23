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

package com.google.cloud.discoveryengine.v1alpha.stub;

import static com.google.cloud.discoveryengine.v1alpha.ConversationalSearchServiceClient.ListConversationsPagedResponse;
import static com.google.cloud.discoveryengine.v1alpha.ConversationalSearchServiceClient.ListSessionsPagedResponse;

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
import com.google.cloud.discoveryengine.v1alpha.Answer;
import com.google.cloud.discoveryengine.v1alpha.AnswerQueryRequest;
import com.google.cloud.discoveryengine.v1alpha.AnswerQueryResponse;
import com.google.cloud.discoveryengine.v1alpha.Conversation;
import com.google.cloud.discoveryengine.v1alpha.ConverseConversationRequest;
import com.google.cloud.discoveryengine.v1alpha.ConverseConversationResponse;
import com.google.cloud.discoveryengine.v1alpha.CreateConversationRequest;
import com.google.cloud.discoveryengine.v1alpha.CreateSessionRequest;
import com.google.cloud.discoveryengine.v1alpha.DeleteConversationRequest;
import com.google.cloud.discoveryengine.v1alpha.DeleteSessionRequest;
import com.google.cloud.discoveryengine.v1alpha.GetAnswerRequest;
import com.google.cloud.discoveryengine.v1alpha.GetConversationRequest;
import com.google.cloud.discoveryengine.v1alpha.GetSessionRequest;
import com.google.cloud.discoveryengine.v1alpha.ListConversationsRequest;
import com.google.cloud.discoveryengine.v1alpha.ListConversationsResponse;
import com.google.cloud.discoveryengine.v1alpha.ListSessionsRequest;
import com.google.cloud.discoveryengine.v1alpha.ListSessionsResponse;
import com.google.cloud.discoveryengine.v1alpha.Session;
import com.google.cloud.discoveryengine.v1alpha.UpdateConversationRequest;
import com.google.cloud.discoveryengine.v1alpha.UpdateSessionRequest;
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
 * Settings class to configure an instance of {@link ConversationalSearchServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (discoveryengine.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of converseConversation to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ConversationalSearchServiceStubSettings.Builder conversationalSearchServiceSettingsBuilder =
 *     ConversationalSearchServiceStubSettings.newBuilder();
 * conversationalSearchServiceSettingsBuilder
 *     .converseConversationSettings()
 *     .setRetrySettings(
 *         conversationalSearchServiceSettingsBuilder
 *             .converseConversationSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ConversationalSearchServiceStubSettings conversationalSearchServiceSettings =
 *     conversationalSearchServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ConversationalSearchServiceStubSettings
    extends StubSettings<ConversationalSearchServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<ConverseConversationRequest, ConverseConversationResponse>
      converseConversationSettings;
  private final UnaryCallSettings<CreateConversationRequest, Conversation>
      createConversationSettings;
  private final UnaryCallSettings<DeleteConversationRequest, Empty> deleteConversationSettings;
  private final UnaryCallSettings<UpdateConversationRequest, Conversation>
      updateConversationSettings;
  private final UnaryCallSettings<GetConversationRequest, Conversation> getConversationSettings;
  private final PagedCallSettings<
          ListConversationsRequest, ListConversationsResponse, ListConversationsPagedResponse>
      listConversationsSettings;
  private final UnaryCallSettings<AnswerQueryRequest, AnswerQueryResponse> answerQuerySettings;
  private final UnaryCallSettings<GetAnswerRequest, Answer> getAnswerSettings;
  private final UnaryCallSettings<CreateSessionRequest, Session> createSessionSettings;
  private final UnaryCallSettings<DeleteSessionRequest, Empty> deleteSessionSettings;
  private final UnaryCallSettings<UpdateSessionRequest, Session> updateSessionSettings;
  private final UnaryCallSettings<GetSessionRequest, Session> getSessionSettings;
  private final PagedCallSettings<
          ListSessionsRequest, ListSessionsResponse, ListSessionsPagedResponse>
      listSessionsSettings;

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
              return payload.getConversationsList() == null
                  ? ImmutableList.<Conversation>of()
                  : payload.getConversationsList();
            }
          };

  private static final PagedListDescriptor<ListSessionsRequest, ListSessionsResponse, Session>
      LIST_SESSIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListSessionsRequest, ListSessionsResponse, Session>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSessionsRequest injectToken(ListSessionsRequest payload, String token) {
              return ListSessionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSessionsRequest injectPageSize(ListSessionsRequest payload, int pageSize) {
              return ListSessionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSessionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSessionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Session> extractResources(ListSessionsResponse payload) {
              return payload.getSessionsList() == null
                  ? ImmutableList.<Session>of()
                  : payload.getSessionsList();
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
          ListSessionsRequest, ListSessionsResponse, ListSessionsPagedResponse>
      LIST_SESSIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSessionsRequest, ListSessionsResponse, ListSessionsPagedResponse>() {
            @Override
            public ApiFuture<ListSessionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSessionsRequest, ListSessionsResponse> callable,
                ListSessionsRequest request,
                ApiCallContext context,
                ApiFuture<ListSessionsResponse> futureResponse) {
              PageContext<ListSessionsRequest, ListSessionsResponse, Session> pageContext =
                  PageContext.create(callable, LIST_SESSIONS_PAGE_STR_DESC, request, context);
              return ListSessionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to converseConversation. */
  public UnaryCallSettings<ConverseConversationRequest, ConverseConversationResponse>
      converseConversationSettings() {
    return converseConversationSettings;
  }

  /** Returns the object with the settings used for calls to createConversation. */
  public UnaryCallSettings<CreateConversationRequest, Conversation> createConversationSettings() {
    return createConversationSettings;
  }

  /** Returns the object with the settings used for calls to deleteConversation. */
  public UnaryCallSettings<DeleteConversationRequest, Empty> deleteConversationSettings() {
    return deleteConversationSettings;
  }

  /** Returns the object with the settings used for calls to updateConversation. */
  public UnaryCallSettings<UpdateConversationRequest, Conversation> updateConversationSettings() {
    return updateConversationSettings;
  }

  /** Returns the object with the settings used for calls to getConversation. */
  public UnaryCallSettings<GetConversationRequest, Conversation> getConversationSettings() {
    return getConversationSettings;
  }

  /** Returns the object with the settings used for calls to listConversations. */
  public PagedCallSettings<
          ListConversationsRequest, ListConversationsResponse, ListConversationsPagedResponse>
      listConversationsSettings() {
    return listConversationsSettings;
  }

  /** Returns the object with the settings used for calls to answerQuery. */
  public UnaryCallSettings<AnswerQueryRequest, AnswerQueryResponse> answerQuerySettings() {
    return answerQuerySettings;
  }

  /** Returns the object with the settings used for calls to getAnswer. */
  public UnaryCallSettings<GetAnswerRequest, Answer> getAnswerSettings() {
    return getAnswerSettings;
  }

  /** Returns the object with the settings used for calls to createSession. */
  public UnaryCallSettings<CreateSessionRequest, Session> createSessionSettings() {
    return createSessionSettings;
  }

  /** Returns the object with the settings used for calls to deleteSession. */
  public UnaryCallSettings<DeleteSessionRequest, Empty> deleteSessionSettings() {
    return deleteSessionSettings;
  }

  /** Returns the object with the settings used for calls to updateSession. */
  public UnaryCallSettings<UpdateSessionRequest, Session> updateSessionSettings() {
    return updateSessionSettings;
  }

  /** Returns the object with the settings used for calls to getSession. */
  public UnaryCallSettings<GetSessionRequest, Session> getSessionSettings() {
    return getSessionSettings;
  }

  /** Returns the object with the settings used for calls to listSessions. */
  public PagedCallSettings<ListSessionsRequest, ListSessionsResponse, ListSessionsPagedResponse>
      listSessionsSettings() {
    return listSessionsSettings;
  }

  public ConversationalSearchServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcConversationalSearchServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonConversationalSearchServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "discoveryengine";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "discoveryengine.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "discoveryengine.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(ConversationalSearchServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ConversationalSearchServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ConversationalSearchServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected ConversationalSearchServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    converseConversationSettings = settingsBuilder.converseConversationSettings().build();
    createConversationSettings = settingsBuilder.createConversationSettings().build();
    deleteConversationSettings = settingsBuilder.deleteConversationSettings().build();
    updateConversationSettings = settingsBuilder.updateConversationSettings().build();
    getConversationSettings = settingsBuilder.getConversationSettings().build();
    listConversationsSettings = settingsBuilder.listConversationsSettings().build();
    answerQuerySettings = settingsBuilder.answerQuerySettings().build();
    getAnswerSettings = settingsBuilder.getAnswerSettings().build();
    createSessionSettings = settingsBuilder.createSessionSettings().build();
    deleteSessionSettings = settingsBuilder.deleteSessionSettings().build();
    updateSessionSettings = settingsBuilder.updateSessionSettings().build();
    getSessionSettings = settingsBuilder.getSessionSettings().build();
    listSessionsSettings = settingsBuilder.listSessionsSettings().build();
  }

  /** Builder for ConversationalSearchServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<ConversationalSearchServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<
            ConverseConversationRequest, ConverseConversationResponse>
        converseConversationSettings;
    private final UnaryCallSettings.Builder<CreateConversationRequest, Conversation>
        createConversationSettings;
    private final UnaryCallSettings.Builder<DeleteConversationRequest, Empty>
        deleteConversationSettings;
    private final UnaryCallSettings.Builder<UpdateConversationRequest, Conversation>
        updateConversationSettings;
    private final UnaryCallSettings.Builder<GetConversationRequest, Conversation>
        getConversationSettings;
    private final PagedCallSettings.Builder<
            ListConversationsRequest, ListConversationsResponse, ListConversationsPagedResponse>
        listConversationsSettings;
    private final UnaryCallSettings.Builder<AnswerQueryRequest, AnswerQueryResponse>
        answerQuerySettings;
    private final UnaryCallSettings.Builder<GetAnswerRequest, Answer> getAnswerSettings;
    private final UnaryCallSettings.Builder<CreateSessionRequest, Session> createSessionSettings;
    private final UnaryCallSettings.Builder<DeleteSessionRequest, Empty> deleteSessionSettings;
    private final UnaryCallSettings.Builder<UpdateSessionRequest, Session> updateSessionSettings;
    private final UnaryCallSettings.Builder<GetSessionRequest, Session> getSessionSettings;
    private final PagedCallSettings.Builder<
            ListSessionsRequest, ListSessionsResponse, ListSessionsPagedResponse>
        listSessionsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_1_codes",
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
      definitions.put("retry_policy_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      converseConversationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createConversationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteConversationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateConversationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getConversationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listConversationsSettings = PagedCallSettings.newBuilder(LIST_CONVERSATIONS_PAGE_STR_FACT);
      answerQuerySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getAnswerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createSessionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteSessionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSessionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getSessionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSessionsSettings = PagedCallSettings.newBuilder(LIST_SESSIONS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              converseConversationSettings,
              createConversationSettings,
              deleteConversationSettings,
              updateConversationSettings,
              getConversationSettings,
              listConversationsSettings,
              answerQuerySettings,
              getAnswerSettings,
              createSessionSettings,
              deleteSessionSettings,
              updateSessionSettings,
              getSessionSettings,
              listSessionsSettings);
      initDefaults(this);
    }

    protected Builder(ConversationalSearchServiceStubSettings settings) {
      super(settings);

      converseConversationSettings = settings.converseConversationSettings.toBuilder();
      createConversationSettings = settings.createConversationSettings.toBuilder();
      deleteConversationSettings = settings.deleteConversationSettings.toBuilder();
      updateConversationSettings = settings.updateConversationSettings.toBuilder();
      getConversationSettings = settings.getConversationSettings.toBuilder();
      listConversationsSettings = settings.listConversationsSettings.toBuilder();
      answerQuerySettings = settings.answerQuerySettings.toBuilder();
      getAnswerSettings = settings.getAnswerSettings.toBuilder();
      createSessionSettings = settings.createSessionSettings.toBuilder();
      deleteSessionSettings = settings.deleteSessionSettings.toBuilder();
      updateSessionSettings = settings.updateSessionSettings.toBuilder();
      getSessionSettings = settings.getSessionSettings.toBuilder();
      listSessionsSettings = settings.listSessionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              converseConversationSettings,
              createConversationSettings,
              deleteConversationSettings,
              updateConversationSettings,
              getConversationSettings,
              listConversationsSettings,
              answerQuerySettings,
              getAnswerSettings,
              createSessionSettings,
              deleteSessionSettings,
              updateSessionSettings,
              getSessionSettings,
              listSessionsSettings);
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
          .converseConversationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .createConversationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .deleteConversationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .updateConversationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getConversationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .listConversationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .answerQuerySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getAnswerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .createSessionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .deleteSessionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .updateSessionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getSessionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .listSessionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

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

    /** Returns the builder for the settings used for calls to converseConversation. */
    public UnaryCallSettings.Builder<ConverseConversationRequest, ConverseConversationResponse>
        converseConversationSettings() {
      return converseConversationSettings;
    }

    /** Returns the builder for the settings used for calls to createConversation. */
    public UnaryCallSettings.Builder<CreateConversationRequest, Conversation>
        createConversationSettings() {
      return createConversationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteConversation. */
    public UnaryCallSettings.Builder<DeleteConversationRequest, Empty>
        deleteConversationSettings() {
      return deleteConversationSettings;
    }

    /** Returns the builder for the settings used for calls to updateConversation. */
    public UnaryCallSettings.Builder<UpdateConversationRequest, Conversation>
        updateConversationSettings() {
      return updateConversationSettings;
    }

    /** Returns the builder for the settings used for calls to getConversation. */
    public UnaryCallSettings.Builder<GetConversationRequest, Conversation>
        getConversationSettings() {
      return getConversationSettings;
    }

    /** Returns the builder for the settings used for calls to listConversations. */
    public PagedCallSettings.Builder<
            ListConversationsRequest, ListConversationsResponse, ListConversationsPagedResponse>
        listConversationsSettings() {
      return listConversationsSettings;
    }

    /** Returns the builder for the settings used for calls to answerQuery. */
    public UnaryCallSettings.Builder<AnswerQueryRequest, AnswerQueryResponse>
        answerQuerySettings() {
      return answerQuerySettings;
    }

    /** Returns the builder for the settings used for calls to getAnswer. */
    public UnaryCallSettings.Builder<GetAnswerRequest, Answer> getAnswerSettings() {
      return getAnswerSettings;
    }

    /** Returns the builder for the settings used for calls to createSession. */
    public UnaryCallSettings.Builder<CreateSessionRequest, Session> createSessionSettings() {
      return createSessionSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSession. */
    public UnaryCallSettings.Builder<DeleteSessionRequest, Empty> deleteSessionSettings() {
      return deleteSessionSettings;
    }

    /** Returns the builder for the settings used for calls to updateSession. */
    public UnaryCallSettings.Builder<UpdateSessionRequest, Session> updateSessionSettings() {
      return updateSessionSettings;
    }

    /** Returns the builder for the settings used for calls to getSession. */
    public UnaryCallSettings.Builder<GetSessionRequest, Session> getSessionSettings() {
      return getSessionSettings;
    }

    /** Returns the builder for the settings used for calls to listSessions. */
    public PagedCallSettings.Builder<
            ListSessionsRequest, ListSessionsResponse, ListSessionsPagedResponse>
        listSessionsSettings() {
      return listSessionsSettings;
    }

    @Override
    public ConversationalSearchServiceStubSettings build() throws IOException {
      return new ConversationalSearchServiceStubSettings(this);
    }
  }
}
