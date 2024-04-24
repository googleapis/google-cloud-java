/*
 * Copyright 2024 Google LLC
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

package com.google.maps.solar.v1;

import com.google.api.HttpBody;
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
import com.google.maps.solar.v1.stub.SolarStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SolarClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (solar.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of findClosestBuildingInsights to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SolarSettings.Builder solarSettingsBuilder = SolarSettings.newBuilder();
 * solarSettingsBuilder
 *     .findClosestBuildingInsightsSettings()
 *     .setRetrySettings(
 *         solarSettingsBuilder
 *             .findClosestBuildingInsightsSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * SolarSettings solarSettings = solarSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class SolarSettings extends ClientSettings<SolarSettings> {

  /** Returns the object with the settings used for calls to findClosestBuildingInsights. */
  public UnaryCallSettings<FindClosestBuildingInsightsRequest, BuildingInsights>
      findClosestBuildingInsightsSettings() {
    return ((SolarStubSettings) getStubSettings()).findClosestBuildingInsightsSettings();
  }

  /** Returns the object with the settings used for calls to getDataLayers. */
  public UnaryCallSettings<GetDataLayersRequest, DataLayers> getDataLayersSettings() {
    return ((SolarStubSettings) getStubSettings()).getDataLayersSettings();
  }

  /** Returns the object with the settings used for calls to getGeoTiff. */
  public UnaryCallSettings<GetGeoTiffRequest, HttpBody> getGeoTiffSettings() {
    return ((SolarStubSettings) getStubSettings()).getGeoTiffSettings();
  }

  public static final SolarSettings create(SolarStubSettings stub) throws IOException {
    return new SolarSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return SolarStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return SolarStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return SolarStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return SolarStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return SolarStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return SolarStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return SolarStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SolarStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected SolarSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for SolarSettings. */
  public static class Builder extends ClientSettings.Builder<SolarSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(SolarStubSettings.newBuilder(clientContext));
    }

    protected Builder(SolarSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(SolarStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(SolarStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(SolarStubSettings.newHttpJsonBuilder());
    }

    public SolarStubSettings.Builder getStubSettingsBuilder() {
      return ((SolarStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to findClosestBuildingInsights. */
    public UnaryCallSettings.Builder<FindClosestBuildingInsightsRequest, BuildingInsights>
        findClosestBuildingInsightsSettings() {
      return getStubSettingsBuilder().findClosestBuildingInsightsSettings();
    }

    /** Returns the builder for the settings used for calls to getDataLayers. */
    public UnaryCallSettings.Builder<GetDataLayersRequest, DataLayers> getDataLayersSettings() {
      return getStubSettingsBuilder().getDataLayersSettings();
    }

    /** Returns the builder for the settings used for calls to getGeoTiff. */
    public UnaryCallSettings.Builder<GetGeoTiffRequest, HttpBody> getGeoTiffSettings() {
      return getStubSettingsBuilder().getGeoTiffSettings();
    }

    @Override
    public SolarSettings build() throws IOException {
      return new SolarSettings(this);
    }
  }
}
