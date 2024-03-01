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

package com.google.maps.mapsplatformdatasets.v1alpha;

import static com.google.maps.mapsplatformdatasets.v1alpha.MapsPlatformDatasetsV1AlphaClient.ListDatasetVersionsPagedResponse;
import static com.google.maps.mapsplatformdatasets.v1alpha.MapsPlatformDatasetsV1AlphaClient.ListDatasetsPagedResponse;

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
import com.google.maps.mapsplatformdatasets.v1alpha.stub.MapsPlatformDatasetsV1AlphaStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link MapsPlatformDatasetsV1AlphaClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (mapsplatformdatasets.googleapis.com) and default port (443)
 *       are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createDataset to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MapsPlatformDatasetsV1AlphaSettings.Builder mapsPlatformDatasetsV1AlphaSettingsBuilder =
 *     MapsPlatformDatasetsV1AlphaSettings.newBuilder();
 * mapsPlatformDatasetsV1AlphaSettingsBuilder
 *     .createDatasetSettings()
 *     .setRetrySettings(
 *         mapsPlatformDatasetsV1AlphaSettingsBuilder
 *             .createDatasetSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * MapsPlatformDatasetsV1AlphaSettings mapsPlatformDatasetsV1AlphaSettings =
 *     mapsPlatformDatasetsV1AlphaSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class MapsPlatformDatasetsV1AlphaSettings
    extends ClientSettings<MapsPlatformDatasetsV1AlphaSettings> {

  /** Returns the object with the settings used for calls to createDataset. */
  public UnaryCallSettings<CreateDatasetRequest, Dataset> createDatasetSettings() {
    return ((MapsPlatformDatasetsV1AlphaStubSettings) getStubSettings()).createDatasetSettings();
  }

  /** Returns the object with the settings used for calls to updateDatasetMetadata. */
  public UnaryCallSettings<UpdateDatasetMetadataRequest, Dataset> updateDatasetMetadataSettings() {
    return ((MapsPlatformDatasetsV1AlphaStubSettings) getStubSettings())
        .updateDatasetMetadataSettings();
  }

  /** Returns the object with the settings used for calls to getDataset. */
  public UnaryCallSettings<GetDatasetRequest, Dataset> getDatasetSettings() {
    return ((MapsPlatformDatasetsV1AlphaStubSettings) getStubSettings()).getDatasetSettings();
  }

  /** Returns the object with the settings used for calls to listDatasetVersions. */
  public PagedCallSettings<
          ListDatasetVersionsRequest, ListDatasetVersionsResponse, ListDatasetVersionsPagedResponse>
      listDatasetVersionsSettings() {
    return ((MapsPlatformDatasetsV1AlphaStubSettings) getStubSettings())
        .listDatasetVersionsSettings();
  }

  /** Returns the object with the settings used for calls to listDatasets. */
  public PagedCallSettings<ListDatasetsRequest, ListDatasetsResponse, ListDatasetsPagedResponse>
      listDatasetsSettings() {
    return ((MapsPlatformDatasetsV1AlphaStubSettings) getStubSettings()).listDatasetsSettings();
  }

  /** Returns the object with the settings used for calls to deleteDataset. */
  public UnaryCallSettings<DeleteDatasetRequest, Empty> deleteDatasetSettings() {
    return ((MapsPlatformDatasetsV1AlphaStubSettings) getStubSettings()).deleteDatasetSettings();
  }

  /** Returns the object with the settings used for calls to deleteDatasetVersion. */
  public UnaryCallSettings<DeleteDatasetVersionRequest, Empty> deleteDatasetVersionSettings() {
    return ((MapsPlatformDatasetsV1AlphaStubSettings) getStubSettings())
        .deleteDatasetVersionSettings();
  }

  public static final MapsPlatformDatasetsV1AlphaSettings create(
      MapsPlatformDatasetsV1AlphaStubSettings stub) throws IOException {
    return new MapsPlatformDatasetsV1AlphaSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return MapsPlatformDatasetsV1AlphaStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return MapsPlatformDatasetsV1AlphaStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return MapsPlatformDatasetsV1AlphaStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return MapsPlatformDatasetsV1AlphaStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return MapsPlatformDatasetsV1AlphaStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return MapsPlatformDatasetsV1AlphaStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return MapsPlatformDatasetsV1AlphaStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return MapsPlatformDatasetsV1AlphaStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected MapsPlatformDatasetsV1AlphaSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for MapsPlatformDatasetsV1AlphaSettings. */
  public static class Builder
      extends ClientSettings.Builder<MapsPlatformDatasetsV1AlphaSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(MapsPlatformDatasetsV1AlphaStubSettings.newBuilder(clientContext));
    }

    protected Builder(MapsPlatformDatasetsV1AlphaSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(MapsPlatformDatasetsV1AlphaStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(MapsPlatformDatasetsV1AlphaStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(MapsPlatformDatasetsV1AlphaStubSettings.newHttpJsonBuilder());
    }

    public MapsPlatformDatasetsV1AlphaStubSettings.Builder getStubSettingsBuilder() {
      return ((MapsPlatformDatasetsV1AlphaStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createDataset. */
    public UnaryCallSettings.Builder<CreateDatasetRequest, Dataset> createDatasetSettings() {
      return getStubSettingsBuilder().createDatasetSettings();
    }

    /** Returns the builder for the settings used for calls to updateDatasetMetadata. */
    public UnaryCallSettings.Builder<UpdateDatasetMetadataRequest, Dataset>
        updateDatasetMetadataSettings() {
      return getStubSettingsBuilder().updateDatasetMetadataSettings();
    }

    /** Returns the builder for the settings used for calls to getDataset. */
    public UnaryCallSettings.Builder<GetDatasetRequest, Dataset> getDatasetSettings() {
      return getStubSettingsBuilder().getDatasetSettings();
    }

    /** Returns the builder for the settings used for calls to listDatasetVersions. */
    public PagedCallSettings.Builder<
            ListDatasetVersionsRequest,
            ListDatasetVersionsResponse,
            ListDatasetVersionsPagedResponse>
        listDatasetVersionsSettings() {
      return getStubSettingsBuilder().listDatasetVersionsSettings();
    }

    /** Returns the builder for the settings used for calls to listDatasets. */
    public PagedCallSettings.Builder<
            ListDatasetsRequest, ListDatasetsResponse, ListDatasetsPagedResponse>
        listDatasetsSettings() {
      return getStubSettingsBuilder().listDatasetsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDataset. */
    public UnaryCallSettings.Builder<DeleteDatasetRequest, Empty> deleteDatasetSettings() {
      return getStubSettingsBuilder().deleteDatasetSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDatasetVersion. */
    public UnaryCallSettings.Builder<DeleteDatasetVersionRequest, Empty>
        deleteDatasetVersionSettings() {
      return getStubSettingsBuilder().deleteDatasetVersionSettings();
    }

    @Override
    public MapsPlatformDatasetsV1AlphaSettings build() throws IOException {
      return new MapsPlatformDatasetsV1AlphaSettings(this);
    }
  }
}
