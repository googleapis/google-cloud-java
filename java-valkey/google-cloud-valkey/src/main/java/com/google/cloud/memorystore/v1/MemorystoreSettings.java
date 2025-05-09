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

package com.google.cloud.memorystore.v1;

import static com.google.cloud.memorystore.v1.MemorystoreClient.ListBackupCollectionsPagedResponse;
import static com.google.cloud.memorystore.v1.MemorystoreClient.ListBackupsPagedResponse;
import static com.google.cloud.memorystore.v1.MemorystoreClient.ListInstancesPagedResponse;
import static com.google.cloud.memorystore.v1.MemorystoreClient.ListLocationsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
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
import com.google.cloud.memorystore.v1.stub.MemorystoreStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link MemorystoreClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (memorystore.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getInstance:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MemorystoreSettings.Builder memorystoreSettingsBuilder = MemorystoreSettings.newBuilder();
 * memorystoreSettingsBuilder
 *     .getInstanceSettings()
 *     .setRetrySettings(
 *         memorystoreSettingsBuilder
 *             .getInstanceSettings()
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
 * MemorystoreSettings memorystoreSettings = memorystoreSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createInstance:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MemorystoreSettings.Builder memorystoreSettingsBuilder = MemorystoreSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * memorystoreSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class MemorystoreSettings extends ClientSettings<MemorystoreSettings> {

  /** Returns the object with the settings used for calls to listInstances. */
  public PagedCallSettings<ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
      listInstancesSettings() {
    return ((MemorystoreStubSettings) getStubSettings()).listInstancesSettings();
  }

  /** Returns the object with the settings used for calls to getInstance. */
  public UnaryCallSettings<GetInstanceRequest, Instance> getInstanceSettings() {
    return ((MemorystoreStubSettings) getStubSettings()).getInstanceSettings();
  }

  /** Returns the object with the settings used for calls to createInstance. */
  public UnaryCallSettings<CreateInstanceRequest, Operation> createInstanceSettings() {
    return ((MemorystoreStubSettings) getStubSettings()).createInstanceSettings();
  }

  /** Returns the object with the settings used for calls to createInstance. */
  public OperationCallSettings<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationSettings() {
    return ((MemorystoreStubSettings) getStubSettings()).createInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateInstance. */
  public UnaryCallSettings<UpdateInstanceRequest, Operation> updateInstanceSettings() {
    return ((MemorystoreStubSettings) getStubSettings()).updateInstanceSettings();
  }

  /** Returns the object with the settings used for calls to updateInstance. */
  public OperationCallSettings<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationSettings() {
    return ((MemorystoreStubSettings) getStubSettings()).updateInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteInstance. */
  public UnaryCallSettings<DeleteInstanceRequest, Operation> deleteInstanceSettings() {
    return ((MemorystoreStubSettings) getStubSettings()).deleteInstanceSettings();
  }

  /** Returns the object with the settings used for calls to deleteInstance. */
  public OperationCallSettings<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationSettings() {
    return ((MemorystoreStubSettings) getStubSettings()).deleteInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to getCertificateAuthority. */
  public UnaryCallSettings<GetCertificateAuthorityRequest, CertificateAuthority>
      getCertificateAuthoritySettings() {
    return ((MemorystoreStubSettings) getStubSettings()).getCertificateAuthoritySettings();
  }

  /** Returns the object with the settings used for calls to rescheduleMaintenance. */
  public UnaryCallSettings<RescheduleMaintenanceRequest, Operation>
      rescheduleMaintenanceSettings() {
    return ((MemorystoreStubSettings) getStubSettings()).rescheduleMaintenanceSettings();
  }

  /** Returns the object with the settings used for calls to rescheduleMaintenance. */
  public OperationCallSettings<RescheduleMaintenanceRequest, Instance, OperationMetadata>
      rescheduleMaintenanceOperationSettings() {
    return ((MemorystoreStubSettings) getStubSettings()).rescheduleMaintenanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to listBackupCollections. */
  public PagedCallSettings<
          ListBackupCollectionsRequest,
          ListBackupCollectionsResponse,
          ListBackupCollectionsPagedResponse>
      listBackupCollectionsSettings() {
    return ((MemorystoreStubSettings) getStubSettings()).listBackupCollectionsSettings();
  }

  /** Returns the object with the settings used for calls to getBackupCollection. */
  public UnaryCallSettings<GetBackupCollectionRequest, BackupCollection>
      getBackupCollectionSettings() {
    return ((MemorystoreStubSettings) getStubSettings()).getBackupCollectionSettings();
  }

  /** Returns the object with the settings used for calls to listBackups. */
  public PagedCallSettings<ListBackupsRequest, ListBackupsResponse, ListBackupsPagedResponse>
      listBackupsSettings() {
    return ((MemorystoreStubSettings) getStubSettings()).listBackupsSettings();
  }

  /** Returns the object with the settings used for calls to getBackup. */
  public UnaryCallSettings<GetBackupRequest, Backup> getBackupSettings() {
    return ((MemorystoreStubSettings) getStubSettings()).getBackupSettings();
  }

  /** Returns the object with the settings used for calls to deleteBackup. */
  public UnaryCallSettings<DeleteBackupRequest, Operation> deleteBackupSettings() {
    return ((MemorystoreStubSettings) getStubSettings()).deleteBackupSettings();
  }

  /** Returns the object with the settings used for calls to deleteBackup. */
  public OperationCallSettings<DeleteBackupRequest, Empty, OperationMetadata>
      deleteBackupOperationSettings() {
    return ((MemorystoreStubSettings) getStubSettings()).deleteBackupOperationSettings();
  }

  /** Returns the object with the settings used for calls to exportBackup. */
  public UnaryCallSettings<ExportBackupRequest, Operation> exportBackupSettings() {
    return ((MemorystoreStubSettings) getStubSettings()).exportBackupSettings();
  }

  /** Returns the object with the settings used for calls to exportBackup. */
  public OperationCallSettings<ExportBackupRequest, Backup, OperationMetadata>
      exportBackupOperationSettings() {
    return ((MemorystoreStubSettings) getStubSettings()).exportBackupOperationSettings();
  }

  /** Returns the object with the settings used for calls to backupInstance. */
  public UnaryCallSettings<BackupInstanceRequest, Operation> backupInstanceSettings() {
    return ((MemorystoreStubSettings) getStubSettings()).backupInstanceSettings();
  }

  /** Returns the object with the settings used for calls to backupInstance. */
  public OperationCallSettings<BackupInstanceRequest, Instance, OperationMetadata>
      backupInstanceOperationSettings() {
    return ((MemorystoreStubSettings) getStubSettings()).backupInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((MemorystoreStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((MemorystoreStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final MemorystoreSettings create(MemorystoreStubSettings stub) throws IOException {
    return new MemorystoreSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return MemorystoreStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return MemorystoreStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return MemorystoreStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return MemorystoreStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return MemorystoreStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return MemorystoreStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return MemorystoreStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected MemorystoreSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for MemorystoreSettings. */
  public static class Builder extends ClientSettings.Builder<MemorystoreSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(MemorystoreStubSettings.newBuilder(clientContext));
    }

    protected Builder(MemorystoreSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(MemorystoreStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(MemorystoreStubSettings.newBuilder());
    }

    public MemorystoreStubSettings.Builder getStubSettingsBuilder() {
      return ((MemorystoreStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listInstances. */
    public PagedCallSettings.Builder<
            ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
        listInstancesSettings() {
      return getStubSettingsBuilder().listInstancesSettings();
    }

    /** Returns the builder for the settings used for calls to getInstance. */
    public UnaryCallSettings.Builder<GetInstanceRequest, Instance> getInstanceSettings() {
      return getStubSettingsBuilder().getInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to createInstance. */
    public UnaryCallSettings.Builder<CreateInstanceRequest, Operation> createInstanceSettings() {
      return getStubSettingsBuilder().createInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to createInstance. */
    public OperationCallSettings.Builder<CreateInstanceRequest, Instance, OperationMetadata>
        createInstanceOperationSettings() {
      return getStubSettingsBuilder().createInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateInstance. */
    public UnaryCallSettings.Builder<UpdateInstanceRequest, Operation> updateInstanceSettings() {
      return getStubSettingsBuilder().updateInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to updateInstance. */
    public OperationCallSettings.Builder<UpdateInstanceRequest, Instance, OperationMetadata>
        updateInstanceOperationSettings() {
      return getStubSettingsBuilder().updateInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteInstance. */
    public UnaryCallSettings.Builder<DeleteInstanceRequest, Operation> deleteInstanceSettings() {
      return getStubSettingsBuilder().deleteInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to deleteInstance. */
    public OperationCallSettings.Builder<DeleteInstanceRequest, Empty, OperationMetadata>
        deleteInstanceOperationSettings() {
      return getStubSettingsBuilder().deleteInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getCertificateAuthority. */
    public UnaryCallSettings.Builder<GetCertificateAuthorityRequest, CertificateAuthority>
        getCertificateAuthoritySettings() {
      return getStubSettingsBuilder().getCertificateAuthoritySettings();
    }

    /** Returns the builder for the settings used for calls to rescheduleMaintenance. */
    public UnaryCallSettings.Builder<RescheduleMaintenanceRequest, Operation>
        rescheduleMaintenanceSettings() {
      return getStubSettingsBuilder().rescheduleMaintenanceSettings();
    }

    /** Returns the builder for the settings used for calls to rescheduleMaintenance. */
    public OperationCallSettings.Builder<RescheduleMaintenanceRequest, Instance, OperationMetadata>
        rescheduleMaintenanceOperationSettings() {
      return getStubSettingsBuilder().rescheduleMaintenanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listBackupCollections. */
    public PagedCallSettings.Builder<
            ListBackupCollectionsRequest,
            ListBackupCollectionsResponse,
            ListBackupCollectionsPagedResponse>
        listBackupCollectionsSettings() {
      return getStubSettingsBuilder().listBackupCollectionsSettings();
    }

    /** Returns the builder for the settings used for calls to getBackupCollection. */
    public UnaryCallSettings.Builder<GetBackupCollectionRequest, BackupCollection>
        getBackupCollectionSettings() {
      return getStubSettingsBuilder().getBackupCollectionSettings();
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

    /** Returns the builder for the settings used for calls to deleteBackup. */
    public UnaryCallSettings.Builder<DeleteBackupRequest, Operation> deleteBackupSettings() {
      return getStubSettingsBuilder().deleteBackupSettings();
    }

    /** Returns the builder for the settings used for calls to deleteBackup. */
    public OperationCallSettings.Builder<DeleteBackupRequest, Empty, OperationMetadata>
        deleteBackupOperationSettings() {
      return getStubSettingsBuilder().deleteBackupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to exportBackup. */
    public UnaryCallSettings.Builder<ExportBackupRequest, Operation> exportBackupSettings() {
      return getStubSettingsBuilder().exportBackupSettings();
    }

    /** Returns the builder for the settings used for calls to exportBackup. */
    public OperationCallSettings.Builder<ExportBackupRequest, Backup, OperationMetadata>
        exportBackupOperationSettings() {
      return getStubSettingsBuilder().exportBackupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to backupInstance. */
    public UnaryCallSettings.Builder<BackupInstanceRequest, Operation> backupInstanceSettings() {
      return getStubSettingsBuilder().backupInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to backupInstance. */
    public OperationCallSettings.Builder<BackupInstanceRequest, Instance, OperationMetadata>
        backupInstanceOperationSettings() {
      return getStubSettingsBuilder().backupInstanceOperationSettings();
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
    public MemorystoreSettings build() throws IOException {
      return new MemorystoreSettings(this);
    }
  }
}
