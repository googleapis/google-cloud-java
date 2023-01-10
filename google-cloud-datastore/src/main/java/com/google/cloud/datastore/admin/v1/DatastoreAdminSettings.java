/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.datastore.admin.v1;

import static com.google.cloud.datastore.admin.v1.DatastoreAdminClient.ListIndexesPagedResponse;

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
import com.google.cloud.datastore.admin.v1.stub.DatastoreAdminStubSettings;
import com.google.datastore.admin.v1.CreateIndexRequest;
import com.google.datastore.admin.v1.DeleteIndexRequest;
import com.google.datastore.admin.v1.ExportEntitiesMetadata;
import com.google.datastore.admin.v1.ExportEntitiesRequest;
import com.google.datastore.admin.v1.ExportEntitiesResponse;
import com.google.datastore.admin.v1.GetIndexRequest;
import com.google.datastore.admin.v1.ImportEntitiesMetadata;
import com.google.datastore.admin.v1.ImportEntitiesRequest;
import com.google.datastore.admin.v1.Index;
import com.google.datastore.admin.v1.IndexOperationMetadata;
import com.google.datastore.admin.v1.ListIndexesRequest;
import com.google.datastore.admin.v1.ListIndexesResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DatastoreAdminClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (datastore.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getIndex to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DatastoreAdminSettings.Builder datastoreAdminSettingsBuilder =
 *     DatastoreAdminSettings.newBuilder();
 * datastoreAdminSettingsBuilder
 *     .getIndexSettings()
 *     .setRetrySettings(
 *         datastoreAdminSettingsBuilder
 *             .getIndexSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DatastoreAdminSettings datastoreAdminSettings = datastoreAdminSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DatastoreAdminSettings extends ClientSettings<DatastoreAdminSettings> {

  /** Returns the object with the settings used for calls to exportEntities. */
  public UnaryCallSettings<ExportEntitiesRequest, Operation> exportEntitiesSettings() {
    return ((DatastoreAdminStubSettings) getStubSettings()).exportEntitiesSettings();
  }

  /** Returns the object with the settings used for calls to exportEntities. */
  public OperationCallSettings<
          ExportEntitiesRequest, ExportEntitiesResponse, ExportEntitiesMetadata>
      exportEntitiesOperationSettings() {
    return ((DatastoreAdminStubSettings) getStubSettings()).exportEntitiesOperationSettings();
  }

  /** Returns the object with the settings used for calls to importEntities. */
  public UnaryCallSettings<ImportEntitiesRequest, Operation> importEntitiesSettings() {
    return ((DatastoreAdminStubSettings) getStubSettings()).importEntitiesSettings();
  }

  /** Returns the object with the settings used for calls to importEntities. */
  public OperationCallSettings<ImportEntitiesRequest, Empty, ImportEntitiesMetadata>
      importEntitiesOperationSettings() {
    return ((DatastoreAdminStubSettings) getStubSettings()).importEntitiesOperationSettings();
  }

  /** Returns the object with the settings used for calls to createIndex. */
  public UnaryCallSettings<CreateIndexRequest, Operation> createIndexSettings() {
    return ((DatastoreAdminStubSettings) getStubSettings()).createIndexSettings();
  }

  /** Returns the object with the settings used for calls to createIndex. */
  public OperationCallSettings<CreateIndexRequest, Index, IndexOperationMetadata>
      createIndexOperationSettings() {
    return ((DatastoreAdminStubSettings) getStubSettings()).createIndexOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteIndex. */
  public UnaryCallSettings<DeleteIndexRequest, Operation> deleteIndexSettings() {
    return ((DatastoreAdminStubSettings) getStubSettings()).deleteIndexSettings();
  }

  /** Returns the object with the settings used for calls to deleteIndex. */
  public OperationCallSettings<DeleteIndexRequest, Index, IndexOperationMetadata>
      deleteIndexOperationSettings() {
    return ((DatastoreAdminStubSettings) getStubSettings()).deleteIndexOperationSettings();
  }

  /** Returns the object with the settings used for calls to getIndex. */
  public UnaryCallSettings<GetIndexRequest, Index> getIndexSettings() {
    return ((DatastoreAdminStubSettings) getStubSettings()).getIndexSettings();
  }

  /** Returns the object with the settings used for calls to listIndexes. */
  public PagedCallSettings<ListIndexesRequest, ListIndexesResponse, ListIndexesPagedResponse>
      listIndexesSettings() {
    return ((DatastoreAdminStubSettings) getStubSettings()).listIndexesSettings();
  }

  public static final DatastoreAdminSettings create(DatastoreAdminStubSettings stub)
      throws IOException {
    return new DatastoreAdminSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DatastoreAdminStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DatastoreAdminStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DatastoreAdminStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DatastoreAdminStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DatastoreAdminStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return DatastoreAdminStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DatastoreAdminStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DatastoreAdminStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  @BetaApi
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

  protected DatastoreAdminSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DatastoreAdminSettings. */
  public static class Builder extends ClientSettings.Builder<DatastoreAdminSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(DatastoreAdminStubSettings.newBuilder(clientContext));
    }

    protected Builder(DatastoreAdminSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DatastoreAdminStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DatastoreAdminStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(DatastoreAdminStubSettings.newHttpJsonBuilder());
    }

    public DatastoreAdminStubSettings.Builder getStubSettingsBuilder() {
      return ((DatastoreAdminStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to exportEntities. */
    public UnaryCallSettings.Builder<ExportEntitiesRequest, Operation> exportEntitiesSettings() {
      return getStubSettingsBuilder().exportEntitiesSettings();
    }

    /** Returns the builder for the settings used for calls to exportEntities. */
    public OperationCallSettings.Builder<
            ExportEntitiesRequest, ExportEntitiesResponse, ExportEntitiesMetadata>
        exportEntitiesOperationSettings() {
      return getStubSettingsBuilder().exportEntitiesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to importEntities. */
    public UnaryCallSettings.Builder<ImportEntitiesRequest, Operation> importEntitiesSettings() {
      return getStubSettingsBuilder().importEntitiesSettings();
    }

    /** Returns the builder for the settings used for calls to importEntities. */
    public OperationCallSettings.Builder<ImportEntitiesRequest, Empty, ImportEntitiesMetadata>
        importEntitiesOperationSettings() {
      return getStubSettingsBuilder().importEntitiesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createIndex. */
    public UnaryCallSettings.Builder<CreateIndexRequest, Operation> createIndexSettings() {
      return getStubSettingsBuilder().createIndexSettings();
    }

    /** Returns the builder for the settings used for calls to createIndex. */
    public OperationCallSettings.Builder<CreateIndexRequest, Index, IndexOperationMetadata>
        createIndexOperationSettings() {
      return getStubSettingsBuilder().createIndexOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteIndex. */
    public UnaryCallSettings.Builder<DeleteIndexRequest, Operation> deleteIndexSettings() {
      return getStubSettingsBuilder().deleteIndexSettings();
    }

    /** Returns the builder for the settings used for calls to deleteIndex. */
    public OperationCallSettings.Builder<DeleteIndexRequest, Index, IndexOperationMetadata>
        deleteIndexOperationSettings() {
      return getStubSettingsBuilder().deleteIndexOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getIndex. */
    public UnaryCallSettings.Builder<GetIndexRequest, Index> getIndexSettings() {
      return getStubSettingsBuilder().getIndexSettings();
    }

    /** Returns the builder for the settings used for calls to listIndexes. */
    public PagedCallSettings.Builder<
            ListIndexesRequest, ListIndexesResponse, ListIndexesPagedResponse>
        listIndexesSettings() {
      return getStubSettingsBuilder().listIndexesSettings();
    }

    @Override
    public DatastoreAdminSettings build() throws IOException {
      return new DatastoreAdminSettings(this);
    }
  }
}
