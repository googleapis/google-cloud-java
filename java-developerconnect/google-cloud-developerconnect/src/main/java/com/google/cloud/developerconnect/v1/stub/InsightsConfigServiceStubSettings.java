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

package com.google.cloud.developerconnect.v1.stub;

import static com.google.cloud.developerconnect.v1.InsightsConfigServiceClient.ListInsightsConfigsPagedResponse;
import static com.google.cloud.developerconnect.v1.InsightsConfigServiceClient.ListLocationsPagedResponse;

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
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.developerconnect.v1.CreateInsightsConfigRequest;
import com.google.cloud.developerconnect.v1.DeleteInsightsConfigRequest;
import com.google.cloud.developerconnect.v1.GetInsightsConfigRequest;
import com.google.cloud.developerconnect.v1.InsightsConfig;
import com.google.cloud.developerconnect.v1.ListInsightsConfigsRequest;
import com.google.cloud.developerconnect.v1.ListInsightsConfigsResponse;
import com.google.cloud.developerconnect.v1.OperationMetadata;
import com.google.cloud.developerconnect.v1.UpdateInsightsConfigRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link InsightsConfigServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (developerconnect.googleapis.com) and default port (443) are
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
 * of getInsightsConfig:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * InsightsConfigServiceStubSettings.Builder insightsConfigServiceSettingsBuilder =
 *     InsightsConfigServiceStubSettings.newBuilder();
 * insightsConfigServiceSettingsBuilder
 *     .getInsightsConfigSettings()
 *     .setRetrySettings(
 *         insightsConfigServiceSettingsBuilder
 *             .getInsightsConfigSettings()
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
 * InsightsConfigServiceStubSettings insightsConfigServiceSettings =
 *     insightsConfigServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createInsightsConfig:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * InsightsConfigServiceStubSettings.Builder insightsConfigServiceSettingsBuilder =
 *     InsightsConfigServiceStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * insightsConfigServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class InsightsConfigServiceStubSettings
    extends StubSettings<InsightsConfigServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListInsightsConfigsRequest, ListInsightsConfigsResponse, ListInsightsConfigsPagedResponse>
      listInsightsConfigsSettings;
  private final UnaryCallSettings<CreateInsightsConfigRequest, Operation>
      createInsightsConfigSettings;
  private final OperationCallSettings<
          CreateInsightsConfigRequest, InsightsConfig, OperationMetadata>
      createInsightsConfigOperationSettings;
  private final UnaryCallSettings<GetInsightsConfigRequest, InsightsConfig>
      getInsightsConfigSettings;
  private final UnaryCallSettings<UpdateInsightsConfigRequest, Operation>
      updateInsightsConfigSettings;
  private final OperationCallSettings<
          UpdateInsightsConfigRequest, InsightsConfig, OperationMetadata>
      updateInsightsConfigOperationSettings;
  private final UnaryCallSettings<DeleteInsightsConfigRequest, Operation>
      deleteInsightsConfigSettings;
  private final OperationCallSettings<DeleteInsightsConfigRequest, Empty, OperationMetadata>
      deleteInsightsConfigOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<
          ListInsightsConfigsRequest, ListInsightsConfigsResponse, InsightsConfig>
      LIST_INSIGHTS_CONFIGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListInsightsConfigsRequest, ListInsightsConfigsResponse, InsightsConfig>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListInsightsConfigsRequest injectToken(
                ListInsightsConfigsRequest payload, String token) {
              return ListInsightsConfigsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListInsightsConfigsRequest injectPageSize(
                ListInsightsConfigsRequest payload, int pageSize) {
              return ListInsightsConfigsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListInsightsConfigsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListInsightsConfigsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<InsightsConfig> extractResources(ListInsightsConfigsResponse payload) {
              return payload.getInsightsConfigsList();
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
          ListInsightsConfigsRequest, ListInsightsConfigsResponse, ListInsightsConfigsPagedResponse>
      LIST_INSIGHTS_CONFIGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListInsightsConfigsRequest,
              ListInsightsConfigsResponse,
              ListInsightsConfigsPagedResponse>() {
            @Override
            public ApiFuture<ListInsightsConfigsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListInsightsConfigsRequest, ListInsightsConfigsResponse> callable,
                ListInsightsConfigsRequest request,
                ApiCallContext context,
                ApiFuture<ListInsightsConfigsResponse> futureResponse) {
              PageContext<ListInsightsConfigsRequest, ListInsightsConfigsResponse, InsightsConfig>
                  pageContext =
                      PageContext.create(
                          callable, LIST_INSIGHTS_CONFIGS_PAGE_STR_DESC, request, context);
              return ListInsightsConfigsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listInsightsConfigs. */
  public PagedCallSettings<
          ListInsightsConfigsRequest, ListInsightsConfigsResponse, ListInsightsConfigsPagedResponse>
      listInsightsConfigsSettings() {
    return listInsightsConfigsSettings;
  }

  /** Returns the object with the settings used for calls to createInsightsConfig. */
  public UnaryCallSettings<CreateInsightsConfigRequest, Operation> createInsightsConfigSettings() {
    return createInsightsConfigSettings;
  }

  /** Returns the object with the settings used for calls to createInsightsConfig. */
  public OperationCallSettings<CreateInsightsConfigRequest, InsightsConfig, OperationMetadata>
      createInsightsConfigOperationSettings() {
    return createInsightsConfigOperationSettings;
  }

  /** Returns the object with the settings used for calls to getInsightsConfig. */
  public UnaryCallSettings<GetInsightsConfigRequest, InsightsConfig> getInsightsConfigSettings() {
    return getInsightsConfigSettings;
  }

  /** Returns the object with the settings used for calls to updateInsightsConfig. */
  public UnaryCallSettings<UpdateInsightsConfigRequest, Operation> updateInsightsConfigSettings() {
    return updateInsightsConfigSettings;
  }

  /** Returns the object with the settings used for calls to updateInsightsConfig. */
  public OperationCallSettings<UpdateInsightsConfigRequest, InsightsConfig, OperationMetadata>
      updateInsightsConfigOperationSettings() {
    return updateInsightsConfigOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteInsightsConfig. */
  public UnaryCallSettings<DeleteInsightsConfigRequest, Operation> deleteInsightsConfigSettings() {
    return deleteInsightsConfigSettings;
  }

  /** Returns the object with the settings used for calls to deleteInsightsConfig. */
  public OperationCallSettings<DeleteInsightsConfigRequest, Empty, OperationMetadata>
      deleteInsightsConfigOperationSettings() {
    return deleteInsightsConfigOperationSettings;
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

  public InsightsConfigServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcInsightsConfigServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonInsightsConfigServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "developerconnect";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "developerconnect.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "developerconnect.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(InsightsConfigServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(InsightsConfigServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return InsightsConfigServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected InsightsConfigServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listInsightsConfigsSettings = settingsBuilder.listInsightsConfigsSettings().build();
    createInsightsConfigSettings = settingsBuilder.createInsightsConfigSettings().build();
    createInsightsConfigOperationSettings =
        settingsBuilder.createInsightsConfigOperationSettings().build();
    getInsightsConfigSettings = settingsBuilder.getInsightsConfigSettings().build();
    updateInsightsConfigSettings = settingsBuilder.updateInsightsConfigSettings().build();
    updateInsightsConfigOperationSettings =
        settingsBuilder.updateInsightsConfigOperationSettings().build();
    deleteInsightsConfigSettings = settingsBuilder.deleteInsightsConfigSettings().build();
    deleteInsightsConfigOperationSettings =
        settingsBuilder.deleteInsightsConfigOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for InsightsConfigServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<InsightsConfigServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListInsightsConfigsRequest,
            ListInsightsConfigsResponse,
            ListInsightsConfigsPagedResponse>
        listInsightsConfigsSettings;
    private final UnaryCallSettings.Builder<CreateInsightsConfigRequest, Operation>
        createInsightsConfigSettings;
    private final OperationCallSettings.Builder<
            CreateInsightsConfigRequest, InsightsConfig, OperationMetadata>
        createInsightsConfigOperationSettings;
    private final UnaryCallSettings.Builder<GetInsightsConfigRequest, InsightsConfig>
        getInsightsConfigSettings;
    private final UnaryCallSettings.Builder<UpdateInsightsConfigRequest, Operation>
        updateInsightsConfigSettings;
    private final OperationCallSettings.Builder<
            UpdateInsightsConfigRequest, InsightsConfig, OperationMetadata>
        updateInsightsConfigOperationSettings;
    private final UnaryCallSettings.Builder<DeleteInsightsConfigRequest, Operation>
        deleteInsightsConfigSettings;
    private final OperationCallSettings.Builder<
            DeleteInsightsConfigRequest, Empty, OperationMetadata>
        deleteInsightsConfigOperationSettings;
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

      listInsightsConfigsSettings =
          PagedCallSettings.newBuilder(LIST_INSIGHTS_CONFIGS_PAGE_STR_FACT);
      createInsightsConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createInsightsConfigOperationSettings = OperationCallSettings.newBuilder();
      getInsightsConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateInsightsConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateInsightsConfigOperationSettings = OperationCallSettings.newBuilder();
      deleteInsightsConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteInsightsConfigOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listInsightsConfigsSettings,
              createInsightsConfigSettings,
              getInsightsConfigSettings,
              updateInsightsConfigSettings,
              deleteInsightsConfigSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(InsightsConfigServiceStubSettings settings) {
      super(settings);

      listInsightsConfigsSettings = settings.listInsightsConfigsSettings.toBuilder();
      createInsightsConfigSettings = settings.createInsightsConfigSettings.toBuilder();
      createInsightsConfigOperationSettings =
          settings.createInsightsConfigOperationSettings.toBuilder();
      getInsightsConfigSettings = settings.getInsightsConfigSettings.toBuilder();
      updateInsightsConfigSettings = settings.updateInsightsConfigSettings.toBuilder();
      updateInsightsConfigOperationSettings =
          settings.updateInsightsConfigOperationSettings.toBuilder();
      deleteInsightsConfigSettings = settings.deleteInsightsConfigSettings.toBuilder();
      deleteInsightsConfigOperationSettings =
          settings.deleteInsightsConfigOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listInsightsConfigsSettings,
              createInsightsConfigSettings,
              getInsightsConfigSettings,
              updateInsightsConfigSettings,
              deleteInsightsConfigSettings,
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
          .listInsightsConfigsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createInsightsConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getInsightsConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateInsightsConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteInsightsConfigSettings()
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

      builder
          .createInsightsConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateInsightsConfigRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(InsightsConfig.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateInsightsConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateInsightsConfigRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(InsightsConfig.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteInsightsConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteInsightsConfigRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

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

    /** Returns the builder for the settings used for calls to listInsightsConfigs. */
    public PagedCallSettings.Builder<
            ListInsightsConfigsRequest,
            ListInsightsConfigsResponse,
            ListInsightsConfigsPagedResponse>
        listInsightsConfigsSettings() {
      return listInsightsConfigsSettings;
    }

    /** Returns the builder for the settings used for calls to createInsightsConfig. */
    public UnaryCallSettings.Builder<CreateInsightsConfigRequest, Operation>
        createInsightsConfigSettings() {
      return createInsightsConfigSettings;
    }

    /** Returns the builder for the settings used for calls to createInsightsConfig. */
    public OperationCallSettings.Builder<
            CreateInsightsConfigRequest, InsightsConfig, OperationMetadata>
        createInsightsConfigOperationSettings() {
      return createInsightsConfigOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getInsightsConfig. */
    public UnaryCallSettings.Builder<GetInsightsConfigRequest, InsightsConfig>
        getInsightsConfigSettings() {
      return getInsightsConfigSettings;
    }

    /** Returns the builder for the settings used for calls to updateInsightsConfig. */
    public UnaryCallSettings.Builder<UpdateInsightsConfigRequest, Operation>
        updateInsightsConfigSettings() {
      return updateInsightsConfigSettings;
    }

    /** Returns the builder for the settings used for calls to updateInsightsConfig. */
    public OperationCallSettings.Builder<
            UpdateInsightsConfigRequest, InsightsConfig, OperationMetadata>
        updateInsightsConfigOperationSettings() {
      return updateInsightsConfigOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteInsightsConfig. */
    public UnaryCallSettings.Builder<DeleteInsightsConfigRequest, Operation>
        deleteInsightsConfigSettings() {
      return deleteInsightsConfigSettings;
    }

    /** Returns the builder for the settings used for calls to deleteInsightsConfig. */
    public OperationCallSettings.Builder<DeleteInsightsConfigRequest, Empty, OperationMetadata>
        deleteInsightsConfigOperationSettings() {
      return deleteInsightsConfigOperationSettings;
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
    public InsightsConfigServiceStubSettings build() throws IOException {
      return new InsightsConfigServiceStubSettings(this);
    }
  }
}
