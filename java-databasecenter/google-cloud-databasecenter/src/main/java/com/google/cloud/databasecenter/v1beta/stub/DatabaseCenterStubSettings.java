/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.databasecenter.v1beta.stub;

import static com.google.cloud.databasecenter.v1beta.DatabaseCenterClient.AggregateFleetPagedResponse;
import static com.google.cloud.databasecenter.v1beta.DatabaseCenterClient.QueryDatabaseResourceGroupsPagedResponse;
import static com.google.cloud.databasecenter.v1beta.DatabaseCenterClient.QueryIssuesPagedResponse;
import static com.google.cloud.databasecenter.v1beta.DatabaseCenterClient.QueryProductsPagedResponse;

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
import com.google.cloud.databasecenter.v1beta.AggregateFleetRequest;
import com.google.cloud.databasecenter.v1beta.AggregateFleetResponse;
import com.google.cloud.databasecenter.v1beta.AggregateFleetRow;
import com.google.cloud.databasecenter.v1beta.AggregateIssueStatsRequest;
import com.google.cloud.databasecenter.v1beta.AggregateIssueStatsResponse;
import com.google.cloud.databasecenter.v1beta.DatabaseResourceGroup;
import com.google.cloud.databasecenter.v1beta.DatabaseResourceIssue;
import com.google.cloud.databasecenter.v1beta.Product;
import com.google.cloud.databasecenter.v1beta.QueryDatabaseResourceGroupsRequest;
import com.google.cloud.databasecenter.v1beta.QueryDatabaseResourceGroupsResponse;
import com.google.cloud.databasecenter.v1beta.QueryIssuesRequest;
import com.google.cloud.databasecenter.v1beta.QueryIssuesResponse;
import com.google.cloud.databasecenter.v1beta.QueryProductsRequest;
import com.google.cloud.databasecenter.v1beta.QueryProductsResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DatabaseCenterStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (databasecenter.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of aggregateIssueStats:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DatabaseCenterStubSettings.Builder databaseCenterSettingsBuilder =
 *     DatabaseCenterStubSettings.newBuilder();
 * databaseCenterSettingsBuilder
 *     .aggregateIssueStatsSettings()
 *     .setRetrySettings(
 *         databaseCenterSettingsBuilder
 *             .aggregateIssueStatsSettings()
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
 * DatabaseCenterStubSettings databaseCenterSettings = databaseCenterSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DatabaseCenterStubSettings extends StubSettings<DatabaseCenterStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          QueryProductsRequest, QueryProductsResponse, QueryProductsPagedResponse>
      queryProductsSettings;
  private final PagedCallSettings<
          AggregateFleetRequest, AggregateFleetResponse, AggregateFleetPagedResponse>
      aggregateFleetSettings;
  private final PagedCallSettings<
          QueryDatabaseResourceGroupsRequest,
          QueryDatabaseResourceGroupsResponse,
          QueryDatabaseResourceGroupsPagedResponse>
      queryDatabaseResourceGroupsSettings;
  private final UnaryCallSettings<AggregateIssueStatsRequest, AggregateIssueStatsResponse>
      aggregateIssueStatsSettings;
  private final PagedCallSettings<QueryIssuesRequest, QueryIssuesResponse, QueryIssuesPagedResponse>
      queryIssuesSettings;

  private static final PagedListDescriptor<QueryProductsRequest, QueryProductsResponse, Product>
      QUERY_PRODUCTS_PAGE_STR_DESC =
          new PagedListDescriptor<QueryProductsRequest, QueryProductsResponse, Product>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public QueryProductsRequest injectToken(QueryProductsRequest payload, String token) {
              return QueryProductsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public QueryProductsRequest injectPageSize(QueryProductsRequest payload, int pageSize) {
              return QueryProductsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(QueryProductsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(QueryProductsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Product> extractResources(QueryProductsResponse payload) {
              return payload.getProductsList();
            }
          };

  private static final PagedListDescriptor<
          AggregateFleetRequest, AggregateFleetResponse, AggregateFleetRow>
      AGGREGATE_FLEET_PAGE_STR_DESC =
          new PagedListDescriptor<
              AggregateFleetRequest, AggregateFleetResponse, AggregateFleetRow>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public AggregateFleetRequest injectToken(AggregateFleetRequest payload, String token) {
              return AggregateFleetRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public AggregateFleetRequest injectPageSize(
                AggregateFleetRequest payload, int pageSize) {
              return AggregateFleetRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(AggregateFleetRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(AggregateFleetResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AggregateFleetRow> extractResources(AggregateFleetResponse payload) {
              return payload.getRowsList();
            }
          };

  private static final PagedListDescriptor<
          QueryDatabaseResourceGroupsRequest,
          QueryDatabaseResourceGroupsResponse,
          DatabaseResourceGroup>
      QUERY_DATABASE_RESOURCE_GROUPS_PAGE_STR_DESC =
          new PagedListDescriptor<
              QueryDatabaseResourceGroupsRequest,
              QueryDatabaseResourceGroupsResponse,
              DatabaseResourceGroup>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public QueryDatabaseResourceGroupsRequest injectToken(
                QueryDatabaseResourceGroupsRequest payload, String token) {
              return QueryDatabaseResourceGroupsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public QueryDatabaseResourceGroupsRequest injectPageSize(
                QueryDatabaseResourceGroupsRequest payload, int pageSize) {
              return QueryDatabaseResourceGroupsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(QueryDatabaseResourceGroupsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(QueryDatabaseResourceGroupsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DatabaseResourceGroup> extractResources(
                QueryDatabaseResourceGroupsResponse payload) {
              return payload.getResourceGroupsList();
            }
          };

  private static final PagedListDescriptor<
          QueryIssuesRequest, QueryIssuesResponse, DatabaseResourceIssue>
      QUERY_ISSUES_PAGE_STR_DESC =
          new PagedListDescriptor<
              QueryIssuesRequest, QueryIssuesResponse, DatabaseResourceIssue>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public QueryIssuesRequest injectToken(QueryIssuesRequest payload, String token) {
              return QueryIssuesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public QueryIssuesRequest injectPageSize(QueryIssuesRequest payload, int pageSize) {
              return QueryIssuesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(QueryIssuesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(QueryIssuesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DatabaseResourceIssue> extractResources(QueryIssuesResponse payload) {
              return payload.getResourceIssuesList();
            }
          };

  private static final PagedListResponseFactory<
          QueryProductsRequest, QueryProductsResponse, QueryProductsPagedResponse>
      QUERY_PRODUCTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              QueryProductsRequest, QueryProductsResponse, QueryProductsPagedResponse>() {
            @Override
            public ApiFuture<QueryProductsPagedResponse> getFuturePagedResponse(
                UnaryCallable<QueryProductsRequest, QueryProductsResponse> callable,
                QueryProductsRequest request,
                ApiCallContext context,
                ApiFuture<QueryProductsResponse> futureResponse) {
              PageContext<QueryProductsRequest, QueryProductsResponse, Product> pageContext =
                  PageContext.create(callable, QUERY_PRODUCTS_PAGE_STR_DESC, request, context);
              return QueryProductsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          AggregateFleetRequest, AggregateFleetResponse, AggregateFleetPagedResponse>
      AGGREGATE_FLEET_PAGE_STR_FACT =
          new PagedListResponseFactory<
              AggregateFleetRequest, AggregateFleetResponse, AggregateFleetPagedResponse>() {
            @Override
            public ApiFuture<AggregateFleetPagedResponse> getFuturePagedResponse(
                UnaryCallable<AggregateFleetRequest, AggregateFleetResponse> callable,
                AggregateFleetRequest request,
                ApiCallContext context,
                ApiFuture<AggregateFleetResponse> futureResponse) {
              PageContext<AggregateFleetRequest, AggregateFleetResponse, AggregateFleetRow>
                  pageContext =
                      PageContext.create(callable, AGGREGATE_FLEET_PAGE_STR_DESC, request, context);
              return AggregateFleetPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          QueryDatabaseResourceGroupsRequest,
          QueryDatabaseResourceGroupsResponse,
          QueryDatabaseResourceGroupsPagedResponse>
      QUERY_DATABASE_RESOURCE_GROUPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              QueryDatabaseResourceGroupsRequest,
              QueryDatabaseResourceGroupsResponse,
              QueryDatabaseResourceGroupsPagedResponse>() {
            @Override
            public ApiFuture<QueryDatabaseResourceGroupsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        QueryDatabaseResourceGroupsRequest, QueryDatabaseResourceGroupsResponse>
                    callable,
                QueryDatabaseResourceGroupsRequest request,
                ApiCallContext context,
                ApiFuture<QueryDatabaseResourceGroupsResponse> futureResponse) {
              PageContext<
                      QueryDatabaseResourceGroupsRequest,
                      QueryDatabaseResourceGroupsResponse,
                      DatabaseResourceGroup>
                  pageContext =
                      PageContext.create(
                          callable, QUERY_DATABASE_RESOURCE_GROUPS_PAGE_STR_DESC, request, context);
              return QueryDatabaseResourceGroupsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          QueryIssuesRequest, QueryIssuesResponse, QueryIssuesPagedResponse>
      QUERY_ISSUES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              QueryIssuesRequest, QueryIssuesResponse, QueryIssuesPagedResponse>() {
            @Override
            public ApiFuture<QueryIssuesPagedResponse> getFuturePagedResponse(
                UnaryCallable<QueryIssuesRequest, QueryIssuesResponse> callable,
                QueryIssuesRequest request,
                ApiCallContext context,
                ApiFuture<QueryIssuesResponse> futureResponse) {
              PageContext<QueryIssuesRequest, QueryIssuesResponse, DatabaseResourceIssue>
                  pageContext =
                      PageContext.create(callable, QUERY_ISSUES_PAGE_STR_DESC, request, context);
              return QueryIssuesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to queryProducts. */
  public PagedCallSettings<QueryProductsRequest, QueryProductsResponse, QueryProductsPagedResponse>
      queryProductsSettings() {
    return queryProductsSettings;
  }

  /** Returns the object with the settings used for calls to aggregateFleet. */
  public PagedCallSettings<
          AggregateFleetRequest, AggregateFleetResponse, AggregateFleetPagedResponse>
      aggregateFleetSettings() {
    return aggregateFleetSettings;
  }

  /** Returns the object with the settings used for calls to queryDatabaseResourceGroups. */
  public PagedCallSettings<
          QueryDatabaseResourceGroupsRequest,
          QueryDatabaseResourceGroupsResponse,
          QueryDatabaseResourceGroupsPagedResponse>
      queryDatabaseResourceGroupsSettings() {
    return queryDatabaseResourceGroupsSettings;
  }

  /** Returns the object with the settings used for calls to aggregateIssueStats. */
  public UnaryCallSettings<AggregateIssueStatsRequest, AggregateIssueStatsResponse>
      aggregateIssueStatsSettings() {
    return aggregateIssueStatsSettings;
  }

  /** Returns the object with the settings used for calls to queryIssues. */
  public PagedCallSettings<QueryIssuesRequest, QueryIssuesResponse, QueryIssuesPagedResponse>
      queryIssuesSettings() {
    return queryIssuesSettings;
  }

  public DatabaseCenterStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDatabaseCenterStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDatabaseCenterStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "databasecenter";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "databasecenter.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "databasecenter.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(DatabaseCenterStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DatabaseCenterStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DatabaseCenterStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected DatabaseCenterStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    queryProductsSettings = settingsBuilder.queryProductsSettings().build();
    aggregateFleetSettings = settingsBuilder.aggregateFleetSettings().build();
    queryDatabaseResourceGroupsSettings =
        settingsBuilder.queryDatabaseResourceGroupsSettings().build();
    aggregateIssueStatsSettings = settingsBuilder.aggregateIssueStatsSettings().build();
    queryIssuesSettings = settingsBuilder.queryIssuesSettings().build();
  }

  /** Builder for DatabaseCenterStubSettings. */
  public static class Builder extends StubSettings.Builder<DatabaseCenterStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            QueryProductsRequest, QueryProductsResponse, QueryProductsPagedResponse>
        queryProductsSettings;
    private final PagedCallSettings.Builder<
            AggregateFleetRequest, AggregateFleetResponse, AggregateFleetPagedResponse>
        aggregateFleetSettings;
    private final PagedCallSettings.Builder<
            QueryDatabaseResourceGroupsRequest,
            QueryDatabaseResourceGroupsResponse,
            QueryDatabaseResourceGroupsPagedResponse>
        queryDatabaseResourceGroupsSettings;
    private final UnaryCallSettings.Builder<AggregateIssueStatsRequest, AggregateIssueStatsResponse>
        aggregateIssueStatsSettings;
    private final PagedCallSettings.Builder<
            QueryIssuesRequest, QueryIssuesResponse, QueryIssuesPagedResponse>
        queryIssuesSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      queryProductsSettings = PagedCallSettings.newBuilder(QUERY_PRODUCTS_PAGE_STR_FACT);
      aggregateFleetSettings = PagedCallSettings.newBuilder(AGGREGATE_FLEET_PAGE_STR_FACT);
      queryDatabaseResourceGroupsSettings =
          PagedCallSettings.newBuilder(QUERY_DATABASE_RESOURCE_GROUPS_PAGE_STR_FACT);
      aggregateIssueStatsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      queryIssuesSettings = PagedCallSettings.newBuilder(QUERY_ISSUES_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              queryProductsSettings,
              aggregateFleetSettings,
              queryDatabaseResourceGroupsSettings,
              aggregateIssueStatsSettings,
              queryIssuesSettings);
      initDefaults(this);
    }

    protected Builder(DatabaseCenterStubSettings settings) {
      super(settings);

      queryProductsSettings = settings.queryProductsSettings.toBuilder();
      aggregateFleetSettings = settings.aggregateFleetSettings.toBuilder();
      queryDatabaseResourceGroupsSettings =
          settings.queryDatabaseResourceGroupsSettings.toBuilder();
      aggregateIssueStatsSettings = settings.aggregateIssueStatsSettings.toBuilder();
      queryIssuesSettings = settings.queryIssuesSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              queryProductsSettings,
              aggregateFleetSettings,
              queryDatabaseResourceGroupsSettings,
              aggregateIssueStatsSettings,
              queryIssuesSettings);
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
          .queryProductsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .aggregateFleetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .queryDatabaseResourceGroupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .aggregateIssueStatsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .queryIssuesSettings()
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

    /** Returns the builder for the settings used for calls to queryProducts. */
    public PagedCallSettings.Builder<
            QueryProductsRequest, QueryProductsResponse, QueryProductsPagedResponse>
        queryProductsSettings() {
      return queryProductsSettings;
    }

    /** Returns the builder for the settings used for calls to aggregateFleet. */
    public PagedCallSettings.Builder<
            AggregateFleetRequest, AggregateFleetResponse, AggregateFleetPagedResponse>
        aggregateFleetSettings() {
      return aggregateFleetSettings;
    }

    /** Returns the builder for the settings used for calls to queryDatabaseResourceGroups. */
    public PagedCallSettings.Builder<
            QueryDatabaseResourceGroupsRequest,
            QueryDatabaseResourceGroupsResponse,
            QueryDatabaseResourceGroupsPagedResponse>
        queryDatabaseResourceGroupsSettings() {
      return queryDatabaseResourceGroupsSettings;
    }

    /** Returns the builder for the settings used for calls to aggregateIssueStats. */
    public UnaryCallSettings.Builder<AggregateIssueStatsRequest, AggregateIssueStatsResponse>
        aggregateIssueStatsSettings() {
      return aggregateIssueStatsSettings;
    }

    /** Returns the builder for the settings used for calls to queryIssues. */
    public PagedCallSettings.Builder<
            QueryIssuesRequest, QueryIssuesResponse, QueryIssuesPagedResponse>
        queryIssuesSettings() {
      return queryIssuesSettings;
    }

    @Override
    public DatabaseCenterStubSettings build() throws IOException {
      return new DatabaseCenterStubSettings(this);
    }
  }
}
