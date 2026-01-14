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

package com.google.cloud.vectorsearch.v1beta;

import static com.google.cloud.vectorsearch.v1beta.VectorSearchServiceClient.ListCollectionsPagedResponse;
import static com.google.cloud.vectorsearch.v1beta.VectorSearchServiceClient.ListIndexesPagedResponse;
import static com.google.cloud.vectorsearch.v1beta.VectorSearchServiceClient.ListLocationsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.vectorsearch.v1beta.stub.VectorSearchServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link VectorSearchServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (vectorsearch.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getCollection:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * VectorSearchServiceSettings.Builder vectorSearchServiceSettingsBuilder =
 *     VectorSearchServiceSettings.newBuilder();
 * vectorSearchServiceSettingsBuilder
 *     .getCollectionSettings()
 *     .setRetrySettings(
 *         vectorSearchServiceSettingsBuilder
 *             .getCollectionSettings()
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
 * VectorSearchServiceSettings vectorSearchServiceSettings =
 *     vectorSearchServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createCollection:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * VectorSearchServiceSettings.Builder vectorSearchServiceSettingsBuilder =
 *     VectorSearchServiceSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * vectorSearchServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class VectorSearchServiceSettings extends ClientSettings<VectorSearchServiceSettings> {

  /** Returns the object with the settings used for calls to listCollections. */
  public PagedCallSettings<
          ListCollectionsRequest, ListCollectionsResponse, ListCollectionsPagedResponse>
      listCollectionsSettings() {
    return ((VectorSearchServiceStubSettings) getStubSettings()).listCollectionsSettings();
  }

  /** Returns the object with the settings used for calls to getCollection. */
  public UnaryCallSettings<GetCollectionRequest, Collection> getCollectionSettings() {
    return ((VectorSearchServiceStubSettings) getStubSettings()).getCollectionSettings();
  }

  /** Returns the object with the settings used for calls to createCollection. */
  public UnaryCallSettings<CreateCollectionRequest, Operation> createCollectionSettings() {
    return ((VectorSearchServiceStubSettings) getStubSettings()).createCollectionSettings();
  }

  /** Returns the object with the settings used for calls to createCollection. */
  public OperationCallSettings<CreateCollectionRequest, Collection, OperationMetadata>
      createCollectionOperationSettings() {
    return ((VectorSearchServiceStubSettings) getStubSettings())
        .createCollectionOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateCollection. */
  public UnaryCallSettings<UpdateCollectionRequest, Operation> updateCollectionSettings() {
    return ((VectorSearchServiceStubSettings) getStubSettings()).updateCollectionSettings();
  }

  /** Returns the object with the settings used for calls to updateCollection. */
  public OperationCallSettings<UpdateCollectionRequest, Collection, OperationMetadata>
      updateCollectionOperationSettings() {
    return ((VectorSearchServiceStubSettings) getStubSettings())
        .updateCollectionOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteCollection. */
  public UnaryCallSettings<DeleteCollectionRequest, Operation> deleteCollectionSettings() {
    return ((VectorSearchServiceStubSettings) getStubSettings()).deleteCollectionSettings();
  }

  /** Returns the object with the settings used for calls to deleteCollection. */
  public OperationCallSettings<DeleteCollectionRequest, Empty, OperationMetadata>
      deleteCollectionOperationSettings() {
    return ((VectorSearchServiceStubSettings) getStubSettings())
        .deleteCollectionOperationSettings();
  }

  /** Returns the object with the settings used for calls to listIndexes. */
  public PagedCallSettings<ListIndexesRequest, ListIndexesResponse, ListIndexesPagedResponse>
      listIndexesSettings() {
    return ((VectorSearchServiceStubSettings) getStubSettings()).listIndexesSettings();
  }

  /** Returns the object with the settings used for calls to getIndex. */
  public UnaryCallSettings<GetIndexRequest, Index> getIndexSettings() {
    return ((VectorSearchServiceStubSettings) getStubSettings()).getIndexSettings();
  }

  /** Returns the object with the settings used for calls to createIndex. */
  public UnaryCallSettings<CreateIndexRequest, Operation> createIndexSettings() {
    return ((VectorSearchServiceStubSettings) getStubSettings()).createIndexSettings();
  }

  /** Returns the object with the settings used for calls to createIndex. */
  public OperationCallSettings<CreateIndexRequest, Index, OperationMetadata>
      createIndexOperationSettings() {
    return ((VectorSearchServiceStubSettings) getStubSettings()).createIndexOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteIndex. */
  public UnaryCallSettings<DeleteIndexRequest, Operation> deleteIndexSettings() {
    return ((VectorSearchServiceStubSettings) getStubSettings()).deleteIndexSettings();
  }

  /** Returns the object with the settings used for calls to deleteIndex. */
  public OperationCallSettings<DeleteIndexRequest, Empty, OperationMetadata>
      deleteIndexOperationSettings() {
    return ((VectorSearchServiceStubSettings) getStubSettings()).deleteIndexOperationSettings();
  }

  /** Returns the object with the settings used for calls to importDataObjects. */
  public UnaryCallSettings<ImportDataObjectsRequest, Operation> importDataObjectsSettings() {
    return ((VectorSearchServiceStubSettings) getStubSettings()).importDataObjectsSettings();
  }

  /** Returns the object with the settings used for calls to importDataObjects. */
  public OperationCallSettings<
          ImportDataObjectsRequest, ImportDataObjectsResponse, ImportDataObjectsMetadata>
      importDataObjectsOperationSettings() {
    return ((VectorSearchServiceStubSettings) getStubSettings())
        .importDataObjectsOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((VectorSearchServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((VectorSearchServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final VectorSearchServiceSettings create(VectorSearchServiceStubSettings stub)
      throws IOException {
    return new VectorSearchServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return VectorSearchServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return VectorSearchServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return VectorSearchServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return VectorSearchServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return VectorSearchServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return VectorSearchServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return VectorSearchServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return VectorSearchServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected VectorSearchServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for VectorSearchServiceSettings. */
  public static class Builder extends ClientSettings.Builder<VectorSearchServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(VectorSearchServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(VectorSearchServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(VectorSearchServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(VectorSearchServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(VectorSearchServiceStubSettings.newHttpJsonBuilder());
    }

    public VectorSearchServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((VectorSearchServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listCollections. */
    public PagedCallSettings.Builder<
            ListCollectionsRequest, ListCollectionsResponse, ListCollectionsPagedResponse>
        listCollectionsSettings() {
      return getStubSettingsBuilder().listCollectionsSettings();
    }

    /** Returns the builder for the settings used for calls to getCollection. */
    public UnaryCallSettings.Builder<GetCollectionRequest, Collection> getCollectionSettings() {
      return getStubSettingsBuilder().getCollectionSettings();
    }

    /** Returns the builder for the settings used for calls to createCollection. */
    public UnaryCallSettings.Builder<CreateCollectionRequest, Operation>
        createCollectionSettings() {
      return getStubSettingsBuilder().createCollectionSettings();
    }

    /** Returns the builder for the settings used for calls to createCollection. */
    public OperationCallSettings.Builder<CreateCollectionRequest, Collection, OperationMetadata>
        createCollectionOperationSettings() {
      return getStubSettingsBuilder().createCollectionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateCollection. */
    public UnaryCallSettings.Builder<UpdateCollectionRequest, Operation>
        updateCollectionSettings() {
      return getStubSettingsBuilder().updateCollectionSettings();
    }

    /** Returns the builder for the settings used for calls to updateCollection. */
    public OperationCallSettings.Builder<UpdateCollectionRequest, Collection, OperationMetadata>
        updateCollectionOperationSettings() {
      return getStubSettingsBuilder().updateCollectionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCollection. */
    public UnaryCallSettings.Builder<DeleteCollectionRequest, Operation>
        deleteCollectionSettings() {
      return getStubSettingsBuilder().deleteCollectionSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCollection. */
    public OperationCallSettings.Builder<DeleteCollectionRequest, Empty, OperationMetadata>
        deleteCollectionOperationSettings() {
      return getStubSettingsBuilder().deleteCollectionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listIndexes. */
    public PagedCallSettings.Builder<
            ListIndexesRequest, ListIndexesResponse, ListIndexesPagedResponse>
        listIndexesSettings() {
      return getStubSettingsBuilder().listIndexesSettings();
    }

    /** Returns the builder for the settings used for calls to getIndex. */
    public UnaryCallSettings.Builder<GetIndexRequest, Index> getIndexSettings() {
      return getStubSettingsBuilder().getIndexSettings();
    }

    /** Returns the builder for the settings used for calls to createIndex. */
    public UnaryCallSettings.Builder<CreateIndexRequest, Operation> createIndexSettings() {
      return getStubSettingsBuilder().createIndexSettings();
    }

    /** Returns the builder for the settings used for calls to createIndex. */
    public OperationCallSettings.Builder<CreateIndexRequest, Index, OperationMetadata>
        createIndexOperationSettings() {
      return getStubSettingsBuilder().createIndexOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteIndex. */
    public UnaryCallSettings.Builder<DeleteIndexRequest, Operation> deleteIndexSettings() {
      return getStubSettingsBuilder().deleteIndexSettings();
    }

    /** Returns the builder for the settings used for calls to deleteIndex. */
    public OperationCallSettings.Builder<DeleteIndexRequest, Empty, OperationMetadata>
        deleteIndexOperationSettings() {
      return getStubSettingsBuilder().deleteIndexOperationSettings();
    }

    /** Returns the builder for the settings used for calls to importDataObjects. */
    public UnaryCallSettings.Builder<ImportDataObjectsRequest, Operation>
        importDataObjectsSettings() {
      return getStubSettingsBuilder().importDataObjectsSettings();
    }

    /** Returns the builder for the settings used for calls to importDataObjects. */
    public OperationCallSettings.Builder<
            ImportDataObjectsRequest, ImportDataObjectsResponse, ImportDataObjectsMetadata>
        importDataObjectsOperationSettings() {
      return getStubSettingsBuilder().importDataObjectsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return getStubSettingsBuilder().listLocationsSettings();
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getStubSettingsBuilder().getLocationSettings();
    }

    @Override
    public VectorSearchServiceSettings build() throws IOException {
      return new VectorSearchServiceSettings(this);
    }
  }
}
