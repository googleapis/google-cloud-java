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

package com.google.maps.places.v1.stub;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.maps.places.v1.AutocompletePlacesRequest;
import com.google.maps.places.v1.AutocompletePlacesResponse;
import com.google.maps.places.v1.GetPhotoMediaRequest;
import com.google.maps.places.v1.GetPlaceRequest;
import com.google.maps.places.v1.PhotoMedia;
import com.google.maps.places.v1.Place;
import com.google.maps.places.v1.SearchNearbyRequest;
import com.google.maps.places.v1.SearchNearbyResponse;
import com.google.maps.places.v1.SearchTextRequest;
import com.google.maps.places.v1.SearchTextResponse;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link PlacesStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (places.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of searchNearby to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PlacesStubSettings.Builder placesSettingsBuilder = PlacesStubSettings.newBuilder();
 * placesSettingsBuilder
 *     .searchNearbySettings()
 *     .setRetrySettings(
 *         placesSettingsBuilder
 *             .searchNearbySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * PlacesStubSettings placesSettings = placesSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class PlacesStubSettings extends StubSettings<PlacesStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().build();

  private final UnaryCallSettings<SearchNearbyRequest, SearchNearbyResponse> searchNearbySettings;
  private final UnaryCallSettings<SearchTextRequest, SearchTextResponse> searchTextSettings;
  private final UnaryCallSettings<GetPhotoMediaRequest, PhotoMedia> getPhotoMediaSettings;
  private final UnaryCallSettings<GetPlaceRequest, Place> getPlaceSettings;
  private final UnaryCallSettings<AutocompletePlacesRequest, AutocompletePlacesResponse>
      autocompletePlacesSettings;

  /** Returns the object with the settings used for calls to searchNearby. */
  public UnaryCallSettings<SearchNearbyRequest, SearchNearbyResponse> searchNearbySettings() {
    return searchNearbySettings;
  }

  /** Returns the object with the settings used for calls to searchText. */
  public UnaryCallSettings<SearchTextRequest, SearchTextResponse> searchTextSettings() {
    return searchTextSettings;
  }

  /** Returns the object with the settings used for calls to getPhotoMedia. */
  public UnaryCallSettings<GetPhotoMediaRequest, PhotoMedia> getPhotoMediaSettings() {
    return getPhotoMediaSettings;
  }

  /** Returns the object with the settings used for calls to getPlace. */
  public UnaryCallSettings<GetPlaceRequest, Place> getPlaceSettings() {
    return getPlaceSettings;
  }

  /** Returns the object with the settings used for calls to autocompletePlaces. */
  public UnaryCallSettings<AutocompletePlacesRequest, AutocompletePlacesResponse>
      autocompletePlacesSettings() {
    return autocompletePlacesSettings;
  }

  public PlacesStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcPlacesStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonPlacesStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "places";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "places.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "places.mtls.googleapis.com:443";
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

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(PlacesStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(PlacesStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return PlacesStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected PlacesStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    searchNearbySettings = settingsBuilder.searchNearbySettings().build();
    searchTextSettings = settingsBuilder.searchTextSettings().build();
    getPhotoMediaSettings = settingsBuilder.getPhotoMediaSettings().build();
    getPlaceSettings = settingsBuilder.getPlaceSettings().build();
    autocompletePlacesSettings = settingsBuilder.autocompletePlacesSettings().build();
  }

  /** Builder for PlacesStubSettings. */
  public static class Builder extends StubSettings.Builder<PlacesStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<SearchNearbyRequest, SearchNearbyResponse>
        searchNearbySettings;
    private final UnaryCallSettings.Builder<SearchTextRequest, SearchTextResponse>
        searchTextSettings;
    private final UnaryCallSettings.Builder<GetPhotoMediaRequest, PhotoMedia> getPhotoMediaSettings;
    private final UnaryCallSettings.Builder<GetPlaceRequest, Place> getPlaceSettings;
    private final UnaryCallSettings.Builder<AutocompletePlacesRequest, AutocompletePlacesResponse>
        autocompletePlacesSettings;
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

      searchNearbySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      searchTextSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getPhotoMediaSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getPlaceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      autocompletePlacesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              searchNearbySettings,
              searchTextSettings,
              getPhotoMediaSettings,
              getPlaceSettings,
              autocompletePlacesSettings);
      initDefaults(this);
    }

    protected Builder(PlacesStubSettings settings) {
      super(settings);

      searchNearbySettings = settings.searchNearbySettings.toBuilder();
      searchTextSettings = settings.searchTextSettings.toBuilder();
      getPhotoMediaSettings = settings.getPhotoMediaSettings.toBuilder();
      getPlaceSettings = settings.getPlaceSettings.toBuilder();
      autocompletePlacesSettings = settings.autocompletePlacesSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              searchNearbySettings,
              searchTextSettings,
              getPhotoMediaSettings,
              getPlaceSettings,
              autocompletePlacesSettings);
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

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .searchNearbySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .searchTextSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getPhotoMediaSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getPlaceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .autocompletePlacesSettings()
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

    /** Returns the builder for the settings used for calls to searchNearby. */
    public UnaryCallSettings.Builder<SearchNearbyRequest, SearchNearbyResponse>
        searchNearbySettings() {
      return searchNearbySettings;
    }

    /** Returns the builder for the settings used for calls to searchText. */
    public UnaryCallSettings.Builder<SearchTextRequest, SearchTextResponse> searchTextSettings() {
      return searchTextSettings;
    }

    /** Returns the builder for the settings used for calls to getPhotoMedia. */
    public UnaryCallSettings.Builder<GetPhotoMediaRequest, PhotoMedia> getPhotoMediaSettings() {
      return getPhotoMediaSettings;
    }

    /** Returns the builder for the settings used for calls to getPlace. */
    public UnaryCallSettings.Builder<GetPlaceRequest, Place> getPlaceSettings() {
      return getPlaceSettings;
    }

    /** Returns the builder for the settings used for calls to autocompletePlaces. */
    public UnaryCallSettings.Builder<AutocompletePlacesRequest, AutocompletePlacesResponse>
        autocompletePlacesSettings() {
      return autocompletePlacesSettings;
    }

    @Override
    public PlacesStubSettings build() throws IOException {
      return new PlacesStubSettings(this);
    }
  }
}
