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

import static com.google.ads.admanager.v1.LiveStreamServiceClient.ListLiveStreamsPagedResponse;

import com.google.ads.admanager.v1.BatchActivateLiveStreamsRequest;
import com.google.ads.admanager.v1.BatchActivateLiveStreamsResponse;
import com.google.ads.admanager.v1.BatchArchiveLiveStreamsRequest;
import com.google.ads.admanager.v1.BatchArchiveLiveStreamsResponse;
import com.google.ads.admanager.v1.BatchCreateLiveStreamsRequest;
import com.google.ads.admanager.v1.BatchCreateLiveStreamsResponse;
import com.google.ads.admanager.v1.BatchPauseAdsLiveStreamsRequest;
import com.google.ads.admanager.v1.BatchPauseAdsLiveStreamsResponse;
import com.google.ads.admanager.v1.BatchPauseLiveStreamsRequest;
import com.google.ads.admanager.v1.BatchPauseLiveStreamsResponse;
import com.google.ads.admanager.v1.BatchRefreshMasterPlaylistsRequest;
import com.google.ads.admanager.v1.BatchRefreshMasterPlaylistsResponse;
import com.google.ads.admanager.v1.BatchUpdateLiveStreamsRequest;
import com.google.ads.admanager.v1.BatchUpdateLiveStreamsResponse;
import com.google.ads.admanager.v1.CreateLiveStreamRequest;
import com.google.ads.admanager.v1.GetLiveStreamRequest;
import com.google.ads.admanager.v1.ListLiveStreamsRequest;
import com.google.ads.admanager.v1.ListLiveStreamsResponse;
import com.google.ads.admanager.v1.LiveStream;
import com.google.ads.admanager.v1.UpdateLiveStreamRequest;
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
 * Settings class to configure an instance of {@link LiveStreamServiceStub}.
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
 * of getLiveStream:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * LiveStreamServiceStubSettings.Builder liveStreamServiceSettingsBuilder =
 *     LiveStreamServiceStubSettings.newBuilder();
 * liveStreamServiceSettingsBuilder
 *     .getLiveStreamSettings()
 *     .setRetrySettings(
 *         liveStreamServiceSettingsBuilder
 *             .getLiveStreamSettings()
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
 * LiveStreamServiceStubSettings liveStreamServiceSettings =
 *     liveStreamServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class LiveStreamServiceStubSettings extends StubSettings<LiveStreamServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/admanager")
          .add("https://www.googleapis.com/auth/admanager.readonly")
          .build();

  private final UnaryCallSettings<GetLiveStreamRequest, LiveStream> getLiveStreamSettings;
  private final PagedCallSettings<
          ListLiveStreamsRequest, ListLiveStreamsResponse, ListLiveStreamsPagedResponse>
      listLiveStreamsSettings;
  private final UnaryCallSettings<CreateLiveStreamRequest, LiveStream> createLiveStreamSettings;
  private final UnaryCallSettings<BatchCreateLiveStreamsRequest, BatchCreateLiveStreamsResponse>
      batchCreateLiveStreamsSettings;
  private final UnaryCallSettings<UpdateLiveStreamRequest, LiveStream> updateLiveStreamSettings;
  private final UnaryCallSettings<BatchUpdateLiveStreamsRequest, BatchUpdateLiveStreamsResponse>
      batchUpdateLiveStreamsSettings;
  private final UnaryCallSettings<BatchActivateLiveStreamsRequest, BatchActivateLiveStreamsResponse>
      batchActivateLiveStreamsSettings;
  private final UnaryCallSettings<BatchPauseLiveStreamsRequest, BatchPauseLiveStreamsResponse>
      batchPauseLiveStreamsSettings;
  private final UnaryCallSettings<BatchArchiveLiveStreamsRequest, BatchArchiveLiveStreamsResponse>
      batchArchiveLiveStreamsSettings;
  private final UnaryCallSettings<BatchPauseAdsLiveStreamsRequest, BatchPauseAdsLiveStreamsResponse>
      batchPauseAdsLiveStreamsSettings;
  private final UnaryCallSettings<
          BatchRefreshMasterPlaylistsRequest, BatchRefreshMasterPlaylistsResponse>
      batchRefreshMasterPlaylistsSettings;

  private static final PagedListDescriptor<
          ListLiveStreamsRequest, ListLiveStreamsResponse, LiveStream>
      LIST_LIVE_STREAMS_PAGE_STR_DESC =
          new PagedListDescriptor<ListLiveStreamsRequest, ListLiveStreamsResponse, LiveStream>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLiveStreamsRequest injectToken(
                ListLiveStreamsRequest payload, String token) {
              return ListLiveStreamsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLiveStreamsRequest injectPageSize(
                ListLiveStreamsRequest payload, int pageSize) {
              return ListLiveStreamsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLiveStreamsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLiveStreamsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<LiveStream> extractResources(ListLiveStreamsResponse payload) {
              return payload.getLiveStreamsList();
            }
          };

  private static final PagedListResponseFactory<
          ListLiveStreamsRequest, ListLiveStreamsResponse, ListLiveStreamsPagedResponse>
      LIST_LIVE_STREAMS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLiveStreamsRequest, ListLiveStreamsResponse, ListLiveStreamsPagedResponse>() {
            @Override
            public ApiFuture<ListLiveStreamsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLiveStreamsRequest, ListLiveStreamsResponse> callable,
                ListLiveStreamsRequest request,
                ApiCallContext context,
                ApiFuture<ListLiveStreamsResponse> futureResponse) {
              PageContext<ListLiveStreamsRequest, ListLiveStreamsResponse, LiveStream> pageContext =
                  PageContext.create(callable, LIST_LIVE_STREAMS_PAGE_STR_DESC, request, context);
              return ListLiveStreamsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getLiveStream. */
  public UnaryCallSettings<GetLiveStreamRequest, LiveStream> getLiveStreamSettings() {
    return getLiveStreamSettings;
  }

  /** Returns the object with the settings used for calls to listLiveStreams. */
  public PagedCallSettings<
          ListLiveStreamsRequest, ListLiveStreamsResponse, ListLiveStreamsPagedResponse>
      listLiveStreamsSettings() {
    return listLiveStreamsSettings;
  }

  /** Returns the object with the settings used for calls to createLiveStream. */
  public UnaryCallSettings<CreateLiveStreamRequest, LiveStream> createLiveStreamSettings() {
    return createLiveStreamSettings;
  }

  /** Returns the object with the settings used for calls to batchCreateLiveStreams. */
  public UnaryCallSettings<BatchCreateLiveStreamsRequest, BatchCreateLiveStreamsResponse>
      batchCreateLiveStreamsSettings() {
    return batchCreateLiveStreamsSettings;
  }

  /** Returns the object with the settings used for calls to updateLiveStream. */
  public UnaryCallSettings<UpdateLiveStreamRequest, LiveStream> updateLiveStreamSettings() {
    return updateLiveStreamSettings;
  }

  /** Returns the object with the settings used for calls to batchUpdateLiveStreams. */
  public UnaryCallSettings<BatchUpdateLiveStreamsRequest, BatchUpdateLiveStreamsResponse>
      batchUpdateLiveStreamsSettings() {
    return batchUpdateLiveStreamsSettings;
  }

  /** Returns the object with the settings used for calls to batchActivateLiveStreams. */
  public UnaryCallSettings<BatchActivateLiveStreamsRequest, BatchActivateLiveStreamsResponse>
      batchActivateLiveStreamsSettings() {
    return batchActivateLiveStreamsSettings;
  }

  /** Returns the object with the settings used for calls to batchPauseLiveStreams. */
  public UnaryCallSettings<BatchPauseLiveStreamsRequest, BatchPauseLiveStreamsResponse>
      batchPauseLiveStreamsSettings() {
    return batchPauseLiveStreamsSettings;
  }

  /** Returns the object with the settings used for calls to batchArchiveLiveStreams. */
  public UnaryCallSettings<BatchArchiveLiveStreamsRequest, BatchArchiveLiveStreamsResponse>
      batchArchiveLiveStreamsSettings() {
    return batchArchiveLiveStreamsSettings;
  }

  /** Returns the object with the settings used for calls to batchPauseAdsLiveStreams. */
  public UnaryCallSettings<BatchPauseAdsLiveStreamsRequest, BatchPauseAdsLiveStreamsResponse>
      batchPauseAdsLiveStreamsSettings() {
    return batchPauseAdsLiveStreamsSettings;
  }

  /** Returns the object with the settings used for calls to batchRefreshMasterPlaylists. */
  public UnaryCallSettings<BatchRefreshMasterPlaylistsRequest, BatchRefreshMasterPlaylistsResponse>
      batchRefreshMasterPlaylistsSettings() {
    return batchRefreshMasterPlaylistsSettings;
  }

  public LiveStreamServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonLiveStreamServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(LiveStreamServiceStubSettings.class))
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

  protected LiveStreamServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getLiveStreamSettings = settingsBuilder.getLiveStreamSettings().build();
    listLiveStreamsSettings = settingsBuilder.listLiveStreamsSettings().build();
    createLiveStreamSettings = settingsBuilder.createLiveStreamSettings().build();
    batchCreateLiveStreamsSettings = settingsBuilder.batchCreateLiveStreamsSettings().build();
    updateLiveStreamSettings = settingsBuilder.updateLiveStreamSettings().build();
    batchUpdateLiveStreamsSettings = settingsBuilder.batchUpdateLiveStreamsSettings().build();
    batchActivateLiveStreamsSettings = settingsBuilder.batchActivateLiveStreamsSettings().build();
    batchPauseLiveStreamsSettings = settingsBuilder.batchPauseLiveStreamsSettings().build();
    batchArchiveLiveStreamsSettings = settingsBuilder.batchArchiveLiveStreamsSettings().build();
    batchPauseAdsLiveStreamsSettings = settingsBuilder.batchPauseAdsLiveStreamsSettings().build();
    batchRefreshMasterPlaylistsSettings =
        settingsBuilder.batchRefreshMasterPlaylistsSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.api-ads:ad-manager")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for LiveStreamServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<LiveStreamServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetLiveStreamRequest, LiveStream> getLiveStreamSettings;
    private final PagedCallSettings.Builder<
            ListLiveStreamsRequest, ListLiveStreamsResponse, ListLiveStreamsPagedResponse>
        listLiveStreamsSettings;
    private final UnaryCallSettings.Builder<CreateLiveStreamRequest, LiveStream>
        createLiveStreamSettings;
    private final UnaryCallSettings.Builder<
            BatchCreateLiveStreamsRequest, BatchCreateLiveStreamsResponse>
        batchCreateLiveStreamsSettings;
    private final UnaryCallSettings.Builder<UpdateLiveStreamRequest, LiveStream>
        updateLiveStreamSettings;
    private final UnaryCallSettings.Builder<
            BatchUpdateLiveStreamsRequest, BatchUpdateLiveStreamsResponse>
        batchUpdateLiveStreamsSettings;
    private final UnaryCallSettings.Builder<
            BatchActivateLiveStreamsRequest, BatchActivateLiveStreamsResponse>
        batchActivateLiveStreamsSettings;
    private final UnaryCallSettings.Builder<
            BatchPauseLiveStreamsRequest, BatchPauseLiveStreamsResponse>
        batchPauseLiveStreamsSettings;
    private final UnaryCallSettings.Builder<
            BatchArchiveLiveStreamsRequest, BatchArchiveLiveStreamsResponse>
        batchArchiveLiveStreamsSettings;
    private final UnaryCallSettings.Builder<
            BatchPauseAdsLiveStreamsRequest, BatchPauseAdsLiveStreamsResponse>
        batchPauseAdsLiveStreamsSettings;
    private final UnaryCallSettings.Builder<
            BatchRefreshMasterPlaylistsRequest, BatchRefreshMasterPlaylistsResponse>
        batchRefreshMasterPlaylistsSettings;
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

      getLiveStreamSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLiveStreamsSettings = PagedCallSettings.newBuilder(LIST_LIVE_STREAMS_PAGE_STR_FACT);
      createLiveStreamSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchCreateLiveStreamsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateLiveStreamSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchUpdateLiveStreamsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchActivateLiveStreamsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchPauseLiveStreamsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchArchiveLiveStreamsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchPauseAdsLiveStreamsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchRefreshMasterPlaylistsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getLiveStreamSettings,
              listLiveStreamsSettings,
              createLiveStreamSettings,
              batchCreateLiveStreamsSettings,
              updateLiveStreamSettings,
              batchUpdateLiveStreamsSettings,
              batchActivateLiveStreamsSettings,
              batchPauseLiveStreamsSettings,
              batchArchiveLiveStreamsSettings,
              batchPauseAdsLiveStreamsSettings,
              batchRefreshMasterPlaylistsSettings);
      initDefaults(this);
    }

    protected Builder(LiveStreamServiceStubSettings settings) {
      super(settings);

      getLiveStreamSettings = settings.getLiveStreamSettings.toBuilder();
      listLiveStreamsSettings = settings.listLiveStreamsSettings.toBuilder();
      createLiveStreamSettings = settings.createLiveStreamSettings.toBuilder();
      batchCreateLiveStreamsSettings = settings.batchCreateLiveStreamsSettings.toBuilder();
      updateLiveStreamSettings = settings.updateLiveStreamSettings.toBuilder();
      batchUpdateLiveStreamsSettings = settings.batchUpdateLiveStreamsSettings.toBuilder();
      batchActivateLiveStreamsSettings = settings.batchActivateLiveStreamsSettings.toBuilder();
      batchPauseLiveStreamsSettings = settings.batchPauseLiveStreamsSettings.toBuilder();
      batchArchiveLiveStreamsSettings = settings.batchArchiveLiveStreamsSettings.toBuilder();
      batchPauseAdsLiveStreamsSettings = settings.batchPauseAdsLiveStreamsSettings.toBuilder();
      batchRefreshMasterPlaylistsSettings =
          settings.batchRefreshMasterPlaylistsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getLiveStreamSettings,
              listLiveStreamsSettings,
              createLiveStreamSettings,
              batchCreateLiveStreamsSettings,
              updateLiveStreamSettings,
              batchUpdateLiveStreamsSettings,
              batchActivateLiveStreamsSettings,
              batchPauseLiveStreamsSettings,
              batchArchiveLiveStreamsSettings,
              batchPauseAdsLiveStreamsSettings,
              batchRefreshMasterPlaylistsSettings);
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
          .getLiveStreamSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listLiveStreamsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createLiveStreamSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchCreateLiveStreamsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateLiveStreamSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchUpdateLiveStreamsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchActivateLiveStreamsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchPauseLiveStreamsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchArchiveLiveStreamsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchPauseAdsLiveStreamsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchRefreshMasterPlaylistsSettings()
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

    /** Returns the builder for the settings used for calls to getLiveStream. */
    public UnaryCallSettings.Builder<GetLiveStreamRequest, LiveStream> getLiveStreamSettings() {
      return getLiveStreamSettings;
    }

    /** Returns the builder for the settings used for calls to listLiveStreams. */
    public PagedCallSettings.Builder<
            ListLiveStreamsRequest, ListLiveStreamsResponse, ListLiveStreamsPagedResponse>
        listLiveStreamsSettings() {
      return listLiveStreamsSettings;
    }

    /** Returns the builder for the settings used for calls to createLiveStream. */
    public UnaryCallSettings.Builder<CreateLiveStreamRequest, LiveStream>
        createLiveStreamSettings() {
      return createLiveStreamSettings;
    }

    /** Returns the builder for the settings used for calls to batchCreateLiveStreams. */
    public UnaryCallSettings.Builder<BatchCreateLiveStreamsRequest, BatchCreateLiveStreamsResponse>
        batchCreateLiveStreamsSettings() {
      return batchCreateLiveStreamsSettings;
    }

    /** Returns the builder for the settings used for calls to updateLiveStream. */
    public UnaryCallSettings.Builder<UpdateLiveStreamRequest, LiveStream>
        updateLiveStreamSettings() {
      return updateLiveStreamSettings;
    }

    /** Returns the builder for the settings used for calls to batchUpdateLiveStreams. */
    public UnaryCallSettings.Builder<BatchUpdateLiveStreamsRequest, BatchUpdateLiveStreamsResponse>
        batchUpdateLiveStreamsSettings() {
      return batchUpdateLiveStreamsSettings;
    }

    /** Returns the builder for the settings used for calls to batchActivateLiveStreams. */
    public UnaryCallSettings.Builder<
            BatchActivateLiveStreamsRequest, BatchActivateLiveStreamsResponse>
        batchActivateLiveStreamsSettings() {
      return batchActivateLiveStreamsSettings;
    }

    /** Returns the builder for the settings used for calls to batchPauseLiveStreams. */
    public UnaryCallSettings.Builder<BatchPauseLiveStreamsRequest, BatchPauseLiveStreamsResponse>
        batchPauseLiveStreamsSettings() {
      return batchPauseLiveStreamsSettings;
    }

    /** Returns the builder for the settings used for calls to batchArchiveLiveStreams. */
    public UnaryCallSettings.Builder<
            BatchArchiveLiveStreamsRequest, BatchArchiveLiveStreamsResponse>
        batchArchiveLiveStreamsSettings() {
      return batchArchiveLiveStreamsSettings;
    }

    /** Returns the builder for the settings used for calls to batchPauseAdsLiveStreams. */
    public UnaryCallSettings.Builder<
            BatchPauseAdsLiveStreamsRequest, BatchPauseAdsLiveStreamsResponse>
        batchPauseAdsLiveStreamsSettings() {
      return batchPauseAdsLiveStreamsSettings;
    }

    /** Returns the builder for the settings used for calls to batchRefreshMasterPlaylists. */
    public UnaryCallSettings.Builder<
            BatchRefreshMasterPlaylistsRequest, BatchRefreshMasterPlaylistsResponse>
        batchRefreshMasterPlaylistsSettings() {
      return batchRefreshMasterPlaylistsSettings;
    }

    @Override
    public LiveStreamServiceStubSettings build() throws IOException {
      return new LiveStreamServiceStubSettings(this);
    }
  }
}
