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

package com.google.ads.admanager.v1;

import static com.google.ads.admanager.v1.LiveStreamServiceClient.ListLiveStreamsPagedResponse;

import com.google.ads.admanager.v1.stub.LiveStreamServiceStubSettings;
import com.google.api.core.ApiFunction;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link LiveStreamServiceClient}.
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
 * LiveStreamServiceSettings.Builder liveStreamServiceSettingsBuilder =
 *     LiveStreamServiceSettings.newBuilder();
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
 * LiveStreamServiceSettings liveStreamServiceSettings = liveStreamServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class LiveStreamServiceSettings extends ClientSettings<LiveStreamServiceSettings> {

  /** Returns the object with the settings used for calls to getLiveStream. */
  public UnaryCallSettings<GetLiveStreamRequest, LiveStream> getLiveStreamSettings() {
    return ((LiveStreamServiceStubSettings) getStubSettings()).getLiveStreamSettings();
  }

  /** Returns the object with the settings used for calls to listLiveStreams. */
  public PagedCallSettings<
          ListLiveStreamsRequest, ListLiveStreamsResponse, ListLiveStreamsPagedResponse>
      listLiveStreamsSettings() {
    return ((LiveStreamServiceStubSettings) getStubSettings()).listLiveStreamsSettings();
  }

  /** Returns the object with the settings used for calls to createLiveStream. */
  public UnaryCallSettings<CreateLiveStreamRequest, LiveStream> createLiveStreamSettings() {
    return ((LiveStreamServiceStubSettings) getStubSettings()).createLiveStreamSettings();
  }

  /** Returns the object with the settings used for calls to batchCreateLiveStreams. */
  public UnaryCallSettings<BatchCreateLiveStreamsRequest, BatchCreateLiveStreamsResponse>
      batchCreateLiveStreamsSettings() {
    return ((LiveStreamServiceStubSettings) getStubSettings()).batchCreateLiveStreamsSettings();
  }

  /** Returns the object with the settings used for calls to updateLiveStream. */
  public UnaryCallSettings<UpdateLiveStreamRequest, LiveStream> updateLiveStreamSettings() {
    return ((LiveStreamServiceStubSettings) getStubSettings()).updateLiveStreamSettings();
  }

  /** Returns the object with the settings used for calls to batchUpdateLiveStreams. */
  public UnaryCallSettings<BatchUpdateLiveStreamsRequest, BatchUpdateLiveStreamsResponse>
      batchUpdateLiveStreamsSettings() {
    return ((LiveStreamServiceStubSettings) getStubSettings()).batchUpdateLiveStreamsSettings();
  }

  /** Returns the object with the settings used for calls to batchActivateLiveStreams. */
  public UnaryCallSettings<BatchActivateLiveStreamsRequest, BatchActivateLiveStreamsResponse>
      batchActivateLiveStreamsSettings() {
    return ((LiveStreamServiceStubSettings) getStubSettings()).batchActivateLiveStreamsSettings();
  }

  /** Returns the object with the settings used for calls to batchPauseLiveStreams. */
  public UnaryCallSettings<BatchPauseLiveStreamsRequest, BatchPauseLiveStreamsResponse>
      batchPauseLiveStreamsSettings() {
    return ((LiveStreamServiceStubSettings) getStubSettings()).batchPauseLiveStreamsSettings();
  }

  /** Returns the object with the settings used for calls to batchArchiveLiveStreams. */
  public UnaryCallSettings<BatchArchiveLiveStreamsRequest, BatchArchiveLiveStreamsResponse>
      batchArchiveLiveStreamsSettings() {
    return ((LiveStreamServiceStubSettings) getStubSettings()).batchArchiveLiveStreamsSettings();
  }

  /** Returns the object with the settings used for calls to batchPauseAdsLiveStreams. */
  public UnaryCallSettings<BatchPauseAdsLiveStreamsRequest, BatchPauseAdsLiveStreamsResponse>
      batchPauseAdsLiveStreamsSettings() {
    return ((LiveStreamServiceStubSettings) getStubSettings()).batchPauseAdsLiveStreamsSettings();
  }

  /** Returns the object with the settings used for calls to batchRefreshMasterPlaylists. */
  public UnaryCallSettings<BatchRefreshMasterPlaylistsRequest, BatchRefreshMasterPlaylistsResponse>
      batchRefreshMasterPlaylistsSettings() {
    return ((LiveStreamServiceStubSettings) getStubSettings())
        .batchRefreshMasterPlaylistsSettings();
  }

  public static final LiveStreamServiceSettings create(LiveStreamServiceStubSettings stub)
      throws IOException {
    return new LiveStreamServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return LiveStreamServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return LiveStreamServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return LiveStreamServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return LiveStreamServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return LiveStreamServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return LiveStreamServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return LiveStreamServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected LiveStreamServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for LiveStreamServiceSettings. */
  public static class Builder extends ClientSettings.Builder<LiveStreamServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(LiveStreamServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(LiveStreamServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(LiveStreamServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(LiveStreamServiceStubSettings.newBuilder());
    }

    public LiveStreamServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((LiveStreamServiceStubSettings.Builder) getStubSettings());
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to getLiveStream. */
    public UnaryCallSettings.Builder<GetLiveStreamRequest, LiveStream> getLiveStreamSettings() {
      return getStubSettingsBuilder().getLiveStreamSettings();
    }

    /** Returns the builder for the settings used for calls to listLiveStreams. */
    public PagedCallSettings.Builder<
            ListLiveStreamsRequest, ListLiveStreamsResponse, ListLiveStreamsPagedResponse>
        listLiveStreamsSettings() {
      return getStubSettingsBuilder().listLiveStreamsSettings();
    }

    /** Returns the builder for the settings used for calls to createLiveStream. */
    public UnaryCallSettings.Builder<CreateLiveStreamRequest, LiveStream>
        createLiveStreamSettings() {
      return getStubSettingsBuilder().createLiveStreamSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreateLiveStreams. */
    public UnaryCallSettings.Builder<BatchCreateLiveStreamsRequest, BatchCreateLiveStreamsResponse>
        batchCreateLiveStreamsSettings() {
      return getStubSettingsBuilder().batchCreateLiveStreamsSettings();
    }

    /** Returns the builder for the settings used for calls to updateLiveStream. */
    public UnaryCallSettings.Builder<UpdateLiveStreamRequest, LiveStream>
        updateLiveStreamSettings() {
      return getStubSettingsBuilder().updateLiveStreamSettings();
    }

    /** Returns the builder for the settings used for calls to batchUpdateLiveStreams. */
    public UnaryCallSettings.Builder<BatchUpdateLiveStreamsRequest, BatchUpdateLiveStreamsResponse>
        batchUpdateLiveStreamsSettings() {
      return getStubSettingsBuilder().batchUpdateLiveStreamsSettings();
    }

    /** Returns the builder for the settings used for calls to batchActivateLiveStreams. */
    public UnaryCallSettings.Builder<
            BatchActivateLiveStreamsRequest, BatchActivateLiveStreamsResponse>
        batchActivateLiveStreamsSettings() {
      return getStubSettingsBuilder().batchActivateLiveStreamsSettings();
    }

    /** Returns the builder for the settings used for calls to batchPauseLiveStreams. */
    public UnaryCallSettings.Builder<BatchPauseLiveStreamsRequest, BatchPauseLiveStreamsResponse>
        batchPauseLiveStreamsSettings() {
      return getStubSettingsBuilder().batchPauseLiveStreamsSettings();
    }

    /** Returns the builder for the settings used for calls to batchArchiveLiveStreams. */
    public UnaryCallSettings.Builder<
            BatchArchiveLiveStreamsRequest, BatchArchiveLiveStreamsResponse>
        batchArchiveLiveStreamsSettings() {
      return getStubSettingsBuilder().batchArchiveLiveStreamsSettings();
    }

    /** Returns the builder for the settings used for calls to batchPauseAdsLiveStreams. */
    public UnaryCallSettings.Builder<
            BatchPauseAdsLiveStreamsRequest, BatchPauseAdsLiveStreamsResponse>
        batchPauseAdsLiveStreamsSettings() {
      return getStubSettingsBuilder().batchPauseAdsLiveStreamsSettings();
    }

    /** Returns the builder for the settings used for calls to batchRefreshMasterPlaylists. */
    public UnaryCallSettings.Builder<
            BatchRefreshMasterPlaylistsRequest, BatchRefreshMasterPlaylistsResponse>
        batchRefreshMasterPlaylistsSettings() {
      return getStubSettingsBuilder().batchRefreshMasterPlaylistsSettings();
    }

    @Override
    public LiveStreamServiceSettings build() throws IOException {
      return new LiveStreamServiceSettings(this);
    }
  }
}
