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

package com.google.cloud.metastore.v1;

import static com.google.cloud.metastore.v1.DataprocMetastoreClient.ListBackupsPagedResponse;
import static com.google.cloud.metastore.v1.DataprocMetastoreClient.ListMetadataImportsPagedResponse;
import static com.google.cloud.metastore.v1.DataprocMetastoreClient.ListServicesPagedResponse;

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
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.metastore.v1.stub.DataprocMetastoreStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DataprocMetastoreClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (metastore.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getService to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataprocMetastoreSettings.Builder dataprocMetastoreSettingsBuilder =
 *     DataprocMetastoreSettings.newBuilder();
 * dataprocMetastoreSettingsBuilder
 *     .getServiceSettings()
 *     .setRetrySettings(
 *         dataprocMetastoreSettingsBuilder
 *             .getServiceSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DataprocMetastoreSettings dataprocMetastoreSettings = dataprocMetastoreSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DataprocMetastoreSettings extends ClientSettings<DataprocMetastoreSettings> {

  /** Returns the object with the settings used for calls to listServices. */
  public PagedCallSettings<ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
      listServicesSettings() {
    return ((DataprocMetastoreStubSettings) getStubSettings()).listServicesSettings();
  }

  /** Returns the object with the settings used for calls to getService. */
  public UnaryCallSettings<GetServiceRequest, Service> getServiceSettings() {
    return ((DataprocMetastoreStubSettings) getStubSettings()).getServiceSettings();
  }

  /** Returns the object with the settings used for calls to createService. */
  public UnaryCallSettings<CreateServiceRequest, Operation> createServiceSettings() {
    return ((DataprocMetastoreStubSettings) getStubSettings()).createServiceSettings();
  }

  /** Returns the object with the settings used for calls to createService. */
  public OperationCallSettings<CreateServiceRequest, Service, OperationMetadata>
      createServiceOperationSettings() {
    return ((DataprocMetastoreStubSettings) getStubSettings()).createServiceOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateService. */
  public UnaryCallSettings<UpdateServiceRequest, Operation> updateServiceSettings() {
    return ((DataprocMetastoreStubSettings) getStubSettings()).updateServiceSettings();
  }

  /** Returns the object with the settings used for calls to updateService. */
  public OperationCallSettings<UpdateServiceRequest, Service, OperationMetadata>
      updateServiceOperationSettings() {
    return ((DataprocMetastoreStubSettings) getStubSettings()).updateServiceOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteService. */
  public UnaryCallSettings<DeleteServiceRequest, Operation> deleteServiceSettings() {
    return ((DataprocMetastoreStubSettings) getStubSettings()).deleteServiceSettings();
  }

  /** Returns the object with the settings used for calls to deleteService. */
  public OperationCallSettings<DeleteServiceRequest, Empty, OperationMetadata>
      deleteServiceOperationSettings() {
    return ((DataprocMetastoreStubSettings) getStubSettings()).deleteServiceOperationSettings();
  }

  /** Returns the object with the settings used for calls to listMetadataImports. */
  public PagedCallSettings<
          ListMetadataImportsRequest, ListMetadataImportsResponse, ListMetadataImportsPagedResponse>
      listMetadataImportsSettings() {
    return ((DataprocMetastoreStubSettings) getStubSettings()).listMetadataImportsSettings();
  }

  /** Returns the object with the settings used for calls to getMetadataImport. */
  public UnaryCallSettings<GetMetadataImportRequest, MetadataImport> getMetadataImportSettings() {
    return ((DataprocMetastoreStubSettings) getStubSettings()).getMetadataImportSettings();
  }

  /** Returns the object with the settings used for calls to createMetadataImport. */
  public UnaryCallSettings<CreateMetadataImportRequest, Operation> createMetadataImportSettings() {
    return ((DataprocMetastoreStubSettings) getStubSettings()).createMetadataImportSettings();
  }

  /** Returns the object with the settings used for calls to createMetadataImport. */
  public OperationCallSettings<CreateMetadataImportRequest, MetadataImport, OperationMetadata>
      createMetadataImportOperationSettings() {
    return ((DataprocMetastoreStubSettings) getStubSettings())
        .createMetadataImportOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateMetadataImport. */
  public UnaryCallSettings<UpdateMetadataImportRequest, Operation> updateMetadataImportSettings() {
    return ((DataprocMetastoreStubSettings) getStubSettings()).updateMetadataImportSettings();
  }

  /** Returns the object with the settings used for calls to updateMetadataImport. */
  public OperationCallSettings<UpdateMetadataImportRequest, MetadataImport, OperationMetadata>
      updateMetadataImportOperationSettings() {
    return ((DataprocMetastoreStubSettings) getStubSettings())
        .updateMetadataImportOperationSettings();
  }

  /** Returns the object with the settings used for calls to exportMetadata. */
  public UnaryCallSettings<ExportMetadataRequest, Operation> exportMetadataSettings() {
    return ((DataprocMetastoreStubSettings) getStubSettings()).exportMetadataSettings();
  }

  /** Returns the object with the settings used for calls to exportMetadata. */
  public OperationCallSettings<ExportMetadataRequest, MetadataExport, OperationMetadata>
      exportMetadataOperationSettings() {
    return ((DataprocMetastoreStubSettings) getStubSettings()).exportMetadataOperationSettings();
  }

  /** Returns the object with the settings used for calls to restoreService. */
  public UnaryCallSettings<RestoreServiceRequest, Operation> restoreServiceSettings() {
    return ((DataprocMetastoreStubSettings) getStubSettings()).restoreServiceSettings();
  }

  /** Returns the object with the settings used for calls to restoreService. */
  public OperationCallSettings<RestoreServiceRequest, Restore, OperationMetadata>
      restoreServiceOperationSettings() {
    return ((DataprocMetastoreStubSettings) getStubSettings()).restoreServiceOperationSettings();
  }

  /** Returns the object with the settings used for calls to listBackups. */
  public PagedCallSettings<ListBackupsRequest, ListBackupsResponse, ListBackupsPagedResponse>
      listBackupsSettings() {
    return ((DataprocMetastoreStubSettings) getStubSettings()).listBackupsSettings();
  }

  /** Returns the object with the settings used for calls to getBackup. */
  public UnaryCallSettings<GetBackupRequest, Backup> getBackupSettings() {
    return ((DataprocMetastoreStubSettings) getStubSettings()).getBackupSettings();
  }

  /** Returns the object with the settings used for calls to createBackup. */
  public UnaryCallSettings<CreateBackupRequest, Operation> createBackupSettings() {
    return ((DataprocMetastoreStubSettings) getStubSettings()).createBackupSettings();
  }

  /** Returns the object with the settings used for calls to createBackup. */
  public OperationCallSettings<CreateBackupRequest, Backup, OperationMetadata>
      createBackupOperationSettings() {
    return ((DataprocMetastoreStubSettings) getStubSettings()).createBackupOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteBackup. */
  public UnaryCallSettings<DeleteBackupRequest, Operation> deleteBackupSettings() {
    return ((DataprocMetastoreStubSettings) getStubSettings()).deleteBackupSettings();
  }

  /** Returns the object with the settings used for calls to deleteBackup. */
  public OperationCallSettings<DeleteBackupRequest, Empty, OperationMetadata>
      deleteBackupOperationSettings() {
    return ((DataprocMetastoreStubSettings) getStubSettings()).deleteBackupOperationSettings();
  }

  public static final DataprocMetastoreSettings create(DataprocMetastoreStubSettings stub)
      throws IOException {
    return new DataprocMetastoreSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DataprocMetastoreStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DataprocMetastoreStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DataprocMetastoreStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DataprocMetastoreStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DataprocMetastoreStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return DataprocMetastoreStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DataprocMetastoreStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DataprocMetastoreStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected DataprocMetastoreSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DataprocMetastoreSettings. */
  public static class Builder extends ClientSettings.Builder<DataprocMetastoreSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(DataprocMetastoreStubSettings.newBuilder(clientContext));
    }

    protected Builder(DataprocMetastoreSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DataprocMetastoreStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DataprocMetastoreStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(DataprocMetastoreStubSettings.newHttpJsonBuilder());
    }

    public DataprocMetastoreStubSettings.Builder getStubSettingsBuilder() {
      return ((DataprocMetastoreStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listServices. */
    public PagedCallSettings.Builder<
            ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
        listServicesSettings() {
      return getStubSettingsBuilder().listServicesSettings();
    }

    /** Returns the builder for the settings used for calls to getService. */
    public UnaryCallSettings.Builder<GetServiceRequest, Service> getServiceSettings() {
      return getStubSettingsBuilder().getServiceSettings();
    }

    /** Returns the builder for the settings used for calls to createService. */
    public UnaryCallSettings.Builder<CreateServiceRequest, Operation> createServiceSettings() {
      return getStubSettingsBuilder().createServiceSettings();
    }

    /** Returns the builder for the settings used for calls to createService. */
    public OperationCallSettings.Builder<CreateServiceRequest, Service, OperationMetadata>
        createServiceOperationSettings() {
      return getStubSettingsBuilder().createServiceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateService. */
    public UnaryCallSettings.Builder<UpdateServiceRequest, Operation> updateServiceSettings() {
      return getStubSettingsBuilder().updateServiceSettings();
    }

    /** Returns the builder for the settings used for calls to updateService. */
    public OperationCallSettings.Builder<UpdateServiceRequest, Service, OperationMetadata>
        updateServiceOperationSettings() {
      return getStubSettingsBuilder().updateServiceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteService. */
    public UnaryCallSettings.Builder<DeleteServiceRequest, Operation> deleteServiceSettings() {
      return getStubSettingsBuilder().deleteServiceSettings();
    }

    /** Returns the builder for the settings used for calls to deleteService. */
    public OperationCallSettings.Builder<DeleteServiceRequest, Empty, OperationMetadata>
        deleteServiceOperationSettings() {
      return getStubSettingsBuilder().deleteServiceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listMetadataImports. */
    public PagedCallSettings.Builder<
            ListMetadataImportsRequest,
            ListMetadataImportsResponse,
            ListMetadataImportsPagedResponse>
        listMetadataImportsSettings() {
      return getStubSettingsBuilder().listMetadataImportsSettings();
    }

    /** Returns the builder for the settings used for calls to getMetadataImport. */
    public UnaryCallSettings.Builder<GetMetadataImportRequest, MetadataImport>
        getMetadataImportSettings() {
      return getStubSettingsBuilder().getMetadataImportSettings();
    }

    /** Returns the builder for the settings used for calls to createMetadataImport. */
    public UnaryCallSettings.Builder<CreateMetadataImportRequest, Operation>
        createMetadataImportSettings() {
      return getStubSettingsBuilder().createMetadataImportSettings();
    }

    /** Returns the builder for the settings used for calls to createMetadataImport. */
    public OperationCallSettings.Builder<
            CreateMetadataImportRequest, MetadataImport, OperationMetadata>
        createMetadataImportOperationSettings() {
      return getStubSettingsBuilder().createMetadataImportOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateMetadataImport. */
    public UnaryCallSettings.Builder<UpdateMetadataImportRequest, Operation>
        updateMetadataImportSettings() {
      return getStubSettingsBuilder().updateMetadataImportSettings();
    }

    /** Returns the builder for the settings used for calls to updateMetadataImport. */
    public OperationCallSettings.Builder<
            UpdateMetadataImportRequest, MetadataImport, OperationMetadata>
        updateMetadataImportOperationSettings() {
      return getStubSettingsBuilder().updateMetadataImportOperationSettings();
    }

    /** Returns the builder for the settings used for calls to exportMetadata. */
    public UnaryCallSettings.Builder<ExportMetadataRequest, Operation> exportMetadataSettings() {
      return getStubSettingsBuilder().exportMetadataSettings();
    }

    /** Returns the builder for the settings used for calls to exportMetadata. */
    public OperationCallSettings.Builder<ExportMetadataRequest, MetadataExport, OperationMetadata>
        exportMetadataOperationSettings() {
      return getStubSettingsBuilder().exportMetadataOperationSettings();
    }

    /** Returns the builder for the settings used for calls to restoreService. */
    public UnaryCallSettings.Builder<RestoreServiceRequest, Operation> restoreServiceSettings() {
      return getStubSettingsBuilder().restoreServiceSettings();
    }

    /** Returns the builder for the settings used for calls to restoreService. */
    public OperationCallSettings.Builder<RestoreServiceRequest, Restore, OperationMetadata>
        restoreServiceOperationSettings() {
      return getStubSettingsBuilder().restoreServiceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listBackups. */
    public PagedCallSettings.Builder<
            ListBackupsRequest, ListBackupsResponse, ListBackupsPagedResponse>
        listBackupsSettings() {
      return getStubSettingsBuilder().listBackupsSettings();
    }

    /** Returns the builder for the settings used for calls to getBackup. */
    public UnaryCallSettings.Builder<GetBackupRequest, Backup> getBackupSettings() {
      return getStubSettingsBuilder().getBackupSettings();
    }

    /** Returns the builder for the settings used for calls to createBackup. */
    public UnaryCallSettings.Builder<CreateBackupRequest, Operation> createBackupSettings() {
      return getStubSettingsBuilder().createBackupSettings();
    }

    /** Returns the builder for the settings used for calls to createBackup. */
    public OperationCallSettings.Builder<CreateBackupRequest, Backup, OperationMetadata>
        createBackupOperationSettings() {
      return getStubSettingsBuilder().createBackupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteBackup. */
    public UnaryCallSettings.Builder<DeleteBackupRequest, Operation> deleteBackupSettings() {
      return getStubSettingsBuilder().deleteBackupSettings();
    }

    /** Returns the builder for the settings used for calls to deleteBackup. */
    public OperationCallSettings.Builder<DeleteBackupRequest, Empty, OperationMetadata>
        deleteBackupOperationSettings() {
      return getStubSettingsBuilder().deleteBackupOperationSettings();
    }

    @Override
    public DataprocMetastoreSettings build() throws IOException {
      return new DataprocMetastoreSettings(this);
    }
  }
}
