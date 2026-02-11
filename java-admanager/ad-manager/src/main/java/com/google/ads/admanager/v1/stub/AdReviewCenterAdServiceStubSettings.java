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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.AdReviewCenterAdServiceClient.SearchAdReviewCenterAdsPagedResponse;

import com.google.ads.admanager.v1.AdReviewCenterAd;
import com.google.ads.admanager.v1.BatchAdReviewCenterAdsOperationMetadata;
import com.google.ads.admanager.v1.BatchAllowAdReviewCenterAdsRequest;
import com.google.ads.admanager.v1.BatchAllowAdReviewCenterAdsResponse;
import com.google.ads.admanager.v1.BatchBlockAdReviewCenterAdsRequest;
import com.google.ads.admanager.v1.BatchBlockAdReviewCenterAdsResponse;
import com.google.ads.admanager.v1.SearchAdReviewCenterAdsRequest;
import com.google.ads.admanager.v1.SearchAdReviewCenterAdsResponse;
import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.httpjson.ProtoOperationTransformers;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AdReviewCenterAdServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (admanager.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of searchAdReviewCenterAds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AdReviewCenterAdServiceStubSettings.Builder adReviewCenterAdServiceSettingsBuilder =
 *     AdReviewCenterAdServiceStubSettings.newBuilder();
 * adReviewCenterAdServiceSettingsBuilder
 *     .searchAdReviewCenterAdsSettings()
 *     .setRetrySettings(
 *         adReviewCenterAdServiceSettingsBuilder
 *             .searchAdReviewCenterAdsSettings()
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
 * AdReviewCenterAdServiceStubSettings adReviewCenterAdServiceSettings =
 *     adReviewCenterAdServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for batchAllowAdReviewCenterAds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AdReviewCenterAdServiceStubSettings.Builder adReviewCenterAdServiceSettingsBuilder =
 *     AdReviewCenterAdServiceStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * adReviewCenterAdServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AdReviewCenterAdServiceStubSettings
    extends StubSettings<AdReviewCenterAdServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/admanager").build();

  private final PagedCallSettings<
          SearchAdReviewCenterAdsRequest,
          SearchAdReviewCenterAdsResponse,
          SearchAdReviewCenterAdsPagedResponse>
      searchAdReviewCenterAdsSettings;
  private final UnaryCallSettings<BatchAllowAdReviewCenterAdsRequest, Operation>
      batchAllowAdReviewCenterAdsSettings;
  private final OperationCallSettings<
          BatchAllowAdReviewCenterAdsRequest,
          BatchAllowAdReviewCenterAdsResponse,
          BatchAdReviewCenterAdsOperationMetadata>
      batchAllowAdReviewCenterAdsOperationSettings;
  private final UnaryCallSettings<BatchBlockAdReviewCenterAdsRequest, Operation>
      batchBlockAdReviewCenterAdsSettings;
  private final OperationCallSettings<
          BatchBlockAdReviewCenterAdsRequest,
          BatchBlockAdReviewCenterAdsResponse,
          BatchAdReviewCenterAdsOperationMetadata>
      batchBlockAdReviewCenterAdsOperationSettings;

  private static final PagedListDescriptor<
          SearchAdReviewCenterAdsRequest, SearchAdReviewCenterAdsResponse, AdReviewCenterAd>
      SEARCH_AD_REVIEW_CENTER_ADS_PAGE_STR_DESC =
          new PagedListDescriptor<
              SearchAdReviewCenterAdsRequest, SearchAdReviewCenterAdsResponse, AdReviewCenterAd>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchAdReviewCenterAdsRequest injectToken(
                SearchAdReviewCenterAdsRequest payload, String token) {
              return SearchAdReviewCenterAdsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public SearchAdReviewCenterAdsRequest injectPageSize(
                SearchAdReviewCenterAdsRequest payload, int pageSize) {
              return SearchAdReviewCenterAdsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(SearchAdReviewCenterAdsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchAdReviewCenterAdsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AdReviewCenterAd> extractResources(
                SearchAdReviewCenterAdsResponse payload) {
              return payload.getAdReviewCenterAdsList();
            }
          };

  private static final PagedListResponseFactory<
          SearchAdReviewCenterAdsRequest,
          SearchAdReviewCenterAdsResponse,
          SearchAdReviewCenterAdsPagedResponse>
      SEARCH_AD_REVIEW_CENTER_ADS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchAdReviewCenterAdsRequest,
              SearchAdReviewCenterAdsResponse,
              SearchAdReviewCenterAdsPagedResponse>() {
            @Override
            public ApiFuture<SearchAdReviewCenterAdsPagedResponse> getFuturePagedResponse(
                UnaryCallable<SearchAdReviewCenterAdsRequest, SearchAdReviewCenterAdsResponse>
                    callable,
                SearchAdReviewCenterAdsRequest request,
                ApiCallContext context,
                ApiFuture<SearchAdReviewCenterAdsResponse> futureResponse) {
              PageContext<
                      SearchAdReviewCenterAdsRequest,
                      SearchAdReviewCenterAdsResponse,
                      AdReviewCenterAd>
                  pageContext =
                      PageContext.create(
                          callable, SEARCH_AD_REVIEW_CENTER_ADS_PAGE_STR_DESC, request, context);
              return SearchAdReviewCenterAdsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to searchAdReviewCenterAds. */
  public PagedCallSettings<
          SearchAdReviewCenterAdsRequest,
          SearchAdReviewCenterAdsResponse,
          SearchAdReviewCenterAdsPagedResponse>
      searchAdReviewCenterAdsSettings() {
    return searchAdReviewCenterAdsSettings;
  }

  /** Returns the object with the settings used for calls to batchAllowAdReviewCenterAds. */
  public UnaryCallSettings<BatchAllowAdReviewCenterAdsRequest, Operation>
      batchAllowAdReviewCenterAdsSettings() {
    return batchAllowAdReviewCenterAdsSettings;
  }

  /** Returns the object with the settings used for calls to batchAllowAdReviewCenterAds. */
  public OperationCallSettings<
          BatchAllowAdReviewCenterAdsRequest,
          BatchAllowAdReviewCenterAdsResponse,
          BatchAdReviewCenterAdsOperationMetadata>
      batchAllowAdReviewCenterAdsOperationSettings() {
    return batchAllowAdReviewCenterAdsOperationSettings;
  }

  /** Returns the object with the settings used for calls to batchBlockAdReviewCenterAds. */
  public UnaryCallSettings<BatchBlockAdReviewCenterAdsRequest, Operation>
      batchBlockAdReviewCenterAdsSettings() {
    return batchBlockAdReviewCenterAdsSettings;
  }

  /** Returns the object with the settings used for calls to batchBlockAdReviewCenterAds. */
  public OperationCallSettings<
          BatchBlockAdReviewCenterAdsRequest,
          BatchBlockAdReviewCenterAdsResponse,
          BatchAdReviewCenterAdsOperationMetadata>
      batchBlockAdReviewCenterAdsOperationSettings() {
    return batchBlockAdReviewCenterAdsOperationSettings;
  }

  public AdReviewCenterAdServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonAdReviewCenterAdServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "admanager";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "admanager.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "admanager.mtls.googleapis.com:443";
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

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultHttpJsonTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(AdReviewCenterAdServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
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

  protected AdReviewCenterAdServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    searchAdReviewCenterAdsSettings = settingsBuilder.searchAdReviewCenterAdsSettings().build();
    batchAllowAdReviewCenterAdsSettings =
        settingsBuilder.batchAllowAdReviewCenterAdsSettings().build();
    batchAllowAdReviewCenterAdsOperationSettings =
        settingsBuilder.batchAllowAdReviewCenterAdsOperationSettings().build();
    batchBlockAdReviewCenterAdsSettings =
        settingsBuilder.batchBlockAdReviewCenterAdsSettings().build();
    batchBlockAdReviewCenterAdsOperationSettings =
        settingsBuilder.batchBlockAdReviewCenterAdsOperationSettings().build();
  }

  /** Builder for AdReviewCenterAdServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<AdReviewCenterAdServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            SearchAdReviewCenterAdsRequest,
            SearchAdReviewCenterAdsResponse,
            SearchAdReviewCenterAdsPagedResponse>
        searchAdReviewCenterAdsSettings;
    private final UnaryCallSettings.Builder<BatchAllowAdReviewCenterAdsRequest, Operation>
        batchAllowAdReviewCenterAdsSettings;
    private final OperationCallSettings.Builder<
            BatchAllowAdReviewCenterAdsRequest,
            BatchAllowAdReviewCenterAdsResponse,
            BatchAdReviewCenterAdsOperationMetadata>
        batchAllowAdReviewCenterAdsOperationSettings;
    private final UnaryCallSettings.Builder<BatchBlockAdReviewCenterAdsRequest, Operation>
        batchBlockAdReviewCenterAdsSettings;
    private final OperationCallSettings.Builder<
            BatchBlockAdReviewCenterAdsRequest,
            BatchBlockAdReviewCenterAdsResponse,
            BatchAdReviewCenterAdsOperationMetadata>
        batchBlockAdReviewCenterAdsOperationSettings;
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

      searchAdReviewCenterAdsSettings =
          PagedCallSettings.newBuilder(SEARCH_AD_REVIEW_CENTER_ADS_PAGE_STR_FACT);
      batchAllowAdReviewCenterAdsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchAllowAdReviewCenterAdsOperationSettings = OperationCallSettings.newBuilder();
      batchBlockAdReviewCenterAdsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchBlockAdReviewCenterAdsOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              searchAdReviewCenterAdsSettings,
              batchAllowAdReviewCenterAdsSettings,
              batchBlockAdReviewCenterAdsSettings);
      initDefaults(this);
    }

    protected Builder(AdReviewCenterAdServiceStubSettings settings) {
      super(settings);

      searchAdReviewCenterAdsSettings = settings.searchAdReviewCenterAdsSettings.toBuilder();
      batchAllowAdReviewCenterAdsSettings =
          settings.batchAllowAdReviewCenterAdsSettings.toBuilder();
      batchAllowAdReviewCenterAdsOperationSettings =
          settings.batchAllowAdReviewCenterAdsOperationSettings.toBuilder();
      batchBlockAdReviewCenterAdsSettings =
          settings.batchBlockAdReviewCenterAdsSettings.toBuilder();
      batchBlockAdReviewCenterAdsOperationSettings =
          settings.batchBlockAdReviewCenterAdsOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              searchAdReviewCenterAdsSettings,
              batchAllowAdReviewCenterAdsSettings,
              batchBlockAdReviewCenterAdsSettings);
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

    private static Builder initDefaults(Builder builder) {
      builder
          .searchAdReviewCenterAdsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchAllowAdReviewCenterAdsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchBlockAdReviewCenterAdsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchAllowAdReviewCenterAdsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BatchAllowAdReviewCenterAdsRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  BatchAllowAdReviewCenterAdsResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  BatchAdReviewCenterAdsOperationMetadata.class))
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
          .batchBlockAdReviewCenterAdsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BatchBlockAdReviewCenterAdsRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  BatchBlockAdReviewCenterAdsResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  BatchAdReviewCenterAdsOperationMetadata.class))
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

    /** Returns the builder for the settings used for calls to searchAdReviewCenterAds. */
    public PagedCallSettings.Builder<
            SearchAdReviewCenterAdsRequest,
            SearchAdReviewCenterAdsResponse,
            SearchAdReviewCenterAdsPagedResponse>
        searchAdReviewCenterAdsSettings() {
      return searchAdReviewCenterAdsSettings;
    }

    /** Returns the builder for the settings used for calls to batchAllowAdReviewCenterAds. */
    public UnaryCallSettings.Builder<BatchAllowAdReviewCenterAdsRequest, Operation>
        batchAllowAdReviewCenterAdsSettings() {
      return batchAllowAdReviewCenterAdsSettings;
    }

    /** Returns the builder for the settings used for calls to batchAllowAdReviewCenterAds. */
    public OperationCallSettings.Builder<
            BatchAllowAdReviewCenterAdsRequest,
            BatchAllowAdReviewCenterAdsResponse,
            BatchAdReviewCenterAdsOperationMetadata>
        batchAllowAdReviewCenterAdsOperationSettings() {
      return batchAllowAdReviewCenterAdsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to batchBlockAdReviewCenterAds. */
    public UnaryCallSettings.Builder<BatchBlockAdReviewCenterAdsRequest, Operation>
        batchBlockAdReviewCenterAdsSettings() {
      return batchBlockAdReviewCenterAdsSettings;
    }

    /** Returns the builder for the settings used for calls to batchBlockAdReviewCenterAds. */
    public OperationCallSettings.Builder<
            BatchBlockAdReviewCenterAdsRequest,
            BatchBlockAdReviewCenterAdsResponse,
            BatchAdReviewCenterAdsOperationMetadata>
        batchBlockAdReviewCenterAdsOperationSettings() {
      return batchBlockAdReviewCenterAdsOperationSettings;
    }

    @Override
    public AdReviewCenterAdServiceStubSettings build() throws IOException {
      return new AdReviewCenterAdServiceStubSettings(this);
    }
  }
}
