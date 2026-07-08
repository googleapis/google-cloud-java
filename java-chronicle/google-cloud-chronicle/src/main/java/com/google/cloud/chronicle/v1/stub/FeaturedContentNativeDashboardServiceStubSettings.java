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

package com.google.cloud.chronicle.v1.stub;

import static com.google.cloud.chronicle.v1.FeaturedContentNativeDashboardServiceClient.ListFeaturedContentNativeDashboardsPagedResponse;

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
import com.google.api.gax.rpc.LibraryMetadata;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.chronicle.v1.FeaturedContentNativeDashboard;
import com.google.cloud.chronicle.v1.GetFeaturedContentNativeDashboardRequest;
import com.google.cloud.chronicle.v1.InstallFeaturedContentNativeDashboardRequest;
import com.google.cloud.chronicle.v1.InstallFeaturedContentNativeDashboardResponse;
import com.google.cloud.chronicle.v1.ListFeaturedContentNativeDashboardsRequest;
import com.google.cloud.chronicle.v1.ListFeaturedContentNativeDashboardsResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link FeaturedContentNativeDashboardServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (chronicle.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getFeaturedContentNativeDashboard:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * FeaturedContentNativeDashboardServiceStubSettings.Builder
 *     featuredContentNativeDashboardServiceSettingsBuilder =
 *         FeaturedContentNativeDashboardServiceStubSettings.newBuilder();
 * featuredContentNativeDashboardServiceSettingsBuilder
 *     .getFeaturedContentNativeDashboardSettings()
 *     .setRetrySettings(
 *         featuredContentNativeDashboardServiceSettingsBuilder
 *             .getFeaturedContentNativeDashboardSettings()
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
 * FeaturedContentNativeDashboardServiceStubSettings
 *     featuredContentNativeDashboardServiceSettings =
 *         featuredContentNativeDashboardServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class FeaturedContentNativeDashboardServiceStubSettings
    extends StubSettings<FeaturedContentNativeDashboardServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/chronicle")
          .add("https://www.googleapis.com/auth/chronicle.readonly")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final UnaryCallSettings<
          GetFeaturedContentNativeDashboardRequest, FeaturedContentNativeDashboard>
      getFeaturedContentNativeDashboardSettings;
  private final PagedCallSettings<
          ListFeaturedContentNativeDashboardsRequest,
          ListFeaturedContentNativeDashboardsResponse,
          ListFeaturedContentNativeDashboardsPagedResponse>
      listFeaturedContentNativeDashboardsSettings;
  private final UnaryCallSettings<
          InstallFeaturedContentNativeDashboardRequest,
          InstallFeaturedContentNativeDashboardResponse>
      installFeaturedContentNativeDashboardSettings;

  private static final PagedListDescriptor<
          ListFeaturedContentNativeDashboardsRequest,
          ListFeaturedContentNativeDashboardsResponse,
          FeaturedContentNativeDashboard>
      LIST_FEATURED_CONTENT_NATIVE_DASHBOARDS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListFeaturedContentNativeDashboardsRequest,
              ListFeaturedContentNativeDashboardsResponse,
              FeaturedContentNativeDashboard>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListFeaturedContentNativeDashboardsRequest injectToken(
                ListFeaturedContentNativeDashboardsRequest payload, String token) {
              return ListFeaturedContentNativeDashboardsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListFeaturedContentNativeDashboardsRequest injectPageSize(
                ListFeaturedContentNativeDashboardsRequest payload, int pageSize) {
              return ListFeaturedContentNativeDashboardsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListFeaturedContentNativeDashboardsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListFeaturedContentNativeDashboardsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<FeaturedContentNativeDashboard> extractResources(
                ListFeaturedContentNativeDashboardsResponse payload) {
              return payload.getFeaturedContentNativeDashboardsList();
            }
          };

  private static final PagedListResponseFactory<
          ListFeaturedContentNativeDashboardsRequest,
          ListFeaturedContentNativeDashboardsResponse,
          ListFeaturedContentNativeDashboardsPagedResponse>
      LIST_FEATURED_CONTENT_NATIVE_DASHBOARDS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListFeaturedContentNativeDashboardsRequest,
              ListFeaturedContentNativeDashboardsResponse,
              ListFeaturedContentNativeDashboardsPagedResponse>() {
            @Override
            public ApiFuture<ListFeaturedContentNativeDashboardsPagedResponse>
                getFuturePagedResponse(
                    UnaryCallable<
                            ListFeaturedContentNativeDashboardsRequest,
                            ListFeaturedContentNativeDashboardsResponse>
                        callable,
                    ListFeaturedContentNativeDashboardsRequest request,
                    ApiCallContext context,
                    ApiFuture<ListFeaturedContentNativeDashboardsResponse> futureResponse) {
              PageContext<
                      ListFeaturedContentNativeDashboardsRequest,
                      ListFeaturedContentNativeDashboardsResponse,
                      FeaturedContentNativeDashboard>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_FEATURED_CONTENT_NATIVE_DASHBOARDS_PAGE_STR_DESC,
                          request,
                          context);
              return ListFeaturedContentNativeDashboardsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getFeaturedContentNativeDashboard. */
  public UnaryCallSettings<GetFeaturedContentNativeDashboardRequest, FeaturedContentNativeDashboard>
      getFeaturedContentNativeDashboardSettings() {
    return getFeaturedContentNativeDashboardSettings;
  }

  /** Returns the object with the settings used for calls to listFeaturedContentNativeDashboards. */
  public PagedCallSettings<
          ListFeaturedContentNativeDashboardsRequest,
          ListFeaturedContentNativeDashboardsResponse,
          ListFeaturedContentNativeDashboardsPagedResponse>
      listFeaturedContentNativeDashboardsSettings() {
    return listFeaturedContentNativeDashboardsSettings;
  }

  /**
   * Returns the object with the settings used for calls to installFeaturedContentNativeDashboard.
   */
  public UnaryCallSettings<
          InstallFeaturedContentNativeDashboardRequest,
          InstallFeaturedContentNativeDashboardResponse>
      installFeaturedContentNativeDashboardSettings() {
    return installFeaturedContentNativeDashboardSettings;
  }

  public FeaturedContentNativeDashboardServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcFeaturedContentNativeDashboardServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonFeaturedContentNativeDashboardServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "chronicle";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "chronicle.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "chronicle.mtls.googleapis.com:443";
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
            "gapic",
            GaxProperties.getLibraryVersion(
                FeaturedContentNativeDashboardServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic",
            GaxProperties.getLibraryVersion(
                FeaturedContentNativeDashboardServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return FeaturedContentNativeDashboardServiceStubSettings
        .defaultGrpcApiClientHeaderProviderBuilder();
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

  protected FeaturedContentNativeDashboardServiceStubSettings(Builder settingsBuilder)
      throws IOException {
    super(settingsBuilder);

    getFeaturedContentNativeDashboardSettings =
        settingsBuilder.getFeaturedContentNativeDashboardSettings().build();
    listFeaturedContentNativeDashboardsSettings =
        settingsBuilder.listFeaturedContentNativeDashboardsSettings().build();
    installFeaturedContentNativeDashboardSettings =
        settingsBuilder.installFeaturedContentNativeDashboardSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.cloud:google-cloud-chronicle")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for FeaturedContentNativeDashboardServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<FeaturedContentNativeDashboardServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<
            GetFeaturedContentNativeDashboardRequest, FeaturedContentNativeDashboard>
        getFeaturedContentNativeDashboardSettings;
    private final PagedCallSettings.Builder<
            ListFeaturedContentNativeDashboardsRequest,
            ListFeaturedContentNativeDashboardsResponse,
            ListFeaturedContentNativeDashboardsPagedResponse>
        listFeaturedContentNativeDashboardsSettings;
    private final UnaryCallSettings.Builder<
            InstallFeaturedContentNativeDashboardRequest,
            InstallFeaturedContentNativeDashboardResponse>
        installFeaturedContentNativeDashboardSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
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
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(60000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
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

      getFeaturedContentNativeDashboardSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listFeaturedContentNativeDashboardsSettings =
          PagedCallSettings.newBuilder(LIST_FEATURED_CONTENT_NATIVE_DASHBOARDS_PAGE_STR_FACT);
      installFeaturedContentNativeDashboardSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getFeaturedContentNativeDashboardSettings,
              listFeaturedContentNativeDashboardsSettings,
              installFeaturedContentNativeDashboardSettings);
      initDefaults(this);
    }

    protected Builder(FeaturedContentNativeDashboardServiceStubSettings settings) {
      super(settings);

      getFeaturedContentNativeDashboardSettings =
          settings.getFeaturedContentNativeDashboardSettings.toBuilder();
      listFeaturedContentNativeDashboardsSettings =
          settings.listFeaturedContentNativeDashboardsSettings.toBuilder();
      installFeaturedContentNativeDashboardSettings =
          settings.installFeaturedContentNativeDashboardSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getFeaturedContentNativeDashboardSettings,
              listFeaturedContentNativeDashboardsSettings,
              installFeaturedContentNativeDashboardSettings);
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
          .getFeaturedContentNativeDashboardSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listFeaturedContentNativeDashboardsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .installFeaturedContentNativeDashboardSettings()
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

    /** Returns the builder for the settings used for calls to getFeaturedContentNativeDashboard. */
    public UnaryCallSettings.Builder<
            GetFeaturedContentNativeDashboardRequest, FeaturedContentNativeDashboard>
        getFeaturedContentNativeDashboardSettings() {
      return getFeaturedContentNativeDashboardSettings;
    }

    /**
     * Returns the builder for the settings used for calls to listFeaturedContentNativeDashboards.
     */
    public PagedCallSettings.Builder<
            ListFeaturedContentNativeDashboardsRequest,
            ListFeaturedContentNativeDashboardsResponse,
            ListFeaturedContentNativeDashboardsPagedResponse>
        listFeaturedContentNativeDashboardsSettings() {
      return listFeaturedContentNativeDashboardsSettings;
    }

    /**
     * Returns the builder for the settings used for calls to installFeaturedContentNativeDashboard.
     */
    public UnaryCallSettings.Builder<
            InstallFeaturedContentNativeDashboardRequest,
            InstallFeaturedContentNativeDashboardResponse>
        installFeaturedContentNativeDashboardSettings() {
      return installFeaturedContentNativeDashboardSettings;
    }

    @Override
    public FeaturedContentNativeDashboardServiceStubSettings build() throws IOException {
      return new FeaturedContentNativeDashboardServiceStubSettings(this);
    }
  }
}
