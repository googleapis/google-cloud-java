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

package com.google.cloud.bigquery.biglake.v1alpha1;

import static com.google.cloud.bigquery.biglake.v1alpha1.MetastoreServiceClient.ListCatalogsPagedResponse;
import static com.google.cloud.bigquery.biglake.v1alpha1.MetastoreServiceClient.ListDatabasesPagedResponse;
import static com.google.cloud.bigquery.biglake.v1alpha1.MetastoreServiceClient.ListLocksPagedResponse;
import static com.google.cloud.bigquery.biglake.v1alpha1.MetastoreServiceClient.ListTablesPagedResponse;

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
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.bigquery.biglake.v1alpha1.stub.MetastoreServiceStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link MetastoreServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (biglake.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createCatalog to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MetastoreServiceSettings.Builder metastoreServiceSettingsBuilder =
 *     MetastoreServiceSettings.newBuilder();
 * metastoreServiceSettingsBuilder
 *     .createCatalogSettings()
 *     .setRetrySettings(
 *         metastoreServiceSettingsBuilder
 *             .createCatalogSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * MetastoreServiceSettings metastoreServiceSettings = metastoreServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class MetastoreServiceSettings extends ClientSettings<MetastoreServiceSettings> {

  /** Returns the object with the settings used for calls to createCatalog. */
  public UnaryCallSettings<CreateCatalogRequest, Catalog> createCatalogSettings() {
    return ((MetastoreServiceStubSettings) getStubSettings()).createCatalogSettings();
  }

  /** Returns the object with the settings used for calls to deleteCatalog. */
  public UnaryCallSettings<DeleteCatalogRequest, Catalog> deleteCatalogSettings() {
    return ((MetastoreServiceStubSettings) getStubSettings()).deleteCatalogSettings();
  }

  /** Returns the object with the settings used for calls to getCatalog. */
  public UnaryCallSettings<GetCatalogRequest, Catalog> getCatalogSettings() {
    return ((MetastoreServiceStubSettings) getStubSettings()).getCatalogSettings();
  }

  /** Returns the object with the settings used for calls to listCatalogs. */
  public PagedCallSettings<ListCatalogsRequest, ListCatalogsResponse, ListCatalogsPagedResponse>
      listCatalogsSettings() {
    return ((MetastoreServiceStubSettings) getStubSettings()).listCatalogsSettings();
  }

  /** Returns the object with the settings used for calls to createDatabase. */
  public UnaryCallSettings<CreateDatabaseRequest, Database> createDatabaseSettings() {
    return ((MetastoreServiceStubSettings) getStubSettings()).createDatabaseSettings();
  }

  /** Returns the object with the settings used for calls to deleteDatabase. */
  public UnaryCallSettings<DeleteDatabaseRequest, Database> deleteDatabaseSettings() {
    return ((MetastoreServiceStubSettings) getStubSettings()).deleteDatabaseSettings();
  }

  /** Returns the object with the settings used for calls to updateDatabase. */
  public UnaryCallSettings<UpdateDatabaseRequest, Database> updateDatabaseSettings() {
    return ((MetastoreServiceStubSettings) getStubSettings()).updateDatabaseSettings();
  }

  /** Returns the object with the settings used for calls to getDatabase. */
  public UnaryCallSettings<GetDatabaseRequest, Database> getDatabaseSettings() {
    return ((MetastoreServiceStubSettings) getStubSettings()).getDatabaseSettings();
  }

  /** Returns the object with the settings used for calls to listDatabases. */
  public PagedCallSettings<ListDatabasesRequest, ListDatabasesResponse, ListDatabasesPagedResponse>
      listDatabasesSettings() {
    return ((MetastoreServiceStubSettings) getStubSettings()).listDatabasesSettings();
  }

  /** Returns the object with the settings used for calls to createTable. */
  public UnaryCallSettings<CreateTableRequest, Table> createTableSettings() {
    return ((MetastoreServiceStubSettings) getStubSettings()).createTableSettings();
  }

  /** Returns the object with the settings used for calls to deleteTable. */
  public UnaryCallSettings<DeleteTableRequest, Table> deleteTableSettings() {
    return ((MetastoreServiceStubSettings) getStubSettings()).deleteTableSettings();
  }

  /** Returns the object with the settings used for calls to updateTable. */
  public UnaryCallSettings<UpdateTableRequest, Table> updateTableSettings() {
    return ((MetastoreServiceStubSettings) getStubSettings()).updateTableSettings();
  }

  /** Returns the object with the settings used for calls to renameTable. */
  public UnaryCallSettings<RenameTableRequest, Table> renameTableSettings() {
    return ((MetastoreServiceStubSettings) getStubSettings()).renameTableSettings();
  }

  /** Returns the object with the settings used for calls to getTable. */
  public UnaryCallSettings<GetTableRequest, Table> getTableSettings() {
    return ((MetastoreServiceStubSettings) getStubSettings()).getTableSettings();
  }

  /** Returns the object with the settings used for calls to listTables. */
  public PagedCallSettings<ListTablesRequest, ListTablesResponse, ListTablesPagedResponse>
      listTablesSettings() {
    return ((MetastoreServiceStubSettings) getStubSettings()).listTablesSettings();
  }

  /** Returns the object with the settings used for calls to createLock. */
  public UnaryCallSettings<CreateLockRequest, Lock> createLockSettings() {
    return ((MetastoreServiceStubSettings) getStubSettings()).createLockSettings();
  }

  /** Returns the object with the settings used for calls to deleteLock. */
  public UnaryCallSettings<DeleteLockRequest, Empty> deleteLockSettings() {
    return ((MetastoreServiceStubSettings) getStubSettings()).deleteLockSettings();
  }

  /** Returns the object with the settings used for calls to checkLock. */
  public UnaryCallSettings<CheckLockRequest, Lock> checkLockSettings() {
    return ((MetastoreServiceStubSettings) getStubSettings()).checkLockSettings();
  }

  /** Returns the object with the settings used for calls to listLocks. */
  public PagedCallSettings<ListLocksRequest, ListLocksResponse, ListLocksPagedResponse>
      listLocksSettings() {
    return ((MetastoreServiceStubSettings) getStubSettings()).listLocksSettings();
  }

  public static final MetastoreServiceSettings create(MetastoreServiceStubSettings stub)
      throws IOException {
    return new MetastoreServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return MetastoreServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return MetastoreServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return MetastoreServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return MetastoreServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return MetastoreServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return MetastoreServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return MetastoreServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return MetastoreServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected MetastoreServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for MetastoreServiceSettings. */
  public static class Builder extends ClientSettings.Builder<MetastoreServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(MetastoreServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(MetastoreServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(MetastoreServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(MetastoreServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(MetastoreServiceStubSettings.newHttpJsonBuilder());
    }

    public MetastoreServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((MetastoreServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createCatalog. */
    public UnaryCallSettings.Builder<CreateCatalogRequest, Catalog> createCatalogSettings() {
      return getStubSettingsBuilder().createCatalogSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCatalog. */
    public UnaryCallSettings.Builder<DeleteCatalogRequest, Catalog> deleteCatalogSettings() {
      return getStubSettingsBuilder().deleteCatalogSettings();
    }

    /** Returns the builder for the settings used for calls to getCatalog. */
    public UnaryCallSettings.Builder<GetCatalogRequest, Catalog> getCatalogSettings() {
      return getStubSettingsBuilder().getCatalogSettings();
    }

    /** Returns the builder for the settings used for calls to listCatalogs. */
    public PagedCallSettings.Builder<
            ListCatalogsRequest, ListCatalogsResponse, ListCatalogsPagedResponse>
        listCatalogsSettings() {
      return getStubSettingsBuilder().listCatalogsSettings();
    }

    /** Returns the builder for the settings used for calls to createDatabase. */
    public UnaryCallSettings.Builder<CreateDatabaseRequest, Database> createDatabaseSettings() {
      return getStubSettingsBuilder().createDatabaseSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDatabase. */
    public UnaryCallSettings.Builder<DeleteDatabaseRequest, Database> deleteDatabaseSettings() {
      return getStubSettingsBuilder().deleteDatabaseSettings();
    }

    /** Returns the builder for the settings used for calls to updateDatabase. */
    public UnaryCallSettings.Builder<UpdateDatabaseRequest, Database> updateDatabaseSettings() {
      return getStubSettingsBuilder().updateDatabaseSettings();
    }

    /** Returns the builder for the settings used for calls to getDatabase. */
    public UnaryCallSettings.Builder<GetDatabaseRequest, Database> getDatabaseSettings() {
      return getStubSettingsBuilder().getDatabaseSettings();
    }

    /** Returns the builder for the settings used for calls to listDatabases. */
    public PagedCallSettings.Builder<
            ListDatabasesRequest, ListDatabasesResponse, ListDatabasesPagedResponse>
        listDatabasesSettings() {
      return getStubSettingsBuilder().listDatabasesSettings();
    }

    /** Returns the builder for the settings used for calls to createTable. */
    public UnaryCallSettings.Builder<CreateTableRequest, Table> createTableSettings() {
      return getStubSettingsBuilder().createTableSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTable. */
    public UnaryCallSettings.Builder<DeleteTableRequest, Table> deleteTableSettings() {
      return getStubSettingsBuilder().deleteTableSettings();
    }

    /** Returns the builder for the settings used for calls to updateTable. */
    public UnaryCallSettings.Builder<UpdateTableRequest, Table> updateTableSettings() {
      return getStubSettingsBuilder().updateTableSettings();
    }

    /** Returns the builder for the settings used for calls to renameTable. */
    public UnaryCallSettings.Builder<RenameTableRequest, Table> renameTableSettings() {
      return getStubSettingsBuilder().renameTableSettings();
    }

    /** Returns the builder for the settings used for calls to getTable. */
    public UnaryCallSettings.Builder<GetTableRequest, Table> getTableSettings() {
      return getStubSettingsBuilder().getTableSettings();
    }

    /** Returns the builder for the settings used for calls to listTables. */
    public PagedCallSettings.Builder<ListTablesRequest, ListTablesResponse, ListTablesPagedResponse>
        listTablesSettings() {
      return getStubSettingsBuilder().listTablesSettings();
    }

    /** Returns the builder for the settings used for calls to createLock. */
    public UnaryCallSettings.Builder<CreateLockRequest, Lock> createLockSettings() {
      return getStubSettingsBuilder().createLockSettings();
    }

    /** Returns the builder for the settings used for calls to deleteLock. */
    public UnaryCallSettings.Builder<DeleteLockRequest, Empty> deleteLockSettings() {
      return getStubSettingsBuilder().deleteLockSettings();
    }

    /** Returns the builder for the settings used for calls to checkLock. */
    public UnaryCallSettings.Builder<CheckLockRequest, Lock> checkLockSettings() {
      return getStubSettingsBuilder().checkLockSettings();
    }

    /** Returns the builder for the settings used for calls to listLocks. */
    public PagedCallSettings.Builder<ListLocksRequest, ListLocksResponse, ListLocksPagedResponse>
        listLocksSettings() {
      return getStubSettingsBuilder().listLocksSettings();
    }

    @Override
    public MetastoreServiceSettings build() throws IOException {
      return new MetastoreServiceSettings(this);
    }
  }
}
