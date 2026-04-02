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

package com.google.maps.geocode.v4;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.maps.geocode.v4.stub.GeocodeServiceStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link GeocodeServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (geocoding-backend.googleapis.com) and default port (443) are
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
 * of geocodeAddress:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * GeocodeServiceSettings.Builder geocodeServiceSettingsBuilder =
 *     GeocodeServiceSettings.newBuilder();
 * geocodeServiceSettingsBuilder
 *     .geocodeAddressSettings()
 *     .setRetrySettings(
 *         geocodeServiceSettingsBuilder
 *             .geocodeAddressSettings()
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
 * GeocodeServiceSettings geocodeServiceSettings = geocodeServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@Generated("by gapic-generator-java")
public class GeocodeServiceSettings extends ClientSettings<GeocodeServiceSettings> {

  /** Returns the object with the settings used for calls to geocodeAddress. */
  public UnaryCallSettings<GeocodeAddressRequest, GeocodeAddressResponse> geocodeAddressSettings() {
    return ((GeocodeServiceStubSettings) getStubSettings()).geocodeAddressSettings();
  }

  /** Returns the object with the settings used for calls to geocodeLocation. */
  public UnaryCallSettings<GeocodeLocationRequest, GeocodeLocationResponse>
      geocodeLocationSettings() {
    return ((GeocodeServiceStubSettings) getStubSettings()).geocodeLocationSettings();
  }

  /** Returns the object with the settings used for calls to geocodePlace. */
  public UnaryCallSettings<GeocodePlaceRequest, GeocodeResult> geocodePlaceSettings() {
    return ((GeocodeServiceStubSettings) getStubSettings()).geocodePlaceSettings();
  }

  public static final GeocodeServiceSettings create(GeocodeServiceStubSettings stub)
      throws IOException {
    return new GeocodeServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return GeocodeServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return GeocodeServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return GeocodeServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GeocodeServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return GeocodeServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return GeocodeServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return GeocodeServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return GeocodeServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected GeocodeServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for GeocodeServiceSettings. */
  public static class Builder extends ClientSettings.Builder<GeocodeServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(GeocodeServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(GeocodeServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(GeocodeServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(GeocodeServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(GeocodeServiceStubSettings.newHttpJsonBuilder());
    }

    public GeocodeServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((GeocodeServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to geocodeAddress. */
    public UnaryCallSettings.Builder<GeocodeAddressRequest, GeocodeAddressResponse>
        geocodeAddressSettings() {
      return getStubSettingsBuilder().geocodeAddressSettings();
    }

    /** Returns the builder for the settings used for calls to geocodeLocation. */
    public UnaryCallSettings.Builder<GeocodeLocationRequest, GeocodeLocationResponse>
        geocodeLocationSettings() {
      return getStubSettingsBuilder().geocodeLocationSettings();
    }

    /** Returns the builder for the settings used for calls to geocodePlace. */
    public UnaryCallSettings.Builder<GeocodePlaceRequest, GeocodeResult> geocodePlaceSettings() {
      return getStubSettingsBuilder().geocodePlaceSettings();
    }

    @Override
    public GeocodeServiceSettings build() throws IOException {
      return new GeocodeServiceSettings(this);
    }
  }
}
