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

import static com.google.ads.admanager.v1.AdReviewCenterAdServiceClient.SearchAdReviewCenterAdsPagedResponse;

import com.google.ads.admanager.v1.stub.AdReviewCenterAdServiceStubSettings;
import com.google.api.core.ApiFunction;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AdReviewCenterAdServiceClient}.
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
 * AdReviewCenterAdServiceSettings.Builder adReviewCenterAdServiceSettingsBuilder =
 *     AdReviewCenterAdServiceSettings.newBuilder();
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
 * AdReviewCenterAdServiceSettings adReviewCenterAdServiceSettings =
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
 * AdReviewCenterAdServiceSettings.Builder adReviewCenterAdServiceSettingsBuilder =
 *     AdReviewCenterAdServiceSettings.newBuilder();
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
public class AdReviewCenterAdServiceSettings
    extends ClientSettings<AdReviewCenterAdServiceSettings> {

  /** Returns the object with the settings used for calls to searchAdReviewCenterAds. */
  public PagedCallSettings<
          SearchAdReviewCenterAdsRequest,
          SearchAdReviewCenterAdsResponse,
          SearchAdReviewCenterAdsPagedResponse>
      searchAdReviewCenterAdsSettings() {
    return ((AdReviewCenterAdServiceStubSettings) getStubSettings())
        .searchAdReviewCenterAdsSettings();
  }

  /** Returns the object with the settings used for calls to batchAllowAdReviewCenterAds. */
  public UnaryCallSettings<BatchAllowAdReviewCenterAdsRequest, Operation>
      batchAllowAdReviewCenterAdsSettings() {
    return ((AdReviewCenterAdServiceStubSettings) getStubSettings())
        .batchAllowAdReviewCenterAdsSettings();
  }

  /** Returns the object with the settings used for calls to batchAllowAdReviewCenterAds. */
  public OperationCallSettings<
          BatchAllowAdReviewCenterAdsRequest,
          BatchAllowAdReviewCenterAdsResponse,
          BatchAdReviewCenterAdsOperationMetadata>
      batchAllowAdReviewCenterAdsOperationSettings() {
    return ((AdReviewCenterAdServiceStubSettings) getStubSettings())
        .batchAllowAdReviewCenterAdsOperationSettings();
  }

  /** Returns the object with the settings used for calls to batchBlockAdReviewCenterAds. */
  public UnaryCallSettings<BatchBlockAdReviewCenterAdsRequest, Operation>
      batchBlockAdReviewCenterAdsSettings() {
    return ((AdReviewCenterAdServiceStubSettings) getStubSettings())
        .batchBlockAdReviewCenterAdsSettings();
  }

  /** Returns the object with the settings used for calls to batchBlockAdReviewCenterAds. */
  public OperationCallSettings<
          BatchBlockAdReviewCenterAdsRequest,
          BatchBlockAdReviewCenterAdsResponse,
          BatchAdReviewCenterAdsOperationMetadata>
      batchBlockAdReviewCenterAdsOperationSettings() {
    return ((AdReviewCenterAdServiceStubSettings) getStubSettings())
        .batchBlockAdReviewCenterAdsOperationSettings();
  }

  public static final AdReviewCenterAdServiceSettings create(
      AdReviewCenterAdServiceStubSettings stub) throws IOException {
    return new AdReviewCenterAdServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return AdReviewCenterAdServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return AdReviewCenterAdServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return AdReviewCenterAdServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return AdReviewCenterAdServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return AdReviewCenterAdServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return AdReviewCenterAdServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AdReviewCenterAdServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected AdReviewCenterAdServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for AdReviewCenterAdServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<AdReviewCenterAdServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(AdReviewCenterAdServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(AdReviewCenterAdServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(AdReviewCenterAdServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(AdReviewCenterAdServiceStubSettings.newBuilder());
    }

    public AdReviewCenterAdServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((AdReviewCenterAdServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to searchAdReviewCenterAds. */
    public PagedCallSettings.Builder<
            SearchAdReviewCenterAdsRequest,
            SearchAdReviewCenterAdsResponse,
            SearchAdReviewCenterAdsPagedResponse>
        searchAdReviewCenterAdsSettings() {
      return getStubSettingsBuilder().searchAdReviewCenterAdsSettings();
    }

    /** Returns the builder for the settings used for calls to batchAllowAdReviewCenterAds. */
    public UnaryCallSettings.Builder<BatchAllowAdReviewCenterAdsRequest, Operation>
        batchAllowAdReviewCenterAdsSettings() {
      return getStubSettingsBuilder().batchAllowAdReviewCenterAdsSettings();
    }

    /** Returns the builder for the settings used for calls to batchAllowAdReviewCenterAds. */
    public OperationCallSettings.Builder<
            BatchAllowAdReviewCenterAdsRequest,
            BatchAllowAdReviewCenterAdsResponse,
            BatchAdReviewCenterAdsOperationMetadata>
        batchAllowAdReviewCenterAdsOperationSettings() {
      return getStubSettingsBuilder().batchAllowAdReviewCenterAdsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to batchBlockAdReviewCenterAds. */
    public UnaryCallSettings.Builder<BatchBlockAdReviewCenterAdsRequest, Operation>
        batchBlockAdReviewCenterAdsSettings() {
      return getStubSettingsBuilder().batchBlockAdReviewCenterAdsSettings();
    }

    /** Returns the builder for the settings used for calls to batchBlockAdReviewCenterAds. */
    public OperationCallSettings.Builder<
            BatchBlockAdReviewCenterAdsRequest,
            BatchBlockAdReviewCenterAdsResponse,
            BatchAdReviewCenterAdsOperationMetadata>
        batchBlockAdReviewCenterAdsOperationSettings() {
      return getStubSettingsBuilder().batchBlockAdReviewCenterAdsOperationSettings();
    }

    @Override
    public AdReviewCenterAdServiceSettings build() throws IOException {
      return new AdReviewCenterAdServiceSettings(this);
    }
  }
}
