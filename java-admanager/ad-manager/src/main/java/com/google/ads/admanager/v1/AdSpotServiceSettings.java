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

import static com.google.ads.admanager.v1.AdSpotServiceClient.ListAdSpotsPagedResponse;

import com.google.ads.admanager.v1.stub.AdSpotServiceStubSettings;
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
 * Settings class to configure an instance of {@link AdSpotServiceClient}.
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
 * of getAdSpot:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AdSpotServiceSettings.Builder adSpotServiceSettingsBuilder = AdSpotServiceSettings.newBuilder();
 * adSpotServiceSettingsBuilder
 *     .getAdSpotSettings()
 *     .setRetrySettings(
 *         adSpotServiceSettingsBuilder
 *             .getAdSpotSettings()
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
 * AdSpotServiceSettings adSpotServiceSettings = adSpotServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class AdSpotServiceSettings extends ClientSettings<AdSpotServiceSettings> {

  /** Returns the object with the settings used for calls to getAdSpot. */
  public UnaryCallSettings<GetAdSpotRequest, AdSpot> getAdSpotSettings() {
    return ((AdSpotServiceStubSettings) getStubSettings()).getAdSpotSettings();
  }

  /** Returns the object with the settings used for calls to listAdSpots. */
  public PagedCallSettings<ListAdSpotsRequest, ListAdSpotsResponse, ListAdSpotsPagedResponse>
      listAdSpotsSettings() {
    return ((AdSpotServiceStubSettings) getStubSettings()).listAdSpotsSettings();
  }

  /** Returns the object with the settings used for calls to createAdSpot. */
  public UnaryCallSettings<CreateAdSpotRequest, AdSpot> createAdSpotSettings() {
    return ((AdSpotServiceStubSettings) getStubSettings()).createAdSpotSettings();
  }

  /** Returns the object with the settings used for calls to batchCreateAdSpots. */
  public UnaryCallSettings<BatchCreateAdSpotsRequest, BatchCreateAdSpotsResponse>
      batchCreateAdSpotsSettings() {
    return ((AdSpotServiceStubSettings) getStubSettings()).batchCreateAdSpotsSettings();
  }

  /** Returns the object with the settings used for calls to updateAdSpot. */
  public UnaryCallSettings<UpdateAdSpotRequest, AdSpot> updateAdSpotSettings() {
    return ((AdSpotServiceStubSettings) getStubSettings()).updateAdSpotSettings();
  }

  /** Returns the object with the settings used for calls to batchUpdateAdSpots. */
  public UnaryCallSettings<BatchUpdateAdSpotsRequest, BatchUpdateAdSpotsResponse>
      batchUpdateAdSpotsSettings() {
    return ((AdSpotServiceStubSettings) getStubSettings()).batchUpdateAdSpotsSettings();
  }

  public static final AdSpotServiceSettings create(AdSpotServiceStubSettings stub)
      throws IOException {
    return new AdSpotServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return AdSpotServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return AdSpotServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return AdSpotServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return AdSpotServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return AdSpotServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return AdSpotServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AdSpotServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected AdSpotServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for AdSpotServiceSettings. */
  public static class Builder extends ClientSettings.Builder<AdSpotServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(AdSpotServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(AdSpotServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(AdSpotServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(AdSpotServiceStubSettings.newBuilder());
    }

    public AdSpotServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((AdSpotServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getAdSpot. */
    public UnaryCallSettings.Builder<GetAdSpotRequest, AdSpot> getAdSpotSettings() {
      return getStubSettingsBuilder().getAdSpotSettings();
    }

    /** Returns the builder for the settings used for calls to listAdSpots. */
    public PagedCallSettings.Builder<
            ListAdSpotsRequest, ListAdSpotsResponse, ListAdSpotsPagedResponse>
        listAdSpotsSettings() {
      return getStubSettingsBuilder().listAdSpotsSettings();
    }

    /** Returns the builder for the settings used for calls to createAdSpot. */
    public UnaryCallSettings.Builder<CreateAdSpotRequest, AdSpot> createAdSpotSettings() {
      return getStubSettingsBuilder().createAdSpotSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreateAdSpots. */
    public UnaryCallSettings.Builder<BatchCreateAdSpotsRequest, BatchCreateAdSpotsResponse>
        batchCreateAdSpotsSettings() {
      return getStubSettingsBuilder().batchCreateAdSpotsSettings();
    }

    /** Returns the builder for the settings used for calls to updateAdSpot. */
    public UnaryCallSettings.Builder<UpdateAdSpotRequest, AdSpot> updateAdSpotSettings() {
      return getStubSettingsBuilder().updateAdSpotSettings();
    }

    /** Returns the builder for the settings used for calls to batchUpdateAdSpots. */
    public UnaryCallSettings.Builder<BatchUpdateAdSpotsRequest, BatchUpdateAdSpotsResponse>
        batchUpdateAdSpotsSettings() {
      return getStubSettingsBuilder().batchUpdateAdSpotsSettings();
    }

    @Override
    public AdSpotServiceSettings build() throws IOException {
      return new AdSpotServiceSettings(this);
    }
  }
}
