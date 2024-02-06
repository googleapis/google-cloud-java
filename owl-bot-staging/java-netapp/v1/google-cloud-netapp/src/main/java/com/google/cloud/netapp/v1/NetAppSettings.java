/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.netapp.v1;

import static com.google.cloud.netapp.v1.NetAppClient.ListActiveDirectoriesPagedResponse;
import static com.google.cloud.netapp.v1.NetAppClient.ListBackupPoliciesPagedResponse;
import static com.google.cloud.netapp.v1.NetAppClient.ListBackupVaultsPagedResponse;
import static com.google.cloud.netapp.v1.NetAppClient.ListBackupsPagedResponse;
import static com.google.cloud.netapp.v1.NetAppClient.ListKmsConfigsPagedResponse;
import static com.google.cloud.netapp.v1.NetAppClient.ListLocationsPagedResponse;
import static com.google.cloud.netapp.v1.NetAppClient.ListReplicationsPagedResponse;
import static com.google.cloud.netapp.v1.NetAppClient.ListSnapshotsPagedResponse;
import static com.google.cloud.netapp.v1.NetAppClient.ListStoragePoolsPagedResponse;
import static com.google.cloud.netapp.v1.NetAppClient.ListVolumesPagedResponse;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.netapp.v1.stub.NetAppStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link NetAppClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (netapp.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getStoragePool to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * NetAppSettings.Builder netAppSettingsBuilder = NetAppSettings.newBuilder();
 * netAppSettingsBuilder
 *     .getStoragePoolSettings()
 *     .setRetrySettings(
 *         netAppSettingsBuilder
 *             .getStoragePoolSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * NetAppSettings netAppSettings = netAppSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class NetAppSettings extends ClientSettings<NetAppSettings> {

  /** Returns the object with the settings used for calls to listStoragePools. */
  public PagedCallSettings<
          ListStoragePoolsRequest, ListStoragePoolsResponse, ListStoragePoolsPagedResponse>
      listStoragePoolsSettings() {
    return ((NetAppStubSettings) getStubSettings()).listStoragePoolsSettings();
  }

  /** Returns the object with the settings used for calls to createStoragePool. */
  public UnaryCallSettings<CreateStoragePoolRequest, Operation> createStoragePoolSettings() {
    return ((NetAppStubSettings) getStubSettings()).createStoragePoolSettings();
  }

  /** Returns the object with the settings used for calls to createStoragePool. */
  public OperationCallSettings<CreateStoragePoolRequest, StoragePool, OperationMetadata>
      createStoragePoolOperationSettings() {
    return ((NetAppStubSettings) getStubSettings()).createStoragePoolOperationSettings();
  }

  /** Returns the object with the settings used for calls to getStoragePool. */
  public UnaryCallSettings<GetStoragePoolRequest, StoragePool> getStoragePoolSettings() {
    return ((NetAppStubSettings) getStubSettings()).getStoragePoolSettings();
  }

  /** Returns the object with the settings used for calls to updateStoragePool. */
  public UnaryCallSettings<UpdateStoragePoolRequest, Operation> updateStoragePoolSettings() {
    return ((NetAppStubSettings) getStubSettings()).updateStoragePoolSettings();
  }

  /** Returns the object with the settings used for calls to updateStoragePool. */
  public OperationCallSettings<UpdateStoragePoolRequest, StoragePool, OperationMetadata>
      updateStoragePoolOperationSettings() {
    return ((NetAppStubSettings) getStubSettings()).updateStoragePoolOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteStoragePool. */
  public UnaryCallSettings<DeleteStoragePoolRequest, Operation> deleteStoragePoolSettings() {
    return ((NetAppStubSettings) getStubSettings()).deleteStoragePoolSettings();
  }

  /** Returns the object with the settings used for calls to deleteStoragePool. */
  public OperationCallSettings<DeleteStoragePoolRequest, Empty, OperationMetadata>
      deleteStoragePoolOperationSettings() {
    return ((NetAppStubSettings) getStubSettings()).deleteStoragePoolOperationSettings();
  }

  /** Returns the object with the settings used for calls to listVolumes. */
  public PagedCallSettings<ListVolumesRequest, ListVolumesResponse, ListVolumesPagedResponse>
      listVolumesSettings() {
    return ((NetAppStubSettings) getStubSettings()).listVolumesSettings();
  }

  /** Returns the object with the settings used for calls to getVolume. */
  public UnaryCallSettings<GetVolumeRequest, Volume> getVolumeSettings() {
    return ((NetAppStubSettings) getStubSettings()).getVolumeSettings();
  }

  /** Returns the object with the settings used for calls to createVolume. */
  public UnaryCallSettings<CreateVolumeRequest, Operation> createVolumeSettings() {
    return ((NetAppStubSettings) getStubSettings()).createVolumeSettings();
  }

  /** Returns the object with the settings used for calls to createVolume. */
  public OperationCallSettings<CreateVolumeRequest, Volume, OperationMetadata>
      createVolumeOperationSettings() {
    return ((NetAppStubSettings) getStubSettings()).createVolumeOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateVolume. */
  public UnaryCallSettings<UpdateVolumeRequest, Operation> updateVolumeSettings() {
    return ((NetAppStubSettings) getStubSettings()).updateVolumeSettings();
  }

  /** Returns the object with the settings used for calls to updateVolume. */
  public OperationCallSettings<UpdateVolumeRequest, Volume, OperationMetadata>
      updateVolumeOperationSettings() {
    return ((NetAppStubSettings) getStubSettings()).updateVolumeOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteVolume. */
  public UnaryCallSettings<DeleteVolumeRequest, Operation> deleteVolumeSettings() {
    return ((NetAppStubSettings) getStubSettings()).deleteVolumeSettings();
  }

  /** Returns the object with the settings used for calls to deleteVolume. */
  public OperationCallSettings<DeleteVolumeRequest, Empty, OperationMetadata>
      deleteVolumeOperationSettings() {
    return ((NetAppStubSettings) getStubSettings()).deleteVolumeOperationSettings();
  }

  /** Returns the object with the settings used for calls to revertVolume. */
  public UnaryCallSettings<RevertVolumeRequest, Operation> revertVolumeSettings() {
    return ((NetAppStubSettings) getStubSettings()).revertVolumeSettings();
  }

  /** Returns the object with the settings used for calls to revertVolume. */
  public OperationCallSettings<RevertVolumeRequest, Volume, OperationMetadata>
      revertVolumeOperationSettings() {
    return ((NetAppStubSettings) getStubSettings()).revertVolumeOperationSettings();
  }

  /** Returns the object with the settings used for calls to listSnapshots. */
  public PagedCallSettings<ListSnapshotsRequest, ListSnapshotsResponse, ListSnapshotsPagedResponse>
      listSnapshotsSettings() {
    return ((NetAppStubSettings) getStubSettings()).listSnapshotsSettings();
  }

  /** Returns the object with the settings used for calls to getSnapshot. */
  public UnaryCallSettings<GetSnapshotRequest, Snapshot> getSnapshotSettings() {
    return ((NetAppStubSettings) getStubSettings()).getSnapshotSettings();
  }

  /** Returns the object with the settings used for calls to createSnapshot. */
  public UnaryCallSettings<CreateSnapshotRequest, Operation> createSnapshotSettings() {
    return ((NetAppStubSettings) getStubSettings()).createSnapshotSettings();
  }

  /** Returns the object with the settings used for calls to createSnapshot. */
  public OperationCallSettings<CreateSnapshotRequest, Snapshot, OperationMetadata>
      createSnapshotOperationSettings() {
    return ((NetAppStubSettings) getStubSettings()).createSnapshotOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteSnapshot. */
  public UnaryCallSettings<DeleteSnapshotRequest, Operation> deleteSnapshotSettings() {
    return ((NetAppStubSettings) getStubSettings()).deleteSnapshotSettings();
  }

  /** Returns the object with the settings used for calls to deleteSnapshot. */
  public OperationCallSettings<DeleteSnapshotRequest, Empty, OperationMetadata>
      deleteSnapshotOperationSettings() {
    return ((NetAppStubSettings) getStubSettings()).deleteSnapshotOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateSnapshot. */
  public UnaryCallSettings<UpdateSnapshotRequest, Operation> updateSnapshotSettings() {
    return ((NetAppStubSettings) getStubSettings()).updateSnapshotSettings();
  }

  /** Returns the object with the settings used for calls to updateSnapshot. */
  public OperationCallSettings<UpdateSnapshotRequest, Snapshot, OperationMetadata>
      updateSnapshotOperationSettings() {
    return ((NetAppStubSettings) getStubSettings()).updateSnapshotOperationSettings();
  }

  /** Returns the object with the settings used for calls to listActiveDirectories. */
  public PagedCallSettings<
          ListActiveDirectoriesRequest,
          ListActiveDirectoriesResponse,
          ListActiveDirectoriesPagedResponse>
      listActiveDirectoriesSettings() {
    return ((NetAppStubSettings) getStubSettings()).listActiveDirectoriesSettings();
  }

  /** Returns the object with the settings used for calls to getActiveDirectory. */
  public UnaryCallSettings<GetActiveDirectoryRequest, ActiveDirectory>
      getActiveDirectorySettings() {
    return ((NetAppStubSettings) getStubSettings()).getActiveDirectorySettings();
  }

  /** Returns the object with the settings used for calls to createActiveDirectory. */
  public UnaryCallSettings<CreateActiveDirectoryRequest, Operation>
      createActiveDirectorySettings() {
    return ((NetAppStubSettings) getStubSettings()).createActiveDirectorySettings();
  }

  /** Returns the object with the settings used for calls to createActiveDirectory. */
  public OperationCallSettings<CreateActiveDirectoryRequest, ActiveDirectory, OperationMetadata>
      createActiveDirectoryOperationSettings() {
    return ((NetAppStubSettings) getStubSettings()).createActiveDirectoryOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateActiveDirectory. */
  public UnaryCallSettings<UpdateActiveDirectoryRequest, Operation>
      updateActiveDirectorySettings() {
    return ((NetAppStubSettings) getStubSettings()).updateActiveDirectorySettings();
  }

  /** Returns the object with the settings used for calls to updateActiveDirectory. */
  public OperationCallSettings<UpdateActiveDirectoryRequest, ActiveDirectory, OperationMetadata>
      updateActiveDirectoryOperationSettings() {
    return ((NetAppStubSettings) getStubSettings()).updateActiveDirectoryOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteActiveDirectory. */
  public UnaryCallSettings<DeleteActiveDirectoryRequest, Operation>
      deleteActiveDirectorySettings() {
    return ((NetAppStubSettings) getStubSettings()).deleteActiveDirectorySettings();
  }

  /** Returns the object with the settings used for calls to deleteActiveDirectory. */
  public OperationCallSettings<DeleteActiveDirectoryRequest, Empty, OperationMetadata>
      deleteActiveDirectoryOperationSettings() {
    return ((NetAppStubSettings) getStubSettings()).deleteActiveDirectoryOperationSettings();
  }

  /** Returns the object with the settings used for calls to listKmsConfigs. */
  public PagedCallSettings<
          ListKmsConfigsRequest, ListKmsConfigsResponse, ListKmsConfigsPagedResponse>
      listKmsConfigsSettings() {
    return ((NetAppStubSettings) getStubSettings()).listKmsConfigsSettings();
  }

  /** Returns the object with the settings used for calls to createKmsConfig. */
  public UnaryCallSettings<CreateKmsConfigRequest, Operation> createKmsConfigSettings() {
    return ((NetAppStubSettings) getStubSettings()).createKmsConfigSettings();
  }

  /** Returns the object with the settings used for calls to createKmsConfig. */
  public OperationCallSettings<CreateKmsConfigRequest, KmsConfig, OperationMetadata>
      createKmsConfigOperationSettings() {
    return ((NetAppStubSettings) getStubSettings()).createKmsConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to getKmsConfig. */
  public UnaryCallSettings<GetKmsConfigRequest, KmsConfig> getKmsConfigSettings() {
    return ((NetAppStubSettings) getStubSettings()).getKmsConfigSettings();
  }

  /** Returns the object with the settings used for calls to updateKmsConfig. */
  public UnaryCallSettings<UpdateKmsConfigRequest, Operation> updateKmsConfigSettings() {
    return ((NetAppStubSettings) getStubSettings()).updateKmsConfigSettings();
  }

  /** Returns the object with the settings used for calls to updateKmsConfig. */
  public OperationCallSettings<UpdateKmsConfigRequest, KmsConfig, OperationMetadata>
      updateKmsConfigOperationSettings() {
    return ((NetAppStubSettings) getStubSettings()).updateKmsConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to encryptVolumes. */
  public UnaryCallSettings<EncryptVolumesRequest, Operation> encryptVolumesSettings() {
    return ((NetAppStubSettings) getStubSettings()).encryptVolumesSettings();
  }

  /** Returns the object with the settings used for calls to encryptVolumes. */
  public OperationCallSettings<EncryptVolumesRequest, KmsConfig, OperationMetadata>
      encryptVolumesOperationSettings() {
    return ((NetAppStubSettings) getStubSettings()).encryptVolumesOperationSettings();
  }

  /** Returns the object with the settings used for calls to verifyKmsConfig. */
  public UnaryCallSettings<VerifyKmsConfigRequest, VerifyKmsConfigResponse>
      verifyKmsConfigSettings() {
    return ((NetAppStubSettings) getStubSettings()).verifyKmsConfigSettings();
  }

  /** Returns the object with the settings used for calls to deleteKmsConfig. */
  public UnaryCallSettings<DeleteKmsConfigRequest, Operation> deleteKmsConfigSettings() {
    return ((NetAppStubSettings) getStubSettings()).deleteKmsConfigSettings();
  }

  /** Returns the object with the settings used for calls to deleteKmsConfig. */
  public OperationCallSettings<DeleteKmsConfigRequest, Empty, OperationMetadata>
      deleteKmsConfigOperationSettings() {
    return ((NetAppStubSettings) getStubSettings()).deleteKmsConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to listReplications. */
  public PagedCallSettings<
          ListReplicationsRequest, ListReplicationsResponse, ListReplicationsPagedResponse>
      listReplicationsSettings() {
    return ((NetAppStubSettings) getStubSettings()).listReplicationsSettings();
  }

  /** Returns the object with the settings used for calls to getReplication. */
  public UnaryCallSettings<GetReplicationRequest, Replication> getReplicationSettings() {
    return ((NetAppStubSettings) getStubSettings()).getReplicationSettings();
  }

  /** Returns the object with the settings used for calls to createReplication. */
  public UnaryCallSettings<CreateReplicationRequest, Operation> createReplicationSettings() {
    return ((NetAppStubSettings) getStubSettings()).createReplicationSettings();
  }

  /** Returns the object with the settings used for calls to createReplication. */
  public OperationCallSettings<CreateReplicationRequest, Replication, OperationMetadata>
      createReplicationOperationSettings() {
    return ((NetAppStubSettings) getStubSettings()).createReplicationOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteReplication. */
  public UnaryCallSettings<DeleteReplicationRequest, Operation> deleteReplicationSettings() {
    return ((NetAppStubSettings) getStubSettings()).deleteReplicationSettings();
  }

  /** Returns the object with the settings used for calls to deleteReplication. */
  public OperationCallSettings<DeleteReplicationRequest, Empty, OperationMetadata>
      deleteReplicationOperationSettings() {
    return ((NetAppStubSettings) getStubSettings()).deleteReplicationOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateReplication. */
  public UnaryCallSettings<UpdateReplicationRequest, Operation> updateReplicationSettings() {
    return ((NetAppStubSettings) getStubSettings()).updateReplicationSettings();
  }

  /** Returns the object with the settings used for calls to updateReplication. */
  public OperationCallSettings<UpdateReplicationRequest, Replication, OperationMetadata>
      updateReplicationOperationSettings() {
    return ((NetAppStubSettings) getStubSettings()).updateReplicationOperationSettings();
  }

  /** Returns the object with the settings used for calls to stopReplication. */
  public UnaryCallSettings<StopReplicationRequest, Operation> stopReplicationSettings() {
    return ((NetAppStubSettings) getStubSettings()).stopReplicationSettings();
  }

  /** Returns the object with the settings used for calls to stopReplication. */
  public OperationCallSettings<StopReplicationRequest, Replication, OperationMetadata>
      stopReplicationOperationSettings() {
    return ((NetAppStubSettings) getStubSettings()).stopReplicationOperationSettings();
  }

  /** Returns the object with the settings used for calls to resumeReplication. */
  public UnaryCallSettings<ResumeReplicationRequest, Operation> resumeReplicationSettings() {
    return ((NetAppStubSettings) getStubSettings()).resumeReplicationSettings();
  }

  /** Returns the object with the settings used for calls to resumeReplication. */
  public OperationCallSettings<ResumeReplicationRequest, Replication, OperationMetadata>
      resumeReplicationOperationSettings() {
    return ((NetAppStubSettings) getStubSettings()).resumeReplicationOperationSettings();
  }

  /** Returns the object with the settings used for calls to reverseReplicationDirection. */
  public UnaryCallSettings<ReverseReplicationDirectionRequest, Operation>
      reverseReplicationDirectionSettings() {
    return ((NetAppStubSettings) getStubSettings()).reverseReplicationDirectionSettings();
  }

  /** Returns the object with the settings used for calls to reverseReplicationDirection. */
  public OperationCallSettings<ReverseReplicationDirectionRequest, Replication, OperationMetadata>
      reverseReplicationDirectionOperationSettings() {
    return ((NetAppStubSettings) getStubSettings()).reverseReplicationDirectionOperationSettings();
  }

  /** Returns the object with the settings used for calls to createBackupVault. */
  public UnaryCallSettings<CreateBackupVaultRequest, Operation> createBackupVaultSettings() {
    return ((NetAppStubSettings) getStubSettings()).createBackupVaultSettings();
  }

  /** Returns the object with the settings used for calls to createBackupVault. */
  public OperationCallSettings<CreateBackupVaultRequest, BackupVault, OperationMetadata>
      createBackupVaultOperationSettings() {
    return ((NetAppStubSettings) getStubSettings()).createBackupVaultOperationSettings();
  }

  /** Returns the object with the settings used for calls to getBackupVault. */
  public UnaryCallSettings<GetBackupVaultRequest, BackupVault> getBackupVaultSettings() {
    return ((NetAppStubSettings) getStubSettings()).getBackupVaultSettings();
  }

  /** Returns the object with the settings used for calls to listBackupVaults. */
  public PagedCallSettings<
          ListBackupVaultsRequest, ListBackupVaultsResponse, ListBackupVaultsPagedResponse>
      listBackupVaultsSettings() {
    return ((NetAppStubSettings) getStubSettings()).listBackupVaultsSettings();
  }

  /** Returns the object with the settings used for calls to updateBackupVault. */
  public UnaryCallSettings<UpdateBackupVaultRequest, Operation> updateBackupVaultSettings() {
    return ((NetAppStubSettings) getStubSettings()).updateBackupVaultSettings();
  }

  /** Returns the object with the settings used for calls to updateBackupVault. */
  public OperationCallSettings<UpdateBackupVaultRequest, BackupVault, OperationMetadata>
      updateBackupVaultOperationSettings() {
    return ((NetAppStubSettings) getStubSettings()).updateBackupVaultOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteBackupVault. */
  public UnaryCallSettings<DeleteBackupVaultRequest, Operation> deleteBackupVaultSettings() {
    return ((NetAppStubSettings) getStubSettings()).deleteBackupVaultSettings();
  }

  /** Returns the object with the settings used for calls to deleteBackupVault. */
  public OperationCallSettings<DeleteBackupVaultRequest, Empty, OperationMetadata>
      deleteBackupVaultOperationSettings() {
    return ((NetAppStubSettings) getStubSettings()).deleteBackupVaultOperationSettings();
  }

  /** Returns the object with the settings used for calls to createBackup. */
  public UnaryCallSettings<CreateBackupRequest, Operation> createBackupSettings() {
    return ((NetAppStubSettings) getStubSettings()).createBackupSettings();
  }

  /** Returns the object with the settings used for calls to createBackup. */
  public OperationCallSettings<CreateBackupRequest, Backup, OperationMetadata>
      createBackupOperationSettings() {
    return ((NetAppStubSettings) getStubSettings()).createBackupOperationSettings();
  }

  /** Returns the object with the settings used for calls to getBackup. */
  public UnaryCallSettings<GetBackupRequest, Backup> getBackupSettings() {
    return ((NetAppStubSettings) getStubSettings()).getBackupSettings();
  }

  /** Returns the object with the settings used for calls to listBackups. */
  public PagedCallSettings<ListBackupsRequest, ListBackupsResponse, ListBackupsPagedResponse>
      listBackupsSettings() {
    return ((NetAppStubSettings) getStubSettings()).listBackupsSettings();
  }

  /** Returns the object with the settings used for calls to deleteBackup. */
  public UnaryCallSettings<DeleteBackupRequest, Operation> deleteBackupSettings() {
    return ((NetAppStubSettings) getStubSettings()).deleteBackupSettings();
  }

  /** Returns the object with the settings used for calls to deleteBackup. */
  public OperationCallSettings<DeleteBackupRequest, Empty, OperationMetadata>
      deleteBackupOperationSettings() {
    return ((NetAppStubSettings) getStubSettings()).deleteBackupOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateBackup. */
  public UnaryCallSettings<UpdateBackupRequest, Operation> updateBackupSettings() {
    return ((NetAppStubSettings) getStubSettings()).updateBackupSettings();
  }

  /** Returns the object with the settings used for calls to updateBackup. */
  public OperationCallSettings<UpdateBackupRequest, Backup, OperationMetadata>
      updateBackupOperationSettings() {
    return ((NetAppStubSettings) getStubSettings()).updateBackupOperationSettings();
  }

  /** Returns the object with the settings used for calls to createBackupPolicy. */
  public UnaryCallSettings<CreateBackupPolicyRequest, Operation> createBackupPolicySettings() {
    return ((NetAppStubSettings) getStubSettings()).createBackupPolicySettings();
  }

  /** Returns the object with the settings used for calls to createBackupPolicy. */
  public OperationCallSettings<CreateBackupPolicyRequest, BackupPolicy, OperationMetadata>
      createBackupPolicyOperationSettings() {
    return ((NetAppStubSettings) getStubSettings()).createBackupPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to getBackupPolicy. */
  public UnaryCallSettings<GetBackupPolicyRequest, BackupPolicy> getBackupPolicySettings() {
    return ((NetAppStubSettings) getStubSettings()).getBackupPolicySettings();
  }

  /** Returns the object with the settings used for calls to listBackupPolicies. */
  public PagedCallSettings<
          ListBackupPoliciesRequest, ListBackupPoliciesResponse, ListBackupPoliciesPagedResponse>
      listBackupPoliciesSettings() {
    return ((NetAppStubSettings) getStubSettings()).listBackupPoliciesSettings();
  }

  /** Returns the object with the settings used for calls to updateBackupPolicy. */
  public UnaryCallSettings<UpdateBackupPolicyRequest, Operation> updateBackupPolicySettings() {
    return ((NetAppStubSettings) getStubSettings()).updateBackupPolicySettings();
  }

  /** Returns the object with the settings used for calls to updateBackupPolicy. */
  public OperationCallSettings<UpdateBackupPolicyRequest, BackupPolicy, OperationMetadata>
      updateBackupPolicyOperationSettings() {
    return ((NetAppStubSettings) getStubSettings()).updateBackupPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteBackupPolicy. */
  public UnaryCallSettings<DeleteBackupPolicyRequest, Operation> deleteBackupPolicySettings() {
    return ((NetAppStubSettings) getStubSettings()).deleteBackupPolicySettings();
  }

  /** Returns the object with the settings used for calls to deleteBackupPolicy. */
  public OperationCallSettings<DeleteBackupPolicyRequest, Empty, OperationMetadata>
      deleteBackupPolicyOperationSettings() {
    return ((NetAppStubSettings) getStubSettings()).deleteBackupPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((NetAppStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((NetAppStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final NetAppSettings create(NetAppStubSettings stub) throws IOException {
    return new NetAppSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return NetAppStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return NetAppStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return NetAppStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return NetAppStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return NetAppStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return NetAppStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return NetAppStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return NetAppStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected NetAppSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for NetAppSettings. */
  public static class Builder extends ClientSettings.Builder<NetAppSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(NetAppStubSettings.newBuilder(clientContext));
    }

    protected Builder(NetAppSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(NetAppStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(NetAppStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(NetAppStubSettings.newHttpJsonBuilder());
    }

    public NetAppStubSettings.Builder getStubSettingsBuilder() {
      return ((NetAppStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listStoragePools. */
    public PagedCallSettings.Builder<
            ListStoragePoolsRequest, ListStoragePoolsResponse, ListStoragePoolsPagedResponse>
        listStoragePoolsSettings() {
      return getStubSettingsBuilder().listStoragePoolsSettings();
    }

    /** Returns the builder for the settings used for calls to createStoragePool. */
    public UnaryCallSettings.Builder<CreateStoragePoolRequest, Operation>
        createStoragePoolSettings() {
      return getStubSettingsBuilder().createStoragePoolSettings();
    }

    /** Returns the builder for the settings used for calls to createStoragePool. */
    public OperationCallSettings.Builder<CreateStoragePoolRequest, StoragePool, OperationMetadata>
        createStoragePoolOperationSettings() {
      return getStubSettingsBuilder().createStoragePoolOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getStoragePool. */
    public UnaryCallSettings.Builder<GetStoragePoolRequest, StoragePool> getStoragePoolSettings() {
      return getStubSettingsBuilder().getStoragePoolSettings();
    }

    /** Returns the builder for the settings used for calls to updateStoragePool. */
    public UnaryCallSettings.Builder<UpdateStoragePoolRequest, Operation>
        updateStoragePoolSettings() {
      return getStubSettingsBuilder().updateStoragePoolSettings();
    }

    /** Returns the builder for the settings used for calls to updateStoragePool. */
    public OperationCallSettings.Builder<UpdateStoragePoolRequest, StoragePool, OperationMetadata>
        updateStoragePoolOperationSettings() {
      return getStubSettingsBuilder().updateStoragePoolOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteStoragePool. */
    public UnaryCallSettings.Builder<DeleteStoragePoolRequest, Operation>
        deleteStoragePoolSettings() {
      return getStubSettingsBuilder().deleteStoragePoolSettings();
    }

    /** Returns the builder for the settings used for calls to deleteStoragePool. */
    public OperationCallSettings.Builder<DeleteStoragePoolRequest, Empty, OperationMetadata>
        deleteStoragePoolOperationSettings() {
      return getStubSettingsBuilder().deleteStoragePoolOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listVolumes. */
    public PagedCallSettings.Builder<
            ListVolumesRequest, ListVolumesResponse, ListVolumesPagedResponse>
        listVolumesSettings() {
      return getStubSettingsBuilder().listVolumesSettings();
    }

    /** Returns the builder for the settings used for calls to getVolume. */
    public UnaryCallSettings.Builder<GetVolumeRequest, Volume> getVolumeSettings() {
      return getStubSettingsBuilder().getVolumeSettings();
    }

    /** Returns the builder for the settings used for calls to createVolume. */
    public UnaryCallSettings.Builder<CreateVolumeRequest, Operation> createVolumeSettings() {
      return getStubSettingsBuilder().createVolumeSettings();
    }

    /** Returns the builder for the settings used for calls to createVolume. */
    public OperationCallSettings.Builder<CreateVolumeRequest, Volume, OperationMetadata>
        createVolumeOperationSettings() {
      return getStubSettingsBuilder().createVolumeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateVolume. */
    public UnaryCallSettings.Builder<UpdateVolumeRequest, Operation> updateVolumeSettings() {
      return getStubSettingsBuilder().updateVolumeSettings();
    }

    /** Returns the builder for the settings used for calls to updateVolume. */
    public OperationCallSettings.Builder<UpdateVolumeRequest, Volume, OperationMetadata>
        updateVolumeOperationSettings() {
      return getStubSettingsBuilder().updateVolumeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteVolume. */
    public UnaryCallSettings.Builder<DeleteVolumeRequest, Operation> deleteVolumeSettings() {
      return getStubSettingsBuilder().deleteVolumeSettings();
    }

    /** Returns the builder for the settings used for calls to deleteVolume. */
    public OperationCallSettings.Builder<DeleteVolumeRequest, Empty, OperationMetadata>
        deleteVolumeOperationSettings() {
      return getStubSettingsBuilder().deleteVolumeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to revertVolume. */
    public UnaryCallSettings.Builder<RevertVolumeRequest, Operation> revertVolumeSettings() {
      return getStubSettingsBuilder().revertVolumeSettings();
    }

    /** Returns the builder for the settings used for calls to revertVolume. */
    public OperationCallSettings.Builder<RevertVolumeRequest, Volume, OperationMetadata>
        revertVolumeOperationSettings() {
      return getStubSettingsBuilder().revertVolumeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listSnapshots. */
    public PagedCallSettings.Builder<
            ListSnapshotsRequest, ListSnapshotsResponse, ListSnapshotsPagedResponse>
        listSnapshotsSettings() {
      return getStubSettingsBuilder().listSnapshotsSettings();
    }

    /** Returns the builder for the settings used for calls to getSnapshot. */
    public UnaryCallSettings.Builder<GetSnapshotRequest, Snapshot> getSnapshotSettings() {
      return getStubSettingsBuilder().getSnapshotSettings();
    }

    /** Returns the builder for the settings used for calls to createSnapshot. */
    public UnaryCallSettings.Builder<CreateSnapshotRequest, Operation> createSnapshotSettings() {
      return getStubSettingsBuilder().createSnapshotSettings();
    }

    /** Returns the builder for the settings used for calls to createSnapshot. */
    public OperationCallSettings.Builder<CreateSnapshotRequest, Snapshot, OperationMetadata>
        createSnapshotOperationSettings() {
      return getStubSettingsBuilder().createSnapshotOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSnapshot. */
    public UnaryCallSettings.Builder<DeleteSnapshotRequest, Operation> deleteSnapshotSettings() {
      return getStubSettingsBuilder().deleteSnapshotSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSnapshot. */
    public OperationCallSettings.Builder<DeleteSnapshotRequest, Empty, OperationMetadata>
        deleteSnapshotOperationSettings() {
      return getStubSettingsBuilder().deleteSnapshotOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateSnapshot. */
    public UnaryCallSettings.Builder<UpdateSnapshotRequest, Operation> updateSnapshotSettings() {
      return getStubSettingsBuilder().updateSnapshotSettings();
    }

    /** Returns the builder for the settings used for calls to updateSnapshot. */
    public OperationCallSettings.Builder<UpdateSnapshotRequest, Snapshot, OperationMetadata>
        updateSnapshotOperationSettings() {
      return getStubSettingsBuilder().updateSnapshotOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listActiveDirectories. */
    public PagedCallSettings.Builder<
            ListActiveDirectoriesRequest,
            ListActiveDirectoriesResponse,
            ListActiveDirectoriesPagedResponse>
        listActiveDirectoriesSettings() {
      return getStubSettingsBuilder().listActiveDirectoriesSettings();
    }

    /** Returns the builder for the settings used for calls to getActiveDirectory. */
    public UnaryCallSettings.Builder<GetActiveDirectoryRequest, ActiveDirectory>
        getActiveDirectorySettings() {
      return getStubSettingsBuilder().getActiveDirectorySettings();
    }

    /** Returns the builder for the settings used for calls to createActiveDirectory. */
    public UnaryCallSettings.Builder<CreateActiveDirectoryRequest, Operation>
        createActiveDirectorySettings() {
      return getStubSettingsBuilder().createActiveDirectorySettings();
    }

    /** Returns the builder for the settings used for calls to createActiveDirectory. */
    public OperationCallSettings.Builder<
            CreateActiveDirectoryRequest, ActiveDirectory, OperationMetadata>
        createActiveDirectoryOperationSettings() {
      return getStubSettingsBuilder().createActiveDirectoryOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateActiveDirectory. */
    public UnaryCallSettings.Builder<UpdateActiveDirectoryRequest, Operation>
        updateActiveDirectorySettings() {
      return getStubSettingsBuilder().updateActiveDirectorySettings();
    }

    /** Returns the builder for the settings used for calls to updateActiveDirectory. */
    public OperationCallSettings.Builder<
            UpdateActiveDirectoryRequest, ActiveDirectory, OperationMetadata>
        updateActiveDirectoryOperationSettings() {
      return getStubSettingsBuilder().updateActiveDirectoryOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteActiveDirectory. */
    public UnaryCallSettings.Builder<DeleteActiveDirectoryRequest, Operation>
        deleteActiveDirectorySettings() {
      return getStubSettingsBuilder().deleteActiveDirectorySettings();
    }

    /** Returns the builder for the settings used for calls to deleteActiveDirectory. */
    public OperationCallSettings.Builder<DeleteActiveDirectoryRequest, Empty, OperationMetadata>
        deleteActiveDirectoryOperationSettings() {
      return getStubSettingsBuilder().deleteActiveDirectoryOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listKmsConfigs. */
    public PagedCallSettings.Builder<
            ListKmsConfigsRequest, ListKmsConfigsResponse, ListKmsConfigsPagedResponse>
        listKmsConfigsSettings() {
      return getStubSettingsBuilder().listKmsConfigsSettings();
    }

    /** Returns the builder for the settings used for calls to createKmsConfig. */
    public UnaryCallSettings.Builder<CreateKmsConfigRequest, Operation> createKmsConfigSettings() {
      return getStubSettingsBuilder().createKmsConfigSettings();
    }

    /** Returns the builder for the settings used for calls to createKmsConfig. */
    public OperationCallSettings.Builder<CreateKmsConfigRequest, KmsConfig, OperationMetadata>
        createKmsConfigOperationSettings() {
      return getStubSettingsBuilder().createKmsConfigOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getKmsConfig. */
    public UnaryCallSettings.Builder<GetKmsConfigRequest, KmsConfig> getKmsConfigSettings() {
      return getStubSettingsBuilder().getKmsConfigSettings();
    }

    /** Returns the builder for the settings used for calls to updateKmsConfig. */
    public UnaryCallSettings.Builder<UpdateKmsConfigRequest, Operation> updateKmsConfigSettings() {
      return getStubSettingsBuilder().updateKmsConfigSettings();
    }

    /** Returns the builder for the settings used for calls to updateKmsConfig. */
    public OperationCallSettings.Builder<UpdateKmsConfigRequest, KmsConfig, OperationMetadata>
        updateKmsConfigOperationSettings() {
      return getStubSettingsBuilder().updateKmsConfigOperationSettings();
    }

    /** Returns the builder for the settings used for calls to encryptVolumes. */
    public UnaryCallSettings.Builder<EncryptVolumesRequest, Operation> encryptVolumesSettings() {
      return getStubSettingsBuilder().encryptVolumesSettings();
    }

    /** Returns the builder for the settings used for calls to encryptVolumes. */
    public OperationCallSettings.Builder<EncryptVolumesRequest, KmsConfig, OperationMetadata>
        encryptVolumesOperationSettings() {
      return getStubSettingsBuilder().encryptVolumesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to verifyKmsConfig. */
    public UnaryCallSettings.Builder<VerifyKmsConfigRequest, VerifyKmsConfigResponse>
        verifyKmsConfigSettings() {
      return getStubSettingsBuilder().verifyKmsConfigSettings();
    }

    /** Returns the builder for the settings used for calls to deleteKmsConfig. */
    public UnaryCallSettings.Builder<DeleteKmsConfigRequest, Operation> deleteKmsConfigSettings() {
      return getStubSettingsBuilder().deleteKmsConfigSettings();
    }

    /** Returns the builder for the settings used for calls to deleteKmsConfig. */
    public OperationCallSettings.Builder<DeleteKmsConfigRequest, Empty, OperationMetadata>
        deleteKmsConfigOperationSettings() {
      return getStubSettingsBuilder().deleteKmsConfigOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listReplications. */
    public PagedCallSettings.Builder<
            ListReplicationsRequest, ListReplicationsResponse, ListReplicationsPagedResponse>
        listReplicationsSettings() {
      return getStubSettingsBuilder().listReplicationsSettings();
    }

    /** Returns the builder for the settings used for calls to getReplication. */
    public UnaryCallSettings.Builder<GetReplicationRequest, Replication> getReplicationSettings() {
      return getStubSettingsBuilder().getReplicationSettings();
    }

    /** Returns the builder for the settings used for calls to createReplication. */
    public UnaryCallSettings.Builder<CreateReplicationRequest, Operation>
        createReplicationSettings() {
      return getStubSettingsBuilder().createReplicationSettings();
    }

    /** Returns the builder for the settings used for calls to createReplication. */
    public OperationCallSettings.Builder<CreateReplicationRequest, Replication, OperationMetadata>
        createReplicationOperationSettings() {
      return getStubSettingsBuilder().createReplicationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteReplication. */
    public UnaryCallSettings.Builder<DeleteReplicationRequest, Operation>
        deleteReplicationSettings() {
      return getStubSettingsBuilder().deleteReplicationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteReplication. */
    public OperationCallSettings.Builder<DeleteReplicationRequest, Empty, OperationMetadata>
        deleteReplicationOperationSettings() {
      return getStubSettingsBuilder().deleteReplicationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateReplication. */
    public UnaryCallSettings.Builder<UpdateReplicationRequest, Operation>
        updateReplicationSettings() {
      return getStubSettingsBuilder().updateReplicationSettings();
    }

    /** Returns the builder for the settings used for calls to updateReplication. */
    public OperationCallSettings.Builder<UpdateReplicationRequest, Replication, OperationMetadata>
        updateReplicationOperationSettings() {
      return getStubSettingsBuilder().updateReplicationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to stopReplication. */
    public UnaryCallSettings.Builder<StopReplicationRequest, Operation> stopReplicationSettings() {
      return getStubSettingsBuilder().stopReplicationSettings();
    }

    /** Returns the builder for the settings used for calls to stopReplication. */
    public OperationCallSettings.Builder<StopReplicationRequest, Replication, OperationMetadata>
        stopReplicationOperationSettings() {
      return getStubSettingsBuilder().stopReplicationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to resumeReplication. */
    public UnaryCallSettings.Builder<ResumeReplicationRequest, Operation>
        resumeReplicationSettings() {
      return getStubSettingsBuilder().resumeReplicationSettings();
    }

    /** Returns the builder for the settings used for calls to resumeReplication. */
    public OperationCallSettings.Builder<ResumeReplicationRequest, Replication, OperationMetadata>
        resumeReplicationOperationSettings() {
      return getStubSettingsBuilder().resumeReplicationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to reverseReplicationDirection. */
    public UnaryCallSettings.Builder<ReverseReplicationDirectionRequest, Operation>
        reverseReplicationDirectionSettings() {
      return getStubSettingsBuilder().reverseReplicationDirectionSettings();
    }

    /** Returns the builder for the settings used for calls to reverseReplicationDirection. */
    public OperationCallSettings.Builder<
            ReverseReplicationDirectionRequest, Replication, OperationMetadata>
        reverseReplicationDirectionOperationSettings() {
      return getStubSettingsBuilder().reverseReplicationDirectionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createBackupVault. */
    public UnaryCallSettings.Builder<CreateBackupVaultRequest, Operation>
        createBackupVaultSettings() {
      return getStubSettingsBuilder().createBackupVaultSettings();
    }

    /** Returns the builder for the settings used for calls to createBackupVault. */
    public OperationCallSettings.Builder<CreateBackupVaultRequest, BackupVault, OperationMetadata>
        createBackupVaultOperationSettings() {
      return getStubSettingsBuilder().createBackupVaultOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getBackupVault. */
    public UnaryCallSettings.Builder<GetBackupVaultRequest, BackupVault> getBackupVaultSettings() {
      return getStubSettingsBuilder().getBackupVaultSettings();
    }

    /** Returns the builder for the settings used for calls to listBackupVaults. */
    public PagedCallSettings.Builder<
            ListBackupVaultsRequest, ListBackupVaultsResponse, ListBackupVaultsPagedResponse>
        listBackupVaultsSettings() {
      return getStubSettingsBuilder().listBackupVaultsSettings();
    }

    /** Returns the builder for the settings used for calls to updateBackupVault. */
    public UnaryCallSettings.Builder<UpdateBackupVaultRequest, Operation>
        updateBackupVaultSettings() {
      return getStubSettingsBuilder().updateBackupVaultSettings();
    }

    /** Returns the builder for the settings used for calls to updateBackupVault. */
    public OperationCallSettings.Builder<UpdateBackupVaultRequest, BackupVault, OperationMetadata>
        updateBackupVaultOperationSettings() {
      return getStubSettingsBuilder().updateBackupVaultOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteBackupVault. */
    public UnaryCallSettings.Builder<DeleteBackupVaultRequest, Operation>
        deleteBackupVaultSettings() {
      return getStubSettingsBuilder().deleteBackupVaultSettings();
    }

    /** Returns the builder for the settings used for calls to deleteBackupVault. */
    public OperationCallSettings.Builder<DeleteBackupVaultRequest, Empty, OperationMetadata>
        deleteBackupVaultOperationSettings() {
      return getStubSettingsBuilder().deleteBackupVaultOperationSettings();
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

    /** Returns the builder for the settings used for calls to getBackup. */
    public UnaryCallSettings.Builder<GetBackupRequest, Backup> getBackupSettings() {
      return getStubSettingsBuilder().getBackupSettings();
    }

    /** Returns the builder for the settings used for calls to listBackups. */
    public PagedCallSettings.Builder<
            ListBackupsRequest, ListBackupsResponse, ListBackupsPagedResponse>
        listBackupsSettings() {
      return getStubSettingsBuilder().listBackupsSettings();
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

    /** Returns the builder for the settings used for calls to updateBackup. */
    public UnaryCallSettings.Builder<UpdateBackupRequest, Operation> updateBackupSettings() {
      return getStubSettingsBuilder().updateBackupSettings();
    }

    /** Returns the builder for the settings used for calls to updateBackup. */
    public OperationCallSettings.Builder<UpdateBackupRequest, Backup, OperationMetadata>
        updateBackupOperationSettings() {
      return getStubSettingsBuilder().updateBackupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createBackupPolicy. */
    public UnaryCallSettings.Builder<CreateBackupPolicyRequest, Operation>
        createBackupPolicySettings() {
      return getStubSettingsBuilder().createBackupPolicySettings();
    }

    /** Returns the builder for the settings used for calls to createBackupPolicy. */
    public OperationCallSettings.Builder<CreateBackupPolicyRequest, BackupPolicy, OperationMetadata>
        createBackupPolicyOperationSettings() {
      return getStubSettingsBuilder().createBackupPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getBackupPolicy. */
    public UnaryCallSettings.Builder<GetBackupPolicyRequest, BackupPolicy>
        getBackupPolicySettings() {
      return getStubSettingsBuilder().getBackupPolicySettings();
    }

    /** Returns the builder for the settings used for calls to listBackupPolicies. */
    public PagedCallSettings.Builder<
            ListBackupPoliciesRequest, ListBackupPoliciesResponse, ListBackupPoliciesPagedResponse>
        listBackupPoliciesSettings() {
      return getStubSettingsBuilder().listBackupPoliciesSettings();
    }

    /** Returns the builder for the settings used for calls to updateBackupPolicy. */
    public UnaryCallSettings.Builder<UpdateBackupPolicyRequest, Operation>
        updateBackupPolicySettings() {
      return getStubSettingsBuilder().updateBackupPolicySettings();
    }

    /** Returns the builder for the settings used for calls to updateBackupPolicy. */
    public OperationCallSettings.Builder<UpdateBackupPolicyRequest, BackupPolicy, OperationMetadata>
        updateBackupPolicyOperationSettings() {
      return getStubSettingsBuilder().updateBackupPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteBackupPolicy. */
    public UnaryCallSettings.Builder<DeleteBackupPolicyRequest, Operation>
        deleteBackupPolicySettings() {
      return getStubSettingsBuilder().deleteBackupPolicySettings();
    }

    /** Returns the builder for the settings used for calls to deleteBackupPolicy. */
    public OperationCallSettings.Builder<DeleteBackupPolicyRequest, Empty, OperationMetadata>
        deleteBackupPolicyOperationSettings() {
      return getStubSettingsBuilder().deleteBackupPolicyOperationSettings();
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
    public NetAppSettings build() throws IOException {
      return new NetAppSettings(this);
    }
  }
}
