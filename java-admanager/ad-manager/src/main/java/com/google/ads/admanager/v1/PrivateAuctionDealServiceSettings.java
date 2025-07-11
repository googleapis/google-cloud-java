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

package com.google.ads.admanager.v1;

import static com.google.ads.admanager.v1.PrivateAuctionDealServiceClient.ListPrivateAuctionDealsPagedResponse;

import com.google.ads.admanager.v1.stub.PrivateAuctionDealServiceStubSettings;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link PrivateAuctionDealServiceClient}.
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
 * of getPrivateAuctionDeal:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PrivateAuctionDealServiceSettings.Builder privateAuctionDealServiceSettingsBuilder =
 *     PrivateAuctionDealServiceSettings.newBuilder();
 * privateAuctionDealServiceSettingsBuilder
 *     .getPrivateAuctionDealSettings()
 *     .setRetrySettings(
 *         privateAuctionDealServiceSettingsBuilder
 *             .getPrivateAuctionDealSettings()
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
 * PrivateAuctionDealServiceSettings privateAuctionDealServiceSettings =
 *     privateAuctionDealServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@Generated("by gapic-generator-java")
public class PrivateAuctionDealServiceSettings
    extends ClientSettings<PrivateAuctionDealServiceSettings> {

  /** Returns the object with the settings used for calls to getPrivateAuctionDeal. */
  public UnaryCallSettings<GetPrivateAuctionDealRequest, PrivateAuctionDeal>
      getPrivateAuctionDealSettings() {
    return ((PrivateAuctionDealServiceStubSettings) getStubSettings())
        .getPrivateAuctionDealSettings();
  }

  /** Returns the object with the settings used for calls to listPrivateAuctionDeals. */
  public PagedCallSettings<
          ListPrivateAuctionDealsRequest,
          ListPrivateAuctionDealsResponse,
          ListPrivateAuctionDealsPagedResponse>
      listPrivateAuctionDealsSettings() {
    return ((PrivateAuctionDealServiceStubSettings) getStubSettings())
        .listPrivateAuctionDealsSettings();
  }

  /** Returns the object with the settings used for calls to createPrivateAuctionDeal. */
  public UnaryCallSettings<CreatePrivateAuctionDealRequest, PrivateAuctionDeal>
      createPrivateAuctionDealSettings() {
    return ((PrivateAuctionDealServiceStubSettings) getStubSettings())
        .createPrivateAuctionDealSettings();
  }

  /** Returns the object with the settings used for calls to updatePrivateAuctionDeal. */
  public UnaryCallSettings<UpdatePrivateAuctionDealRequest, PrivateAuctionDeal>
      updatePrivateAuctionDealSettings() {
    return ((PrivateAuctionDealServiceStubSettings) getStubSettings())
        .updatePrivateAuctionDealSettings();
  }

  public static final PrivateAuctionDealServiceSettings create(
      PrivateAuctionDealServiceStubSettings stub) throws IOException {
    return new PrivateAuctionDealServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return PrivateAuctionDealServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return PrivateAuctionDealServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return PrivateAuctionDealServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return PrivateAuctionDealServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return PrivateAuctionDealServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return PrivateAuctionDealServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return PrivateAuctionDealServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected PrivateAuctionDealServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for PrivateAuctionDealServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<PrivateAuctionDealServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(PrivateAuctionDealServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(PrivateAuctionDealServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(PrivateAuctionDealServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(PrivateAuctionDealServiceStubSettings.newBuilder());
    }

    public PrivateAuctionDealServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((PrivateAuctionDealServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getPrivateAuctionDeal. */
    public UnaryCallSettings.Builder<GetPrivateAuctionDealRequest, PrivateAuctionDeal>
        getPrivateAuctionDealSettings() {
      return getStubSettingsBuilder().getPrivateAuctionDealSettings();
    }

    /** Returns the builder for the settings used for calls to listPrivateAuctionDeals. */
    public PagedCallSettings.Builder<
            ListPrivateAuctionDealsRequest,
            ListPrivateAuctionDealsResponse,
            ListPrivateAuctionDealsPagedResponse>
        listPrivateAuctionDealsSettings() {
      return getStubSettingsBuilder().listPrivateAuctionDealsSettings();
    }

    /** Returns the builder for the settings used for calls to createPrivateAuctionDeal. */
    public UnaryCallSettings.Builder<CreatePrivateAuctionDealRequest, PrivateAuctionDeal>
        createPrivateAuctionDealSettings() {
      return getStubSettingsBuilder().createPrivateAuctionDealSettings();
    }

    /** Returns the builder for the settings used for calls to updatePrivateAuctionDeal. */
    public UnaryCallSettings.Builder<UpdatePrivateAuctionDealRequest, PrivateAuctionDeal>
        updatePrivateAuctionDealSettings() {
      return getStubSettingsBuilder().updatePrivateAuctionDealSettings();
    }

    @Override
    public PrivateAuctionDealServiceSettings build() throws IOException {
      return new PrivateAuctionDealServiceSettings(this);
    }
  }
}
