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

import static com.google.ads.admanager.v1.TrafficForecastSegmentServiceClient.ListTrafficForecastSegmentsPagedResponse;

import com.google.ads.admanager.v1.BatchCreateTrafficForecastSegmentsRequest;
import com.google.ads.admanager.v1.BatchCreateTrafficForecastSegmentsResponse;
import com.google.ads.admanager.v1.BatchUpdateTrafficForecastSegmentsRequest;
import com.google.ads.admanager.v1.BatchUpdateTrafficForecastSegmentsResponse;
import com.google.ads.admanager.v1.CreateTrafficForecastSegmentRequest;
import com.google.ads.admanager.v1.GetTrafficForecastSegmentRequest;
import com.google.ads.admanager.v1.ListTrafficForecastSegmentsRequest;
import com.google.ads.admanager.v1.ListTrafficForecastSegmentsResponse;
import com.google.ads.admanager.v1.TrafficForecastSegment;
import com.google.ads.admanager.v1.UpdateTrafficForecastSegmentRequest;
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
 * Settings class to configure an instance of {@link TrafficForecastSegmentServiceStub}.
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
 * of getTrafficForecastSegment:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TrafficForecastSegmentServiceStubSettings.Builder trafficForecastSegmentServiceSettingsBuilder =
 *     TrafficForecastSegmentServiceStubSettings.newBuilder();
 * trafficForecastSegmentServiceSettingsBuilder
 *     .getTrafficForecastSegmentSettings()
 *     .setRetrySettings(
 *         trafficForecastSegmentServiceSettingsBuilder
 *             .getTrafficForecastSegmentSettings()
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
 * TrafficForecastSegmentServiceStubSettings trafficForecastSegmentServiceSettings =
 *     trafficForecastSegmentServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class TrafficForecastSegmentServiceStubSettings
    extends StubSettings<TrafficForecastSegmentServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/admanager")
          .add("https://www.googleapis.com/auth/admanager.readonly")
          .build();

  private final UnaryCallSettings<GetTrafficForecastSegmentRequest, TrafficForecastSegment>
      getTrafficForecastSegmentSettings;
  private final PagedCallSettings<
          ListTrafficForecastSegmentsRequest,
          ListTrafficForecastSegmentsResponse,
          ListTrafficForecastSegmentsPagedResponse>
      listTrafficForecastSegmentsSettings;
  private final UnaryCallSettings<CreateTrafficForecastSegmentRequest, TrafficForecastSegment>
      createTrafficForecastSegmentSettings;
  private final UnaryCallSettings<
          BatchCreateTrafficForecastSegmentsRequest, BatchCreateTrafficForecastSegmentsResponse>
      batchCreateTrafficForecastSegmentsSettings;
  private final UnaryCallSettings<UpdateTrafficForecastSegmentRequest, TrafficForecastSegment>
      updateTrafficForecastSegmentSettings;
  private final UnaryCallSettings<
          BatchUpdateTrafficForecastSegmentsRequest, BatchUpdateTrafficForecastSegmentsResponse>
      batchUpdateTrafficForecastSegmentsSettings;

  private static final PagedListDescriptor<
          ListTrafficForecastSegmentsRequest,
          ListTrafficForecastSegmentsResponse,
          TrafficForecastSegment>
      LIST_TRAFFIC_FORECAST_SEGMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListTrafficForecastSegmentsRequest,
              ListTrafficForecastSegmentsResponse,
              TrafficForecastSegment>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTrafficForecastSegmentsRequest injectToken(
                ListTrafficForecastSegmentsRequest payload, String token) {
              return ListTrafficForecastSegmentsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListTrafficForecastSegmentsRequest injectPageSize(
                ListTrafficForecastSegmentsRequest payload, int pageSize) {
              return ListTrafficForecastSegmentsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListTrafficForecastSegmentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTrafficForecastSegmentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<TrafficForecastSegment> extractResources(
                ListTrafficForecastSegmentsResponse payload) {
              return payload.getTrafficForecastSegmentsList();
            }
          };

  private static final PagedListResponseFactory<
          ListTrafficForecastSegmentsRequest,
          ListTrafficForecastSegmentsResponse,
          ListTrafficForecastSegmentsPagedResponse>
      LIST_TRAFFIC_FORECAST_SEGMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTrafficForecastSegmentsRequest,
              ListTrafficForecastSegmentsResponse,
              ListTrafficForecastSegmentsPagedResponse>() {
            @Override
            public ApiFuture<ListTrafficForecastSegmentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListTrafficForecastSegmentsRequest, ListTrafficForecastSegmentsResponse>
                    callable,
                ListTrafficForecastSegmentsRequest request,
                ApiCallContext context,
                ApiFuture<ListTrafficForecastSegmentsResponse> futureResponse) {
              PageContext<
                      ListTrafficForecastSegmentsRequest,
                      ListTrafficForecastSegmentsResponse,
                      TrafficForecastSegment>
                  pageContext =
                      PageContext.create(
                          callable, LIST_TRAFFIC_FORECAST_SEGMENTS_PAGE_STR_DESC, request, context);
              return ListTrafficForecastSegmentsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getTrafficForecastSegment. */
  public UnaryCallSettings<GetTrafficForecastSegmentRequest, TrafficForecastSegment>
      getTrafficForecastSegmentSettings() {
    return getTrafficForecastSegmentSettings;
  }

  /** Returns the object with the settings used for calls to listTrafficForecastSegments. */
  public PagedCallSettings<
          ListTrafficForecastSegmentsRequest,
          ListTrafficForecastSegmentsResponse,
          ListTrafficForecastSegmentsPagedResponse>
      listTrafficForecastSegmentsSettings() {
    return listTrafficForecastSegmentsSettings;
  }

  /** Returns the object with the settings used for calls to createTrafficForecastSegment. */
  public UnaryCallSettings<CreateTrafficForecastSegmentRequest, TrafficForecastSegment>
      createTrafficForecastSegmentSettings() {
    return createTrafficForecastSegmentSettings;
  }

  /** Returns the object with the settings used for calls to batchCreateTrafficForecastSegments. */
  public UnaryCallSettings<
          BatchCreateTrafficForecastSegmentsRequest, BatchCreateTrafficForecastSegmentsResponse>
      batchCreateTrafficForecastSegmentsSettings() {
    return batchCreateTrafficForecastSegmentsSettings;
  }

  /** Returns the object with the settings used for calls to updateTrafficForecastSegment. */
  public UnaryCallSettings<UpdateTrafficForecastSegmentRequest, TrafficForecastSegment>
      updateTrafficForecastSegmentSettings() {
    return updateTrafficForecastSegmentSettings;
  }

  /** Returns the object with the settings used for calls to batchUpdateTrafficForecastSegments. */
  public UnaryCallSettings<
          BatchUpdateTrafficForecastSegmentsRequest, BatchUpdateTrafficForecastSegmentsResponse>
      batchUpdateTrafficForecastSegmentsSettings() {
    return batchUpdateTrafficForecastSegmentsSettings;
  }

  public TrafficForecastSegmentServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonTrafficForecastSegmentServiceStub.create(this);
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
            "gapic",
            GaxProperties.getLibraryVersion(TrafficForecastSegmentServiceStubSettings.class))
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

  protected TrafficForecastSegmentServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getTrafficForecastSegmentSettings = settingsBuilder.getTrafficForecastSegmentSettings().build();
    listTrafficForecastSegmentsSettings =
        settingsBuilder.listTrafficForecastSegmentsSettings().build();
    createTrafficForecastSegmentSettings =
        settingsBuilder.createTrafficForecastSegmentSettings().build();
    batchCreateTrafficForecastSegmentsSettings =
        settingsBuilder.batchCreateTrafficForecastSegmentsSettings().build();
    updateTrafficForecastSegmentSettings =
        settingsBuilder.updateTrafficForecastSegmentSettings().build();
    batchUpdateTrafficForecastSegmentsSettings =
        settingsBuilder.batchUpdateTrafficForecastSegmentsSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.api-ads:ad-manager")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for TrafficForecastSegmentServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<TrafficForecastSegmentServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<
            GetTrafficForecastSegmentRequest, TrafficForecastSegment>
        getTrafficForecastSegmentSettings;
    private final PagedCallSettings.Builder<
            ListTrafficForecastSegmentsRequest,
            ListTrafficForecastSegmentsResponse,
            ListTrafficForecastSegmentsPagedResponse>
        listTrafficForecastSegmentsSettings;
    private final UnaryCallSettings.Builder<
            CreateTrafficForecastSegmentRequest, TrafficForecastSegment>
        createTrafficForecastSegmentSettings;
    private final UnaryCallSettings.Builder<
            BatchCreateTrafficForecastSegmentsRequest, BatchCreateTrafficForecastSegmentsResponse>
        batchCreateTrafficForecastSegmentsSettings;
    private final UnaryCallSettings.Builder<
            UpdateTrafficForecastSegmentRequest, TrafficForecastSegment>
        updateTrafficForecastSegmentSettings;
    private final UnaryCallSettings.Builder<
            BatchUpdateTrafficForecastSegmentsRequest, BatchUpdateTrafficForecastSegmentsResponse>
        batchUpdateTrafficForecastSegmentsSettings;
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

      getTrafficForecastSegmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listTrafficForecastSegmentsSettings =
          PagedCallSettings.newBuilder(LIST_TRAFFIC_FORECAST_SEGMENTS_PAGE_STR_FACT);
      createTrafficForecastSegmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchCreateTrafficForecastSegmentsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateTrafficForecastSegmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchUpdateTrafficForecastSegmentsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getTrafficForecastSegmentSettings,
              listTrafficForecastSegmentsSettings,
              createTrafficForecastSegmentSettings,
              batchCreateTrafficForecastSegmentsSettings,
              updateTrafficForecastSegmentSettings,
              batchUpdateTrafficForecastSegmentsSettings);
      initDefaults(this);
    }

    protected Builder(TrafficForecastSegmentServiceStubSettings settings) {
      super(settings);

      getTrafficForecastSegmentSettings = settings.getTrafficForecastSegmentSettings.toBuilder();
      listTrafficForecastSegmentsSettings =
          settings.listTrafficForecastSegmentsSettings.toBuilder();
      createTrafficForecastSegmentSettings =
          settings.createTrafficForecastSegmentSettings.toBuilder();
      batchCreateTrafficForecastSegmentsSettings =
          settings.batchCreateTrafficForecastSegmentsSettings.toBuilder();
      updateTrafficForecastSegmentSettings =
          settings.updateTrafficForecastSegmentSettings.toBuilder();
      batchUpdateTrafficForecastSegmentsSettings =
          settings.batchUpdateTrafficForecastSegmentsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getTrafficForecastSegmentSettings,
              listTrafficForecastSegmentsSettings,
              createTrafficForecastSegmentSettings,
              batchCreateTrafficForecastSegmentsSettings,
              updateTrafficForecastSegmentSettings,
              batchUpdateTrafficForecastSegmentsSettings);
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
          .getTrafficForecastSegmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listTrafficForecastSegmentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createTrafficForecastSegmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchCreateTrafficForecastSegmentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateTrafficForecastSegmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchUpdateTrafficForecastSegmentsSettings()
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

    /** Returns the builder for the settings used for calls to getTrafficForecastSegment. */
    public UnaryCallSettings.Builder<GetTrafficForecastSegmentRequest, TrafficForecastSegment>
        getTrafficForecastSegmentSettings() {
      return getTrafficForecastSegmentSettings;
    }

    /** Returns the builder for the settings used for calls to listTrafficForecastSegments. */
    public PagedCallSettings.Builder<
            ListTrafficForecastSegmentsRequest,
            ListTrafficForecastSegmentsResponse,
            ListTrafficForecastSegmentsPagedResponse>
        listTrafficForecastSegmentsSettings() {
      return listTrafficForecastSegmentsSettings;
    }

    /** Returns the builder for the settings used for calls to createTrafficForecastSegment. */
    public UnaryCallSettings.Builder<CreateTrafficForecastSegmentRequest, TrafficForecastSegment>
        createTrafficForecastSegmentSettings() {
      return createTrafficForecastSegmentSettings;
    }

    /**
     * Returns the builder for the settings used for calls to batchCreateTrafficForecastSegments.
     */
    public UnaryCallSettings.Builder<
            BatchCreateTrafficForecastSegmentsRequest, BatchCreateTrafficForecastSegmentsResponse>
        batchCreateTrafficForecastSegmentsSettings() {
      return batchCreateTrafficForecastSegmentsSettings;
    }

    /** Returns the builder for the settings used for calls to updateTrafficForecastSegment. */
    public UnaryCallSettings.Builder<UpdateTrafficForecastSegmentRequest, TrafficForecastSegment>
        updateTrafficForecastSegmentSettings() {
      return updateTrafficForecastSegmentSettings;
    }

    /**
     * Returns the builder for the settings used for calls to batchUpdateTrafficForecastSegments.
     */
    public UnaryCallSettings.Builder<
            BatchUpdateTrafficForecastSegmentsRequest, BatchUpdateTrafficForecastSegmentsResponse>
        batchUpdateTrafficForecastSegmentsSettings() {
      return batchUpdateTrafficForecastSegmentsSettings;
    }

    @Override
    public TrafficForecastSegmentServiceStubSettings build() throws IOException {
      return new TrafficForecastSegmentServiceStubSettings(this);
    }
  }
}
