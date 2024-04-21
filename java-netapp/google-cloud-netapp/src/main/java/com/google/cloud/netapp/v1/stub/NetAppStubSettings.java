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

package com.google.cloud.netapp.v1.stub;

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
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.netapp.v1.ActiveDirectory;
import com.google.cloud.netapp.v1.Backup;
import com.google.cloud.netapp.v1.BackupPolicy;
import com.google.cloud.netapp.v1.BackupVault;
import com.google.cloud.netapp.v1.CreateActiveDirectoryRequest;
import com.google.cloud.netapp.v1.CreateBackupPolicyRequest;
import com.google.cloud.netapp.v1.CreateBackupRequest;
import com.google.cloud.netapp.v1.CreateBackupVaultRequest;
import com.google.cloud.netapp.v1.CreateKmsConfigRequest;
import com.google.cloud.netapp.v1.CreateReplicationRequest;
import com.google.cloud.netapp.v1.CreateSnapshotRequest;
import com.google.cloud.netapp.v1.CreateStoragePoolRequest;
import com.google.cloud.netapp.v1.CreateVolumeRequest;
import com.google.cloud.netapp.v1.DeleteActiveDirectoryRequest;
import com.google.cloud.netapp.v1.DeleteBackupPolicyRequest;
import com.google.cloud.netapp.v1.DeleteBackupRequest;
import com.google.cloud.netapp.v1.DeleteBackupVaultRequest;
import com.google.cloud.netapp.v1.DeleteKmsConfigRequest;
import com.google.cloud.netapp.v1.DeleteReplicationRequest;
import com.google.cloud.netapp.v1.DeleteSnapshotRequest;
import com.google.cloud.netapp.v1.DeleteStoragePoolRequest;
import com.google.cloud.netapp.v1.DeleteVolumeRequest;
import com.google.cloud.netapp.v1.EncryptVolumesRequest;
import com.google.cloud.netapp.v1.GetActiveDirectoryRequest;
import com.google.cloud.netapp.v1.GetBackupPolicyRequest;
import com.google.cloud.netapp.v1.GetBackupRequest;
import com.google.cloud.netapp.v1.GetBackupVaultRequest;
import com.google.cloud.netapp.v1.GetKmsConfigRequest;
import com.google.cloud.netapp.v1.GetReplicationRequest;
import com.google.cloud.netapp.v1.GetSnapshotRequest;
import com.google.cloud.netapp.v1.GetStoragePoolRequest;
import com.google.cloud.netapp.v1.GetVolumeRequest;
import com.google.cloud.netapp.v1.KmsConfig;
import com.google.cloud.netapp.v1.ListActiveDirectoriesRequest;
import com.google.cloud.netapp.v1.ListActiveDirectoriesResponse;
import com.google.cloud.netapp.v1.ListBackupPoliciesRequest;
import com.google.cloud.netapp.v1.ListBackupPoliciesResponse;
import com.google.cloud.netapp.v1.ListBackupVaultsRequest;
import com.google.cloud.netapp.v1.ListBackupVaultsResponse;
import com.google.cloud.netapp.v1.ListBackupsRequest;
import com.google.cloud.netapp.v1.ListBackupsResponse;
import com.google.cloud.netapp.v1.ListKmsConfigsRequest;
import com.google.cloud.netapp.v1.ListKmsConfigsResponse;
import com.google.cloud.netapp.v1.ListReplicationsRequest;
import com.google.cloud.netapp.v1.ListReplicationsResponse;
import com.google.cloud.netapp.v1.ListSnapshotsRequest;
import com.google.cloud.netapp.v1.ListSnapshotsResponse;
import com.google.cloud.netapp.v1.ListStoragePoolsRequest;
import com.google.cloud.netapp.v1.ListStoragePoolsResponse;
import com.google.cloud.netapp.v1.ListVolumesRequest;
import com.google.cloud.netapp.v1.ListVolumesResponse;
import com.google.cloud.netapp.v1.OperationMetadata;
import com.google.cloud.netapp.v1.Replication;
import com.google.cloud.netapp.v1.ResumeReplicationRequest;
import com.google.cloud.netapp.v1.ReverseReplicationDirectionRequest;
import com.google.cloud.netapp.v1.RevertVolumeRequest;
import com.google.cloud.netapp.v1.Snapshot;
import com.google.cloud.netapp.v1.StopReplicationRequest;
import com.google.cloud.netapp.v1.StoragePool;
import com.google.cloud.netapp.v1.UpdateActiveDirectoryRequest;
import com.google.cloud.netapp.v1.UpdateBackupPolicyRequest;
import com.google.cloud.netapp.v1.UpdateBackupRequest;
import com.google.cloud.netapp.v1.UpdateBackupVaultRequest;
import com.google.cloud.netapp.v1.UpdateKmsConfigRequest;
import com.google.cloud.netapp.v1.UpdateReplicationRequest;
import com.google.cloud.netapp.v1.UpdateSnapshotRequest;
import com.google.cloud.netapp.v1.UpdateStoragePoolRequest;
import com.google.cloud.netapp.v1.UpdateVolumeRequest;
import com.google.cloud.netapp.v1.VerifyKmsConfigRequest;
import com.google.cloud.netapp.v1.VerifyKmsConfigResponse;
import com.google.cloud.netapp.v1.Volume;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link NetAppStub}.
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
 * NetAppStubSettings.Builder netAppSettingsBuilder = NetAppStubSettings.newBuilder();
 * netAppSettingsBuilder
 *     .getStoragePoolSettings()
 *     .setRetrySettings(
 *         netAppSettingsBuilder
 *             .getStoragePoolSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * NetAppStubSettings netAppSettings = netAppSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class NetAppStubSettings extends StubSettings<NetAppStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListStoragePoolsRequest, ListStoragePoolsResponse, ListStoragePoolsPagedResponse>
      listStoragePoolsSettings;
  private final UnaryCallSettings<CreateStoragePoolRequest, Operation> createStoragePoolSettings;
  private final OperationCallSettings<CreateStoragePoolRequest, StoragePool, OperationMetadata>
      createStoragePoolOperationSettings;
  private final UnaryCallSettings<GetStoragePoolRequest, StoragePool> getStoragePoolSettings;
  private final UnaryCallSettings<UpdateStoragePoolRequest, Operation> updateStoragePoolSettings;
  private final OperationCallSettings<UpdateStoragePoolRequest, StoragePool, OperationMetadata>
      updateStoragePoolOperationSettings;
  private final UnaryCallSettings<DeleteStoragePoolRequest, Operation> deleteStoragePoolSettings;
  private final OperationCallSettings<DeleteStoragePoolRequest, Empty, OperationMetadata>
      deleteStoragePoolOperationSettings;
  private final PagedCallSettings<ListVolumesRequest, ListVolumesResponse, ListVolumesPagedResponse>
      listVolumesSettings;
  private final UnaryCallSettings<GetVolumeRequest, Volume> getVolumeSettings;
  private final UnaryCallSettings<CreateVolumeRequest, Operation> createVolumeSettings;
  private final OperationCallSettings<CreateVolumeRequest, Volume, OperationMetadata>
      createVolumeOperationSettings;
  private final UnaryCallSettings<UpdateVolumeRequest, Operation> updateVolumeSettings;
  private final OperationCallSettings<UpdateVolumeRequest, Volume, OperationMetadata>
      updateVolumeOperationSettings;
  private final UnaryCallSettings<DeleteVolumeRequest, Operation> deleteVolumeSettings;
  private final OperationCallSettings<DeleteVolumeRequest, Empty, OperationMetadata>
      deleteVolumeOperationSettings;
  private final UnaryCallSettings<RevertVolumeRequest, Operation> revertVolumeSettings;
  private final OperationCallSettings<RevertVolumeRequest, Volume, OperationMetadata>
      revertVolumeOperationSettings;
  private final PagedCallSettings<
          ListSnapshotsRequest, ListSnapshotsResponse, ListSnapshotsPagedResponse>
      listSnapshotsSettings;
  private final UnaryCallSettings<GetSnapshotRequest, Snapshot> getSnapshotSettings;
  private final UnaryCallSettings<CreateSnapshotRequest, Operation> createSnapshotSettings;
  private final OperationCallSettings<CreateSnapshotRequest, Snapshot, OperationMetadata>
      createSnapshotOperationSettings;
  private final UnaryCallSettings<DeleteSnapshotRequest, Operation> deleteSnapshotSettings;
  private final OperationCallSettings<DeleteSnapshotRequest, Empty, OperationMetadata>
      deleteSnapshotOperationSettings;
  private final UnaryCallSettings<UpdateSnapshotRequest, Operation> updateSnapshotSettings;
  private final OperationCallSettings<UpdateSnapshotRequest, Snapshot, OperationMetadata>
      updateSnapshotOperationSettings;
  private final PagedCallSettings<
          ListActiveDirectoriesRequest,
          ListActiveDirectoriesResponse,
          ListActiveDirectoriesPagedResponse>
      listActiveDirectoriesSettings;
  private final UnaryCallSettings<GetActiveDirectoryRequest, ActiveDirectory>
      getActiveDirectorySettings;
  private final UnaryCallSettings<CreateActiveDirectoryRequest, Operation>
      createActiveDirectorySettings;
  private final OperationCallSettings<
          CreateActiveDirectoryRequest, ActiveDirectory, OperationMetadata>
      createActiveDirectoryOperationSettings;
  private final UnaryCallSettings<UpdateActiveDirectoryRequest, Operation>
      updateActiveDirectorySettings;
  private final OperationCallSettings<
          UpdateActiveDirectoryRequest, ActiveDirectory, OperationMetadata>
      updateActiveDirectoryOperationSettings;
  private final UnaryCallSettings<DeleteActiveDirectoryRequest, Operation>
      deleteActiveDirectorySettings;
  private final OperationCallSettings<DeleteActiveDirectoryRequest, Empty, OperationMetadata>
      deleteActiveDirectoryOperationSettings;
  private final PagedCallSettings<
          ListKmsConfigsRequest, ListKmsConfigsResponse, ListKmsConfigsPagedResponse>
      listKmsConfigsSettings;
  private final UnaryCallSettings<CreateKmsConfigRequest, Operation> createKmsConfigSettings;
  private final OperationCallSettings<CreateKmsConfigRequest, KmsConfig, OperationMetadata>
      createKmsConfigOperationSettings;
  private final UnaryCallSettings<GetKmsConfigRequest, KmsConfig> getKmsConfigSettings;
  private final UnaryCallSettings<UpdateKmsConfigRequest, Operation> updateKmsConfigSettings;
  private final OperationCallSettings<UpdateKmsConfigRequest, KmsConfig, OperationMetadata>
      updateKmsConfigOperationSettings;
  private final UnaryCallSettings<EncryptVolumesRequest, Operation> encryptVolumesSettings;
  private final OperationCallSettings<EncryptVolumesRequest, KmsConfig, OperationMetadata>
      encryptVolumesOperationSettings;
  private final UnaryCallSettings<VerifyKmsConfigRequest, VerifyKmsConfigResponse>
      verifyKmsConfigSettings;
  private final UnaryCallSettings<DeleteKmsConfigRequest, Operation> deleteKmsConfigSettings;
  private final OperationCallSettings<DeleteKmsConfigRequest, Empty, OperationMetadata>
      deleteKmsConfigOperationSettings;
  private final PagedCallSettings<
          ListReplicationsRequest, ListReplicationsResponse, ListReplicationsPagedResponse>
      listReplicationsSettings;
  private final UnaryCallSettings<GetReplicationRequest, Replication> getReplicationSettings;
  private final UnaryCallSettings<CreateReplicationRequest, Operation> createReplicationSettings;
  private final OperationCallSettings<CreateReplicationRequest, Replication, OperationMetadata>
      createReplicationOperationSettings;
  private final UnaryCallSettings<DeleteReplicationRequest, Operation> deleteReplicationSettings;
  private final OperationCallSettings<DeleteReplicationRequest, Empty, OperationMetadata>
      deleteReplicationOperationSettings;
  private final UnaryCallSettings<UpdateReplicationRequest, Operation> updateReplicationSettings;
  private final OperationCallSettings<UpdateReplicationRequest, Replication, OperationMetadata>
      updateReplicationOperationSettings;
  private final UnaryCallSettings<StopReplicationRequest, Operation> stopReplicationSettings;
  private final OperationCallSettings<StopReplicationRequest, Replication, OperationMetadata>
      stopReplicationOperationSettings;
  private final UnaryCallSettings<ResumeReplicationRequest, Operation> resumeReplicationSettings;
  private final OperationCallSettings<ResumeReplicationRequest, Replication, OperationMetadata>
      resumeReplicationOperationSettings;
  private final UnaryCallSettings<ReverseReplicationDirectionRequest, Operation>
      reverseReplicationDirectionSettings;
  private final OperationCallSettings<
          ReverseReplicationDirectionRequest, Replication, OperationMetadata>
      reverseReplicationDirectionOperationSettings;
  private final UnaryCallSettings<CreateBackupVaultRequest, Operation> createBackupVaultSettings;
  private final OperationCallSettings<CreateBackupVaultRequest, BackupVault, OperationMetadata>
      createBackupVaultOperationSettings;
  private final UnaryCallSettings<GetBackupVaultRequest, BackupVault> getBackupVaultSettings;
  private final PagedCallSettings<
          ListBackupVaultsRequest, ListBackupVaultsResponse, ListBackupVaultsPagedResponse>
      listBackupVaultsSettings;
  private final UnaryCallSettings<UpdateBackupVaultRequest, Operation> updateBackupVaultSettings;
  private final OperationCallSettings<UpdateBackupVaultRequest, BackupVault, OperationMetadata>
      updateBackupVaultOperationSettings;
  private final UnaryCallSettings<DeleteBackupVaultRequest, Operation> deleteBackupVaultSettings;
  private final OperationCallSettings<DeleteBackupVaultRequest, Empty, OperationMetadata>
      deleteBackupVaultOperationSettings;
  private final UnaryCallSettings<CreateBackupRequest, Operation> createBackupSettings;
  private final OperationCallSettings<CreateBackupRequest, Backup, OperationMetadata>
      createBackupOperationSettings;
  private final UnaryCallSettings<GetBackupRequest, Backup> getBackupSettings;
  private final PagedCallSettings<ListBackupsRequest, ListBackupsResponse, ListBackupsPagedResponse>
      listBackupsSettings;
  private final UnaryCallSettings<DeleteBackupRequest, Operation> deleteBackupSettings;
  private final OperationCallSettings<DeleteBackupRequest, Empty, OperationMetadata>
      deleteBackupOperationSettings;
  private final UnaryCallSettings<UpdateBackupRequest, Operation> updateBackupSettings;
  private final OperationCallSettings<UpdateBackupRequest, Backup, OperationMetadata>
      updateBackupOperationSettings;
  private final UnaryCallSettings<CreateBackupPolicyRequest, Operation> createBackupPolicySettings;
  private final OperationCallSettings<CreateBackupPolicyRequest, BackupPolicy, OperationMetadata>
      createBackupPolicyOperationSettings;
  private final UnaryCallSettings<GetBackupPolicyRequest, BackupPolicy> getBackupPolicySettings;
  private final PagedCallSettings<
          ListBackupPoliciesRequest, ListBackupPoliciesResponse, ListBackupPoliciesPagedResponse>
      listBackupPoliciesSettings;
  private final UnaryCallSettings<UpdateBackupPolicyRequest, Operation> updateBackupPolicySettings;
  private final OperationCallSettings<UpdateBackupPolicyRequest, BackupPolicy, OperationMetadata>
      updateBackupPolicyOperationSettings;
  private final UnaryCallSettings<DeleteBackupPolicyRequest, Operation> deleteBackupPolicySettings;
  private final OperationCallSettings<DeleteBackupPolicyRequest, Empty, OperationMetadata>
      deleteBackupPolicyOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<
          ListStoragePoolsRequest, ListStoragePoolsResponse, StoragePool>
      LIST_STORAGE_POOLS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListStoragePoolsRequest, ListStoragePoolsResponse, StoragePool>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListStoragePoolsRequest injectToken(
                ListStoragePoolsRequest payload, String token) {
              return ListStoragePoolsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListStoragePoolsRequest injectPageSize(
                ListStoragePoolsRequest payload, int pageSize) {
              return ListStoragePoolsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListStoragePoolsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListStoragePoolsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<StoragePool> extractResources(ListStoragePoolsResponse payload) {
              return payload.getStoragePoolsList() == null
                  ? ImmutableList.<StoragePool>of()
                  : payload.getStoragePoolsList();
            }
          };

  private static final PagedListDescriptor<ListVolumesRequest, ListVolumesResponse, Volume>
      LIST_VOLUMES_PAGE_STR_DESC =
          new PagedListDescriptor<ListVolumesRequest, ListVolumesResponse, Volume>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListVolumesRequest injectToken(ListVolumesRequest payload, String token) {
              return ListVolumesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListVolumesRequest injectPageSize(ListVolumesRequest payload, int pageSize) {
              return ListVolumesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListVolumesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListVolumesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Volume> extractResources(ListVolumesResponse payload) {
              return payload.getVolumesList() == null
                  ? ImmutableList.<Volume>of()
                  : payload.getVolumesList();
            }
          };

  private static final PagedListDescriptor<ListSnapshotsRequest, ListSnapshotsResponse, Snapshot>
      LIST_SNAPSHOTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListSnapshotsRequest, ListSnapshotsResponse, Snapshot>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSnapshotsRequest injectToken(ListSnapshotsRequest payload, String token) {
              return ListSnapshotsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSnapshotsRequest injectPageSize(ListSnapshotsRequest payload, int pageSize) {
              return ListSnapshotsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSnapshotsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSnapshotsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Snapshot> extractResources(ListSnapshotsResponse payload) {
              return payload.getSnapshotsList() == null
                  ? ImmutableList.<Snapshot>of()
                  : payload.getSnapshotsList();
            }
          };

  private static final PagedListDescriptor<
          ListActiveDirectoriesRequest, ListActiveDirectoriesResponse, ActiveDirectory>
      LIST_ACTIVE_DIRECTORIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListActiveDirectoriesRequest, ListActiveDirectoriesResponse, ActiveDirectory>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListActiveDirectoriesRequest injectToken(
                ListActiveDirectoriesRequest payload, String token) {
              return ListActiveDirectoriesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListActiveDirectoriesRequest injectPageSize(
                ListActiveDirectoriesRequest payload, int pageSize) {
              return ListActiveDirectoriesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListActiveDirectoriesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListActiveDirectoriesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ActiveDirectory> extractResources(
                ListActiveDirectoriesResponse payload) {
              return payload.getActiveDirectoriesList() == null
                  ? ImmutableList.<ActiveDirectory>of()
                  : payload.getActiveDirectoriesList();
            }
          };

  private static final PagedListDescriptor<ListKmsConfigsRequest, ListKmsConfigsResponse, KmsConfig>
      LIST_KMS_CONFIGS_PAGE_STR_DESC =
          new PagedListDescriptor<ListKmsConfigsRequest, ListKmsConfigsResponse, KmsConfig>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListKmsConfigsRequest injectToken(ListKmsConfigsRequest payload, String token) {
              return ListKmsConfigsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListKmsConfigsRequest injectPageSize(
                ListKmsConfigsRequest payload, int pageSize) {
              return ListKmsConfigsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListKmsConfigsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListKmsConfigsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<KmsConfig> extractResources(ListKmsConfigsResponse payload) {
              return payload.getKmsConfigsList() == null
                  ? ImmutableList.<KmsConfig>of()
                  : payload.getKmsConfigsList();
            }
          };

  private static final PagedListDescriptor<
          ListReplicationsRequest, ListReplicationsResponse, Replication>
      LIST_REPLICATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListReplicationsRequest, ListReplicationsResponse, Replication>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListReplicationsRequest injectToken(
                ListReplicationsRequest payload, String token) {
              return ListReplicationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListReplicationsRequest injectPageSize(
                ListReplicationsRequest payload, int pageSize) {
              return ListReplicationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListReplicationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListReplicationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Replication> extractResources(ListReplicationsResponse payload) {
              return payload.getReplicationsList() == null
                  ? ImmutableList.<Replication>of()
                  : payload.getReplicationsList();
            }
          };

  private static final PagedListDescriptor<
          ListBackupVaultsRequest, ListBackupVaultsResponse, BackupVault>
      LIST_BACKUP_VAULTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListBackupVaultsRequest, ListBackupVaultsResponse, BackupVault>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListBackupVaultsRequest injectToken(
                ListBackupVaultsRequest payload, String token) {
              return ListBackupVaultsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListBackupVaultsRequest injectPageSize(
                ListBackupVaultsRequest payload, int pageSize) {
              return ListBackupVaultsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListBackupVaultsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListBackupVaultsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<BackupVault> extractResources(ListBackupVaultsResponse payload) {
              return payload.getBackupVaultsList() == null
                  ? ImmutableList.<BackupVault>of()
                  : payload.getBackupVaultsList();
            }
          };

  private static final PagedListDescriptor<ListBackupsRequest, ListBackupsResponse, Backup>
      LIST_BACKUPS_PAGE_STR_DESC =
          new PagedListDescriptor<ListBackupsRequest, ListBackupsResponse, Backup>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListBackupsRequest injectToken(ListBackupsRequest payload, String token) {
              return ListBackupsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListBackupsRequest injectPageSize(ListBackupsRequest payload, int pageSize) {
              return ListBackupsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListBackupsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListBackupsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Backup> extractResources(ListBackupsResponse payload) {
              return payload.getBackupsList() == null
                  ? ImmutableList.<Backup>of()
                  : payload.getBackupsList();
            }
          };

  private static final PagedListDescriptor<
          ListBackupPoliciesRequest, ListBackupPoliciesResponse, BackupPolicy>
      LIST_BACKUP_POLICIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListBackupPoliciesRequest, ListBackupPoliciesResponse, BackupPolicy>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListBackupPoliciesRequest injectToken(
                ListBackupPoliciesRequest payload, String token) {
              return ListBackupPoliciesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListBackupPoliciesRequest injectPageSize(
                ListBackupPoliciesRequest payload, int pageSize) {
              return ListBackupPoliciesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListBackupPoliciesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListBackupPoliciesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<BackupPolicy> extractResources(ListBackupPoliciesResponse payload) {
              return payload.getBackupPoliciesList() == null
                  ? ImmutableList.<BackupPolicy>of()
                  : payload.getBackupPoliciesList();
            }
          };

  private static final PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>
      LIST_LOCATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLocationsRequest injectToken(ListLocationsRequest payload, String token) {
              return ListLocationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLocationsRequest injectPageSize(ListLocationsRequest payload, int pageSize) {
              return ListLocationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLocationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLocationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Location> extractResources(ListLocationsResponse payload) {
              return payload.getLocationsList() == null
                  ? ImmutableList.<Location>of()
                  : payload.getLocationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListStoragePoolsRequest, ListStoragePoolsResponse, ListStoragePoolsPagedResponse>
      LIST_STORAGE_POOLS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListStoragePoolsRequest, ListStoragePoolsResponse, ListStoragePoolsPagedResponse>() {
            @Override
            public ApiFuture<ListStoragePoolsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListStoragePoolsRequest, ListStoragePoolsResponse> callable,
                ListStoragePoolsRequest request,
                ApiCallContext context,
                ApiFuture<ListStoragePoolsResponse> futureResponse) {
              PageContext<ListStoragePoolsRequest, ListStoragePoolsResponse, StoragePool>
                  pageContext =
                      PageContext.create(
                          callable, LIST_STORAGE_POOLS_PAGE_STR_DESC, request, context);
              return ListStoragePoolsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListVolumesRequest, ListVolumesResponse, ListVolumesPagedResponse>
      LIST_VOLUMES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListVolumesRequest, ListVolumesResponse, ListVolumesPagedResponse>() {
            @Override
            public ApiFuture<ListVolumesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListVolumesRequest, ListVolumesResponse> callable,
                ListVolumesRequest request,
                ApiCallContext context,
                ApiFuture<ListVolumesResponse> futureResponse) {
              PageContext<ListVolumesRequest, ListVolumesResponse, Volume> pageContext =
                  PageContext.create(callable, LIST_VOLUMES_PAGE_STR_DESC, request, context);
              return ListVolumesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListSnapshotsRequest, ListSnapshotsResponse, ListSnapshotsPagedResponse>
      LIST_SNAPSHOTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSnapshotsRequest, ListSnapshotsResponse, ListSnapshotsPagedResponse>() {
            @Override
            public ApiFuture<ListSnapshotsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSnapshotsRequest, ListSnapshotsResponse> callable,
                ListSnapshotsRequest request,
                ApiCallContext context,
                ApiFuture<ListSnapshotsResponse> futureResponse) {
              PageContext<ListSnapshotsRequest, ListSnapshotsResponse, Snapshot> pageContext =
                  PageContext.create(callable, LIST_SNAPSHOTS_PAGE_STR_DESC, request, context);
              return ListSnapshotsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListActiveDirectoriesRequest,
          ListActiveDirectoriesResponse,
          ListActiveDirectoriesPagedResponse>
      LIST_ACTIVE_DIRECTORIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListActiveDirectoriesRequest,
              ListActiveDirectoriesResponse,
              ListActiveDirectoriesPagedResponse>() {
            @Override
            public ApiFuture<ListActiveDirectoriesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListActiveDirectoriesRequest, ListActiveDirectoriesResponse> callable,
                ListActiveDirectoriesRequest request,
                ApiCallContext context,
                ApiFuture<ListActiveDirectoriesResponse> futureResponse) {
              PageContext<
                      ListActiveDirectoriesRequest, ListActiveDirectoriesResponse, ActiveDirectory>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ACTIVE_DIRECTORIES_PAGE_STR_DESC, request, context);
              return ListActiveDirectoriesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListKmsConfigsRequest, ListKmsConfigsResponse, ListKmsConfigsPagedResponse>
      LIST_KMS_CONFIGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListKmsConfigsRequest, ListKmsConfigsResponse, ListKmsConfigsPagedResponse>() {
            @Override
            public ApiFuture<ListKmsConfigsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListKmsConfigsRequest, ListKmsConfigsResponse> callable,
                ListKmsConfigsRequest request,
                ApiCallContext context,
                ApiFuture<ListKmsConfigsResponse> futureResponse) {
              PageContext<ListKmsConfigsRequest, ListKmsConfigsResponse, KmsConfig> pageContext =
                  PageContext.create(callable, LIST_KMS_CONFIGS_PAGE_STR_DESC, request, context);
              return ListKmsConfigsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListReplicationsRequest, ListReplicationsResponse, ListReplicationsPagedResponse>
      LIST_REPLICATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListReplicationsRequest, ListReplicationsResponse, ListReplicationsPagedResponse>() {
            @Override
            public ApiFuture<ListReplicationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListReplicationsRequest, ListReplicationsResponse> callable,
                ListReplicationsRequest request,
                ApiCallContext context,
                ApiFuture<ListReplicationsResponse> futureResponse) {
              PageContext<ListReplicationsRequest, ListReplicationsResponse, Replication>
                  pageContext =
                      PageContext.create(
                          callable, LIST_REPLICATIONS_PAGE_STR_DESC, request, context);
              return ListReplicationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListBackupVaultsRequest, ListBackupVaultsResponse, ListBackupVaultsPagedResponse>
      LIST_BACKUP_VAULTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListBackupVaultsRequest, ListBackupVaultsResponse, ListBackupVaultsPagedResponse>() {
            @Override
            public ApiFuture<ListBackupVaultsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListBackupVaultsRequest, ListBackupVaultsResponse> callable,
                ListBackupVaultsRequest request,
                ApiCallContext context,
                ApiFuture<ListBackupVaultsResponse> futureResponse) {
              PageContext<ListBackupVaultsRequest, ListBackupVaultsResponse, BackupVault>
                  pageContext =
                      PageContext.create(
                          callable, LIST_BACKUP_VAULTS_PAGE_STR_DESC, request, context);
              return ListBackupVaultsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListBackupsRequest, ListBackupsResponse, ListBackupsPagedResponse>
      LIST_BACKUPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListBackupsRequest, ListBackupsResponse, ListBackupsPagedResponse>() {
            @Override
            public ApiFuture<ListBackupsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListBackupsRequest, ListBackupsResponse> callable,
                ListBackupsRequest request,
                ApiCallContext context,
                ApiFuture<ListBackupsResponse> futureResponse) {
              PageContext<ListBackupsRequest, ListBackupsResponse, Backup> pageContext =
                  PageContext.create(callable, LIST_BACKUPS_PAGE_STR_DESC, request, context);
              return ListBackupsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListBackupPoliciesRequest, ListBackupPoliciesResponse, ListBackupPoliciesPagedResponse>
      LIST_BACKUP_POLICIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListBackupPoliciesRequest,
              ListBackupPoliciesResponse,
              ListBackupPoliciesPagedResponse>() {
            @Override
            public ApiFuture<ListBackupPoliciesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListBackupPoliciesRequest, ListBackupPoliciesResponse> callable,
                ListBackupPoliciesRequest request,
                ApiCallContext context,
                ApiFuture<ListBackupPoliciesResponse> futureResponse) {
              PageContext<ListBackupPoliciesRequest, ListBackupPoliciesResponse, BackupPolicy>
                  pageContext =
                      PageContext.create(
                          callable, LIST_BACKUP_POLICIES_PAGE_STR_DESC, request, context);
              return ListBackupPoliciesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      LIST_LOCATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>() {
            @Override
            public ApiFuture<ListLocationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLocationsRequest, ListLocationsResponse> callable,
                ListLocationsRequest request,
                ApiCallContext context,
                ApiFuture<ListLocationsResponse> futureResponse) {
              PageContext<ListLocationsRequest, ListLocationsResponse, Location> pageContext =
                  PageContext.create(callable, LIST_LOCATIONS_PAGE_STR_DESC, request, context);
              return ListLocationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listStoragePools. */
  public PagedCallSettings<
          ListStoragePoolsRequest, ListStoragePoolsResponse, ListStoragePoolsPagedResponse>
      listStoragePoolsSettings() {
    return listStoragePoolsSettings;
  }

  /** Returns the object with the settings used for calls to createStoragePool. */
  public UnaryCallSettings<CreateStoragePoolRequest, Operation> createStoragePoolSettings() {
    return createStoragePoolSettings;
  }

  /** Returns the object with the settings used for calls to createStoragePool. */
  public OperationCallSettings<CreateStoragePoolRequest, StoragePool, OperationMetadata>
      createStoragePoolOperationSettings() {
    return createStoragePoolOperationSettings;
  }

  /** Returns the object with the settings used for calls to getStoragePool. */
  public UnaryCallSettings<GetStoragePoolRequest, StoragePool> getStoragePoolSettings() {
    return getStoragePoolSettings;
  }

  /** Returns the object with the settings used for calls to updateStoragePool. */
  public UnaryCallSettings<UpdateStoragePoolRequest, Operation> updateStoragePoolSettings() {
    return updateStoragePoolSettings;
  }

  /** Returns the object with the settings used for calls to updateStoragePool. */
  public OperationCallSettings<UpdateStoragePoolRequest, StoragePool, OperationMetadata>
      updateStoragePoolOperationSettings() {
    return updateStoragePoolOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteStoragePool. */
  public UnaryCallSettings<DeleteStoragePoolRequest, Operation> deleteStoragePoolSettings() {
    return deleteStoragePoolSettings;
  }

  /** Returns the object with the settings used for calls to deleteStoragePool. */
  public OperationCallSettings<DeleteStoragePoolRequest, Empty, OperationMetadata>
      deleteStoragePoolOperationSettings() {
    return deleteStoragePoolOperationSettings;
  }

  /** Returns the object with the settings used for calls to listVolumes. */
  public PagedCallSettings<ListVolumesRequest, ListVolumesResponse, ListVolumesPagedResponse>
      listVolumesSettings() {
    return listVolumesSettings;
  }

  /** Returns the object with the settings used for calls to getVolume. */
  public UnaryCallSettings<GetVolumeRequest, Volume> getVolumeSettings() {
    return getVolumeSettings;
  }

  /** Returns the object with the settings used for calls to createVolume. */
  public UnaryCallSettings<CreateVolumeRequest, Operation> createVolumeSettings() {
    return createVolumeSettings;
  }

  /** Returns the object with the settings used for calls to createVolume. */
  public OperationCallSettings<CreateVolumeRequest, Volume, OperationMetadata>
      createVolumeOperationSettings() {
    return createVolumeOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateVolume. */
  public UnaryCallSettings<UpdateVolumeRequest, Operation> updateVolumeSettings() {
    return updateVolumeSettings;
  }

  /** Returns the object with the settings used for calls to updateVolume. */
  public OperationCallSettings<UpdateVolumeRequest, Volume, OperationMetadata>
      updateVolumeOperationSettings() {
    return updateVolumeOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteVolume. */
  public UnaryCallSettings<DeleteVolumeRequest, Operation> deleteVolumeSettings() {
    return deleteVolumeSettings;
  }

  /** Returns the object with the settings used for calls to deleteVolume. */
  public OperationCallSettings<DeleteVolumeRequest, Empty, OperationMetadata>
      deleteVolumeOperationSettings() {
    return deleteVolumeOperationSettings;
  }

  /** Returns the object with the settings used for calls to revertVolume. */
  public UnaryCallSettings<RevertVolumeRequest, Operation> revertVolumeSettings() {
    return revertVolumeSettings;
  }

  /** Returns the object with the settings used for calls to revertVolume. */
  public OperationCallSettings<RevertVolumeRequest, Volume, OperationMetadata>
      revertVolumeOperationSettings() {
    return revertVolumeOperationSettings;
  }

  /** Returns the object with the settings used for calls to listSnapshots. */
  public PagedCallSettings<ListSnapshotsRequest, ListSnapshotsResponse, ListSnapshotsPagedResponse>
      listSnapshotsSettings() {
    return listSnapshotsSettings;
  }

  /** Returns the object with the settings used for calls to getSnapshot. */
  public UnaryCallSettings<GetSnapshotRequest, Snapshot> getSnapshotSettings() {
    return getSnapshotSettings;
  }

  /** Returns the object with the settings used for calls to createSnapshot. */
  public UnaryCallSettings<CreateSnapshotRequest, Operation> createSnapshotSettings() {
    return createSnapshotSettings;
  }

  /** Returns the object with the settings used for calls to createSnapshot. */
  public OperationCallSettings<CreateSnapshotRequest, Snapshot, OperationMetadata>
      createSnapshotOperationSettings() {
    return createSnapshotOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteSnapshot. */
  public UnaryCallSettings<DeleteSnapshotRequest, Operation> deleteSnapshotSettings() {
    return deleteSnapshotSettings;
  }

  /** Returns the object with the settings used for calls to deleteSnapshot. */
  public OperationCallSettings<DeleteSnapshotRequest, Empty, OperationMetadata>
      deleteSnapshotOperationSettings() {
    return deleteSnapshotOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateSnapshot. */
  public UnaryCallSettings<UpdateSnapshotRequest, Operation> updateSnapshotSettings() {
    return updateSnapshotSettings;
  }

  /** Returns the object with the settings used for calls to updateSnapshot. */
  public OperationCallSettings<UpdateSnapshotRequest, Snapshot, OperationMetadata>
      updateSnapshotOperationSettings() {
    return updateSnapshotOperationSettings;
  }

  /** Returns the object with the settings used for calls to listActiveDirectories. */
  public PagedCallSettings<
          ListActiveDirectoriesRequest,
          ListActiveDirectoriesResponse,
          ListActiveDirectoriesPagedResponse>
      listActiveDirectoriesSettings() {
    return listActiveDirectoriesSettings;
  }

  /** Returns the object with the settings used for calls to getActiveDirectory. */
  public UnaryCallSettings<GetActiveDirectoryRequest, ActiveDirectory>
      getActiveDirectorySettings() {
    return getActiveDirectorySettings;
  }

  /** Returns the object with the settings used for calls to createActiveDirectory. */
  public UnaryCallSettings<CreateActiveDirectoryRequest, Operation>
      createActiveDirectorySettings() {
    return createActiveDirectorySettings;
  }

  /** Returns the object with the settings used for calls to createActiveDirectory. */
  public OperationCallSettings<CreateActiveDirectoryRequest, ActiveDirectory, OperationMetadata>
      createActiveDirectoryOperationSettings() {
    return createActiveDirectoryOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateActiveDirectory. */
  public UnaryCallSettings<UpdateActiveDirectoryRequest, Operation>
      updateActiveDirectorySettings() {
    return updateActiveDirectorySettings;
  }

  /** Returns the object with the settings used for calls to updateActiveDirectory. */
  public OperationCallSettings<UpdateActiveDirectoryRequest, ActiveDirectory, OperationMetadata>
      updateActiveDirectoryOperationSettings() {
    return updateActiveDirectoryOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteActiveDirectory. */
  public UnaryCallSettings<DeleteActiveDirectoryRequest, Operation>
      deleteActiveDirectorySettings() {
    return deleteActiveDirectorySettings;
  }

  /** Returns the object with the settings used for calls to deleteActiveDirectory. */
  public OperationCallSettings<DeleteActiveDirectoryRequest, Empty, OperationMetadata>
      deleteActiveDirectoryOperationSettings() {
    return deleteActiveDirectoryOperationSettings;
  }

  /** Returns the object with the settings used for calls to listKmsConfigs. */
  public PagedCallSettings<
          ListKmsConfigsRequest, ListKmsConfigsResponse, ListKmsConfigsPagedResponse>
      listKmsConfigsSettings() {
    return listKmsConfigsSettings;
  }

  /** Returns the object with the settings used for calls to createKmsConfig. */
  public UnaryCallSettings<CreateKmsConfigRequest, Operation> createKmsConfigSettings() {
    return createKmsConfigSettings;
  }

  /** Returns the object with the settings used for calls to createKmsConfig. */
  public OperationCallSettings<CreateKmsConfigRequest, KmsConfig, OperationMetadata>
      createKmsConfigOperationSettings() {
    return createKmsConfigOperationSettings;
  }

  /** Returns the object with the settings used for calls to getKmsConfig. */
  public UnaryCallSettings<GetKmsConfigRequest, KmsConfig> getKmsConfigSettings() {
    return getKmsConfigSettings;
  }

  /** Returns the object with the settings used for calls to updateKmsConfig. */
  public UnaryCallSettings<UpdateKmsConfigRequest, Operation> updateKmsConfigSettings() {
    return updateKmsConfigSettings;
  }

  /** Returns the object with the settings used for calls to updateKmsConfig. */
  public OperationCallSettings<UpdateKmsConfigRequest, KmsConfig, OperationMetadata>
      updateKmsConfigOperationSettings() {
    return updateKmsConfigOperationSettings;
  }

  /** Returns the object with the settings used for calls to encryptVolumes. */
  public UnaryCallSettings<EncryptVolumesRequest, Operation> encryptVolumesSettings() {
    return encryptVolumesSettings;
  }

  /** Returns the object with the settings used for calls to encryptVolumes. */
  public OperationCallSettings<EncryptVolumesRequest, KmsConfig, OperationMetadata>
      encryptVolumesOperationSettings() {
    return encryptVolumesOperationSettings;
  }

  /** Returns the object with the settings used for calls to verifyKmsConfig. */
  public UnaryCallSettings<VerifyKmsConfigRequest, VerifyKmsConfigResponse>
      verifyKmsConfigSettings() {
    return verifyKmsConfigSettings;
  }

  /** Returns the object with the settings used for calls to deleteKmsConfig. */
  public UnaryCallSettings<DeleteKmsConfigRequest, Operation> deleteKmsConfigSettings() {
    return deleteKmsConfigSettings;
  }

  /** Returns the object with the settings used for calls to deleteKmsConfig. */
  public OperationCallSettings<DeleteKmsConfigRequest, Empty, OperationMetadata>
      deleteKmsConfigOperationSettings() {
    return deleteKmsConfigOperationSettings;
  }

  /** Returns the object with the settings used for calls to listReplications. */
  public PagedCallSettings<
          ListReplicationsRequest, ListReplicationsResponse, ListReplicationsPagedResponse>
      listReplicationsSettings() {
    return listReplicationsSettings;
  }

  /** Returns the object with the settings used for calls to getReplication. */
  public UnaryCallSettings<GetReplicationRequest, Replication> getReplicationSettings() {
    return getReplicationSettings;
  }

  /** Returns the object with the settings used for calls to createReplication. */
  public UnaryCallSettings<CreateReplicationRequest, Operation> createReplicationSettings() {
    return createReplicationSettings;
  }

  /** Returns the object with the settings used for calls to createReplication. */
  public OperationCallSettings<CreateReplicationRequest, Replication, OperationMetadata>
      createReplicationOperationSettings() {
    return createReplicationOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteReplication. */
  public UnaryCallSettings<DeleteReplicationRequest, Operation> deleteReplicationSettings() {
    return deleteReplicationSettings;
  }

  /** Returns the object with the settings used for calls to deleteReplication. */
  public OperationCallSettings<DeleteReplicationRequest, Empty, OperationMetadata>
      deleteReplicationOperationSettings() {
    return deleteReplicationOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateReplication. */
  public UnaryCallSettings<UpdateReplicationRequest, Operation> updateReplicationSettings() {
    return updateReplicationSettings;
  }

  /** Returns the object with the settings used for calls to updateReplication. */
  public OperationCallSettings<UpdateReplicationRequest, Replication, OperationMetadata>
      updateReplicationOperationSettings() {
    return updateReplicationOperationSettings;
  }

  /** Returns the object with the settings used for calls to stopReplication. */
  public UnaryCallSettings<StopReplicationRequest, Operation> stopReplicationSettings() {
    return stopReplicationSettings;
  }

  /** Returns the object with the settings used for calls to stopReplication. */
  public OperationCallSettings<StopReplicationRequest, Replication, OperationMetadata>
      stopReplicationOperationSettings() {
    return stopReplicationOperationSettings;
  }

  /** Returns the object with the settings used for calls to resumeReplication. */
  public UnaryCallSettings<ResumeReplicationRequest, Operation> resumeReplicationSettings() {
    return resumeReplicationSettings;
  }

  /** Returns the object with the settings used for calls to resumeReplication. */
  public OperationCallSettings<ResumeReplicationRequest, Replication, OperationMetadata>
      resumeReplicationOperationSettings() {
    return resumeReplicationOperationSettings;
  }

  /** Returns the object with the settings used for calls to reverseReplicationDirection. */
  public UnaryCallSettings<ReverseReplicationDirectionRequest, Operation>
      reverseReplicationDirectionSettings() {
    return reverseReplicationDirectionSettings;
  }

  /** Returns the object with the settings used for calls to reverseReplicationDirection. */
  public OperationCallSettings<ReverseReplicationDirectionRequest, Replication, OperationMetadata>
      reverseReplicationDirectionOperationSettings() {
    return reverseReplicationDirectionOperationSettings;
  }

  /** Returns the object with the settings used for calls to createBackupVault. */
  public UnaryCallSettings<CreateBackupVaultRequest, Operation> createBackupVaultSettings() {
    return createBackupVaultSettings;
  }

  /** Returns the object with the settings used for calls to createBackupVault. */
  public OperationCallSettings<CreateBackupVaultRequest, BackupVault, OperationMetadata>
      createBackupVaultOperationSettings() {
    return createBackupVaultOperationSettings;
  }

  /** Returns the object with the settings used for calls to getBackupVault. */
  public UnaryCallSettings<GetBackupVaultRequest, BackupVault> getBackupVaultSettings() {
    return getBackupVaultSettings;
  }

  /** Returns the object with the settings used for calls to listBackupVaults. */
  public PagedCallSettings<
          ListBackupVaultsRequest, ListBackupVaultsResponse, ListBackupVaultsPagedResponse>
      listBackupVaultsSettings() {
    return listBackupVaultsSettings;
  }

  /** Returns the object with the settings used for calls to updateBackupVault. */
  public UnaryCallSettings<UpdateBackupVaultRequest, Operation> updateBackupVaultSettings() {
    return updateBackupVaultSettings;
  }

  /** Returns the object with the settings used for calls to updateBackupVault. */
  public OperationCallSettings<UpdateBackupVaultRequest, BackupVault, OperationMetadata>
      updateBackupVaultOperationSettings() {
    return updateBackupVaultOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteBackupVault. */
  public UnaryCallSettings<DeleteBackupVaultRequest, Operation> deleteBackupVaultSettings() {
    return deleteBackupVaultSettings;
  }

  /** Returns the object with the settings used for calls to deleteBackupVault. */
  public OperationCallSettings<DeleteBackupVaultRequest, Empty, OperationMetadata>
      deleteBackupVaultOperationSettings() {
    return deleteBackupVaultOperationSettings;
  }

  /** Returns the object with the settings used for calls to createBackup. */
  public UnaryCallSettings<CreateBackupRequest, Operation> createBackupSettings() {
    return createBackupSettings;
  }

  /** Returns the object with the settings used for calls to createBackup. */
  public OperationCallSettings<CreateBackupRequest, Backup, OperationMetadata>
      createBackupOperationSettings() {
    return createBackupOperationSettings;
  }

  /** Returns the object with the settings used for calls to getBackup. */
  public UnaryCallSettings<GetBackupRequest, Backup> getBackupSettings() {
    return getBackupSettings;
  }

  /** Returns the object with the settings used for calls to listBackups. */
  public PagedCallSettings<ListBackupsRequest, ListBackupsResponse, ListBackupsPagedResponse>
      listBackupsSettings() {
    return listBackupsSettings;
  }

  /** Returns the object with the settings used for calls to deleteBackup. */
  public UnaryCallSettings<DeleteBackupRequest, Operation> deleteBackupSettings() {
    return deleteBackupSettings;
  }

  /** Returns the object with the settings used for calls to deleteBackup. */
  public OperationCallSettings<DeleteBackupRequest, Empty, OperationMetadata>
      deleteBackupOperationSettings() {
    return deleteBackupOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateBackup. */
  public UnaryCallSettings<UpdateBackupRequest, Operation> updateBackupSettings() {
    return updateBackupSettings;
  }

  /** Returns the object with the settings used for calls to updateBackup. */
  public OperationCallSettings<UpdateBackupRequest, Backup, OperationMetadata>
      updateBackupOperationSettings() {
    return updateBackupOperationSettings;
  }

  /** Returns the object with the settings used for calls to createBackupPolicy. */
  public UnaryCallSettings<CreateBackupPolicyRequest, Operation> createBackupPolicySettings() {
    return createBackupPolicySettings;
  }

  /** Returns the object with the settings used for calls to createBackupPolicy. */
  public OperationCallSettings<CreateBackupPolicyRequest, BackupPolicy, OperationMetadata>
      createBackupPolicyOperationSettings() {
    return createBackupPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to getBackupPolicy. */
  public UnaryCallSettings<GetBackupPolicyRequest, BackupPolicy> getBackupPolicySettings() {
    return getBackupPolicySettings;
  }

  /** Returns the object with the settings used for calls to listBackupPolicies. */
  public PagedCallSettings<
          ListBackupPoliciesRequest, ListBackupPoliciesResponse, ListBackupPoliciesPagedResponse>
      listBackupPoliciesSettings() {
    return listBackupPoliciesSettings;
  }

  /** Returns the object with the settings used for calls to updateBackupPolicy. */
  public UnaryCallSettings<UpdateBackupPolicyRequest, Operation> updateBackupPolicySettings() {
    return updateBackupPolicySettings;
  }

  /** Returns the object with the settings used for calls to updateBackupPolicy. */
  public OperationCallSettings<UpdateBackupPolicyRequest, BackupPolicy, OperationMetadata>
      updateBackupPolicyOperationSettings() {
    return updateBackupPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteBackupPolicy. */
  public UnaryCallSettings<DeleteBackupPolicyRequest, Operation> deleteBackupPolicySettings() {
    return deleteBackupPolicySettings;
  }

  /** Returns the object with the settings used for calls to deleteBackupPolicy. */
  public OperationCallSettings<DeleteBackupPolicyRequest, Empty, OperationMetadata>
      deleteBackupPolicyOperationSettings() {
    return deleteBackupPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return listLocationsSettings;
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return getLocationSettings;
  }

  public NetAppStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcNetAppStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonNetAppStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "netapp";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "netapp.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "netapp.mtls.googleapis.com:443";
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(NetAppStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(NetAppStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return NetAppStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected NetAppStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listStoragePoolsSettings = settingsBuilder.listStoragePoolsSettings().build();
    createStoragePoolSettings = settingsBuilder.createStoragePoolSettings().build();
    createStoragePoolOperationSettings =
        settingsBuilder.createStoragePoolOperationSettings().build();
    getStoragePoolSettings = settingsBuilder.getStoragePoolSettings().build();
    updateStoragePoolSettings = settingsBuilder.updateStoragePoolSettings().build();
    updateStoragePoolOperationSettings =
        settingsBuilder.updateStoragePoolOperationSettings().build();
    deleteStoragePoolSettings = settingsBuilder.deleteStoragePoolSettings().build();
    deleteStoragePoolOperationSettings =
        settingsBuilder.deleteStoragePoolOperationSettings().build();
    listVolumesSettings = settingsBuilder.listVolumesSettings().build();
    getVolumeSettings = settingsBuilder.getVolumeSettings().build();
    createVolumeSettings = settingsBuilder.createVolumeSettings().build();
    createVolumeOperationSettings = settingsBuilder.createVolumeOperationSettings().build();
    updateVolumeSettings = settingsBuilder.updateVolumeSettings().build();
    updateVolumeOperationSettings = settingsBuilder.updateVolumeOperationSettings().build();
    deleteVolumeSettings = settingsBuilder.deleteVolumeSettings().build();
    deleteVolumeOperationSettings = settingsBuilder.deleteVolumeOperationSettings().build();
    revertVolumeSettings = settingsBuilder.revertVolumeSettings().build();
    revertVolumeOperationSettings = settingsBuilder.revertVolumeOperationSettings().build();
    listSnapshotsSettings = settingsBuilder.listSnapshotsSettings().build();
    getSnapshotSettings = settingsBuilder.getSnapshotSettings().build();
    createSnapshotSettings = settingsBuilder.createSnapshotSettings().build();
    createSnapshotOperationSettings = settingsBuilder.createSnapshotOperationSettings().build();
    deleteSnapshotSettings = settingsBuilder.deleteSnapshotSettings().build();
    deleteSnapshotOperationSettings = settingsBuilder.deleteSnapshotOperationSettings().build();
    updateSnapshotSettings = settingsBuilder.updateSnapshotSettings().build();
    updateSnapshotOperationSettings = settingsBuilder.updateSnapshotOperationSettings().build();
    listActiveDirectoriesSettings = settingsBuilder.listActiveDirectoriesSettings().build();
    getActiveDirectorySettings = settingsBuilder.getActiveDirectorySettings().build();
    createActiveDirectorySettings = settingsBuilder.createActiveDirectorySettings().build();
    createActiveDirectoryOperationSettings =
        settingsBuilder.createActiveDirectoryOperationSettings().build();
    updateActiveDirectorySettings = settingsBuilder.updateActiveDirectorySettings().build();
    updateActiveDirectoryOperationSettings =
        settingsBuilder.updateActiveDirectoryOperationSettings().build();
    deleteActiveDirectorySettings = settingsBuilder.deleteActiveDirectorySettings().build();
    deleteActiveDirectoryOperationSettings =
        settingsBuilder.deleteActiveDirectoryOperationSettings().build();
    listKmsConfigsSettings = settingsBuilder.listKmsConfigsSettings().build();
    createKmsConfigSettings = settingsBuilder.createKmsConfigSettings().build();
    createKmsConfigOperationSettings = settingsBuilder.createKmsConfigOperationSettings().build();
    getKmsConfigSettings = settingsBuilder.getKmsConfigSettings().build();
    updateKmsConfigSettings = settingsBuilder.updateKmsConfigSettings().build();
    updateKmsConfigOperationSettings = settingsBuilder.updateKmsConfigOperationSettings().build();
    encryptVolumesSettings = settingsBuilder.encryptVolumesSettings().build();
    encryptVolumesOperationSettings = settingsBuilder.encryptVolumesOperationSettings().build();
    verifyKmsConfigSettings = settingsBuilder.verifyKmsConfigSettings().build();
    deleteKmsConfigSettings = settingsBuilder.deleteKmsConfigSettings().build();
    deleteKmsConfigOperationSettings = settingsBuilder.deleteKmsConfigOperationSettings().build();
    listReplicationsSettings = settingsBuilder.listReplicationsSettings().build();
    getReplicationSettings = settingsBuilder.getReplicationSettings().build();
    createReplicationSettings = settingsBuilder.createReplicationSettings().build();
    createReplicationOperationSettings =
        settingsBuilder.createReplicationOperationSettings().build();
    deleteReplicationSettings = settingsBuilder.deleteReplicationSettings().build();
    deleteReplicationOperationSettings =
        settingsBuilder.deleteReplicationOperationSettings().build();
    updateReplicationSettings = settingsBuilder.updateReplicationSettings().build();
    updateReplicationOperationSettings =
        settingsBuilder.updateReplicationOperationSettings().build();
    stopReplicationSettings = settingsBuilder.stopReplicationSettings().build();
    stopReplicationOperationSettings = settingsBuilder.stopReplicationOperationSettings().build();
    resumeReplicationSettings = settingsBuilder.resumeReplicationSettings().build();
    resumeReplicationOperationSettings =
        settingsBuilder.resumeReplicationOperationSettings().build();
    reverseReplicationDirectionSettings =
        settingsBuilder.reverseReplicationDirectionSettings().build();
    reverseReplicationDirectionOperationSettings =
        settingsBuilder.reverseReplicationDirectionOperationSettings().build();
    createBackupVaultSettings = settingsBuilder.createBackupVaultSettings().build();
    createBackupVaultOperationSettings =
        settingsBuilder.createBackupVaultOperationSettings().build();
    getBackupVaultSettings = settingsBuilder.getBackupVaultSettings().build();
    listBackupVaultsSettings = settingsBuilder.listBackupVaultsSettings().build();
    updateBackupVaultSettings = settingsBuilder.updateBackupVaultSettings().build();
    updateBackupVaultOperationSettings =
        settingsBuilder.updateBackupVaultOperationSettings().build();
    deleteBackupVaultSettings = settingsBuilder.deleteBackupVaultSettings().build();
    deleteBackupVaultOperationSettings =
        settingsBuilder.deleteBackupVaultOperationSettings().build();
    createBackupSettings = settingsBuilder.createBackupSettings().build();
    createBackupOperationSettings = settingsBuilder.createBackupOperationSettings().build();
    getBackupSettings = settingsBuilder.getBackupSettings().build();
    listBackupsSettings = settingsBuilder.listBackupsSettings().build();
    deleteBackupSettings = settingsBuilder.deleteBackupSettings().build();
    deleteBackupOperationSettings = settingsBuilder.deleteBackupOperationSettings().build();
    updateBackupSettings = settingsBuilder.updateBackupSettings().build();
    updateBackupOperationSettings = settingsBuilder.updateBackupOperationSettings().build();
    createBackupPolicySettings = settingsBuilder.createBackupPolicySettings().build();
    createBackupPolicyOperationSettings =
        settingsBuilder.createBackupPolicyOperationSettings().build();
    getBackupPolicySettings = settingsBuilder.getBackupPolicySettings().build();
    listBackupPoliciesSettings = settingsBuilder.listBackupPoliciesSettings().build();
    updateBackupPolicySettings = settingsBuilder.updateBackupPolicySettings().build();
    updateBackupPolicyOperationSettings =
        settingsBuilder.updateBackupPolicyOperationSettings().build();
    deleteBackupPolicySettings = settingsBuilder.deleteBackupPolicySettings().build();
    deleteBackupPolicyOperationSettings =
        settingsBuilder.deleteBackupPolicyOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for NetAppStubSettings. */
  public static class Builder extends StubSettings.Builder<NetAppStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListStoragePoolsRequest, ListStoragePoolsResponse, ListStoragePoolsPagedResponse>
        listStoragePoolsSettings;
    private final UnaryCallSettings.Builder<CreateStoragePoolRequest, Operation>
        createStoragePoolSettings;
    private final OperationCallSettings.Builder<
            CreateStoragePoolRequest, StoragePool, OperationMetadata>
        createStoragePoolOperationSettings;
    private final UnaryCallSettings.Builder<GetStoragePoolRequest, StoragePool>
        getStoragePoolSettings;
    private final UnaryCallSettings.Builder<UpdateStoragePoolRequest, Operation>
        updateStoragePoolSettings;
    private final OperationCallSettings.Builder<
            UpdateStoragePoolRequest, StoragePool, OperationMetadata>
        updateStoragePoolOperationSettings;
    private final UnaryCallSettings.Builder<DeleteStoragePoolRequest, Operation>
        deleteStoragePoolSettings;
    private final OperationCallSettings.Builder<DeleteStoragePoolRequest, Empty, OperationMetadata>
        deleteStoragePoolOperationSettings;
    private final PagedCallSettings.Builder<
            ListVolumesRequest, ListVolumesResponse, ListVolumesPagedResponse>
        listVolumesSettings;
    private final UnaryCallSettings.Builder<GetVolumeRequest, Volume> getVolumeSettings;
    private final UnaryCallSettings.Builder<CreateVolumeRequest, Operation> createVolumeSettings;
    private final OperationCallSettings.Builder<CreateVolumeRequest, Volume, OperationMetadata>
        createVolumeOperationSettings;
    private final UnaryCallSettings.Builder<UpdateVolumeRequest, Operation> updateVolumeSettings;
    private final OperationCallSettings.Builder<UpdateVolumeRequest, Volume, OperationMetadata>
        updateVolumeOperationSettings;
    private final UnaryCallSettings.Builder<DeleteVolumeRequest, Operation> deleteVolumeSettings;
    private final OperationCallSettings.Builder<DeleteVolumeRequest, Empty, OperationMetadata>
        deleteVolumeOperationSettings;
    private final UnaryCallSettings.Builder<RevertVolumeRequest, Operation> revertVolumeSettings;
    private final OperationCallSettings.Builder<RevertVolumeRequest, Volume, OperationMetadata>
        revertVolumeOperationSettings;
    private final PagedCallSettings.Builder<
            ListSnapshotsRequest, ListSnapshotsResponse, ListSnapshotsPagedResponse>
        listSnapshotsSettings;
    private final UnaryCallSettings.Builder<GetSnapshotRequest, Snapshot> getSnapshotSettings;
    private final UnaryCallSettings.Builder<CreateSnapshotRequest, Operation>
        createSnapshotSettings;
    private final OperationCallSettings.Builder<CreateSnapshotRequest, Snapshot, OperationMetadata>
        createSnapshotOperationSettings;
    private final UnaryCallSettings.Builder<DeleteSnapshotRequest, Operation>
        deleteSnapshotSettings;
    private final OperationCallSettings.Builder<DeleteSnapshotRequest, Empty, OperationMetadata>
        deleteSnapshotOperationSettings;
    private final UnaryCallSettings.Builder<UpdateSnapshotRequest, Operation>
        updateSnapshotSettings;
    private final OperationCallSettings.Builder<UpdateSnapshotRequest, Snapshot, OperationMetadata>
        updateSnapshotOperationSettings;
    private final PagedCallSettings.Builder<
            ListActiveDirectoriesRequest,
            ListActiveDirectoriesResponse,
            ListActiveDirectoriesPagedResponse>
        listActiveDirectoriesSettings;
    private final UnaryCallSettings.Builder<GetActiveDirectoryRequest, ActiveDirectory>
        getActiveDirectorySettings;
    private final UnaryCallSettings.Builder<CreateActiveDirectoryRequest, Operation>
        createActiveDirectorySettings;
    private final OperationCallSettings.Builder<
            CreateActiveDirectoryRequest, ActiveDirectory, OperationMetadata>
        createActiveDirectoryOperationSettings;
    private final UnaryCallSettings.Builder<UpdateActiveDirectoryRequest, Operation>
        updateActiveDirectorySettings;
    private final OperationCallSettings.Builder<
            UpdateActiveDirectoryRequest, ActiveDirectory, OperationMetadata>
        updateActiveDirectoryOperationSettings;
    private final UnaryCallSettings.Builder<DeleteActiveDirectoryRequest, Operation>
        deleteActiveDirectorySettings;
    private final OperationCallSettings.Builder<
            DeleteActiveDirectoryRequest, Empty, OperationMetadata>
        deleteActiveDirectoryOperationSettings;
    private final PagedCallSettings.Builder<
            ListKmsConfigsRequest, ListKmsConfigsResponse, ListKmsConfigsPagedResponse>
        listKmsConfigsSettings;
    private final UnaryCallSettings.Builder<CreateKmsConfigRequest, Operation>
        createKmsConfigSettings;
    private final OperationCallSettings.Builder<
            CreateKmsConfigRequest, KmsConfig, OperationMetadata>
        createKmsConfigOperationSettings;
    private final UnaryCallSettings.Builder<GetKmsConfigRequest, KmsConfig> getKmsConfigSettings;
    private final UnaryCallSettings.Builder<UpdateKmsConfigRequest, Operation>
        updateKmsConfigSettings;
    private final OperationCallSettings.Builder<
            UpdateKmsConfigRequest, KmsConfig, OperationMetadata>
        updateKmsConfigOperationSettings;
    private final UnaryCallSettings.Builder<EncryptVolumesRequest, Operation>
        encryptVolumesSettings;
    private final OperationCallSettings.Builder<EncryptVolumesRequest, KmsConfig, OperationMetadata>
        encryptVolumesOperationSettings;
    private final UnaryCallSettings.Builder<VerifyKmsConfigRequest, VerifyKmsConfigResponse>
        verifyKmsConfigSettings;
    private final UnaryCallSettings.Builder<DeleteKmsConfigRequest, Operation>
        deleteKmsConfigSettings;
    private final OperationCallSettings.Builder<DeleteKmsConfigRequest, Empty, OperationMetadata>
        deleteKmsConfigOperationSettings;
    private final PagedCallSettings.Builder<
            ListReplicationsRequest, ListReplicationsResponse, ListReplicationsPagedResponse>
        listReplicationsSettings;
    private final UnaryCallSettings.Builder<GetReplicationRequest, Replication>
        getReplicationSettings;
    private final UnaryCallSettings.Builder<CreateReplicationRequest, Operation>
        createReplicationSettings;
    private final OperationCallSettings.Builder<
            CreateReplicationRequest, Replication, OperationMetadata>
        createReplicationOperationSettings;
    private final UnaryCallSettings.Builder<DeleteReplicationRequest, Operation>
        deleteReplicationSettings;
    private final OperationCallSettings.Builder<DeleteReplicationRequest, Empty, OperationMetadata>
        deleteReplicationOperationSettings;
    private final UnaryCallSettings.Builder<UpdateReplicationRequest, Operation>
        updateReplicationSettings;
    private final OperationCallSettings.Builder<
            UpdateReplicationRequest, Replication, OperationMetadata>
        updateReplicationOperationSettings;
    private final UnaryCallSettings.Builder<StopReplicationRequest, Operation>
        stopReplicationSettings;
    private final OperationCallSettings.Builder<
            StopReplicationRequest, Replication, OperationMetadata>
        stopReplicationOperationSettings;
    private final UnaryCallSettings.Builder<ResumeReplicationRequest, Operation>
        resumeReplicationSettings;
    private final OperationCallSettings.Builder<
            ResumeReplicationRequest, Replication, OperationMetadata>
        resumeReplicationOperationSettings;
    private final UnaryCallSettings.Builder<ReverseReplicationDirectionRequest, Operation>
        reverseReplicationDirectionSettings;
    private final OperationCallSettings.Builder<
            ReverseReplicationDirectionRequest, Replication, OperationMetadata>
        reverseReplicationDirectionOperationSettings;
    private final UnaryCallSettings.Builder<CreateBackupVaultRequest, Operation>
        createBackupVaultSettings;
    private final OperationCallSettings.Builder<
            CreateBackupVaultRequest, BackupVault, OperationMetadata>
        createBackupVaultOperationSettings;
    private final UnaryCallSettings.Builder<GetBackupVaultRequest, BackupVault>
        getBackupVaultSettings;
    private final PagedCallSettings.Builder<
            ListBackupVaultsRequest, ListBackupVaultsResponse, ListBackupVaultsPagedResponse>
        listBackupVaultsSettings;
    private final UnaryCallSettings.Builder<UpdateBackupVaultRequest, Operation>
        updateBackupVaultSettings;
    private final OperationCallSettings.Builder<
            UpdateBackupVaultRequest, BackupVault, OperationMetadata>
        updateBackupVaultOperationSettings;
    private final UnaryCallSettings.Builder<DeleteBackupVaultRequest, Operation>
        deleteBackupVaultSettings;
    private final OperationCallSettings.Builder<DeleteBackupVaultRequest, Empty, OperationMetadata>
        deleteBackupVaultOperationSettings;
    private final UnaryCallSettings.Builder<CreateBackupRequest, Operation> createBackupSettings;
    private final OperationCallSettings.Builder<CreateBackupRequest, Backup, OperationMetadata>
        createBackupOperationSettings;
    private final UnaryCallSettings.Builder<GetBackupRequest, Backup> getBackupSettings;
    private final PagedCallSettings.Builder<
            ListBackupsRequest, ListBackupsResponse, ListBackupsPagedResponse>
        listBackupsSettings;
    private final UnaryCallSettings.Builder<DeleteBackupRequest, Operation> deleteBackupSettings;
    private final OperationCallSettings.Builder<DeleteBackupRequest, Empty, OperationMetadata>
        deleteBackupOperationSettings;
    private final UnaryCallSettings.Builder<UpdateBackupRequest, Operation> updateBackupSettings;
    private final OperationCallSettings.Builder<UpdateBackupRequest, Backup, OperationMetadata>
        updateBackupOperationSettings;
    private final UnaryCallSettings.Builder<CreateBackupPolicyRequest, Operation>
        createBackupPolicySettings;
    private final OperationCallSettings.Builder<
            CreateBackupPolicyRequest, BackupPolicy, OperationMetadata>
        createBackupPolicyOperationSettings;
    private final UnaryCallSettings.Builder<GetBackupPolicyRequest, BackupPolicy>
        getBackupPolicySettings;
    private final PagedCallSettings.Builder<
            ListBackupPoliciesRequest, ListBackupPoliciesResponse, ListBackupPoliciesPagedResponse>
        listBackupPoliciesSettings;
    private final UnaryCallSettings.Builder<UpdateBackupPolicyRequest, Operation>
        updateBackupPolicySettings;
    private final OperationCallSettings.Builder<
            UpdateBackupPolicyRequest, BackupPolicy, OperationMetadata>
        updateBackupPolicyOperationSettings;
    private final UnaryCallSettings.Builder<DeleteBackupPolicyRequest, Operation>
        deleteBackupPolicySettings;
    private final OperationCallSettings.Builder<DeleteBackupPolicyRequest, Empty, OperationMetadata>
        deleteBackupPolicyOperationSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(10000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listStoragePoolsSettings = PagedCallSettings.newBuilder(LIST_STORAGE_POOLS_PAGE_STR_FACT);
      createStoragePoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createStoragePoolOperationSettings = OperationCallSettings.newBuilder();
      getStoragePoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateStoragePoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateStoragePoolOperationSettings = OperationCallSettings.newBuilder();
      deleteStoragePoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteStoragePoolOperationSettings = OperationCallSettings.newBuilder();
      listVolumesSettings = PagedCallSettings.newBuilder(LIST_VOLUMES_PAGE_STR_FACT);
      getVolumeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createVolumeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createVolumeOperationSettings = OperationCallSettings.newBuilder();
      updateVolumeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateVolumeOperationSettings = OperationCallSettings.newBuilder();
      deleteVolumeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteVolumeOperationSettings = OperationCallSettings.newBuilder();
      revertVolumeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      revertVolumeOperationSettings = OperationCallSettings.newBuilder();
      listSnapshotsSettings = PagedCallSettings.newBuilder(LIST_SNAPSHOTS_PAGE_STR_FACT);
      getSnapshotSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createSnapshotSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createSnapshotOperationSettings = OperationCallSettings.newBuilder();
      deleteSnapshotSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteSnapshotOperationSettings = OperationCallSettings.newBuilder();
      updateSnapshotSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSnapshotOperationSettings = OperationCallSettings.newBuilder();
      listActiveDirectoriesSettings =
          PagedCallSettings.newBuilder(LIST_ACTIVE_DIRECTORIES_PAGE_STR_FACT);
      getActiveDirectorySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createActiveDirectorySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createActiveDirectoryOperationSettings = OperationCallSettings.newBuilder();
      updateActiveDirectorySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateActiveDirectoryOperationSettings = OperationCallSettings.newBuilder();
      deleteActiveDirectorySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteActiveDirectoryOperationSettings = OperationCallSettings.newBuilder();
      listKmsConfigsSettings = PagedCallSettings.newBuilder(LIST_KMS_CONFIGS_PAGE_STR_FACT);
      createKmsConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createKmsConfigOperationSettings = OperationCallSettings.newBuilder();
      getKmsConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateKmsConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateKmsConfigOperationSettings = OperationCallSettings.newBuilder();
      encryptVolumesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      encryptVolumesOperationSettings = OperationCallSettings.newBuilder();
      verifyKmsConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteKmsConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteKmsConfigOperationSettings = OperationCallSettings.newBuilder();
      listReplicationsSettings = PagedCallSettings.newBuilder(LIST_REPLICATIONS_PAGE_STR_FACT);
      getReplicationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createReplicationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createReplicationOperationSettings = OperationCallSettings.newBuilder();
      deleteReplicationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteReplicationOperationSettings = OperationCallSettings.newBuilder();
      updateReplicationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateReplicationOperationSettings = OperationCallSettings.newBuilder();
      stopReplicationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      stopReplicationOperationSettings = OperationCallSettings.newBuilder();
      resumeReplicationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      resumeReplicationOperationSettings = OperationCallSettings.newBuilder();
      reverseReplicationDirectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      reverseReplicationDirectionOperationSettings = OperationCallSettings.newBuilder();
      createBackupVaultSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createBackupVaultOperationSettings = OperationCallSettings.newBuilder();
      getBackupVaultSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listBackupVaultsSettings = PagedCallSettings.newBuilder(LIST_BACKUP_VAULTS_PAGE_STR_FACT);
      updateBackupVaultSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateBackupVaultOperationSettings = OperationCallSettings.newBuilder();
      deleteBackupVaultSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteBackupVaultOperationSettings = OperationCallSettings.newBuilder();
      createBackupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createBackupOperationSettings = OperationCallSettings.newBuilder();
      getBackupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listBackupsSettings = PagedCallSettings.newBuilder(LIST_BACKUPS_PAGE_STR_FACT);
      deleteBackupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteBackupOperationSettings = OperationCallSettings.newBuilder();
      updateBackupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateBackupOperationSettings = OperationCallSettings.newBuilder();
      createBackupPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createBackupPolicyOperationSettings = OperationCallSettings.newBuilder();
      getBackupPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listBackupPoliciesSettings = PagedCallSettings.newBuilder(LIST_BACKUP_POLICIES_PAGE_STR_FACT);
      updateBackupPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateBackupPolicyOperationSettings = OperationCallSettings.newBuilder();
      deleteBackupPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteBackupPolicyOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listStoragePoolsSettings,
              createStoragePoolSettings,
              getStoragePoolSettings,
              updateStoragePoolSettings,
              deleteStoragePoolSettings,
              listVolumesSettings,
              getVolumeSettings,
              createVolumeSettings,
              updateVolumeSettings,
              deleteVolumeSettings,
              revertVolumeSettings,
              listSnapshotsSettings,
              getSnapshotSettings,
              createSnapshotSettings,
              deleteSnapshotSettings,
              updateSnapshotSettings,
              listActiveDirectoriesSettings,
              getActiveDirectorySettings,
              createActiveDirectorySettings,
              updateActiveDirectorySettings,
              deleteActiveDirectorySettings,
              listKmsConfigsSettings,
              createKmsConfigSettings,
              getKmsConfigSettings,
              updateKmsConfigSettings,
              encryptVolumesSettings,
              verifyKmsConfigSettings,
              deleteKmsConfigSettings,
              listReplicationsSettings,
              getReplicationSettings,
              createReplicationSettings,
              deleteReplicationSettings,
              updateReplicationSettings,
              stopReplicationSettings,
              resumeReplicationSettings,
              reverseReplicationDirectionSettings,
              createBackupVaultSettings,
              getBackupVaultSettings,
              listBackupVaultsSettings,
              updateBackupVaultSettings,
              deleteBackupVaultSettings,
              createBackupSettings,
              getBackupSettings,
              listBackupsSettings,
              deleteBackupSettings,
              updateBackupSettings,
              createBackupPolicySettings,
              getBackupPolicySettings,
              listBackupPoliciesSettings,
              updateBackupPolicySettings,
              deleteBackupPolicySettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(NetAppStubSettings settings) {
      super(settings);

      listStoragePoolsSettings = settings.listStoragePoolsSettings.toBuilder();
      createStoragePoolSettings = settings.createStoragePoolSettings.toBuilder();
      createStoragePoolOperationSettings = settings.createStoragePoolOperationSettings.toBuilder();
      getStoragePoolSettings = settings.getStoragePoolSettings.toBuilder();
      updateStoragePoolSettings = settings.updateStoragePoolSettings.toBuilder();
      updateStoragePoolOperationSettings = settings.updateStoragePoolOperationSettings.toBuilder();
      deleteStoragePoolSettings = settings.deleteStoragePoolSettings.toBuilder();
      deleteStoragePoolOperationSettings = settings.deleteStoragePoolOperationSettings.toBuilder();
      listVolumesSettings = settings.listVolumesSettings.toBuilder();
      getVolumeSettings = settings.getVolumeSettings.toBuilder();
      createVolumeSettings = settings.createVolumeSettings.toBuilder();
      createVolumeOperationSettings = settings.createVolumeOperationSettings.toBuilder();
      updateVolumeSettings = settings.updateVolumeSettings.toBuilder();
      updateVolumeOperationSettings = settings.updateVolumeOperationSettings.toBuilder();
      deleteVolumeSettings = settings.deleteVolumeSettings.toBuilder();
      deleteVolumeOperationSettings = settings.deleteVolumeOperationSettings.toBuilder();
      revertVolumeSettings = settings.revertVolumeSettings.toBuilder();
      revertVolumeOperationSettings = settings.revertVolumeOperationSettings.toBuilder();
      listSnapshotsSettings = settings.listSnapshotsSettings.toBuilder();
      getSnapshotSettings = settings.getSnapshotSettings.toBuilder();
      createSnapshotSettings = settings.createSnapshotSettings.toBuilder();
      createSnapshotOperationSettings = settings.createSnapshotOperationSettings.toBuilder();
      deleteSnapshotSettings = settings.deleteSnapshotSettings.toBuilder();
      deleteSnapshotOperationSettings = settings.deleteSnapshotOperationSettings.toBuilder();
      updateSnapshotSettings = settings.updateSnapshotSettings.toBuilder();
      updateSnapshotOperationSettings = settings.updateSnapshotOperationSettings.toBuilder();
      listActiveDirectoriesSettings = settings.listActiveDirectoriesSettings.toBuilder();
      getActiveDirectorySettings = settings.getActiveDirectorySettings.toBuilder();
      createActiveDirectorySettings = settings.createActiveDirectorySettings.toBuilder();
      createActiveDirectoryOperationSettings =
          settings.createActiveDirectoryOperationSettings.toBuilder();
      updateActiveDirectorySettings = settings.updateActiveDirectorySettings.toBuilder();
      updateActiveDirectoryOperationSettings =
          settings.updateActiveDirectoryOperationSettings.toBuilder();
      deleteActiveDirectorySettings = settings.deleteActiveDirectorySettings.toBuilder();
      deleteActiveDirectoryOperationSettings =
          settings.deleteActiveDirectoryOperationSettings.toBuilder();
      listKmsConfigsSettings = settings.listKmsConfigsSettings.toBuilder();
      createKmsConfigSettings = settings.createKmsConfigSettings.toBuilder();
      createKmsConfigOperationSettings = settings.createKmsConfigOperationSettings.toBuilder();
      getKmsConfigSettings = settings.getKmsConfigSettings.toBuilder();
      updateKmsConfigSettings = settings.updateKmsConfigSettings.toBuilder();
      updateKmsConfigOperationSettings = settings.updateKmsConfigOperationSettings.toBuilder();
      encryptVolumesSettings = settings.encryptVolumesSettings.toBuilder();
      encryptVolumesOperationSettings = settings.encryptVolumesOperationSettings.toBuilder();
      verifyKmsConfigSettings = settings.verifyKmsConfigSettings.toBuilder();
      deleteKmsConfigSettings = settings.deleteKmsConfigSettings.toBuilder();
      deleteKmsConfigOperationSettings = settings.deleteKmsConfigOperationSettings.toBuilder();
      listReplicationsSettings = settings.listReplicationsSettings.toBuilder();
      getReplicationSettings = settings.getReplicationSettings.toBuilder();
      createReplicationSettings = settings.createReplicationSettings.toBuilder();
      createReplicationOperationSettings = settings.createReplicationOperationSettings.toBuilder();
      deleteReplicationSettings = settings.deleteReplicationSettings.toBuilder();
      deleteReplicationOperationSettings = settings.deleteReplicationOperationSettings.toBuilder();
      updateReplicationSettings = settings.updateReplicationSettings.toBuilder();
      updateReplicationOperationSettings = settings.updateReplicationOperationSettings.toBuilder();
      stopReplicationSettings = settings.stopReplicationSettings.toBuilder();
      stopReplicationOperationSettings = settings.stopReplicationOperationSettings.toBuilder();
      resumeReplicationSettings = settings.resumeReplicationSettings.toBuilder();
      resumeReplicationOperationSettings = settings.resumeReplicationOperationSettings.toBuilder();
      reverseReplicationDirectionSettings =
          settings.reverseReplicationDirectionSettings.toBuilder();
      reverseReplicationDirectionOperationSettings =
          settings.reverseReplicationDirectionOperationSettings.toBuilder();
      createBackupVaultSettings = settings.createBackupVaultSettings.toBuilder();
      createBackupVaultOperationSettings = settings.createBackupVaultOperationSettings.toBuilder();
      getBackupVaultSettings = settings.getBackupVaultSettings.toBuilder();
      listBackupVaultsSettings = settings.listBackupVaultsSettings.toBuilder();
      updateBackupVaultSettings = settings.updateBackupVaultSettings.toBuilder();
      updateBackupVaultOperationSettings = settings.updateBackupVaultOperationSettings.toBuilder();
      deleteBackupVaultSettings = settings.deleteBackupVaultSettings.toBuilder();
      deleteBackupVaultOperationSettings = settings.deleteBackupVaultOperationSettings.toBuilder();
      createBackupSettings = settings.createBackupSettings.toBuilder();
      createBackupOperationSettings = settings.createBackupOperationSettings.toBuilder();
      getBackupSettings = settings.getBackupSettings.toBuilder();
      listBackupsSettings = settings.listBackupsSettings.toBuilder();
      deleteBackupSettings = settings.deleteBackupSettings.toBuilder();
      deleteBackupOperationSettings = settings.deleteBackupOperationSettings.toBuilder();
      updateBackupSettings = settings.updateBackupSettings.toBuilder();
      updateBackupOperationSettings = settings.updateBackupOperationSettings.toBuilder();
      createBackupPolicySettings = settings.createBackupPolicySettings.toBuilder();
      createBackupPolicyOperationSettings =
          settings.createBackupPolicyOperationSettings.toBuilder();
      getBackupPolicySettings = settings.getBackupPolicySettings.toBuilder();
      listBackupPoliciesSettings = settings.listBackupPoliciesSettings.toBuilder();
      updateBackupPolicySettings = settings.updateBackupPolicySettings.toBuilder();
      updateBackupPolicyOperationSettings =
          settings.updateBackupPolicyOperationSettings.toBuilder();
      deleteBackupPolicySettings = settings.deleteBackupPolicySettings.toBuilder();
      deleteBackupPolicyOperationSettings =
          settings.deleteBackupPolicyOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listStoragePoolsSettings,
              createStoragePoolSettings,
              getStoragePoolSettings,
              updateStoragePoolSettings,
              deleteStoragePoolSettings,
              listVolumesSettings,
              getVolumeSettings,
              createVolumeSettings,
              updateVolumeSettings,
              deleteVolumeSettings,
              revertVolumeSettings,
              listSnapshotsSettings,
              getSnapshotSettings,
              createSnapshotSettings,
              deleteSnapshotSettings,
              updateSnapshotSettings,
              listActiveDirectoriesSettings,
              getActiveDirectorySettings,
              createActiveDirectorySettings,
              updateActiveDirectorySettings,
              deleteActiveDirectorySettings,
              listKmsConfigsSettings,
              createKmsConfigSettings,
              getKmsConfigSettings,
              updateKmsConfigSettings,
              encryptVolumesSettings,
              verifyKmsConfigSettings,
              deleteKmsConfigSettings,
              listReplicationsSettings,
              getReplicationSettings,
              createReplicationSettings,
              deleteReplicationSettings,
              updateReplicationSettings,
              stopReplicationSettings,
              resumeReplicationSettings,
              reverseReplicationDirectionSettings,
              createBackupVaultSettings,
              getBackupVaultSettings,
              listBackupVaultsSettings,
              updateBackupVaultSettings,
              deleteBackupVaultSettings,
              createBackupSettings,
              getBackupSettings,
              listBackupsSettings,
              deleteBackupSettings,
              updateBackupSettings,
              createBackupPolicySettings,
              getBackupPolicySettings,
              listBackupPoliciesSettings,
              updateBackupPolicySettings,
              deleteBackupPolicySettings,
              listLocationsSettings,
              getLocationSettings);
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
          .listStoragePoolsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createStoragePoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getStoragePoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateStoragePoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteStoragePoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listVolumesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getVolumeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createVolumeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateVolumeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteVolumeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .revertVolumeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listSnapshotsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getSnapshotSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createSnapshotSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteSnapshotSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateSnapshotSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listActiveDirectoriesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getActiveDirectorySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createActiveDirectorySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateActiveDirectorySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteActiveDirectorySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listKmsConfigsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createKmsConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getKmsConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateKmsConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .encryptVolumesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .verifyKmsConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteKmsConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listReplicationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getReplicationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createReplicationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteReplicationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateReplicationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .stopReplicationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .resumeReplicationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .reverseReplicationDirectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createBackupVaultSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getBackupVaultSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listBackupVaultsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateBackupVaultSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteBackupVaultSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createBackupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getBackupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listBackupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteBackupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateBackupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createBackupPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getBackupPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listBackupPoliciesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateBackupPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteBackupPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createStoragePoolOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateStoragePoolRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(StoragePool.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateStoragePoolOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateStoragePoolRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(StoragePool.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteStoragePoolOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteStoragePoolRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createVolumeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateVolumeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Volume.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateVolumeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateVolumeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Volume.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteVolumeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteVolumeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .revertVolumeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RevertVolumeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Volume.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createSnapshotOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateSnapshotRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Snapshot.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteSnapshotOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteSnapshotRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateSnapshotOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateSnapshotRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Snapshot.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createActiveDirectoryOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateActiveDirectoryRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ActiveDirectory.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateActiveDirectoryOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateActiveDirectoryRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ActiveDirectory.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteActiveDirectoryOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteActiveDirectoryRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createKmsConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateKmsConfigRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(KmsConfig.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateKmsConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateKmsConfigRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(KmsConfig.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .encryptVolumesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<EncryptVolumesRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(KmsConfig.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteKmsConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteKmsConfigRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createReplicationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateReplicationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Replication.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteReplicationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteReplicationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateReplicationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateReplicationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Replication.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .stopReplicationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<StopReplicationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Replication.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .resumeReplicationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ResumeReplicationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Replication.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .reverseReplicationDirectionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ReverseReplicationDirectionRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Replication.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createBackupVaultOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateBackupVaultRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(BackupVault.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateBackupVaultOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateBackupVaultRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(BackupVault.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteBackupVaultOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteBackupVaultRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createBackupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateBackupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Backup.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteBackupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteBackupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateBackupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateBackupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Backup.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createBackupPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateBackupPolicyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(BackupPolicy.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateBackupPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateBackupPolicyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(BackupPolicy.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteBackupPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteBackupPolicyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

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

    /** Returns the builder for the settings used for calls to listStoragePools. */
    public PagedCallSettings.Builder<
            ListStoragePoolsRequest, ListStoragePoolsResponse, ListStoragePoolsPagedResponse>
        listStoragePoolsSettings() {
      return listStoragePoolsSettings;
    }

    /** Returns the builder for the settings used for calls to createStoragePool. */
    public UnaryCallSettings.Builder<CreateStoragePoolRequest, Operation>
        createStoragePoolSettings() {
      return createStoragePoolSettings;
    }

    /** Returns the builder for the settings used for calls to createStoragePool. */
    public OperationCallSettings.Builder<CreateStoragePoolRequest, StoragePool, OperationMetadata>
        createStoragePoolOperationSettings() {
      return createStoragePoolOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getStoragePool. */
    public UnaryCallSettings.Builder<GetStoragePoolRequest, StoragePool> getStoragePoolSettings() {
      return getStoragePoolSettings;
    }

    /** Returns the builder for the settings used for calls to updateStoragePool. */
    public UnaryCallSettings.Builder<UpdateStoragePoolRequest, Operation>
        updateStoragePoolSettings() {
      return updateStoragePoolSettings;
    }

    /** Returns the builder for the settings used for calls to updateStoragePool. */
    public OperationCallSettings.Builder<UpdateStoragePoolRequest, StoragePool, OperationMetadata>
        updateStoragePoolOperationSettings() {
      return updateStoragePoolOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteStoragePool. */
    public UnaryCallSettings.Builder<DeleteStoragePoolRequest, Operation>
        deleteStoragePoolSettings() {
      return deleteStoragePoolSettings;
    }

    /** Returns the builder for the settings used for calls to deleteStoragePool. */
    public OperationCallSettings.Builder<DeleteStoragePoolRequest, Empty, OperationMetadata>
        deleteStoragePoolOperationSettings() {
      return deleteStoragePoolOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listVolumes. */
    public PagedCallSettings.Builder<
            ListVolumesRequest, ListVolumesResponse, ListVolumesPagedResponse>
        listVolumesSettings() {
      return listVolumesSettings;
    }

    /** Returns the builder for the settings used for calls to getVolume. */
    public UnaryCallSettings.Builder<GetVolumeRequest, Volume> getVolumeSettings() {
      return getVolumeSettings;
    }

    /** Returns the builder for the settings used for calls to createVolume. */
    public UnaryCallSettings.Builder<CreateVolumeRequest, Operation> createVolumeSettings() {
      return createVolumeSettings;
    }

    /** Returns the builder for the settings used for calls to createVolume. */
    public OperationCallSettings.Builder<CreateVolumeRequest, Volume, OperationMetadata>
        createVolumeOperationSettings() {
      return createVolumeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateVolume. */
    public UnaryCallSettings.Builder<UpdateVolumeRequest, Operation> updateVolumeSettings() {
      return updateVolumeSettings;
    }

    /** Returns the builder for the settings used for calls to updateVolume. */
    public OperationCallSettings.Builder<UpdateVolumeRequest, Volume, OperationMetadata>
        updateVolumeOperationSettings() {
      return updateVolumeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteVolume. */
    public UnaryCallSettings.Builder<DeleteVolumeRequest, Operation> deleteVolumeSettings() {
      return deleteVolumeSettings;
    }

    /** Returns the builder for the settings used for calls to deleteVolume. */
    public OperationCallSettings.Builder<DeleteVolumeRequest, Empty, OperationMetadata>
        deleteVolumeOperationSettings() {
      return deleteVolumeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to revertVolume. */
    public UnaryCallSettings.Builder<RevertVolumeRequest, Operation> revertVolumeSettings() {
      return revertVolumeSettings;
    }

    /** Returns the builder for the settings used for calls to revertVolume. */
    public OperationCallSettings.Builder<RevertVolumeRequest, Volume, OperationMetadata>
        revertVolumeOperationSettings() {
      return revertVolumeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listSnapshots. */
    public PagedCallSettings.Builder<
            ListSnapshotsRequest, ListSnapshotsResponse, ListSnapshotsPagedResponse>
        listSnapshotsSettings() {
      return listSnapshotsSettings;
    }

    /** Returns the builder for the settings used for calls to getSnapshot. */
    public UnaryCallSettings.Builder<GetSnapshotRequest, Snapshot> getSnapshotSettings() {
      return getSnapshotSettings;
    }

    /** Returns the builder for the settings used for calls to createSnapshot. */
    public UnaryCallSettings.Builder<CreateSnapshotRequest, Operation> createSnapshotSettings() {
      return createSnapshotSettings;
    }

    /** Returns the builder for the settings used for calls to createSnapshot. */
    public OperationCallSettings.Builder<CreateSnapshotRequest, Snapshot, OperationMetadata>
        createSnapshotOperationSettings() {
      return createSnapshotOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSnapshot. */
    public UnaryCallSettings.Builder<DeleteSnapshotRequest, Operation> deleteSnapshotSettings() {
      return deleteSnapshotSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSnapshot. */
    public OperationCallSettings.Builder<DeleteSnapshotRequest, Empty, OperationMetadata>
        deleteSnapshotOperationSettings() {
      return deleteSnapshotOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateSnapshot. */
    public UnaryCallSettings.Builder<UpdateSnapshotRequest, Operation> updateSnapshotSettings() {
      return updateSnapshotSettings;
    }

    /** Returns the builder for the settings used for calls to updateSnapshot. */
    public OperationCallSettings.Builder<UpdateSnapshotRequest, Snapshot, OperationMetadata>
        updateSnapshotOperationSettings() {
      return updateSnapshotOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listActiveDirectories. */
    public PagedCallSettings.Builder<
            ListActiveDirectoriesRequest,
            ListActiveDirectoriesResponse,
            ListActiveDirectoriesPagedResponse>
        listActiveDirectoriesSettings() {
      return listActiveDirectoriesSettings;
    }

    /** Returns the builder for the settings used for calls to getActiveDirectory. */
    public UnaryCallSettings.Builder<GetActiveDirectoryRequest, ActiveDirectory>
        getActiveDirectorySettings() {
      return getActiveDirectorySettings;
    }

    /** Returns the builder for the settings used for calls to createActiveDirectory. */
    public UnaryCallSettings.Builder<CreateActiveDirectoryRequest, Operation>
        createActiveDirectorySettings() {
      return createActiveDirectorySettings;
    }

    /** Returns the builder for the settings used for calls to createActiveDirectory. */
    public OperationCallSettings.Builder<
            CreateActiveDirectoryRequest, ActiveDirectory, OperationMetadata>
        createActiveDirectoryOperationSettings() {
      return createActiveDirectoryOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateActiveDirectory. */
    public UnaryCallSettings.Builder<UpdateActiveDirectoryRequest, Operation>
        updateActiveDirectorySettings() {
      return updateActiveDirectorySettings;
    }

    /** Returns the builder for the settings used for calls to updateActiveDirectory. */
    public OperationCallSettings.Builder<
            UpdateActiveDirectoryRequest, ActiveDirectory, OperationMetadata>
        updateActiveDirectoryOperationSettings() {
      return updateActiveDirectoryOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteActiveDirectory. */
    public UnaryCallSettings.Builder<DeleteActiveDirectoryRequest, Operation>
        deleteActiveDirectorySettings() {
      return deleteActiveDirectorySettings;
    }

    /** Returns the builder for the settings used for calls to deleteActiveDirectory. */
    public OperationCallSettings.Builder<DeleteActiveDirectoryRequest, Empty, OperationMetadata>
        deleteActiveDirectoryOperationSettings() {
      return deleteActiveDirectoryOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listKmsConfigs. */
    public PagedCallSettings.Builder<
            ListKmsConfigsRequest, ListKmsConfigsResponse, ListKmsConfigsPagedResponse>
        listKmsConfigsSettings() {
      return listKmsConfigsSettings;
    }

    /** Returns the builder for the settings used for calls to createKmsConfig. */
    public UnaryCallSettings.Builder<CreateKmsConfigRequest, Operation> createKmsConfigSettings() {
      return createKmsConfigSettings;
    }

    /** Returns the builder for the settings used for calls to createKmsConfig. */
    public OperationCallSettings.Builder<CreateKmsConfigRequest, KmsConfig, OperationMetadata>
        createKmsConfigOperationSettings() {
      return createKmsConfigOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getKmsConfig. */
    public UnaryCallSettings.Builder<GetKmsConfigRequest, KmsConfig> getKmsConfigSettings() {
      return getKmsConfigSettings;
    }

    /** Returns the builder for the settings used for calls to updateKmsConfig. */
    public UnaryCallSettings.Builder<UpdateKmsConfigRequest, Operation> updateKmsConfigSettings() {
      return updateKmsConfigSettings;
    }

    /** Returns the builder for the settings used for calls to updateKmsConfig. */
    public OperationCallSettings.Builder<UpdateKmsConfigRequest, KmsConfig, OperationMetadata>
        updateKmsConfigOperationSettings() {
      return updateKmsConfigOperationSettings;
    }

    /** Returns the builder for the settings used for calls to encryptVolumes. */
    public UnaryCallSettings.Builder<EncryptVolumesRequest, Operation> encryptVolumesSettings() {
      return encryptVolumesSettings;
    }

    /** Returns the builder for the settings used for calls to encryptVolumes. */
    public OperationCallSettings.Builder<EncryptVolumesRequest, KmsConfig, OperationMetadata>
        encryptVolumesOperationSettings() {
      return encryptVolumesOperationSettings;
    }

    /** Returns the builder for the settings used for calls to verifyKmsConfig. */
    public UnaryCallSettings.Builder<VerifyKmsConfigRequest, VerifyKmsConfigResponse>
        verifyKmsConfigSettings() {
      return verifyKmsConfigSettings;
    }

    /** Returns the builder for the settings used for calls to deleteKmsConfig. */
    public UnaryCallSettings.Builder<DeleteKmsConfigRequest, Operation> deleteKmsConfigSettings() {
      return deleteKmsConfigSettings;
    }

    /** Returns the builder for the settings used for calls to deleteKmsConfig. */
    public OperationCallSettings.Builder<DeleteKmsConfigRequest, Empty, OperationMetadata>
        deleteKmsConfigOperationSettings() {
      return deleteKmsConfigOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listReplications. */
    public PagedCallSettings.Builder<
            ListReplicationsRequest, ListReplicationsResponse, ListReplicationsPagedResponse>
        listReplicationsSettings() {
      return listReplicationsSettings;
    }

    /** Returns the builder for the settings used for calls to getReplication. */
    public UnaryCallSettings.Builder<GetReplicationRequest, Replication> getReplicationSettings() {
      return getReplicationSettings;
    }

    /** Returns the builder for the settings used for calls to createReplication. */
    public UnaryCallSettings.Builder<CreateReplicationRequest, Operation>
        createReplicationSettings() {
      return createReplicationSettings;
    }

    /** Returns the builder for the settings used for calls to createReplication. */
    public OperationCallSettings.Builder<CreateReplicationRequest, Replication, OperationMetadata>
        createReplicationOperationSettings() {
      return createReplicationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteReplication. */
    public UnaryCallSettings.Builder<DeleteReplicationRequest, Operation>
        deleteReplicationSettings() {
      return deleteReplicationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteReplication. */
    public OperationCallSettings.Builder<DeleteReplicationRequest, Empty, OperationMetadata>
        deleteReplicationOperationSettings() {
      return deleteReplicationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateReplication. */
    public UnaryCallSettings.Builder<UpdateReplicationRequest, Operation>
        updateReplicationSettings() {
      return updateReplicationSettings;
    }

    /** Returns the builder for the settings used for calls to updateReplication. */
    public OperationCallSettings.Builder<UpdateReplicationRequest, Replication, OperationMetadata>
        updateReplicationOperationSettings() {
      return updateReplicationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to stopReplication. */
    public UnaryCallSettings.Builder<StopReplicationRequest, Operation> stopReplicationSettings() {
      return stopReplicationSettings;
    }

    /** Returns the builder for the settings used for calls to stopReplication. */
    public OperationCallSettings.Builder<StopReplicationRequest, Replication, OperationMetadata>
        stopReplicationOperationSettings() {
      return stopReplicationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to resumeReplication. */
    public UnaryCallSettings.Builder<ResumeReplicationRequest, Operation>
        resumeReplicationSettings() {
      return resumeReplicationSettings;
    }

    /** Returns the builder for the settings used for calls to resumeReplication. */
    public OperationCallSettings.Builder<ResumeReplicationRequest, Replication, OperationMetadata>
        resumeReplicationOperationSettings() {
      return resumeReplicationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to reverseReplicationDirection. */
    public UnaryCallSettings.Builder<ReverseReplicationDirectionRequest, Operation>
        reverseReplicationDirectionSettings() {
      return reverseReplicationDirectionSettings;
    }

    /** Returns the builder for the settings used for calls to reverseReplicationDirection. */
    public OperationCallSettings.Builder<
            ReverseReplicationDirectionRequest, Replication, OperationMetadata>
        reverseReplicationDirectionOperationSettings() {
      return reverseReplicationDirectionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createBackupVault. */
    public UnaryCallSettings.Builder<CreateBackupVaultRequest, Operation>
        createBackupVaultSettings() {
      return createBackupVaultSettings;
    }

    /** Returns the builder for the settings used for calls to createBackupVault. */
    public OperationCallSettings.Builder<CreateBackupVaultRequest, BackupVault, OperationMetadata>
        createBackupVaultOperationSettings() {
      return createBackupVaultOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getBackupVault. */
    public UnaryCallSettings.Builder<GetBackupVaultRequest, BackupVault> getBackupVaultSettings() {
      return getBackupVaultSettings;
    }

    /** Returns the builder for the settings used for calls to listBackupVaults. */
    public PagedCallSettings.Builder<
            ListBackupVaultsRequest, ListBackupVaultsResponse, ListBackupVaultsPagedResponse>
        listBackupVaultsSettings() {
      return listBackupVaultsSettings;
    }

    /** Returns the builder for the settings used for calls to updateBackupVault. */
    public UnaryCallSettings.Builder<UpdateBackupVaultRequest, Operation>
        updateBackupVaultSettings() {
      return updateBackupVaultSettings;
    }

    /** Returns the builder for the settings used for calls to updateBackupVault. */
    public OperationCallSettings.Builder<UpdateBackupVaultRequest, BackupVault, OperationMetadata>
        updateBackupVaultOperationSettings() {
      return updateBackupVaultOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteBackupVault. */
    public UnaryCallSettings.Builder<DeleteBackupVaultRequest, Operation>
        deleteBackupVaultSettings() {
      return deleteBackupVaultSettings;
    }

    /** Returns the builder for the settings used for calls to deleteBackupVault. */
    public OperationCallSettings.Builder<DeleteBackupVaultRequest, Empty, OperationMetadata>
        deleteBackupVaultOperationSettings() {
      return deleteBackupVaultOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createBackup. */
    public UnaryCallSettings.Builder<CreateBackupRequest, Operation> createBackupSettings() {
      return createBackupSettings;
    }

    /** Returns the builder for the settings used for calls to createBackup. */
    public OperationCallSettings.Builder<CreateBackupRequest, Backup, OperationMetadata>
        createBackupOperationSettings() {
      return createBackupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getBackup. */
    public UnaryCallSettings.Builder<GetBackupRequest, Backup> getBackupSettings() {
      return getBackupSettings;
    }

    /** Returns the builder for the settings used for calls to listBackups. */
    public PagedCallSettings.Builder<
            ListBackupsRequest, ListBackupsResponse, ListBackupsPagedResponse>
        listBackupsSettings() {
      return listBackupsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteBackup. */
    public UnaryCallSettings.Builder<DeleteBackupRequest, Operation> deleteBackupSettings() {
      return deleteBackupSettings;
    }

    /** Returns the builder for the settings used for calls to deleteBackup. */
    public OperationCallSettings.Builder<DeleteBackupRequest, Empty, OperationMetadata>
        deleteBackupOperationSettings() {
      return deleteBackupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateBackup. */
    public UnaryCallSettings.Builder<UpdateBackupRequest, Operation> updateBackupSettings() {
      return updateBackupSettings;
    }

    /** Returns the builder for the settings used for calls to updateBackup. */
    public OperationCallSettings.Builder<UpdateBackupRequest, Backup, OperationMetadata>
        updateBackupOperationSettings() {
      return updateBackupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createBackupPolicy. */
    public UnaryCallSettings.Builder<CreateBackupPolicyRequest, Operation>
        createBackupPolicySettings() {
      return createBackupPolicySettings;
    }

    /** Returns the builder for the settings used for calls to createBackupPolicy. */
    public OperationCallSettings.Builder<CreateBackupPolicyRequest, BackupPolicy, OperationMetadata>
        createBackupPolicyOperationSettings() {
      return createBackupPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getBackupPolicy. */
    public UnaryCallSettings.Builder<GetBackupPolicyRequest, BackupPolicy>
        getBackupPolicySettings() {
      return getBackupPolicySettings;
    }

    /** Returns the builder for the settings used for calls to listBackupPolicies. */
    public PagedCallSettings.Builder<
            ListBackupPoliciesRequest, ListBackupPoliciesResponse, ListBackupPoliciesPagedResponse>
        listBackupPoliciesSettings() {
      return listBackupPoliciesSettings;
    }

    /** Returns the builder for the settings used for calls to updateBackupPolicy. */
    public UnaryCallSettings.Builder<UpdateBackupPolicyRequest, Operation>
        updateBackupPolicySettings() {
      return updateBackupPolicySettings;
    }

    /** Returns the builder for the settings used for calls to updateBackupPolicy. */
    public OperationCallSettings.Builder<UpdateBackupPolicyRequest, BackupPolicy, OperationMetadata>
        updateBackupPolicyOperationSettings() {
      return updateBackupPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteBackupPolicy. */
    public UnaryCallSettings.Builder<DeleteBackupPolicyRequest, Operation>
        deleteBackupPolicySettings() {
      return deleteBackupPolicySettings;
    }

    /** Returns the builder for the settings used for calls to deleteBackupPolicy. */
    public OperationCallSettings.Builder<DeleteBackupPolicyRequest, Empty, OperationMetadata>
        deleteBackupPolicyOperationSettings() {
      return deleteBackupPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return listLocationsSettings;
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getLocationSettings;
    }

    @Override
    public NetAppStubSettings build() throws IOException {
      return new NetAppStubSettings(this);
    }
  }
}
