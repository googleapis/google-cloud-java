/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.enterpriseknowledgegraph.v1.stub;

import static com.google.cloud.enterpriseknowledgegraph.v1.EnterpriseKnowledgeGraphServiceClient.ListEntityReconciliationJobsPagedResponse;

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
import com.google.cloud.enterpriseknowledgegraph.v1.CancelEntityReconciliationJobRequest;
import com.google.cloud.enterpriseknowledgegraph.v1.CreateEntityReconciliationJobRequest;
import com.google.cloud.enterpriseknowledgegraph.v1.DeleteEntityReconciliationJobRequest;
import com.google.cloud.enterpriseknowledgegraph.v1.EntityReconciliationJob;
import com.google.cloud.enterpriseknowledgegraph.v1.GetEntityReconciliationJobRequest;
import com.google.cloud.enterpriseknowledgegraph.v1.ListEntityReconciliationJobsRequest;
import com.google.cloud.enterpriseknowledgegraph.v1.ListEntityReconciliationJobsResponse;
import com.google.cloud.enterpriseknowledgegraph.v1.LookupPublicKgRequest;
import com.google.cloud.enterpriseknowledgegraph.v1.LookupPublicKgResponse;
import com.google.cloud.enterpriseknowledgegraph.v1.LookupRequest;
import com.google.cloud.enterpriseknowledgegraph.v1.LookupResponse;
import com.google.cloud.enterpriseknowledgegraph.v1.SearchPublicKgRequest;
import com.google.cloud.enterpriseknowledgegraph.v1.SearchPublicKgResponse;
import com.google.cloud.enterpriseknowledgegraph.v1.SearchRequest;
import com.google.cloud.enterpriseknowledgegraph.v1.SearchResponse;
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
 * Settings class to configure an instance of {@link EnterpriseKnowledgeGraphServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (enterpriseknowledgegraph.googleapis.com) and default port
 *       (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createEntityReconciliationJob to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * EnterpriseKnowledgeGraphServiceStubSettings.Builder
 *     enterpriseKnowledgeGraphServiceSettingsBuilder =
 *         EnterpriseKnowledgeGraphServiceStubSettings.newBuilder();
 * enterpriseKnowledgeGraphServiceSettingsBuilder
 *     .createEntityReconciliationJobSettings()
 *     .setRetrySettings(
 *         enterpriseKnowledgeGraphServiceSettingsBuilder
 *             .createEntityReconciliationJobSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * EnterpriseKnowledgeGraphServiceStubSettings enterpriseKnowledgeGraphServiceSettings =
 *     enterpriseKnowledgeGraphServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class EnterpriseKnowledgeGraphServiceStubSettings
    extends StubSettings<EnterpriseKnowledgeGraphServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateEntityReconciliationJobRequest, EntityReconciliationJob>
      createEntityReconciliationJobSettings;
  private final UnaryCallSettings<GetEntityReconciliationJobRequest, EntityReconciliationJob>
      getEntityReconciliationJobSettings;
  private final PagedCallSettings<
          ListEntityReconciliationJobsRequest,
          ListEntityReconciliationJobsResponse,
          ListEntityReconciliationJobsPagedResponse>
      listEntityReconciliationJobsSettings;
  private final UnaryCallSettings<CancelEntityReconciliationJobRequest, Empty>
      cancelEntityReconciliationJobSettings;
  private final UnaryCallSettings<DeleteEntityReconciliationJobRequest, Empty>
      deleteEntityReconciliationJobSettings;
  private final UnaryCallSettings<LookupRequest, LookupResponse> lookupSettings;
  private final UnaryCallSettings<SearchRequest, SearchResponse> searchSettings;
  private final UnaryCallSettings<LookupPublicKgRequest, LookupPublicKgResponse>
      lookupPublicKgSettings;
  private final UnaryCallSettings<SearchPublicKgRequest, SearchPublicKgResponse>
      searchPublicKgSettings;

  private static final PagedListDescriptor<
          ListEntityReconciliationJobsRequest,
          ListEntityReconciliationJobsResponse,
          EntityReconciliationJob>
      LIST_ENTITY_RECONCILIATION_JOBS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListEntityReconciliationJobsRequest,
              ListEntityReconciliationJobsResponse,
              EntityReconciliationJob>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEntityReconciliationJobsRequest injectToken(
                ListEntityReconciliationJobsRequest payload, String token) {
              return ListEntityReconciliationJobsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListEntityReconciliationJobsRequest injectPageSize(
                ListEntityReconciliationJobsRequest payload, int pageSize) {
              return ListEntityReconciliationJobsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListEntityReconciliationJobsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListEntityReconciliationJobsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<EntityReconciliationJob> extractResources(
                ListEntityReconciliationJobsResponse payload) {
              return payload.getEntityReconciliationJobsList() == null
                  ? ImmutableList.<EntityReconciliationJob>of()
                  : payload.getEntityReconciliationJobsList();
            }
          };

  private static final PagedListResponseFactory<
          ListEntityReconciliationJobsRequest,
          ListEntityReconciliationJobsResponse,
          ListEntityReconciliationJobsPagedResponse>
      LIST_ENTITY_RECONCILIATION_JOBS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEntityReconciliationJobsRequest,
              ListEntityReconciliationJobsResponse,
              ListEntityReconciliationJobsPagedResponse>() {
            @Override
            public ApiFuture<ListEntityReconciliationJobsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListEntityReconciliationJobsRequest, ListEntityReconciliationJobsResponse>
                    callable,
                ListEntityReconciliationJobsRequest request,
                ApiCallContext context,
                ApiFuture<ListEntityReconciliationJobsResponse> futureResponse) {
              PageContext<
                      ListEntityReconciliationJobsRequest,
                      ListEntityReconciliationJobsResponse,
                      EntityReconciliationJob>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_ENTITY_RECONCILIATION_JOBS_PAGE_STR_DESC,
                          request,
                          context);
              return ListEntityReconciliationJobsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createEntityReconciliationJob. */
  public UnaryCallSettings<CreateEntityReconciliationJobRequest, EntityReconciliationJob>
      createEntityReconciliationJobSettings() {
    return createEntityReconciliationJobSettings;
  }

  /** Returns the object with the settings used for calls to getEntityReconciliationJob. */
  public UnaryCallSettings<GetEntityReconciliationJobRequest, EntityReconciliationJob>
      getEntityReconciliationJobSettings() {
    return getEntityReconciliationJobSettings;
  }

  /** Returns the object with the settings used for calls to listEntityReconciliationJobs. */
  public PagedCallSettings<
          ListEntityReconciliationJobsRequest,
          ListEntityReconciliationJobsResponse,
          ListEntityReconciliationJobsPagedResponse>
      listEntityReconciliationJobsSettings() {
    return listEntityReconciliationJobsSettings;
  }

  /** Returns the object with the settings used for calls to cancelEntityReconciliationJob. */
  public UnaryCallSettings<CancelEntityReconciliationJobRequest, Empty>
      cancelEntityReconciliationJobSettings() {
    return cancelEntityReconciliationJobSettings;
  }

  /** Returns the object with the settings used for calls to deleteEntityReconciliationJob. */
  public UnaryCallSettings<DeleteEntityReconciliationJobRequest, Empty>
      deleteEntityReconciliationJobSettings() {
    return deleteEntityReconciliationJobSettings;
  }

  /** Returns the object with the settings used for calls to lookup. */
  public UnaryCallSettings<LookupRequest, LookupResponse> lookupSettings() {
    return lookupSettings;
  }

  /** Returns the object with the settings used for calls to search. */
  public UnaryCallSettings<SearchRequest, SearchResponse> searchSettings() {
    return searchSettings;
  }

  /** Returns the object with the settings used for calls to lookupPublicKg. */
  public UnaryCallSettings<LookupPublicKgRequest, LookupPublicKgResponse> lookupPublicKgSettings() {
    return lookupPublicKgSettings;
  }

  /** Returns the object with the settings used for calls to searchPublicKg. */
  public UnaryCallSettings<SearchPublicKgRequest, SearchPublicKgResponse> searchPublicKgSettings() {
    return searchPublicKgSettings;
  }

  public EnterpriseKnowledgeGraphServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcEnterpriseKnowledgeGraphServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonEnterpriseKnowledgeGraphServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "enterpriseknowledgegraph.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "enterpriseknowledgegraph.mtls.googleapis.com:443";
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

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic",
            GaxProperties.getLibraryVersion(EnterpriseKnowledgeGraphServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic",
            GaxProperties.getLibraryVersion(EnterpriseKnowledgeGraphServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return EnterpriseKnowledgeGraphServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected EnterpriseKnowledgeGraphServiceStubSettings(Builder settingsBuilder)
      throws IOException {
    super(settingsBuilder);

    createEntityReconciliationJobSettings =
        settingsBuilder.createEntityReconciliationJobSettings().build();
    getEntityReconciliationJobSettings =
        settingsBuilder.getEntityReconciliationJobSettings().build();
    listEntityReconciliationJobsSettings =
        settingsBuilder.listEntityReconciliationJobsSettings().build();
    cancelEntityReconciliationJobSettings =
        settingsBuilder.cancelEntityReconciliationJobSettings().build();
    deleteEntityReconciliationJobSettings =
        settingsBuilder.deleteEntityReconciliationJobSettings().build();
    lookupSettings = settingsBuilder.lookupSettings().build();
    searchSettings = settingsBuilder.searchSettings().build();
    lookupPublicKgSettings = settingsBuilder.lookupPublicKgSettings().build();
    searchPublicKgSettings = settingsBuilder.searchPublicKgSettings().build();
  }

  /** Builder for EnterpriseKnowledgeGraphServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<EnterpriseKnowledgeGraphServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<
            CreateEntityReconciliationJobRequest, EntityReconciliationJob>
        createEntityReconciliationJobSettings;
    private final UnaryCallSettings.Builder<
            GetEntityReconciliationJobRequest, EntityReconciliationJob>
        getEntityReconciliationJobSettings;
    private final PagedCallSettings.Builder<
            ListEntityReconciliationJobsRequest,
            ListEntityReconciliationJobsResponse,
            ListEntityReconciliationJobsPagedResponse>
        listEntityReconciliationJobsSettings;
    private final UnaryCallSettings.Builder<CancelEntityReconciliationJobRequest, Empty>
        cancelEntityReconciliationJobSettings;
    private final UnaryCallSettings.Builder<DeleteEntityReconciliationJobRequest, Empty>
        deleteEntityReconciliationJobSettings;
    private final UnaryCallSettings.Builder<LookupRequest, LookupResponse> lookupSettings;
    private final UnaryCallSettings.Builder<SearchRequest, SearchResponse> searchSettings;
    private final UnaryCallSettings.Builder<LookupPublicKgRequest, LookupPublicKgResponse>
        lookupPublicKgSettings;
    private final UnaryCallSettings.Builder<SearchPublicKgRequest, SearchPublicKgResponse>
        searchPublicKgSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(10000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createEntityReconciliationJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getEntityReconciliationJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listEntityReconciliationJobsSettings =
          PagedCallSettings.newBuilder(LIST_ENTITY_RECONCILIATION_JOBS_PAGE_STR_FACT);
      cancelEntityReconciliationJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteEntityReconciliationJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      lookupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      searchSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      lookupPublicKgSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      searchPublicKgSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createEntityReconciliationJobSettings,
              getEntityReconciliationJobSettings,
              listEntityReconciliationJobsSettings,
              cancelEntityReconciliationJobSettings,
              deleteEntityReconciliationJobSettings,
              lookupSettings,
              searchSettings,
              lookupPublicKgSettings,
              searchPublicKgSettings);
      initDefaults(this);
    }

    protected Builder(EnterpriseKnowledgeGraphServiceStubSettings settings) {
      super(settings);

      createEntityReconciliationJobSettings =
          settings.createEntityReconciliationJobSettings.toBuilder();
      getEntityReconciliationJobSettings = settings.getEntityReconciliationJobSettings.toBuilder();
      listEntityReconciliationJobsSettings =
          settings.listEntityReconciliationJobsSettings.toBuilder();
      cancelEntityReconciliationJobSettings =
          settings.cancelEntityReconciliationJobSettings.toBuilder();
      deleteEntityReconciliationJobSettings =
          settings.deleteEntityReconciliationJobSettings.toBuilder();
      lookupSettings = settings.lookupSettings.toBuilder();
      searchSettings = settings.searchSettings.toBuilder();
      lookupPublicKgSettings = settings.lookupPublicKgSettings.toBuilder();
      searchPublicKgSettings = settings.searchPublicKgSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createEntityReconciliationJobSettings,
              getEntityReconciliationJobSettings,
              listEntityReconciliationJobsSettings,
              cancelEntityReconciliationJobSettings,
              deleteEntityReconciliationJobSettings,
              lookupSettings,
              searchSettings,
              lookupPublicKgSettings,
              searchPublicKgSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .createEntityReconciliationJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getEntityReconciliationJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listEntityReconciliationJobsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .cancelEntityReconciliationJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteEntityReconciliationJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .lookupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .searchSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .lookupPublicKgSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .searchPublicKgSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

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

    /** Returns the builder for the settings used for calls to createEntityReconciliationJob. */
    public UnaryCallSettings.Builder<CreateEntityReconciliationJobRequest, EntityReconciliationJob>
        createEntityReconciliationJobSettings() {
      return createEntityReconciliationJobSettings;
    }

    /** Returns the builder for the settings used for calls to getEntityReconciliationJob. */
    public UnaryCallSettings.Builder<GetEntityReconciliationJobRequest, EntityReconciliationJob>
        getEntityReconciliationJobSettings() {
      return getEntityReconciliationJobSettings;
    }

    /** Returns the builder for the settings used for calls to listEntityReconciliationJobs. */
    public PagedCallSettings.Builder<
            ListEntityReconciliationJobsRequest,
            ListEntityReconciliationJobsResponse,
            ListEntityReconciliationJobsPagedResponse>
        listEntityReconciliationJobsSettings() {
      return listEntityReconciliationJobsSettings;
    }

    /** Returns the builder for the settings used for calls to cancelEntityReconciliationJob. */
    public UnaryCallSettings.Builder<CancelEntityReconciliationJobRequest, Empty>
        cancelEntityReconciliationJobSettings() {
      return cancelEntityReconciliationJobSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEntityReconciliationJob. */
    public UnaryCallSettings.Builder<DeleteEntityReconciliationJobRequest, Empty>
        deleteEntityReconciliationJobSettings() {
      return deleteEntityReconciliationJobSettings;
    }

    /** Returns the builder for the settings used for calls to lookup. */
    public UnaryCallSettings.Builder<LookupRequest, LookupResponse> lookupSettings() {
      return lookupSettings;
    }

    /** Returns the builder for the settings used for calls to search. */
    public UnaryCallSettings.Builder<SearchRequest, SearchResponse> searchSettings() {
      return searchSettings;
    }

    /** Returns the builder for the settings used for calls to lookupPublicKg. */
    public UnaryCallSettings.Builder<LookupPublicKgRequest, LookupPublicKgResponse>
        lookupPublicKgSettings() {
      return lookupPublicKgSettings;
    }

    /** Returns the builder for the settings used for calls to searchPublicKg. */
    public UnaryCallSettings.Builder<SearchPublicKgRequest, SearchPublicKgResponse>
        searchPublicKgSettings() {
      return searchPublicKgSettings;
    }

    @Override
    public EnterpriseKnowledgeGraphServiceStubSettings build() throws IOException {
      return new EnterpriseKnowledgeGraphServiceStubSettings(this);
    }
  }
}
