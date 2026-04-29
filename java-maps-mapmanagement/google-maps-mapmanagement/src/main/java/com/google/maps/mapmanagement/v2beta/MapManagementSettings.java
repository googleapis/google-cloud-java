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

package com.google.maps.mapmanagement.v2beta;

import static com.google.maps.mapmanagement.v2beta.MapManagementClient.ListMapConfigsPagedResponse;
import static com.google.maps.mapmanagement.v2beta.MapManagementClient.ListMapContextConfigsPagedResponse;
import static com.google.maps.mapmanagement.v2beta.MapManagementClient.ListStyleConfigsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.maps.mapmanagement.v2beta.stub.MapManagementStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link MapManagementClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (mapmanagement.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of createMapConfig:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MapManagementSettings.Builder mapManagementSettingsBuilder = MapManagementSettings.newBuilder();
 * mapManagementSettingsBuilder
 *     .createMapConfigSettings()
 *     .setRetrySettings(
 *         mapManagementSettingsBuilder
 *             .createMapConfigSettings()
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
 * MapManagementSettings mapManagementSettings = mapManagementSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class MapManagementSettings extends ClientSettings<MapManagementSettings> {

  /** Returns the object with the settings used for calls to createMapConfig. */
  public UnaryCallSettings<CreateMapConfigRequest, MapConfig> createMapConfigSettings() {
    return ((MapManagementStubSettings) getStubSettings()).createMapConfigSettings();
  }

  /** Returns the object with the settings used for calls to getMapConfig. */
  public UnaryCallSettings<GetMapConfigRequest, MapConfig> getMapConfigSettings() {
    return ((MapManagementStubSettings) getStubSettings()).getMapConfigSettings();
  }

  /** Returns the object with the settings used for calls to listMapConfigs. */
  public PagedCallSettings<
          ListMapConfigsRequest, ListMapConfigsResponse, ListMapConfigsPagedResponse>
      listMapConfigsSettings() {
    return ((MapManagementStubSettings) getStubSettings()).listMapConfigsSettings();
  }

  /** Returns the object with the settings used for calls to updateMapConfig. */
  public UnaryCallSettings<UpdateMapConfigRequest, MapConfig> updateMapConfigSettings() {
    return ((MapManagementStubSettings) getStubSettings()).updateMapConfigSettings();
  }

  /** Returns the object with the settings used for calls to deleteMapConfig. */
  public UnaryCallSettings<DeleteMapConfigRequest, Empty> deleteMapConfigSettings() {
    return ((MapManagementStubSettings) getStubSettings()).deleteMapConfigSettings();
  }

  /** Returns the object with the settings used for calls to createStyleConfig. */
  public UnaryCallSettings<CreateStyleConfigRequest, StyleConfig> createStyleConfigSettings() {
    return ((MapManagementStubSettings) getStubSettings()).createStyleConfigSettings();
  }

  /** Returns the object with the settings used for calls to getStyleConfig. */
  public UnaryCallSettings<GetStyleConfigRequest, StyleConfig> getStyleConfigSettings() {
    return ((MapManagementStubSettings) getStubSettings()).getStyleConfigSettings();
  }

  /** Returns the object with the settings used for calls to listStyleConfigs. */
  public PagedCallSettings<
          ListStyleConfigsRequest, ListStyleConfigsResponse, ListStyleConfigsPagedResponse>
      listStyleConfigsSettings() {
    return ((MapManagementStubSettings) getStubSettings()).listStyleConfigsSettings();
  }

  /** Returns the object with the settings used for calls to updateStyleConfig. */
  public UnaryCallSettings<UpdateStyleConfigRequest, StyleConfig> updateStyleConfigSettings() {
    return ((MapManagementStubSettings) getStubSettings()).updateStyleConfigSettings();
  }

  /** Returns the object with the settings used for calls to deleteStyleConfig. */
  public UnaryCallSettings<DeleteStyleConfigRequest, Empty> deleteStyleConfigSettings() {
    return ((MapManagementStubSettings) getStubSettings()).deleteStyleConfigSettings();
  }

  /** Returns the object with the settings used for calls to createMapContextConfig. */
  public UnaryCallSettings<CreateMapContextConfigRequest, MapContextConfig>
      createMapContextConfigSettings() {
    return ((MapManagementStubSettings) getStubSettings()).createMapContextConfigSettings();
  }

  /** Returns the object with the settings used for calls to getMapContextConfig. */
  public UnaryCallSettings<GetMapContextConfigRequest, MapContextConfig>
      getMapContextConfigSettings() {
    return ((MapManagementStubSettings) getStubSettings()).getMapContextConfigSettings();
  }

  /** Returns the object with the settings used for calls to listMapContextConfigs. */
  public PagedCallSettings<
          ListMapContextConfigsRequest,
          ListMapContextConfigsResponse,
          ListMapContextConfigsPagedResponse>
      listMapContextConfigsSettings() {
    return ((MapManagementStubSettings) getStubSettings()).listMapContextConfigsSettings();
  }

  /** Returns the object with the settings used for calls to updateMapContextConfig. */
  public UnaryCallSettings<UpdateMapContextConfigRequest, MapContextConfig>
      updateMapContextConfigSettings() {
    return ((MapManagementStubSettings) getStubSettings()).updateMapContextConfigSettings();
  }

  /** Returns the object with the settings used for calls to deleteMapContextConfig. */
  public UnaryCallSettings<DeleteMapContextConfigRequest, Empty> deleteMapContextConfigSettings() {
    return ((MapManagementStubSettings) getStubSettings()).deleteMapContextConfigSettings();
  }

  public static final MapManagementSettings create(MapManagementStubSettings stub)
      throws IOException {
    return new MapManagementSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return MapManagementStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return MapManagementStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return MapManagementStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return MapManagementStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return MapManagementStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return MapManagementStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return MapManagementStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return MapManagementStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected MapManagementSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for MapManagementSettings. */
  public static class Builder extends ClientSettings.Builder<MapManagementSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(MapManagementStubSettings.newBuilder(clientContext));
    }

    protected Builder(MapManagementSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(MapManagementStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(MapManagementStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(MapManagementStubSettings.newHttpJsonBuilder());
    }

    public MapManagementStubSettings.Builder getStubSettingsBuilder() {
      return ((MapManagementStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createMapConfig. */
    public UnaryCallSettings.Builder<CreateMapConfigRequest, MapConfig> createMapConfigSettings() {
      return getStubSettingsBuilder().createMapConfigSettings();
    }

    /** Returns the builder for the settings used for calls to getMapConfig. */
    public UnaryCallSettings.Builder<GetMapConfigRequest, MapConfig> getMapConfigSettings() {
      return getStubSettingsBuilder().getMapConfigSettings();
    }

    /** Returns the builder for the settings used for calls to listMapConfigs. */
    public PagedCallSettings.Builder<
            ListMapConfigsRequest, ListMapConfigsResponse, ListMapConfigsPagedResponse>
        listMapConfigsSettings() {
      return getStubSettingsBuilder().listMapConfigsSettings();
    }

    /** Returns the builder for the settings used for calls to updateMapConfig. */
    public UnaryCallSettings.Builder<UpdateMapConfigRequest, MapConfig> updateMapConfigSettings() {
      return getStubSettingsBuilder().updateMapConfigSettings();
    }

    /** Returns the builder for the settings used for calls to deleteMapConfig. */
    public UnaryCallSettings.Builder<DeleteMapConfigRequest, Empty> deleteMapConfigSettings() {
      return getStubSettingsBuilder().deleteMapConfigSettings();
    }

    /** Returns the builder for the settings used for calls to createStyleConfig. */
    public UnaryCallSettings.Builder<CreateStyleConfigRequest, StyleConfig>
        createStyleConfigSettings() {
      return getStubSettingsBuilder().createStyleConfigSettings();
    }

    /** Returns the builder for the settings used for calls to getStyleConfig. */
    public UnaryCallSettings.Builder<GetStyleConfigRequest, StyleConfig> getStyleConfigSettings() {
      return getStubSettingsBuilder().getStyleConfigSettings();
    }

    /** Returns the builder for the settings used for calls to listStyleConfigs. */
    public PagedCallSettings.Builder<
            ListStyleConfigsRequest, ListStyleConfigsResponse, ListStyleConfigsPagedResponse>
        listStyleConfigsSettings() {
      return getStubSettingsBuilder().listStyleConfigsSettings();
    }

    /** Returns the builder for the settings used for calls to updateStyleConfig. */
    public UnaryCallSettings.Builder<UpdateStyleConfigRequest, StyleConfig>
        updateStyleConfigSettings() {
      return getStubSettingsBuilder().updateStyleConfigSettings();
    }

    /** Returns the builder for the settings used for calls to deleteStyleConfig. */
    public UnaryCallSettings.Builder<DeleteStyleConfigRequest, Empty> deleteStyleConfigSettings() {
      return getStubSettingsBuilder().deleteStyleConfigSettings();
    }

    /** Returns the builder for the settings used for calls to createMapContextConfig. */
    public UnaryCallSettings.Builder<CreateMapContextConfigRequest, MapContextConfig>
        createMapContextConfigSettings() {
      return getStubSettingsBuilder().createMapContextConfigSettings();
    }

    /** Returns the builder for the settings used for calls to getMapContextConfig. */
    public UnaryCallSettings.Builder<GetMapContextConfigRequest, MapContextConfig>
        getMapContextConfigSettings() {
      return getStubSettingsBuilder().getMapContextConfigSettings();
    }

    /** Returns the builder for the settings used for calls to listMapContextConfigs. */
    public PagedCallSettings.Builder<
            ListMapContextConfigsRequest,
            ListMapContextConfigsResponse,
            ListMapContextConfigsPagedResponse>
        listMapContextConfigsSettings() {
      return getStubSettingsBuilder().listMapContextConfigsSettings();
    }

    /** Returns the builder for the settings used for calls to updateMapContextConfig. */
    public UnaryCallSettings.Builder<UpdateMapContextConfigRequest, MapContextConfig>
        updateMapContextConfigSettings() {
      return getStubSettingsBuilder().updateMapContextConfigSettings();
    }

    /** Returns the builder for the settings used for calls to deleteMapContextConfig. */
    public UnaryCallSettings.Builder<DeleteMapContextConfigRequest, Empty>
        deleteMapContextConfigSettings() {
      return getStubSettingsBuilder().deleteMapContextConfigSettings();
    }

    @Override
    public MapManagementSettings build() throws IOException {
      return new MapManagementSettings(this);
    }
  }
}
