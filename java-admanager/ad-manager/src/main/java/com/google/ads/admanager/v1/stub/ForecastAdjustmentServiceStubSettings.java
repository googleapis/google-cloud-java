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

import static com.google.ads.admanager.v1.ForecastAdjustmentServiceClient.ListForecastAdjustmentsPagedResponse;

import com.google.ads.admanager.v1.BatchActivateForecastAdjustmentsRequest;
import com.google.ads.admanager.v1.BatchActivateForecastAdjustmentsResponse;
import com.google.ads.admanager.v1.BatchCreateForecastAdjustmentsRequest;
import com.google.ads.admanager.v1.BatchCreateForecastAdjustmentsResponse;
import com.google.ads.admanager.v1.BatchDeactivateForecastAdjustmentsRequest;
import com.google.ads.admanager.v1.BatchDeactivateForecastAdjustmentsResponse;
import com.google.ads.admanager.v1.BatchUpdateForecastAdjustmentsRequest;
import com.google.ads.admanager.v1.BatchUpdateForecastAdjustmentsResponse;
import com.google.ads.admanager.v1.CalculateDailyAdOpportunityCountsRequest;
import com.google.ads.admanager.v1.CalculateDailyAdOpportunityCountsResponse;
import com.google.ads.admanager.v1.CreateForecastAdjustmentRequest;
import com.google.ads.admanager.v1.ForecastAdjustment;
import com.google.ads.admanager.v1.GetForecastAdjustmentRequest;
import com.google.ads.admanager.v1.ListForecastAdjustmentsRequest;
import com.google.ads.admanager.v1.ListForecastAdjustmentsResponse;
import com.google.ads.admanager.v1.UpdateForecastAdjustmentRequest;
import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ForecastAdjustmentServiceStub}.
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
 * of getForecastAdjustment:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ForecastAdjustmentServiceStubSettings.Builder forecastAdjustmentServiceSettingsBuilder =
 *     ForecastAdjustmentServiceStubSettings.newBuilder();
 * forecastAdjustmentServiceSettingsBuilder
 *     .getForecastAdjustmentSettings()
 *     .setRetrySettings(
 *         forecastAdjustmentServiceSettingsBuilder
 *             .getForecastAdjustmentSettings()
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
 * ForecastAdjustmentServiceStubSettings forecastAdjustmentServiceSettings =
 *     forecastAdjustmentServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class ForecastAdjustmentServiceStubSettings
    extends StubSettings<ForecastAdjustmentServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/admanager")
          .add("https://www.googleapis.com/auth/admanager.readonly")
          .build();

  private final UnaryCallSettings<GetForecastAdjustmentRequest, ForecastAdjustment>
      getForecastAdjustmentSettings;
  private final PagedCallSettings<
          ListForecastAdjustmentsRequest,
          ListForecastAdjustmentsResponse,
          ListForecastAdjustmentsPagedResponse>
      listForecastAdjustmentsSettings;
  private final UnaryCallSettings<CreateForecastAdjustmentRequest, ForecastAdjustment>
      createForecastAdjustmentSettings;
  private final UnaryCallSettings<
          BatchCreateForecastAdjustmentsRequest, BatchCreateForecastAdjustmentsResponse>
      batchCreateForecastAdjustmentsSettings;
  private final UnaryCallSettings<
          BatchActivateForecastAdjustmentsRequest, BatchActivateForecastAdjustmentsResponse>
      batchActivateForecastAdjustmentsSettings;
  private final UnaryCallSettings<
          BatchDeactivateForecastAdjustmentsRequest, BatchDeactivateForecastAdjustmentsResponse>
      batchDeactivateForecastAdjustmentsSettings;
  private final UnaryCallSettings<UpdateForecastAdjustmentRequest, ForecastAdjustment>
      updateForecastAdjustmentSettings;
  private final UnaryCallSettings<
          BatchUpdateForecastAdjustmentsRequest, BatchUpdateForecastAdjustmentsResponse>
      batchUpdateForecastAdjustmentsSettings;
  private final UnaryCallSettings<
          CalculateDailyAdOpportunityCountsRequest, CalculateDailyAdOpportunityCountsResponse>
      calculateDailyAdOpportunityCountsSettings;

  private static final PagedListDescriptor<
          ListForecastAdjustmentsRequest, ListForecastAdjustmentsResponse, ForecastAdjustment>
      LIST_FORECAST_ADJUSTMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListForecastAdjustmentsRequest,
              ListForecastAdjustmentsResponse,
              ForecastAdjustment>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListForecastAdjustmentsRequest injectToken(
                ListForecastAdjustmentsRequest payload, String token) {
              return ListForecastAdjustmentsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListForecastAdjustmentsRequest injectPageSize(
                ListForecastAdjustmentsRequest payload, int pageSize) {
              return ListForecastAdjustmentsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListForecastAdjustmentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListForecastAdjustmentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ForecastAdjustment> extractResources(
                ListForecastAdjustmentsResponse payload) {
              return payload.getForecastAdjustmentsList();
            }
          };

  private static final PagedListResponseFactory<
          ListForecastAdjustmentsRequest,
          ListForecastAdjustmentsResponse,
          ListForecastAdjustmentsPagedResponse>
      LIST_FORECAST_ADJUSTMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListForecastAdjustmentsRequest,
              ListForecastAdjustmentsResponse,
              ListForecastAdjustmentsPagedResponse>() {
            @Override
            public ApiFuture<ListForecastAdjustmentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListForecastAdjustmentsRequest, ListForecastAdjustmentsResponse>
                    callable,
                ListForecastAdjustmentsRequest request,
                ApiCallContext context,
                ApiFuture<ListForecastAdjustmentsResponse> futureResponse) {
              PageContext<
                      ListForecastAdjustmentsRequest,
                      ListForecastAdjustmentsResponse,
                      ForecastAdjustment>
                  pageContext =
                      PageContext.create(
                          callable, LIST_FORECAST_ADJUSTMENTS_PAGE_STR_DESC, request, context);
              return ListForecastAdjustmentsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getForecastAdjustment. */
  public UnaryCallSettings<GetForecastAdjustmentRequest, ForecastAdjustment>
      getForecastAdjustmentSettings() {
    return getForecastAdjustmentSettings;
  }

  /** Returns the object with the settings used for calls to listForecastAdjustments. */
  public PagedCallSettings<
          ListForecastAdjustmentsRequest,
          ListForecastAdjustmentsResponse,
          ListForecastAdjustmentsPagedResponse>
      listForecastAdjustmentsSettings() {
    return listForecastAdjustmentsSettings;
  }

  /** Returns the object with the settings used for calls to createForecastAdjustment. */
  public UnaryCallSettings<CreateForecastAdjustmentRequest, ForecastAdjustment>
      createForecastAdjustmentSettings() {
    return createForecastAdjustmentSettings;
  }

  /** Returns the object with the settings used for calls to batchCreateForecastAdjustments. */
  public UnaryCallSettings<
          BatchCreateForecastAdjustmentsRequest, BatchCreateForecastAdjustmentsResponse>
      batchCreateForecastAdjustmentsSettings() {
    return batchCreateForecastAdjustmentsSettings;
  }

  /** Returns the object with the settings used for calls to batchActivateForecastAdjustments. */
  public UnaryCallSettings<
          BatchActivateForecastAdjustmentsRequest, BatchActivateForecastAdjustmentsResponse>
      batchActivateForecastAdjustmentsSettings() {
    return batchActivateForecastAdjustmentsSettings;
  }

  /** Returns the object with the settings used for calls to batchDeactivateForecastAdjustments. */
  public UnaryCallSettings<
          BatchDeactivateForecastAdjustmentsRequest, BatchDeactivateForecastAdjustmentsResponse>
      batchDeactivateForecastAdjustmentsSettings() {
    return batchDeactivateForecastAdjustmentsSettings;
  }

  /** Returns the object with the settings used for calls to updateForecastAdjustment. */
  public UnaryCallSettings<UpdateForecastAdjustmentRequest, ForecastAdjustment>
      updateForecastAdjustmentSettings() {
    return updateForecastAdjustmentSettings;
  }

  /** Returns the object with the settings used for calls to batchUpdateForecastAdjustments. */
  public UnaryCallSettings<
          BatchUpdateForecastAdjustmentsRequest, BatchUpdateForecastAdjustmentsResponse>
      batchUpdateForecastAdjustmentsSettings() {
    return batchUpdateForecastAdjustmentsSettings;
  }

  /** Returns the object with the settings used for calls to calculateDailyAdOpportunityCounts. */
  public UnaryCallSettings<
          CalculateDailyAdOpportunityCountsRequest, CalculateDailyAdOpportunityCountsResponse>
      calculateDailyAdOpportunityCountsSettings() {
    return calculateDailyAdOpportunityCountsSettings;
  }

  public ForecastAdjustmentServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonForecastAdjustmentServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(ForecastAdjustmentServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(@Nullable ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected ForecastAdjustmentServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getForecastAdjustmentSettings = settingsBuilder.getForecastAdjustmentSettings().build();
    listForecastAdjustmentsSettings = settingsBuilder.listForecastAdjustmentsSettings().build();
    createForecastAdjustmentSettings = settingsBuilder.createForecastAdjustmentSettings().build();
    batchCreateForecastAdjustmentsSettings =
        settingsBuilder.batchCreateForecastAdjustmentsSettings().build();
    batchActivateForecastAdjustmentsSettings =
        settingsBuilder.batchActivateForecastAdjustmentsSettings().build();
    batchDeactivateForecastAdjustmentsSettings =
        settingsBuilder.batchDeactivateForecastAdjustmentsSettings().build();
    updateForecastAdjustmentSettings = settingsBuilder.updateForecastAdjustmentSettings().build();
    batchUpdateForecastAdjustmentsSettings =
        settingsBuilder.batchUpdateForecastAdjustmentsSettings().build();
    calculateDailyAdOpportunityCountsSettings =
        settingsBuilder.calculateDailyAdOpportunityCountsSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.api-ads:ad-manager")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for ForecastAdjustmentServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<ForecastAdjustmentServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetForecastAdjustmentRequest, ForecastAdjustment>
        getForecastAdjustmentSettings;
    private final PagedCallSettings.Builder<
            ListForecastAdjustmentsRequest,
            ListForecastAdjustmentsResponse,
            ListForecastAdjustmentsPagedResponse>
        listForecastAdjustmentsSettings;
    private final UnaryCallSettings.Builder<CreateForecastAdjustmentRequest, ForecastAdjustment>
        createForecastAdjustmentSettings;
    private final UnaryCallSettings.Builder<
            BatchCreateForecastAdjustmentsRequest, BatchCreateForecastAdjustmentsResponse>
        batchCreateForecastAdjustmentsSettings;
    private final UnaryCallSettings.Builder<
            BatchActivateForecastAdjustmentsRequest, BatchActivateForecastAdjustmentsResponse>
        batchActivateForecastAdjustmentsSettings;
    private final UnaryCallSettings.Builder<
            BatchDeactivateForecastAdjustmentsRequest, BatchDeactivateForecastAdjustmentsResponse>
        batchDeactivateForecastAdjustmentsSettings;
    private final UnaryCallSettings.Builder<UpdateForecastAdjustmentRequest, ForecastAdjustment>
        updateForecastAdjustmentSettings;
    private final UnaryCallSettings.Builder<
            BatchUpdateForecastAdjustmentsRequest, BatchUpdateForecastAdjustmentsResponse>
        batchUpdateForecastAdjustmentsSettings;
    private final UnaryCallSettings.Builder<
            CalculateDailyAdOpportunityCountsRequest, CalculateDailyAdOpportunityCountsResponse>
        calculateDailyAdOpportunityCountsSettings;
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

    protected Builder(@Nullable ClientContext clientContext) {
      super(clientContext);

      getForecastAdjustmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listForecastAdjustmentsSettings =
          PagedCallSettings.newBuilder(LIST_FORECAST_ADJUSTMENTS_PAGE_STR_FACT);
      createForecastAdjustmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchCreateForecastAdjustmentsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchActivateForecastAdjustmentsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchDeactivateForecastAdjustmentsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateForecastAdjustmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchUpdateForecastAdjustmentsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      calculateDailyAdOpportunityCountsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getForecastAdjustmentSettings,
              listForecastAdjustmentsSettings,
              createForecastAdjustmentSettings,
              batchCreateForecastAdjustmentsSettings,
              batchActivateForecastAdjustmentsSettings,
              batchDeactivateForecastAdjustmentsSettings,
              updateForecastAdjustmentSettings,
              batchUpdateForecastAdjustmentsSettings,
              calculateDailyAdOpportunityCountsSettings);
      initDefaults(this);
    }

    protected Builder(ForecastAdjustmentServiceStubSettings settings) {
      super(settings);

      getForecastAdjustmentSettings = settings.getForecastAdjustmentSettings.toBuilder();
      listForecastAdjustmentsSettings = settings.listForecastAdjustmentsSettings.toBuilder();
      createForecastAdjustmentSettings = settings.createForecastAdjustmentSettings.toBuilder();
      batchCreateForecastAdjustmentsSettings =
          settings.batchCreateForecastAdjustmentsSettings.toBuilder();
      batchActivateForecastAdjustmentsSettings =
          settings.batchActivateForecastAdjustmentsSettings.toBuilder();
      batchDeactivateForecastAdjustmentsSettings =
          settings.batchDeactivateForecastAdjustmentsSettings.toBuilder();
      updateForecastAdjustmentSettings = settings.updateForecastAdjustmentSettings.toBuilder();
      batchUpdateForecastAdjustmentsSettings =
          settings.batchUpdateForecastAdjustmentsSettings.toBuilder();
      calculateDailyAdOpportunityCountsSettings =
          settings.calculateDailyAdOpportunityCountsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getForecastAdjustmentSettings,
              listForecastAdjustmentsSettings,
              createForecastAdjustmentSettings,
              batchCreateForecastAdjustmentsSettings,
              batchActivateForecastAdjustmentsSettings,
              batchDeactivateForecastAdjustmentsSettings,
              updateForecastAdjustmentSettings,
              batchUpdateForecastAdjustmentsSettings,
              calculateDailyAdOpportunityCountsSettings);
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
          .getForecastAdjustmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listForecastAdjustmentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createForecastAdjustmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchCreateForecastAdjustmentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchActivateForecastAdjustmentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchDeactivateForecastAdjustmentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateForecastAdjustmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchUpdateForecastAdjustmentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .calculateDailyAdOpportunityCountsSettings()
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

    /** Returns the builder for the settings used for calls to getForecastAdjustment. */
    public UnaryCallSettings.Builder<GetForecastAdjustmentRequest, ForecastAdjustment>
        getForecastAdjustmentSettings() {
      return getForecastAdjustmentSettings;
    }

    /** Returns the builder for the settings used for calls to listForecastAdjustments. */
    public PagedCallSettings.Builder<
            ListForecastAdjustmentsRequest,
            ListForecastAdjustmentsResponse,
            ListForecastAdjustmentsPagedResponse>
        listForecastAdjustmentsSettings() {
      return listForecastAdjustmentsSettings;
    }

    /** Returns the builder for the settings used for calls to createForecastAdjustment. */
    public UnaryCallSettings.Builder<CreateForecastAdjustmentRequest, ForecastAdjustment>
        createForecastAdjustmentSettings() {
      return createForecastAdjustmentSettings;
    }

    /** Returns the builder for the settings used for calls to batchCreateForecastAdjustments. */
    public UnaryCallSettings.Builder<
            BatchCreateForecastAdjustmentsRequest, BatchCreateForecastAdjustmentsResponse>
        batchCreateForecastAdjustmentsSettings() {
      return batchCreateForecastAdjustmentsSettings;
    }

    /** Returns the builder for the settings used for calls to batchActivateForecastAdjustments. */
    public UnaryCallSettings.Builder<
            BatchActivateForecastAdjustmentsRequest, BatchActivateForecastAdjustmentsResponse>
        batchActivateForecastAdjustmentsSettings() {
      return batchActivateForecastAdjustmentsSettings;
    }

    /**
     * Returns the builder for the settings used for calls to batchDeactivateForecastAdjustments.
     */
    public UnaryCallSettings.Builder<
            BatchDeactivateForecastAdjustmentsRequest, BatchDeactivateForecastAdjustmentsResponse>
        batchDeactivateForecastAdjustmentsSettings() {
      return batchDeactivateForecastAdjustmentsSettings;
    }

    /** Returns the builder for the settings used for calls to updateForecastAdjustment. */
    public UnaryCallSettings.Builder<UpdateForecastAdjustmentRequest, ForecastAdjustment>
        updateForecastAdjustmentSettings() {
      return updateForecastAdjustmentSettings;
    }

    /** Returns the builder for the settings used for calls to batchUpdateForecastAdjustments. */
    public UnaryCallSettings.Builder<
            BatchUpdateForecastAdjustmentsRequest, BatchUpdateForecastAdjustmentsResponse>
        batchUpdateForecastAdjustmentsSettings() {
      return batchUpdateForecastAdjustmentsSettings;
    }

    /** Returns the builder for the settings used for calls to calculateDailyAdOpportunityCounts. */
    public UnaryCallSettings.Builder<
            CalculateDailyAdOpportunityCountsRequest, CalculateDailyAdOpportunityCountsResponse>
        calculateDailyAdOpportunityCountsSettings() {
      return calculateDailyAdOpportunityCountsSettings;
    }

    @Override
    public ForecastAdjustmentServiceStubSettings build() throws IOException {
      return new ForecastAdjustmentServiceStubSettings(this);
    }
  }
}
