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

package com.google.cloud.geminidataanalytics.v1beta.stub;

import static com.google.cloud.geminidataanalytics.v1beta.ContextRetrievalServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryRecentRelevantTablesRequest;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryRecentRelevantTablesResponse;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextRequest;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextResponse;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextsFromRecentTablesRequest;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextsFromRecentTablesResponse;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextsRequest;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextsResponse;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableSuggestedDescriptionsRequest;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableSuggestedDescriptionsResponse;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableSuggestedExamplesRequest;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableSuggestedExamplesResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ContextRetrievalServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (geminidataanalytics.googleapis.com) and default port (443) are
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
 * of retrieveBigQueryTableContext:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ContextRetrievalServiceStubSettings.Builder contextRetrievalServiceSettingsBuilder =
 *     ContextRetrievalServiceStubSettings.newBuilder();
 * contextRetrievalServiceSettingsBuilder
 *     .retrieveBigQueryTableContextSettings()
 *     .setRetrySettings(
 *         contextRetrievalServiceSettingsBuilder
 *             .retrieveBigQueryTableContextSettings()
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
 * ContextRetrievalServiceStubSettings contextRetrievalServiceSettings =
 *     contextRetrievalServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ContextRetrievalServiceStubSettings
    extends StubSettings<ContextRetrievalServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<
          RetrieveBigQueryTableContextRequest, RetrieveBigQueryTableContextResponse>
      retrieveBigQueryTableContextSettings;
  private final UnaryCallSettings<
          RetrieveBigQueryTableContextsRequest, RetrieveBigQueryTableContextsResponse>
      retrieveBigQueryTableContextsSettings;
  private final UnaryCallSettings<
          RetrieveBigQueryTableContextsFromRecentTablesRequest,
          RetrieveBigQueryTableContextsFromRecentTablesResponse>
      retrieveBigQueryTableContextsFromRecentTablesSettings;
  private final UnaryCallSettings<
          RetrieveBigQueryTableSuggestedDescriptionsRequest,
          RetrieveBigQueryTableSuggestedDescriptionsResponse>
      retrieveBigQueryTableSuggestedDescriptionsSettings;
  private final UnaryCallSettings<
          RetrieveBigQueryTableSuggestedExamplesRequest,
          RetrieveBigQueryTableSuggestedExamplesResponse>
      retrieveBigQueryTableSuggestedExamplesSettings;
  private final UnaryCallSettings<
          RetrieveBigQueryRecentRelevantTablesRequest, RetrieveBigQueryRecentRelevantTablesResponse>
      retrieveBigQueryRecentRelevantTablesSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

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

  /** Returns the object with the settings used for calls to retrieveBigQueryTableContext. */
  public UnaryCallSettings<
          RetrieveBigQueryTableContextRequest, RetrieveBigQueryTableContextResponse>
      retrieveBigQueryTableContextSettings() {
    return retrieveBigQueryTableContextSettings;
  }

  /** Returns the object with the settings used for calls to retrieveBigQueryTableContexts. */
  public UnaryCallSettings<
          RetrieveBigQueryTableContextsRequest, RetrieveBigQueryTableContextsResponse>
      retrieveBigQueryTableContextsSettings() {
    return retrieveBigQueryTableContextsSettings;
  }

  /**
   * Returns the object with the settings used for calls to
   * retrieveBigQueryTableContextsFromRecentTables.
   */
  public UnaryCallSettings<
          RetrieveBigQueryTableContextsFromRecentTablesRequest,
          RetrieveBigQueryTableContextsFromRecentTablesResponse>
      retrieveBigQueryTableContextsFromRecentTablesSettings() {
    return retrieveBigQueryTableContextsFromRecentTablesSettings;
  }

  /**
   * Returns the object with the settings used for calls to
   * retrieveBigQueryTableSuggestedDescriptions.
   */
  public UnaryCallSettings<
          RetrieveBigQueryTableSuggestedDescriptionsRequest,
          RetrieveBigQueryTableSuggestedDescriptionsResponse>
      retrieveBigQueryTableSuggestedDescriptionsSettings() {
    return retrieveBigQueryTableSuggestedDescriptionsSettings;
  }

  /**
   * Returns the object with the settings used for calls to retrieveBigQueryTableSuggestedExamples.
   */
  public UnaryCallSettings<
          RetrieveBigQueryTableSuggestedExamplesRequest,
          RetrieveBigQueryTableSuggestedExamplesResponse>
      retrieveBigQueryTableSuggestedExamplesSettings() {
    return retrieveBigQueryTableSuggestedExamplesSettings;
  }

  /**
   * Returns the object with the settings used for calls to retrieveBigQueryRecentRelevantTables.
   */
  public UnaryCallSettings<
          RetrieveBigQueryRecentRelevantTablesRequest, RetrieveBigQueryRecentRelevantTablesResponse>
      retrieveBigQueryRecentRelevantTablesSettings() {
    return retrieveBigQueryRecentRelevantTablesSettings;
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

  public ContextRetrievalServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcContextRetrievalServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonContextRetrievalServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "geminidataanalytics";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "geminidataanalytics.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "geminidataanalytics.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(ContextRetrievalServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ContextRetrievalServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ContextRetrievalServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected ContextRetrievalServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    retrieveBigQueryTableContextSettings =
        settingsBuilder.retrieveBigQueryTableContextSettings().build();
    retrieveBigQueryTableContextsSettings =
        settingsBuilder.retrieveBigQueryTableContextsSettings().build();
    retrieveBigQueryTableContextsFromRecentTablesSettings =
        settingsBuilder.retrieveBigQueryTableContextsFromRecentTablesSettings().build();
    retrieveBigQueryTableSuggestedDescriptionsSettings =
        settingsBuilder.retrieveBigQueryTableSuggestedDescriptionsSettings().build();
    retrieveBigQueryTableSuggestedExamplesSettings =
        settingsBuilder.retrieveBigQueryTableSuggestedExamplesSettings().build();
    retrieveBigQueryRecentRelevantTablesSettings =
        settingsBuilder.retrieveBigQueryRecentRelevantTablesSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for ContextRetrievalServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<ContextRetrievalServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<
            RetrieveBigQueryTableContextRequest, RetrieveBigQueryTableContextResponse>
        retrieveBigQueryTableContextSettings;
    private final UnaryCallSettings.Builder<
            RetrieveBigQueryTableContextsRequest, RetrieveBigQueryTableContextsResponse>
        retrieveBigQueryTableContextsSettings;
    private final UnaryCallSettings.Builder<
            RetrieveBigQueryTableContextsFromRecentTablesRequest,
            RetrieveBigQueryTableContextsFromRecentTablesResponse>
        retrieveBigQueryTableContextsFromRecentTablesSettings;
    private final UnaryCallSettings.Builder<
            RetrieveBigQueryTableSuggestedDescriptionsRequest,
            RetrieveBigQueryTableSuggestedDescriptionsResponse>
        retrieveBigQueryTableSuggestedDescriptionsSettings;
    private final UnaryCallSettings.Builder<
            RetrieveBigQueryTableSuggestedExamplesRequest,
            RetrieveBigQueryTableSuggestedExamplesResponse>
        retrieveBigQueryTableSuggestedExamplesSettings;
    private final UnaryCallSettings.Builder<
            RetrieveBigQueryRecentRelevantTablesRequest,
            RetrieveBigQueryRecentRelevantTablesResponse>
        retrieveBigQueryRecentRelevantTablesSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
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

      retrieveBigQueryTableContextSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      retrieveBigQueryTableContextsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      retrieveBigQueryTableContextsFromRecentTablesSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      retrieveBigQueryTableSuggestedDescriptionsSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      retrieveBigQueryTableSuggestedExamplesSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      retrieveBigQueryRecentRelevantTablesSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              retrieveBigQueryTableContextSettings,
              retrieveBigQueryTableContextsSettings,
              retrieveBigQueryTableContextsFromRecentTablesSettings,
              retrieveBigQueryTableSuggestedDescriptionsSettings,
              retrieveBigQueryTableSuggestedExamplesSettings,
              retrieveBigQueryRecentRelevantTablesSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(ContextRetrievalServiceStubSettings settings) {
      super(settings);

      retrieveBigQueryTableContextSettings =
          settings.retrieveBigQueryTableContextSettings.toBuilder();
      retrieveBigQueryTableContextsSettings =
          settings.retrieveBigQueryTableContextsSettings.toBuilder();
      retrieveBigQueryTableContextsFromRecentTablesSettings =
          settings.retrieveBigQueryTableContextsFromRecentTablesSettings.toBuilder();
      retrieveBigQueryTableSuggestedDescriptionsSettings =
          settings.retrieveBigQueryTableSuggestedDescriptionsSettings.toBuilder();
      retrieveBigQueryTableSuggestedExamplesSettings =
          settings.retrieveBigQueryTableSuggestedExamplesSettings.toBuilder();
      retrieveBigQueryRecentRelevantTablesSettings =
          settings.retrieveBigQueryRecentRelevantTablesSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              retrieveBigQueryTableContextSettings,
              retrieveBigQueryTableContextsSettings,
              retrieveBigQueryTableContextsFromRecentTablesSettings,
              retrieveBigQueryTableSuggestedDescriptionsSettings,
              retrieveBigQueryTableSuggestedExamplesSettings,
              retrieveBigQueryRecentRelevantTablesSettings,
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
          .retrieveBigQueryTableContextSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .retrieveBigQueryTableContextsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .retrieveBigQueryTableContextsFromRecentTablesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .retrieveBigQueryTableSuggestedDescriptionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .retrieveBigQueryTableSuggestedExamplesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .retrieveBigQueryRecentRelevantTablesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLocationSettings()
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

    /** Returns the builder for the settings used for calls to retrieveBigQueryTableContext. */
    public UnaryCallSettings.Builder<
            RetrieveBigQueryTableContextRequest, RetrieveBigQueryTableContextResponse>
        retrieveBigQueryTableContextSettings() {
      return retrieveBigQueryTableContextSettings;
    }

    /** Returns the builder for the settings used for calls to retrieveBigQueryTableContexts. */
    public UnaryCallSettings.Builder<
            RetrieveBigQueryTableContextsRequest, RetrieveBigQueryTableContextsResponse>
        retrieveBigQueryTableContextsSettings() {
      return retrieveBigQueryTableContextsSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * retrieveBigQueryTableContextsFromRecentTables.
     */
    public UnaryCallSettings.Builder<
            RetrieveBigQueryTableContextsFromRecentTablesRequest,
            RetrieveBigQueryTableContextsFromRecentTablesResponse>
        retrieveBigQueryTableContextsFromRecentTablesSettings() {
      return retrieveBigQueryTableContextsFromRecentTablesSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * retrieveBigQueryTableSuggestedDescriptions.
     */
    public UnaryCallSettings.Builder<
            RetrieveBigQueryTableSuggestedDescriptionsRequest,
            RetrieveBigQueryTableSuggestedDescriptionsResponse>
        retrieveBigQueryTableSuggestedDescriptionsSettings() {
      return retrieveBigQueryTableSuggestedDescriptionsSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * retrieveBigQueryTableSuggestedExamples.
     */
    public UnaryCallSettings.Builder<
            RetrieveBigQueryTableSuggestedExamplesRequest,
            RetrieveBigQueryTableSuggestedExamplesResponse>
        retrieveBigQueryTableSuggestedExamplesSettings() {
      return retrieveBigQueryTableSuggestedExamplesSettings;
    }

    /**
     * Returns the builder for the settings used for calls to retrieveBigQueryRecentRelevantTables.
     */
    public UnaryCallSettings.Builder<
            RetrieveBigQueryRecentRelevantTablesRequest,
            RetrieveBigQueryRecentRelevantTablesResponse>
        retrieveBigQueryRecentRelevantTablesSettings() {
      return retrieveBigQueryRecentRelevantTablesSettings;
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
    public ContextRetrievalServiceStubSettings build() throws IOException {
      return new ContextRetrievalServiceStubSettings(this);
    }
  }
}
