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

package com.google.cloud.baremetalsolution.v2.stub;

import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListInstancesPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListLocationsPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListLunsPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListNetworksPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListNfsSharesPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListOSImagesPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListProvisioningQuotasPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListSSHKeysPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListVolumeSnapshotsPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListVolumesPagedResponse;

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
import com.google.cloud.baremetalsolution.v2.CreateNfsShareRequest;
import com.google.cloud.baremetalsolution.v2.CreateProvisioningConfigRequest;
import com.google.cloud.baremetalsolution.v2.CreateSSHKeyRequest;
import com.google.cloud.baremetalsolution.v2.CreateVolumeSnapshotRequest;
import com.google.cloud.baremetalsolution.v2.DeleteNfsShareRequest;
import com.google.cloud.baremetalsolution.v2.DeleteSSHKeyRequest;
import com.google.cloud.baremetalsolution.v2.DeleteVolumeSnapshotRequest;
import com.google.cloud.baremetalsolution.v2.DetachLunRequest;
import com.google.cloud.baremetalsolution.v2.DisableInteractiveSerialConsoleRequest;
import com.google.cloud.baremetalsolution.v2.DisableInteractiveSerialConsoleResponse;
import com.google.cloud.baremetalsolution.v2.EnableInteractiveSerialConsoleRequest;
import com.google.cloud.baremetalsolution.v2.EnableInteractiveSerialConsoleResponse;
import com.google.cloud.baremetalsolution.v2.EvictLunRequest;
import com.google.cloud.baremetalsolution.v2.EvictVolumeRequest;
import com.google.cloud.baremetalsolution.v2.GetInstanceRequest;
import com.google.cloud.baremetalsolution.v2.GetLunRequest;
import com.google.cloud.baremetalsolution.v2.GetNetworkRequest;
import com.google.cloud.baremetalsolution.v2.GetNfsShareRequest;
import com.google.cloud.baremetalsolution.v2.GetProvisioningConfigRequest;
import com.google.cloud.baremetalsolution.v2.GetVolumeRequest;
import com.google.cloud.baremetalsolution.v2.GetVolumeSnapshotRequest;
import com.google.cloud.baremetalsolution.v2.Instance;
import com.google.cloud.baremetalsolution.v2.ListInstancesRequest;
import com.google.cloud.baremetalsolution.v2.ListInstancesResponse;
import com.google.cloud.baremetalsolution.v2.ListLunsRequest;
import com.google.cloud.baremetalsolution.v2.ListLunsResponse;
import com.google.cloud.baremetalsolution.v2.ListNetworkUsageRequest;
import com.google.cloud.baremetalsolution.v2.ListNetworkUsageResponse;
import com.google.cloud.baremetalsolution.v2.ListNetworksRequest;
import com.google.cloud.baremetalsolution.v2.ListNetworksResponse;
import com.google.cloud.baremetalsolution.v2.ListNfsSharesRequest;
import com.google.cloud.baremetalsolution.v2.ListNfsSharesResponse;
import com.google.cloud.baremetalsolution.v2.ListOSImagesRequest;
import com.google.cloud.baremetalsolution.v2.ListOSImagesResponse;
import com.google.cloud.baremetalsolution.v2.ListProvisioningQuotasRequest;
import com.google.cloud.baremetalsolution.v2.ListProvisioningQuotasResponse;
import com.google.cloud.baremetalsolution.v2.ListSSHKeysRequest;
import com.google.cloud.baremetalsolution.v2.ListSSHKeysResponse;
import com.google.cloud.baremetalsolution.v2.ListVolumeSnapshotsRequest;
import com.google.cloud.baremetalsolution.v2.ListVolumeSnapshotsResponse;
import com.google.cloud.baremetalsolution.v2.ListVolumesRequest;
import com.google.cloud.baremetalsolution.v2.ListVolumesResponse;
import com.google.cloud.baremetalsolution.v2.Lun;
import com.google.cloud.baremetalsolution.v2.Network;
import com.google.cloud.baremetalsolution.v2.NfsShare;
import com.google.cloud.baremetalsolution.v2.OSImage;
import com.google.cloud.baremetalsolution.v2.OperationMetadata;
import com.google.cloud.baremetalsolution.v2.ProvisioningConfig;
import com.google.cloud.baremetalsolution.v2.ProvisioningQuota;
import com.google.cloud.baremetalsolution.v2.RenameInstanceRequest;
import com.google.cloud.baremetalsolution.v2.RenameNetworkRequest;
import com.google.cloud.baremetalsolution.v2.RenameNfsShareRequest;
import com.google.cloud.baremetalsolution.v2.RenameVolumeRequest;
import com.google.cloud.baremetalsolution.v2.ResetInstanceRequest;
import com.google.cloud.baremetalsolution.v2.ResetInstanceResponse;
import com.google.cloud.baremetalsolution.v2.ResizeVolumeRequest;
import com.google.cloud.baremetalsolution.v2.RestoreVolumeSnapshotRequest;
import com.google.cloud.baremetalsolution.v2.SSHKey;
import com.google.cloud.baremetalsolution.v2.StartInstanceRequest;
import com.google.cloud.baremetalsolution.v2.StartInstanceResponse;
import com.google.cloud.baremetalsolution.v2.StopInstanceRequest;
import com.google.cloud.baremetalsolution.v2.StopInstanceResponse;
import com.google.cloud.baremetalsolution.v2.SubmitProvisioningConfigRequest;
import com.google.cloud.baremetalsolution.v2.SubmitProvisioningConfigResponse;
import com.google.cloud.baremetalsolution.v2.UpdateInstanceRequest;
import com.google.cloud.baremetalsolution.v2.UpdateNetworkRequest;
import com.google.cloud.baremetalsolution.v2.UpdateNfsShareRequest;
import com.google.cloud.baremetalsolution.v2.UpdateProvisioningConfigRequest;
import com.google.cloud.baremetalsolution.v2.UpdateVolumeRequest;
import com.google.cloud.baremetalsolution.v2.Volume;
import com.google.cloud.baremetalsolution.v2.VolumeSnapshot;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * Settings class to configure an instance of {@link BareMetalSolutionStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (baremetalsolution.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getInstance to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * BareMetalSolutionStubSettings.Builder bareMetalSolutionSettingsBuilder =
 *     BareMetalSolutionStubSettings.newBuilder();
 * bareMetalSolutionSettingsBuilder
 *     .getInstanceSettings()
 *     .setRetrySettings(
 *         bareMetalSolutionSettingsBuilder
 *             .getInstanceSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * BareMetalSolutionStubSettings bareMetalSolutionSettings =
 *     bareMetalSolutionSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class BareMetalSolutionStubSettings extends StubSettings<BareMetalSolutionStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
      listInstancesSettings;
  private final UnaryCallSettings<GetInstanceRequest, Instance> getInstanceSettings;
  private final UnaryCallSettings<UpdateInstanceRequest, Operation> updateInstanceSettings;
  private final OperationCallSettings<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationSettings;
  private final UnaryCallSettings<RenameInstanceRequest, Instance> renameInstanceSettings;
  private final UnaryCallSettings<ResetInstanceRequest, Operation> resetInstanceSettings;
  private final OperationCallSettings<
          ResetInstanceRequest, ResetInstanceResponse, OperationMetadata>
      resetInstanceOperationSettings;
  private final UnaryCallSettings<StartInstanceRequest, Operation> startInstanceSettings;
  private final OperationCallSettings<
          StartInstanceRequest, StartInstanceResponse, OperationMetadata>
      startInstanceOperationSettings;
  private final UnaryCallSettings<StopInstanceRequest, Operation> stopInstanceSettings;
  private final OperationCallSettings<StopInstanceRequest, StopInstanceResponse, OperationMetadata>
      stopInstanceOperationSettings;
  private final UnaryCallSettings<EnableInteractiveSerialConsoleRequest, Operation>
      enableInteractiveSerialConsoleSettings;
  private final OperationCallSettings<
          EnableInteractiveSerialConsoleRequest,
          EnableInteractiveSerialConsoleResponse,
          OperationMetadata>
      enableInteractiveSerialConsoleOperationSettings;
  private final UnaryCallSettings<DisableInteractiveSerialConsoleRequest, Operation>
      disableInteractiveSerialConsoleSettings;
  private final OperationCallSettings<
          DisableInteractiveSerialConsoleRequest,
          DisableInteractiveSerialConsoleResponse,
          OperationMetadata>
      disableInteractiveSerialConsoleOperationSettings;
  private final UnaryCallSettings<DetachLunRequest, Operation> detachLunSettings;
  private final OperationCallSettings<DetachLunRequest, Instance, OperationMetadata>
      detachLunOperationSettings;
  private final PagedCallSettings<ListSSHKeysRequest, ListSSHKeysResponse, ListSSHKeysPagedResponse>
      listSSHKeysSettings;
  private final UnaryCallSettings<CreateSSHKeyRequest, SSHKey> createSSHKeySettings;
  private final UnaryCallSettings<DeleteSSHKeyRequest, Empty> deleteSSHKeySettings;
  private final PagedCallSettings<ListVolumesRequest, ListVolumesResponse, ListVolumesPagedResponse>
      listVolumesSettings;
  private final UnaryCallSettings<GetVolumeRequest, Volume> getVolumeSettings;
  private final UnaryCallSettings<UpdateVolumeRequest, Operation> updateVolumeSettings;
  private final OperationCallSettings<UpdateVolumeRequest, Volume, OperationMetadata>
      updateVolumeOperationSettings;
  private final UnaryCallSettings<RenameVolumeRequest, Volume> renameVolumeSettings;
  private final UnaryCallSettings<EvictVolumeRequest, Operation> evictVolumeSettings;
  private final OperationCallSettings<EvictVolumeRequest, Empty, OperationMetadata>
      evictVolumeOperationSettings;
  private final UnaryCallSettings<ResizeVolumeRequest, Operation> resizeVolumeSettings;
  private final OperationCallSettings<ResizeVolumeRequest, Volume, OperationMetadata>
      resizeVolumeOperationSettings;
  private final PagedCallSettings<
          ListNetworksRequest, ListNetworksResponse, ListNetworksPagedResponse>
      listNetworksSettings;
  private final UnaryCallSettings<ListNetworkUsageRequest, ListNetworkUsageResponse>
      listNetworkUsageSettings;
  private final UnaryCallSettings<GetNetworkRequest, Network> getNetworkSettings;
  private final UnaryCallSettings<UpdateNetworkRequest, Operation> updateNetworkSettings;
  private final OperationCallSettings<UpdateNetworkRequest, Network, OperationMetadata>
      updateNetworkOperationSettings;
  private final UnaryCallSettings<CreateVolumeSnapshotRequest, VolumeSnapshot>
      createVolumeSnapshotSettings;
  private final UnaryCallSettings<RestoreVolumeSnapshotRequest, Operation>
      restoreVolumeSnapshotSettings;
  private final OperationCallSettings<
          RestoreVolumeSnapshotRequest, VolumeSnapshot, OperationMetadata>
      restoreVolumeSnapshotOperationSettings;
  private final UnaryCallSettings<DeleteVolumeSnapshotRequest, Empty> deleteVolumeSnapshotSettings;
  private final UnaryCallSettings<GetVolumeSnapshotRequest, VolumeSnapshot>
      getVolumeSnapshotSettings;
  private final PagedCallSettings<
          ListVolumeSnapshotsRequest, ListVolumeSnapshotsResponse, ListVolumeSnapshotsPagedResponse>
      listVolumeSnapshotsSettings;
  private final UnaryCallSettings<GetLunRequest, Lun> getLunSettings;
  private final PagedCallSettings<ListLunsRequest, ListLunsResponse, ListLunsPagedResponse>
      listLunsSettings;
  private final UnaryCallSettings<EvictLunRequest, Operation> evictLunSettings;
  private final OperationCallSettings<EvictLunRequest, Empty, OperationMetadata>
      evictLunOperationSettings;
  private final UnaryCallSettings<GetNfsShareRequest, NfsShare> getNfsShareSettings;
  private final PagedCallSettings<
          ListNfsSharesRequest, ListNfsSharesResponse, ListNfsSharesPagedResponse>
      listNfsSharesSettings;
  private final UnaryCallSettings<UpdateNfsShareRequest, Operation> updateNfsShareSettings;
  private final OperationCallSettings<UpdateNfsShareRequest, NfsShare, OperationMetadata>
      updateNfsShareOperationSettings;
  private final UnaryCallSettings<CreateNfsShareRequest, Operation> createNfsShareSettings;
  private final OperationCallSettings<CreateNfsShareRequest, NfsShare, OperationMetadata>
      createNfsShareOperationSettings;
  private final UnaryCallSettings<RenameNfsShareRequest, NfsShare> renameNfsShareSettings;
  private final UnaryCallSettings<DeleteNfsShareRequest, Operation> deleteNfsShareSettings;
  private final OperationCallSettings<DeleteNfsShareRequest, Empty, OperationMetadata>
      deleteNfsShareOperationSettings;
  private final PagedCallSettings<
          ListProvisioningQuotasRequest,
          ListProvisioningQuotasResponse,
          ListProvisioningQuotasPagedResponse>
      listProvisioningQuotasSettings;
  private final UnaryCallSettings<SubmitProvisioningConfigRequest, SubmitProvisioningConfigResponse>
      submitProvisioningConfigSettings;
  private final UnaryCallSettings<GetProvisioningConfigRequest, ProvisioningConfig>
      getProvisioningConfigSettings;
  private final UnaryCallSettings<CreateProvisioningConfigRequest, ProvisioningConfig>
      createProvisioningConfigSettings;
  private final UnaryCallSettings<UpdateProvisioningConfigRequest, ProvisioningConfig>
      updateProvisioningConfigSettings;
  private final UnaryCallSettings<RenameNetworkRequest, Network> renameNetworkSettings;
  private final PagedCallSettings<
          ListOSImagesRequest, ListOSImagesResponse, ListOSImagesPagedResponse>
      listOSImagesSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<ListInstancesRequest, ListInstancesResponse, Instance>
      LIST_INSTANCES_PAGE_STR_DESC =
          new PagedListDescriptor<ListInstancesRequest, ListInstancesResponse, Instance>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListInstancesRequest injectToken(ListInstancesRequest payload, String token) {
              return ListInstancesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListInstancesRequest injectPageSize(ListInstancesRequest payload, int pageSize) {
              return ListInstancesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListInstancesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListInstancesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Instance> extractResources(ListInstancesResponse payload) {
              return payload.getInstancesList() == null
                  ? ImmutableList.<Instance>of()
                  : payload.getInstancesList();
            }
          };

  private static final PagedListDescriptor<ListSSHKeysRequest, ListSSHKeysResponse, SSHKey>
      LIST_S_S_H_KEYS_PAGE_STR_DESC =
          new PagedListDescriptor<ListSSHKeysRequest, ListSSHKeysResponse, SSHKey>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSSHKeysRequest injectToken(ListSSHKeysRequest payload, String token) {
              return ListSSHKeysRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSSHKeysRequest injectPageSize(ListSSHKeysRequest payload, int pageSize) {
              return ListSSHKeysRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSSHKeysRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSSHKeysResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<SSHKey> extractResources(ListSSHKeysResponse payload) {
              return payload.getSshKeysList() == null
                  ? ImmutableList.<SSHKey>of()
                  : payload.getSshKeysList();
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

  private static final PagedListDescriptor<ListNetworksRequest, ListNetworksResponse, Network>
      LIST_NETWORKS_PAGE_STR_DESC =
          new PagedListDescriptor<ListNetworksRequest, ListNetworksResponse, Network>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListNetworksRequest injectToken(ListNetworksRequest payload, String token) {
              return ListNetworksRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListNetworksRequest injectPageSize(ListNetworksRequest payload, int pageSize) {
              return ListNetworksRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListNetworksRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListNetworksResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Network> extractResources(ListNetworksResponse payload) {
              return payload.getNetworksList() == null
                  ? ImmutableList.<Network>of()
                  : payload.getNetworksList();
            }
          };

  private static final PagedListDescriptor<
          ListVolumeSnapshotsRequest, ListVolumeSnapshotsResponse, VolumeSnapshot>
      LIST_VOLUME_SNAPSHOTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListVolumeSnapshotsRequest, ListVolumeSnapshotsResponse, VolumeSnapshot>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListVolumeSnapshotsRequest injectToken(
                ListVolumeSnapshotsRequest payload, String token) {
              return ListVolumeSnapshotsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListVolumeSnapshotsRequest injectPageSize(
                ListVolumeSnapshotsRequest payload, int pageSize) {
              return ListVolumeSnapshotsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListVolumeSnapshotsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListVolumeSnapshotsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<VolumeSnapshot> extractResources(ListVolumeSnapshotsResponse payload) {
              return payload.getVolumeSnapshotsList() == null
                  ? ImmutableList.<VolumeSnapshot>of()
                  : payload.getVolumeSnapshotsList();
            }
          };

  private static final PagedListDescriptor<ListLunsRequest, ListLunsResponse, Lun>
      LIST_LUNS_PAGE_STR_DESC =
          new PagedListDescriptor<ListLunsRequest, ListLunsResponse, Lun>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLunsRequest injectToken(ListLunsRequest payload, String token) {
              return ListLunsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLunsRequest injectPageSize(ListLunsRequest payload, int pageSize) {
              return ListLunsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLunsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLunsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Lun> extractResources(ListLunsResponse payload) {
              return payload.getLunsList() == null
                  ? ImmutableList.<Lun>of()
                  : payload.getLunsList();
            }
          };

  private static final PagedListDescriptor<ListNfsSharesRequest, ListNfsSharesResponse, NfsShare>
      LIST_NFS_SHARES_PAGE_STR_DESC =
          new PagedListDescriptor<ListNfsSharesRequest, ListNfsSharesResponse, NfsShare>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListNfsSharesRequest injectToken(ListNfsSharesRequest payload, String token) {
              return ListNfsSharesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListNfsSharesRequest injectPageSize(ListNfsSharesRequest payload, int pageSize) {
              return ListNfsSharesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListNfsSharesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListNfsSharesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<NfsShare> extractResources(ListNfsSharesResponse payload) {
              return payload.getNfsSharesList() == null
                  ? ImmutableList.<NfsShare>of()
                  : payload.getNfsSharesList();
            }
          };

  private static final PagedListDescriptor<
          ListProvisioningQuotasRequest, ListProvisioningQuotasResponse, ProvisioningQuota>
      LIST_PROVISIONING_QUOTAS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListProvisioningQuotasRequest, ListProvisioningQuotasResponse, ProvisioningQuota>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListProvisioningQuotasRequest injectToken(
                ListProvisioningQuotasRequest payload, String token) {
              return ListProvisioningQuotasRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListProvisioningQuotasRequest injectPageSize(
                ListProvisioningQuotasRequest payload, int pageSize) {
              return ListProvisioningQuotasRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListProvisioningQuotasRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListProvisioningQuotasResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ProvisioningQuota> extractResources(
                ListProvisioningQuotasResponse payload) {
              return payload.getProvisioningQuotasList() == null
                  ? ImmutableList.<ProvisioningQuota>of()
                  : payload.getProvisioningQuotasList();
            }
          };

  private static final PagedListDescriptor<ListOSImagesRequest, ListOSImagesResponse, OSImage>
      LIST_O_S_IMAGES_PAGE_STR_DESC =
          new PagedListDescriptor<ListOSImagesRequest, ListOSImagesResponse, OSImage>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListOSImagesRequest injectToken(ListOSImagesRequest payload, String token) {
              return ListOSImagesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListOSImagesRequest injectPageSize(ListOSImagesRequest payload, int pageSize) {
              return ListOSImagesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListOSImagesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListOSImagesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<OSImage> extractResources(ListOSImagesResponse payload) {
              return payload.getOsImagesList() == null
                  ? ImmutableList.<OSImage>of()
                  : payload.getOsImagesList();
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
          ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
      LIST_INSTANCES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>() {
            @Override
            public ApiFuture<ListInstancesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListInstancesRequest, ListInstancesResponse> callable,
                ListInstancesRequest request,
                ApiCallContext context,
                ApiFuture<ListInstancesResponse> futureResponse) {
              PageContext<ListInstancesRequest, ListInstancesResponse, Instance> pageContext =
                  PageContext.create(callable, LIST_INSTANCES_PAGE_STR_DESC, request, context);
              return ListInstancesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListSSHKeysRequest, ListSSHKeysResponse, ListSSHKeysPagedResponse>
      LIST_S_S_H_KEYS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSSHKeysRequest, ListSSHKeysResponse, ListSSHKeysPagedResponse>() {
            @Override
            public ApiFuture<ListSSHKeysPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSSHKeysRequest, ListSSHKeysResponse> callable,
                ListSSHKeysRequest request,
                ApiCallContext context,
                ApiFuture<ListSSHKeysResponse> futureResponse) {
              PageContext<ListSSHKeysRequest, ListSSHKeysResponse, SSHKey> pageContext =
                  PageContext.create(callable, LIST_S_S_H_KEYS_PAGE_STR_DESC, request, context);
              return ListSSHKeysPagedResponse.createAsync(pageContext, futureResponse);
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
          ListNetworksRequest, ListNetworksResponse, ListNetworksPagedResponse>
      LIST_NETWORKS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListNetworksRequest, ListNetworksResponse, ListNetworksPagedResponse>() {
            @Override
            public ApiFuture<ListNetworksPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListNetworksRequest, ListNetworksResponse> callable,
                ListNetworksRequest request,
                ApiCallContext context,
                ApiFuture<ListNetworksResponse> futureResponse) {
              PageContext<ListNetworksRequest, ListNetworksResponse, Network> pageContext =
                  PageContext.create(callable, LIST_NETWORKS_PAGE_STR_DESC, request, context);
              return ListNetworksPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListVolumeSnapshotsRequest, ListVolumeSnapshotsResponse, ListVolumeSnapshotsPagedResponse>
      LIST_VOLUME_SNAPSHOTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListVolumeSnapshotsRequest,
              ListVolumeSnapshotsResponse,
              ListVolumeSnapshotsPagedResponse>() {
            @Override
            public ApiFuture<ListVolumeSnapshotsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListVolumeSnapshotsRequest, ListVolumeSnapshotsResponse> callable,
                ListVolumeSnapshotsRequest request,
                ApiCallContext context,
                ApiFuture<ListVolumeSnapshotsResponse> futureResponse) {
              PageContext<ListVolumeSnapshotsRequest, ListVolumeSnapshotsResponse, VolumeSnapshot>
                  pageContext =
                      PageContext.create(
                          callable, LIST_VOLUME_SNAPSHOTS_PAGE_STR_DESC, request, context);
              return ListVolumeSnapshotsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListLunsRequest, ListLunsResponse, ListLunsPagedResponse>
      LIST_LUNS_PAGE_STR_FACT =
          new PagedListResponseFactory<ListLunsRequest, ListLunsResponse, ListLunsPagedResponse>() {
            @Override
            public ApiFuture<ListLunsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLunsRequest, ListLunsResponse> callable,
                ListLunsRequest request,
                ApiCallContext context,
                ApiFuture<ListLunsResponse> futureResponse) {
              PageContext<ListLunsRequest, ListLunsResponse, Lun> pageContext =
                  PageContext.create(callable, LIST_LUNS_PAGE_STR_DESC, request, context);
              return ListLunsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListNfsSharesRequest, ListNfsSharesResponse, ListNfsSharesPagedResponse>
      LIST_NFS_SHARES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListNfsSharesRequest, ListNfsSharesResponse, ListNfsSharesPagedResponse>() {
            @Override
            public ApiFuture<ListNfsSharesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListNfsSharesRequest, ListNfsSharesResponse> callable,
                ListNfsSharesRequest request,
                ApiCallContext context,
                ApiFuture<ListNfsSharesResponse> futureResponse) {
              PageContext<ListNfsSharesRequest, ListNfsSharesResponse, NfsShare> pageContext =
                  PageContext.create(callable, LIST_NFS_SHARES_PAGE_STR_DESC, request, context);
              return ListNfsSharesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListProvisioningQuotasRequest,
          ListProvisioningQuotasResponse,
          ListProvisioningQuotasPagedResponse>
      LIST_PROVISIONING_QUOTAS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListProvisioningQuotasRequest,
              ListProvisioningQuotasResponse,
              ListProvisioningQuotasPagedResponse>() {
            @Override
            public ApiFuture<ListProvisioningQuotasPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListProvisioningQuotasRequest, ListProvisioningQuotasResponse>
                    callable,
                ListProvisioningQuotasRequest request,
                ApiCallContext context,
                ApiFuture<ListProvisioningQuotasResponse> futureResponse) {
              PageContext<
                      ListProvisioningQuotasRequest,
                      ListProvisioningQuotasResponse,
                      ProvisioningQuota>
                  pageContext =
                      PageContext.create(
                          callable, LIST_PROVISIONING_QUOTAS_PAGE_STR_DESC, request, context);
              return ListProvisioningQuotasPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListOSImagesRequest, ListOSImagesResponse, ListOSImagesPagedResponse>
      LIST_O_S_IMAGES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListOSImagesRequest, ListOSImagesResponse, ListOSImagesPagedResponse>() {
            @Override
            public ApiFuture<ListOSImagesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListOSImagesRequest, ListOSImagesResponse> callable,
                ListOSImagesRequest request,
                ApiCallContext context,
                ApiFuture<ListOSImagesResponse> futureResponse) {
              PageContext<ListOSImagesRequest, ListOSImagesResponse, OSImage> pageContext =
                  PageContext.create(callable, LIST_O_S_IMAGES_PAGE_STR_DESC, request, context);
              return ListOSImagesPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listInstances. */
  public PagedCallSettings<ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
      listInstancesSettings() {
    return listInstancesSettings;
  }

  /** Returns the object with the settings used for calls to getInstance. */
  public UnaryCallSettings<GetInstanceRequest, Instance> getInstanceSettings() {
    return getInstanceSettings;
  }

  /** Returns the object with the settings used for calls to updateInstance. */
  public UnaryCallSettings<UpdateInstanceRequest, Operation> updateInstanceSettings() {
    return updateInstanceSettings;
  }

  /** Returns the object with the settings used for calls to updateInstance. */
  public OperationCallSettings<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationSettings() {
    return updateInstanceOperationSettings;
  }

  /** Returns the object with the settings used for calls to renameInstance. */
  public UnaryCallSettings<RenameInstanceRequest, Instance> renameInstanceSettings() {
    return renameInstanceSettings;
  }

  /** Returns the object with the settings used for calls to resetInstance. */
  public UnaryCallSettings<ResetInstanceRequest, Operation> resetInstanceSettings() {
    return resetInstanceSettings;
  }

  /** Returns the object with the settings used for calls to resetInstance. */
  public OperationCallSettings<ResetInstanceRequest, ResetInstanceResponse, OperationMetadata>
      resetInstanceOperationSettings() {
    return resetInstanceOperationSettings;
  }

  /** Returns the object with the settings used for calls to startInstance. */
  public UnaryCallSettings<StartInstanceRequest, Operation> startInstanceSettings() {
    return startInstanceSettings;
  }

  /** Returns the object with the settings used for calls to startInstance. */
  public OperationCallSettings<StartInstanceRequest, StartInstanceResponse, OperationMetadata>
      startInstanceOperationSettings() {
    return startInstanceOperationSettings;
  }

  /** Returns the object with the settings used for calls to stopInstance. */
  public UnaryCallSettings<StopInstanceRequest, Operation> stopInstanceSettings() {
    return stopInstanceSettings;
  }

  /** Returns the object with the settings used for calls to stopInstance. */
  public OperationCallSettings<StopInstanceRequest, StopInstanceResponse, OperationMetadata>
      stopInstanceOperationSettings() {
    return stopInstanceOperationSettings;
  }

  /** Returns the object with the settings used for calls to enableInteractiveSerialConsole. */
  public UnaryCallSettings<EnableInteractiveSerialConsoleRequest, Operation>
      enableInteractiveSerialConsoleSettings() {
    return enableInteractiveSerialConsoleSettings;
  }

  /** Returns the object with the settings used for calls to enableInteractiveSerialConsole. */
  public OperationCallSettings<
          EnableInteractiveSerialConsoleRequest,
          EnableInteractiveSerialConsoleResponse,
          OperationMetadata>
      enableInteractiveSerialConsoleOperationSettings() {
    return enableInteractiveSerialConsoleOperationSettings;
  }

  /** Returns the object with the settings used for calls to disableInteractiveSerialConsole. */
  public UnaryCallSettings<DisableInteractiveSerialConsoleRequest, Operation>
      disableInteractiveSerialConsoleSettings() {
    return disableInteractiveSerialConsoleSettings;
  }

  /** Returns the object with the settings used for calls to disableInteractiveSerialConsole. */
  public OperationCallSettings<
          DisableInteractiveSerialConsoleRequest,
          DisableInteractiveSerialConsoleResponse,
          OperationMetadata>
      disableInteractiveSerialConsoleOperationSettings() {
    return disableInteractiveSerialConsoleOperationSettings;
  }

  /** Returns the object with the settings used for calls to detachLun. */
  public UnaryCallSettings<DetachLunRequest, Operation> detachLunSettings() {
    return detachLunSettings;
  }

  /** Returns the object with the settings used for calls to detachLun. */
  public OperationCallSettings<DetachLunRequest, Instance, OperationMetadata>
      detachLunOperationSettings() {
    return detachLunOperationSettings;
  }

  /** Returns the object with the settings used for calls to listSSHKeys. */
  public PagedCallSettings<ListSSHKeysRequest, ListSSHKeysResponse, ListSSHKeysPagedResponse>
      listSSHKeysSettings() {
    return listSSHKeysSettings;
  }

  /** Returns the object with the settings used for calls to createSSHKey. */
  public UnaryCallSettings<CreateSSHKeyRequest, SSHKey> createSSHKeySettings() {
    return createSSHKeySettings;
  }

  /** Returns the object with the settings used for calls to deleteSSHKey. */
  public UnaryCallSettings<DeleteSSHKeyRequest, Empty> deleteSSHKeySettings() {
    return deleteSSHKeySettings;
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

  /** Returns the object with the settings used for calls to updateVolume. */
  public UnaryCallSettings<UpdateVolumeRequest, Operation> updateVolumeSettings() {
    return updateVolumeSettings;
  }

  /** Returns the object with the settings used for calls to updateVolume. */
  public OperationCallSettings<UpdateVolumeRequest, Volume, OperationMetadata>
      updateVolumeOperationSettings() {
    return updateVolumeOperationSettings;
  }

  /** Returns the object with the settings used for calls to renameVolume. */
  public UnaryCallSettings<RenameVolumeRequest, Volume> renameVolumeSettings() {
    return renameVolumeSettings;
  }

  /** Returns the object with the settings used for calls to evictVolume. */
  public UnaryCallSettings<EvictVolumeRequest, Operation> evictVolumeSettings() {
    return evictVolumeSettings;
  }

  /** Returns the object with the settings used for calls to evictVolume. */
  public OperationCallSettings<EvictVolumeRequest, Empty, OperationMetadata>
      evictVolumeOperationSettings() {
    return evictVolumeOperationSettings;
  }

  /** Returns the object with the settings used for calls to resizeVolume. */
  public UnaryCallSettings<ResizeVolumeRequest, Operation> resizeVolumeSettings() {
    return resizeVolumeSettings;
  }

  /** Returns the object with the settings used for calls to resizeVolume. */
  public OperationCallSettings<ResizeVolumeRequest, Volume, OperationMetadata>
      resizeVolumeOperationSettings() {
    return resizeVolumeOperationSettings;
  }

  /** Returns the object with the settings used for calls to listNetworks. */
  public PagedCallSettings<ListNetworksRequest, ListNetworksResponse, ListNetworksPagedResponse>
      listNetworksSettings() {
    return listNetworksSettings;
  }

  /** Returns the object with the settings used for calls to listNetworkUsage. */
  public UnaryCallSettings<ListNetworkUsageRequest, ListNetworkUsageResponse>
      listNetworkUsageSettings() {
    return listNetworkUsageSettings;
  }

  /** Returns the object with the settings used for calls to getNetwork. */
  public UnaryCallSettings<GetNetworkRequest, Network> getNetworkSettings() {
    return getNetworkSettings;
  }

  /** Returns the object with the settings used for calls to updateNetwork. */
  public UnaryCallSettings<UpdateNetworkRequest, Operation> updateNetworkSettings() {
    return updateNetworkSettings;
  }

  /** Returns the object with the settings used for calls to updateNetwork. */
  public OperationCallSettings<UpdateNetworkRequest, Network, OperationMetadata>
      updateNetworkOperationSettings() {
    return updateNetworkOperationSettings;
  }

  /** Returns the object with the settings used for calls to createVolumeSnapshot. */
  public UnaryCallSettings<CreateVolumeSnapshotRequest, VolumeSnapshot>
      createVolumeSnapshotSettings() {
    return createVolumeSnapshotSettings;
  }

  /** Returns the object with the settings used for calls to restoreVolumeSnapshot. */
  public UnaryCallSettings<RestoreVolumeSnapshotRequest, Operation>
      restoreVolumeSnapshotSettings() {
    return restoreVolumeSnapshotSettings;
  }

  /** Returns the object with the settings used for calls to restoreVolumeSnapshot. */
  public OperationCallSettings<RestoreVolumeSnapshotRequest, VolumeSnapshot, OperationMetadata>
      restoreVolumeSnapshotOperationSettings() {
    return restoreVolumeSnapshotOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteVolumeSnapshot. */
  public UnaryCallSettings<DeleteVolumeSnapshotRequest, Empty> deleteVolumeSnapshotSettings() {
    return deleteVolumeSnapshotSettings;
  }

  /** Returns the object with the settings used for calls to getVolumeSnapshot. */
  public UnaryCallSettings<GetVolumeSnapshotRequest, VolumeSnapshot> getVolumeSnapshotSettings() {
    return getVolumeSnapshotSettings;
  }

  /** Returns the object with the settings used for calls to listVolumeSnapshots. */
  public PagedCallSettings<
          ListVolumeSnapshotsRequest, ListVolumeSnapshotsResponse, ListVolumeSnapshotsPagedResponse>
      listVolumeSnapshotsSettings() {
    return listVolumeSnapshotsSettings;
  }

  /** Returns the object with the settings used for calls to getLun. */
  public UnaryCallSettings<GetLunRequest, Lun> getLunSettings() {
    return getLunSettings;
  }

  /** Returns the object with the settings used for calls to listLuns. */
  public PagedCallSettings<ListLunsRequest, ListLunsResponse, ListLunsPagedResponse>
      listLunsSettings() {
    return listLunsSettings;
  }

  /** Returns the object with the settings used for calls to evictLun. */
  public UnaryCallSettings<EvictLunRequest, Operation> evictLunSettings() {
    return evictLunSettings;
  }

  /** Returns the object with the settings used for calls to evictLun. */
  public OperationCallSettings<EvictLunRequest, Empty, OperationMetadata>
      evictLunOperationSettings() {
    return evictLunOperationSettings;
  }

  /** Returns the object with the settings used for calls to getNfsShare. */
  public UnaryCallSettings<GetNfsShareRequest, NfsShare> getNfsShareSettings() {
    return getNfsShareSettings;
  }

  /** Returns the object with the settings used for calls to listNfsShares. */
  public PagedCallSettings<ListNfsSharesRequest, ListNfsSharesResponse, ListNfsSharesPagedResponse>
      listNfsSharesSettings() {
    return listNfsSharesSettings;
  }

  /** Returns the object with the settings used for calls to updateNfsShare. */
  public UnaryCallSettings<UpdateNfsShareRequest, Operation> updateNfsShareSettings() {
    return updateNfsShareSettings;
  }

  /** Returns the object with the settings used for calls to updateNfsShare. */
  public OperationCallSettings<UpdateNfsShareRequest, NfsShare, OperationMetadata>
      updateNfsShareOperationSettings() {
    return updateNfsShareOperationSettings;
  }

  /** Returns the object with the settings used for calls to createNfsShare. */
  public UnaryCallSettings<CreateNfsShareRequest, Operation> createNfsShareSettings() {
    return createNfsShareSettings;
  }

  /** Returns the object with the settings used for calls to createNfsShare. */
  public OperationCallSettings<CreateNfsShareRequest, NfsShare, OperationMetadata>
      createNfsShareOperationSettings() {
    return createNfsShareOperationSettings;
  }

  /** Returns the object with the settings used for calls to renameNfsShare. */
  public UnaryCallSettings<RenameNfsShareRequest, NfsShare> renameNfsShareSettings() {
    return renameNfsShareSettings;
  }

  /** Returns the object with the settings used for calls to deleteNfsShare. */
  public UnaryCallSettings<DeleteNfsShareRequest, Operation> deleteNfsShareSettings() {
    return deleteNfsShareSettings;
  }

  /** Returns the object with the settings used for calls to deleteNfsShare. */
  public OperationCallSettings<DeleteNfsShareRequest, Empty, OperationMetadata>
      deleteNfsShareOperationSettings() {
    return deleteNfsShareOperationSettings;
  }

  /** Returns the object with the settings used for calls to listProvisioningQuotas. */
  public PagedCallSettings<
          ListProvisioningQuotasRequest,
          ListProvisioningQuotasResponse,
          ListProvisioningQuotasPagedResponse>
      listProvisioningQuotasSettings() {
    return listProvisioningQuotasSettings;
  }

  /** Returns the object with the settings used for calls to submitProvisioningConfig. */
  public UnaryCallSettings<SubmitProvisioningConfigRequest, SubmitProvisioningConfigResponse>
      submitProvisioningConfigSettings() {
    return submitProvisioningConfigSettings;
  }

  /** Returns the object with the settings used for calls to getProvisioningConfig. */
  public UnaryCallSettings<GetProvisioningConfigRequest, ProvisioningConfig>
      getProvisioningConfigSettings() {
    return getProvisioningConfigSettings;
  }

  /** Returns the object with the settings used for calls to createProvisioningConfig. */
  public UnaryCallSettings<CreateProvisioningConfigRequest, ProvisioningConfig>
      createProvisioningConfigSettings() {
    return createProvisioningConfigSettings;
  }

  /** Returns the object with the settings used for calls to updateProvisioningConfig. */
  public UnaryCallSettings<UpdateProvisioningConfigRequest, ProvisioningConfig>
      updateProvisioningConfigSettings() {
    return updateProvisioningConfigSettings;
  }

  /** Returns the object with the settings used for calls to renameNetwork. */
  public UnaryCallSettings<RenameNetworkRequest, Network> renameNetworkSettings() {
    return renameNetworkSettings;
  }

  /** Returns the object with the settings used for calls to listOSImages. */
  public PagedCallSettings<ListOSImagesRequest, ListOSImagesResponse, ListOSImagesPagedResponse>
      listOSImagesSettings() {
    return listOSImagesSettings;
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

  public BareMetalSolutionStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcBareMetalSolutionStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonBareMetalSolutionStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "baremetalsolution";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "baremetalsolution.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "baremetalsolution.mtls.googleapis.com:443";
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
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(BareMetalSolutionStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(BareMetalSolutionStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return BareMetalSolutionStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected BareMetalSolutionStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listInstancesSettings = settingsBuilder.listInstancesSettings().build();
    getInstanceSettings = settingsBuilder.getInstanceSettings().build();
    updateInstanceSettings = settingsBuilder.updateInstanceSettings().build();
    updateInstanceOperationSettings = settingsBuilder.updateInstanceOperationSettings().build();
    renameInstanceSettings = settingsBuilder.renameInstanceSettings().build();
    resetInstanceSettings = settingsBuilder.resetInstanceSettings().build();
    resetInstanceOperationSettings = settingsBuilder.resetInstanceOperationSettings().build();
    startInstanceSettings = settingsBuilder.startInstanceSettings().build();
    startInstanceOperationSettings = settingsBuilder.startInstanceOperationSettings().build();
    stopInstanceSettings = settingsBuilder.stopInstanceSettings().build();
    stopInstanceOperationSettings = settingsBuilder.stopInstanceOperationSettings().build();
    enableInteractiveSerialConsoleSettings =
        settingsBuilder.enableInteractiveSerialConsoleSettings().build();
    enableInteractiveSerialConsoleOperationSettings =
        settingsBuilder.enableInteractiveSerialConsoleOperationSettings().build();
    disableInteractiveSerialConsoleSettings =
        settingsBuilder.disableInteractiveSerialConsoleSettings().build();
    disableInteractiveSerialConsoleOperationSettings =
        settingsBuilder.disableInteractiveSerialConsoleOperationSettings().build();
    detachLunSettings = settingsBuilder.detachLunSettings().build();
    detachLunOperationSettings = settingsBuilder.detachLunOperationSettings().build();
    listSSHKeysSettings = settingsBuilder.listSSHKeysSettings().build();
    createSSHKeySettings = settingsBuilder.createSSHKeySettings().build();
    deleteSSHKeySettings = settingsBuilder.deleteSSHKeySettings().build();
    listVolumesSettings = settingsBuilder.listVolumesSettings().build();
    getVolumeSettings = settingsBuilder.getVolumeSettings().build();
    updateVolumeSettings = settingsBuilder.updateVolumeSettings().build();
    updateVolumeOperationSettings = settingsBuilder.updateVolumeOperationSettings().build();
    renameVolumeSettings = settingsBuilder.renameVolumeSettings().build();
    evictVolumeSettings = settingsBuilder.evictVolumeSettings().build();
    evictVolumeOperationSettings = settingsBuilder.evictVolumeOperationSettings().build();
    resizeVolumeSettings = settingsBuilder.resizeVolumeSettings().build();
    resizeVolumeOperationSettings = settingsBuilder.resizeVolumeOperationSettings().build();
    listNetworksSettings = settingsBuilder.listNetworksSettings().build();
    listNetworkUsageSettings = settingsBuilder.listNetworkUsageSettings().build();
    getNetworkSettings = settingsBuilder.getNetworkSettings().build();
    updateNetworkSettings = settingsBuilder.updateNetworkSettings().build();
    updateNetworkOperationSettings = settingsBuilder.updateNetworkOperationSettings().build();
    createVolumeSnapshotSettings = settingsBuilder.createVolumeSnapshotSettings().build();
    restoreVolumeSnapshotSettings = settingsBuilder.restoreVolumeSnapshotSettings().build();
    restoreVolumeSnapshotOperationSettings =
        settingsBuilder.restoreVolumeSnapshotOperationSettings().build();
    deleteVolumeSnapshotSettings = settingsBuilder.deleteVolumeSnapshotSettings().build();
    getVolumeSnapshotSettings = settingsBuilder.getVolumeSnapshotSettings().build();
    listVolumeSnapshotsSettings = settingsBuilder.listVolumeSnapshotsSettings().build();
    getLunSettings = settingsBuilder.getLunSettings().build();
    listLunsSettings = settingsBuilder.listLunsSettings().build();
    evictLunSettings = settingsBuilder.evictLunSettings().build();
    evictLunOperationSettings = settingsBuilder.evictLunOperationSettings().build();
    getNfsShareSettings = settingsBuilder.getNfsShareSettings().build();
    listNfsSharesSettings = settingsBuilder.listNfsSharesSettings().build();
    updateNfsShareSettings = settingsBuilder.updateNfsShareSettings().build();
    updateNfsShareOperationSettings = settingsBuilder.updateNfsShareOperationSettings().build();
    createNfsShareSettings = settingsBuilder.createNfsShareSettings().build();
    createNfsShareOperationSettings = settingsBuilder.createNfsShareOperationSettings().build();
    renameNfsShareSettings = settingsBuilder.renameNfsShareSettings().build();
    deleteNfsShareSettings = settingsBuilder.deleteNfsShareSettings().build();
    deleteNfsShareOperationSettings = settingsBuilder.deleteNfsShareOperationSettings().build();
    listProvisioningQuotasSettings = settingsBuilder.listProvisioningQuotasSettings().build();
    submitProvisioningConfigSettings = settingsBuilder.submitProvisioningConfigSettings().build();
    getProvisioningConfigSettings = settingsBuilder.getProvisioningConfigSettings().build();
    createProvisioningConfigSettings = settingsBuilder.createProvisioningConfigSettings().build();
    updateProvisioningConfigSettings = settingsBuilder.updateProvisioningConfigSettings().build();
    renameNetworkSettings = settingsBuilder.renameNetworkSettings().build();
    listOSImagesSettings = settingsBuilder.listOSImagesSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for BareMetalSolutionStubSettings. */
  public static class Builder extends StubSettings.Builder<BareMetalSolutionStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
        listInstancesSettings;
    private final UnaryCallSettings.Builder<GetInstanceRequest, Instance> getInstanceSettings;
    private final UnaryCallSettings.Builder<UpdateInstanceRequest, Operation>
        updateInstanceSettings;
    private final OperationCallSettings.Builder<UpdateInstanceRequest, Instance, OperationMetadata>
        updateInstanceOperationSettings;
    private final UnaryCallSettings.Builder<RenameInstanceRequest, Instance> renameInstanceSettings;
    private final UnaryCallSettings.Builder<ResetInstanceRequest, Operation> resetInstanceSettings;
    private final OperationCallSettings.Builder<
            ResetInstanceRequest, ResetInstanceResponse, OperationMetadata>
        resetInstanceOperationSettings;
    private final UnaryCallSettings.Builder<StartInstanceRequest, Operation> startInstanceSettings;
    private final OperationCallSettings.Builder<
            StartInstanceRequest, StartInstanceResponse, OperationMetadata>
        startInstanceOperationSettings;
    private final UnaryCallSettings.Builder<StopInstanceRequest, Operation> stopInstanceSettings;
    private final OperationCallSettings.Builder<
            StopInstanceRequest, StopInstanceResponse, OperationMetadata>
        stopInstanceOperationSettings;
    private final UnaryCallSettings.Builder<EnableInteractiveSerialConsoleRequest, Operation>
        enableInteractiveSerialConsoleSettings;
    private final OperationCallSettings.Builder<
            EnableInteractiveSerialConsoleRequest,
            EnableInteractiveSerialConsoleResponse,
            OperationMetadata>
        enableInteractiveSerialConsoleOperationSettings;
    private final UnaryCallSettings.Builder<DisableInteractiveSerialConsoleRequest, Operation>
        disableInteractiveSerialConsoleSettings;
    private final OperationCallSettings.Builder<
            DisableInteractiveSerialConsoleRequest,
            DisableInteractiveSerialConsoleResponse,
            OperationMetadata>
        disableInteractiveSerialConsoleOperationSettings;
    private final UnaryCallSettings.Builder<DetachLunRequest, Operation> detachLunSettings;
    private final OperationCallSettings.Builder<DetachLunRequest, Instance, OperationMetadata>
        detachLunOperationSettings;
    private final PagedCallSettings.Builder<
            ListSSHKeysRequest, ListSSHKeysResponse, ListSSHKeysPagedResponse>
        listSSHKeysSettings;
    private final UnaryCallSettings.Builder<CreateSSHKeyRequest, SSHKey> createSSHKeySettings;
    private final UnaryCallSettings.Builder<DeleteSSHKeyRequest, Empty> deleteSSHKeySettings;
    private final PagedCallSettings.Builder<
            ListVolumesRequest, ListVolumesResponse, ListVolumesPagedResponse>
        listVolumesSettings;
    private final UnaryCallSettings.Builder<GetVolumeRequest, Volume> getVolumeSettings;
    private final UnaryCallSettings.Builder<UpdateVolumeRequest, Operation> updateVolumeSettings;
    private final OperationCallSettings.Builder<UpdateVolumeRequest, Volume, OperationMetadata>
        updateVolumeOperationSettings;
    private final UnaryCallSettings.Builder<RenameVolumeRequest, Volume> renameVolumeSettings;
    private final UnaryCallSettings.Builder<EvictVolumeRequest, Operation> evictVolumeSettings;
    private final OperationCallSettings.Builder<EvictVolumeRequest, Empty, OperationMetadata>
        evictVolumeOperationSettings;
    private final UnaryCallSettings.Builder<ResizeVolumeRequest, Operation> resizeVolumeSettings;
    private final OperationCallSettings.Builder<ResizeVolumeRequest, Volume, OperationMetadata>
        resizeVolumeOperationSettings;
    private final PagedCallSettings.Builder<
            ListNetworksRequest, ListNetworksResponse, ListNetworksPagedResponse>
        listNetworksSettings;
    private final UnaryCallSettings.Builder<ListNetworkUsageRequest, ListNetworkUsageResponse>
        listNetworkUsageSettings;
    private final UnaryCallSettings.Builder<GetNetworkRequest, Network> getNetworkSettings;
    private final UnaryCallSettings.Builder<UpdateNetworkRequest, Operation> updateNetworkSettings;
    private final OperationCallSettings.Builder<UpdateNetworkRequest, Network, OperationMetadata>
        updateNetworkOperationSettings;
    private final UnaryCallSettings.Builder<CreateVolumeSnapshotRequest, VolumeSnapshot>
        createVolumeSnapshotSettings;
    private final UnaryCallSettings.Builder<RestoreVolumeSnapshotRequest, Operation>
        restoreVolumeSnapshotSettings;
    private final OperationCallSettings.Builder<
            RestoreVolumeSnapshotRequest, VolumeSnapshot, OperationMetadata>
        restoreVolumeSnapshotOperationSettings;
    private final UnaryCallSettings.Builder<DeleteVolumeSnapshotRequest, Empty>
        deleteVolumeSnapshotSettings;
    private final UnaryCallSettings.Builder<GetVolumeSnapshotRequest, VolumeSnapshot>
        getVolumeSnapshotSettings;
    private final PagedCallSettings.Builder<
            ListVolumeSnapshotsRequest,
            ListVolumeSnapshotsResponse,
            ListVolumeSnapshotsPagedResponse>
        listVolumeSnapshotsSettings;
    private final UnaryCallSettings.Builder<GetLunRequest, Lun> getLunSettings;
    private final PagedCallSettings.Builder<
            ListLunsRequest, ListLunsResponse, ListLunsPagedResponse>
        listLunsSettings;
    private final UnaryCallSettings.Builder<EvictLunRequest, Operation> evictLunSettings;
    private final OperationCallSettings.Builder<EvictLunRequest, Empty, OperationMetadata>
        evictLunOperationSettings;
    private final UnaryCallSettings.Builder<GetNfsShareRequest, NfsShare> getNfsShareSettings;
    private final PagedCallSettings.Builder<
            ListNfsSharesRequest, ListNfsSharesResponse, ListNfsSharesPagedResponse>
        listNfsSharesSettings;
    private final UnaryCallSettings.Builder<UpdateNfsShareRequest, Operation>
        updateNfsShareSettings;
    private final OperationCallSettings.Builder<UpdateNfsShareRequest, NfsShare, OperationMetadata>
        updateNfsShareOperationSettings;
    private final UnaryCallSettings.Builder<CreateNfsShareRequest, Operation>
        createNfsShareSettings;
    private final OperationCallSettings.Builder<CreateNfsShareRequest, NfsShare, OperationMetadata>
        createNfsShareOperationSettings;
    private final UnaryCallSettings.Builder<RenameNfsShareRequest, NfsShare> renameNfsShareSettings;
    private final UnaryCallSettings.Builder<DeleteNfsShareRequest, Operation>
        deleteNfsShareSettings;
    private final OperationCallSettings.Builder<DeleteNfsShareRequest, Empty, OperationMetadata>
        deleteNfsShareOperationSettings;
    private final PagedCallSettings.Builder<
            ListProvisioningQuotasRequest,
            ListProvisioningQuotasResponse,
            ListProvisioningQuotasPagedResponse>
        listProvisioningQuotasSettings;
    private final UnaryCallSettings.Builder<
            SubmitProvisioningConfigRequest, SubmitProvisioningConfigResponse>
        submitProvisioningConfigSettings;
    private final UnaryCallSettings.Builder<GetProvisioningConfigRequest, ProvisioningConfig>
        getProvisioningConfigSettings;
    private final UnaryCallSettings.Builder<CreateProvisioningConfigRequest, ProvisioningConfig>
        createProvisioningConfigSettings;
    private final UnaryCallSettings.Builder<UpdateProvisioningConfigRequest, ProvisioningConfig>
        updateProvisioningConfigSettings;
    private final UnaryCallSettings.Builder<RenameNetworkRequest, Network> renameNetworkSettings;
    private final PagedCallSettings.Builder<
            ListOSImagesRequest, ListOSImagesResponse, ListOSImagesPagedResponse>
        listOSImagesSettings;
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
          "no_retry_0_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listInstancesSettings = PagedCallSettings.newBuilder(LIST_INSTANCES_PAGE_STR_FACT);
      getInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateInstanceOperationSettings = OperationCallSettings.newBuilder();
      renameInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      resetInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      resetInstanceOperationSettings = OperationCallSettings.newBuilder();
      startInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      startInstanceOperationSettings = OperationCallSettings.newBuilder();
      stopInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      stopInstanceOperationSettings = OperationCallSettings.newBuilder();
      enableInteractiveSerialConsoleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      enableInteractiveSerialConsoleOperationSettings = OperationCallSettings.newBuilder();
      disableInteractiveSerialConsoleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      disableInteractiveSerialConsoleOperationSettings = OperationCallSettings.newBuilder();
      detachLunSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      detachLunOperationSettings = OperationCallSettings.newBuilder();
      listSSHKeysSettings = PagedCallSettings.newBuilder(LIST_S_S_H_KEYS_PAGE_STR_FACT);
      createSSHKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteSSHKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listVolumesSettings = PagedCallSettings.newBuilder(LIST_VOLUMES_PAGE_STR_FACT);
      getVolumeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateVolumeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateVolumeOperationSettings = OperationCallSettings.newBuilder();
      renameVolumeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      evictVolumeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      evictVolumeOperationSettings = OperationCallSettings.newBuilder();
      resizeVolumeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      resizeVolumeOperationSettings = OperationCallSettings.newBuilder();
      listNetworksSettings = PagedCallSettings.newBuilder(LIST_NETWORKS_PAGE_STR_FACT);
      listNetworkUsageSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getNetworkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateNetworkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateNetworkOperationSettings = OperationCallSettings.newBuilder();
      createVolumeSnapshotSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      restoreVolumeSnapshotSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      restoreVolumeSnapshotOperationSettings = OperationCallSettings.newBuilder();
      deleteVolumeSnapshotSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getVolumeSnapshotSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listVolumeSnapshotsSettings =
          PagedCallSettings.newBuilder(LIST_VOLUME_SNAPSHOTS_PAGE_STR_FACT);
      getLunSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLunsSettings = PagedCallSettings.newBuilder(LIST_LUNS_PAGE_STR_FACT);
      evictLunSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      evictLunOperationSettings = OperationCallSettings.newBuilder();
      getNfsShareSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listNfsSharesSettings = PagedCallSettings.newBuilder(LIST_NFS_SHARES_PAGE_STR_FACT);
      updateNfsShareSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateNfsShareOperationSettings = OperationCallSettings.newBuilder();
      createNfsShareSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createNfsShareOperationSettings = OperationCallSettings.newBuilder();
      renameNfsShareSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteNfsShareSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteNfsShareOperationSettings = OperationCallSettings.newBuilder();
      listProvisioningQuotasSettings =
          PagedCallSettings.newBuilder(LIST_PROVISIONING_QUOTAS_PAGE_STR_FACT);
      submitProvisioningConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getProvisioningConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createProvisioningConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateProvisioningConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      renameNetworkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listOSImagesSettings = PagedCallSettings.newBuilder(LIST_O_S_IMAGES_PAGE_STR_FACT);
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listInstancesSettings,
              getInstanceSettings,
              updateInstanceSettings,
              renameInstanceSettings,
              resetInstanceSettings,
              startInstanceSettings,
              stopInstanceSettings,
              enableInteractiveSerialConsoleSettings,
              disableInteractiveSerialConsoleSettings,
              detachLunSettings,
              listSSHKeysSettings,
              createSSHKeySettings,
              deleteSSHKeySettings,
              listVolumesSettings,
              getVolumeSettings,
              updateVolumeSettings,
              renameVolumeSettings,
              evictVolumeSettings,
              resizeVolumeSettings,
              listNetworksSettings,
              listNetworkUsageSettings,
              getNetworkSettings,
              updateNetworkSettings,
              createVolumeSnapshotSettings,
              restoreVolumeSnapshotSettings,
              deleteVolumeSnapshotSettings,
              getVolumeSnapshotSettings,
              listVolumeSnapshotsSettings,
              getLunSettings,
              listLunsSettings,
              evictLunSettings,
              getNfsShareSettings,
              listNfsSharesSettings,
              updateNfsShareSettings,
              createNfsShareSettings,
              renameNfsShareSettings,
              deleteNfsShareSettings,
              listProvisioningQuotasSettings,
              submitProvisioningConfigSettings,
              getProvisioningConfigSettings,
              createProvisioningConfigSettings,
              updateProvisioningConfigSettings,
              renameNetworkSettings,
              listOSImagesSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(BareMetalSolutionStubSettings settings) {
      super(settings);

      listInstancesSettings = settings.listInstancesSettings.toBuilder();
      getInstanceSettings = settings.getInstanceSettings.toBuilder();
      updateInstanceSettings = settings.updateInstanceSettings.toBuilder();
      updateInstanceOperationSettings = settings.updateInstanceOperationSettings.toBuilder();
      renameInstanceSettings = settings.renameInstanceSettings.toBuilder();
      resetInstanceSettings = settings.resetInstanceSettings.toBuilder();
      resetInstanceOperationSettings = settings.resetInstanceOperationSettings.toBuilder();
      startInstanceSettings = settings.startInstanceSettings.toBuilder();
      startInstanceOperationSettings = settings.startInstanceOperationSettings.toBuilder();
      stopInstanceSettings = settings.stopInstanceSettings.toBuilder();
      stopInstanceOperationSettings = settings.stopInstanceOperationSettings.toBuilder();
      enableInteractiveSerialConsoleSettings =
          settings.enableInteractiveSerialConsoleSettings.toBuilder();
      enableInteractiveSerialConsoleOperationSettings =
          settings.enableInteractiveSerialConsoleOperationSettings.toBuilder();
      disableInteractiveSerialConsoleSettings =
          settings.disableInteractiveSerialConsoleSettings.toBuilder();
      disableInteractiveSerialConsoleOperationSettings =
          settings.disableInteractiveSerialConsoleOperationSettings.toBuilder();
      detachLunSettings = settings.detachLunSettings.toBuilder();
      detachLunOperationSettings = settings.detachLunOperationSettings.toBuilder();
      listSSHKeysSettings = settings.listSSHKeysSettings.toBuilder();
      createSSHKeySettings = settings.createSSHKeySettings.toBuilder();
      deleteSSHKeySettings = settings.deleteSSHKeySettings.toBuilder();
      listVolumesSettings = settings.listVolumesSettings.toBuilder();
      getVolumeSettings = settings.getVolumeSettings.toBuilder();
      updateVolumeSettings = settings.updateVolumeSettings.toBuilder();
      updateVolumeOperationSettings = settings.updateVolumeOperationSettings.toBuilder();
      renameVolumeSettings = settings.renameVolumeSettings.toBuilder();
      evictVolumeSettings = settings.evictVolumeSettings.toBuilder();
      evictVolumeOperationSettings = settings.evictVolumeOperationSettings.toBuilder();
      resizeVolumeSettings = settings.resizeVolumeSettings.toBuilder();
      resizeVolumeOperationSettings = settings.resizeVolumeOperationSettings.toBuilder();
      listNetworksSettings = settings.listNetworksSettings.toBuilder();
      listNetworkUsageSettings = settings.listNetworkUsageSettings.toBuilder();
      getNetworkSettings = settings.getNetworkSettings.toBuilder();
      updateNetworkSettings = settings.updateNetworkSettings.toBuilder();
      updateNetworkOperationSettings = settings.updateNetworkOperationSettings.toBuilder();
      createVolumeSnapshotSettings = settings.createVolumeSnapshotSettings.toBuilder();
      restoreVolumeSnapshotSettings = settings.restoreVolumeSnapshotSettings.toBuilder();
      restoreVolumeSnapshotOperationSettings =
          settings.restoreVolumeSnapshotOperationSettings.toBuilder();
      deleteVolumeSnapshotSettings = settings.deleteVolumeSnapshotSettings.toBuilder();
      getVolumeSnapshotSettings = settings.getVolumeSnapshotSettings.toBuilder();
      listVolumeSnapshotsSettings = settings.listVolumeSnapshotsSettings.toBuilder();
      getLunSettings = settings.getLunSettings.toBuilder();
      listLunsSettings = settings.listLunsSettings.toBuilder();
      evictLunSettings = settings.evictLunSettings.toBuilder();
      evictLunOperationSettings = settings.evictLunOperationSettings.toBuilder();
      getNfsShareSettings = settings.getNfsShareSettings.toBuilder();
      listNfsSharesSettings = settings.listNfsSharesSettings.toBuilder();
      updateNfsShareSettings = settings.updateNfsShareSettings.toBuilder();
      updateNfsShareOperationSettings = settings.updateNfsShareOperationSettings.toBuilder();
      createNfsShareSettings = settings.createNfsShareSettings.toBuilder();
      createNfsShareOperationSettings = settings.createNfsShareOperationSettings.toBuilder();
      renameNfsShareSettings = settings.renameNfsShareSettings.toBuilder();
      deleteNfsShareSettings = settings.deleteNfsShareSettings.toBuilder();
      deleteNfsShareOperationSettings = settings.deleteNfsShareOperationSettings.toBuilder();
      listProvisioningQuotasSettings = settings.listProvisioningQuotasSettings.toBuilder();
      submitProvisioningConfigSettings = settings.submitProvisioningConfigSettings.toBuilder();
      getProvisioningConfigSettings = settings.getProvisioningConfigSettings.toBuilder();
      createProvisioningConfigSettings = settings.createProvisioningConfigSettings.toBuilder();
      updateProvisioningConfigSettings = settings.updateProvisioningConfigSettings.toBuilder();
      renameNetworkSettings = settings.renameNetworkSettings.toBuilder();
      listOSImagesSettings = settings.listOSImagesSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listInstancesSettings,
              getInstanceSettings,
              updateInstanceSettings,
              renameInstanceSettings,
              resetInstanceSettings,
              startInstanceSettings,
              stopInstanceSettings,
              enableInteractiveSerialConsoleSettings,
              disableInteractiveSerialConsoleSettings,
              detachLunSettings,
              listSSHKeysSettings,
              createSSHKeySettings,
              deleteSSHKeySettings,
              listVolumesSettings,
              getVolumeSettings,
              updateVolumeSettings,
              renameVolumeSettings,
              evictVolumeSettings,
              resizeVolumeSettings,
              listNetworksSettings,
              listNetworkUsageSettings,
              getNetworkSettings,
              updateNetworkSettings,
              createVolumeSnapshotSettings,
              restoreVolumeSnapshotSettings,
              deleteVolumeSnapshotSettings,
              getVolumeSnapshotSettings,
              listVolumeSnapshotsSettings,
              getLunSettings,
              listLunsSettings,
              evictLunSettings,
              getNfsShareSettings,
              listNfsSharesSettings,
              updateNfsShareSettings,
              createNfsShareSettings,
              renameNfsShareSettings,
              deleteNfsShareSettings,
              listProvisioningQuotasSettings,
              submitProvisioningConfigSettings,
              getProvisioningConfigSettings,
              createProvisioningConfigSettings,
              updateProvisioningConfigSettings,
              renameNetworkSettings,
              listOSImagesSettings,
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
          .listInstancesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .renameInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .resetInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .startInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .stopInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .enableInteractiveSerialConsoleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .disableInteractiveSerialConsoleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .detachLunSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listSSHKeysSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createSSHKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteSSHKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listVolumesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getVolumeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateVolumeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .renameVolumeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .evictVolumeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .resizeVolumeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listNetworksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listNetworkUsageSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getNetworkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateNetworkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createVolumeSnapshotSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .restoreVolumeSnapshotSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteVolumeSnapshotSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getVolumeSnapshotSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listVolumeSnapshotsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getLunSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listLunsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .evictLunSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getNfsShareSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listNfsSharesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateNfsShareSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createNfsShareSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .renameNfsShareSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteNfsShareSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listProvisioningQuotasSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .submitProvisioningConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getProvisioningConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createProvisioningConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateProvisioningConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .renameNetworkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listOSImagesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateInstanceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Instance.class))
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
          .resetInstanceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ResetInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ResetInstanceResponse.class))
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
          .startInstanceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<StartInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(StartInstanceResponse.class))
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
          .stopInstanceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<StopInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(StopInstanceResponse.class))
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
          .enableInteractiveSerialConsoleOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<EnableInteractiveSerialConsoleRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  EnableInteractiveSerialConsoleResponse.class))
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
          .disableInteractiveSerialConsoleOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DisableInteractiveSerialConsoleRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  DisableInteractiveSerialConsoleResponse.class))
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
          .detachLunOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DetachLunRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Instance.class))
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
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
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
          .evictVolumeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<EvictVolumeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
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
          .resizeVolumeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ResizeVolumeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
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
          .updateNetworkOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateNetworkRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Network.class))
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
          .restoreVolumeSnapshotOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RestoreVolumeSnapshotRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(VolumeSnapshot.class))
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
          .evictLunOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<EvictLunRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
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
          .updateNfsShareOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateNfsShareRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(NfsShare.class))
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
          .createNfsShareOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateNfsShareRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(NfsShare.class))
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
          .deleteNfsShareOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteNfsShareRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
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

    /** Returns the builder for the settings used for calls to listInstances. */
    public PagedCallSettings.Builder<
            ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
        listInstancesSettings() {
      return listInstancesSettings;
    }

    /** Returns the builder for the settings used for calls to getInstance. */
    public UnaryCallSettings.Builder<GetInstanceRequest, Instance> getInstanceSettings() {
      return getInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to updateInstance. */
    public UnaryCallSettings.Builder<UpdateInstanceRequest, Operation> updateInstanceSettings() {
      return updateInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to updateInstance. */
    public OperationCallSettings.Builder<UpdateInstanceRequest, Instance, OperationMetadata>
        updateInstanceOperationSettings() {
      return updateInstanceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to renameInstance. */
    public UnaryCallSettings.Builder<RenameInstanceRequest, Instance> renameInstanceSettings() {
      return renameInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to resetInstance. */
    public UnaryCallSettings.Builder<ResetInstanceRequest, Operation> resetInstanceSettings() {
      return resetInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to resetInstance. */
    public OperationCallSettings.Builder<
            ResetInstanceRequest, ResetInstanceResponse, OperationMetadata>
        resetInstanceOperationSettings() {
      return resetInstanceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to startInstance. */
    public UnaryCallSettings.Builder<StartInstanceRequest, Operation> startInstanceSettings() {
      return startInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to startInstance. */
    public OperationCallSettings.Builder<
            StartInstanceRequest, StartInstanceResponse, OperationMetadata>
        startInstanceOperationSettings() {
      return startInstanceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to stopInstance. */
    public UnaryCallSettings.Builder<StopInstanceRequest, Operation> stopInstanceSettings() {
      return stopInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to stopInstance. */
    public OperationCallSettings.Builder<
            StopInstanceRequest, StopInstanceResponse, OperationMetadata>
        stopInstanceOperationSettings() {
      return stopInstanceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to enableInteractiveSerialConsole. */
    public UnaryCallSettings.Builder<EnableInteractiveSerialConsoleRequest, Operation>
        enableInteractiveSerialConsoleSettings() {
      return enableInteractiveSerialConsoleSettings;
    }

    /** Returns the builder for the settings used for calls to enableInteractiveSerialConsole. */
    public OperationCallSettings.Builder<
            EnableInteractiveSerialConsoleRequest,
            EnableInteractiveSerialConsoleResponse,
            OperationMetadata>
        enableInteractiveSerialConsoleOperationSettings() {
      return enableInteractiveSerialConsoleOperationSettings;
    }

    /** Returns the builder for the settings used for calls to disableInteractiveSerialConsole. */
    public UnaryCallSettings.Builder<DisableInteractiveSerialConsoleRequest, Operation>
        disableInteractiveSerialConsoleSettings() {
      return disableInteractiveSerialConsoleSettings;
    }

    /** Returns the builder for the settings used for calls to disableInteractiveSerialConsole. */
    public OperationCallSettings.Builder<
            DisableInteractiveSerialConsoleRequest,
            DisableInteractiveSerialConsoleResponse,
            OperationMetadata>
        disableInteractiveSerialConsoleOperationSettings() {
      return disableInteractiveSerialConsoleOperationSettings;
    }

    /** Returns the builder for the settings used for calls to detachLun. */
    public UnaryCallSettings.Builder<DetachLunRequest, Operation> detachLunSettings() {
      return detachLunSettings;
    }

    /** Returns the builder for the settings used for calls to detachLun. */
    public OperationCallSettings.Builder<DetachLunRequest, Instance, OperationMetadata>
        detachLunOperationSettings() {
      return detachLunOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listSSHKeys. */
    public PagedCallSettings.Builder<
            ListSSHKeysRequest, ListSSHKeysResponse, ListSSHKeysPagedResponse>
        listSSHKeysSettings() {
      return listSSHKeysSettings;
    }

    /** Returns the builder for the settings used for calls to createSSHKey. */
    public UnaryCallSettings.Builder<CreateSSHKeyRequest, SSHKey> createSSHKeySettings() {
      return createSSHKeySettings;
    }

    /** Returns the builder for the settings used for calls to deleteSSHKey. */
    public UnaryCallSettings.Builder<DeleteSSHKeyRequest, Empty> deleteSSHKeySettings() {
      return deleteSSHKeySettings;
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

    /** Returns the builder for the settings used for calls to updateVolume. */
    public UnaryCallSettings.Builder<UpdateVolumeRequest, Operation> updateVolumeSettings() {
      return updateVolumeSettings;
    }

    /** Returns the builder for the settings used for calls to updateVolume. */
    public OperationCallSettings.Builder<UpdateVolumeRequest, Volume, OperationMetadata>
        updateVolumeOperationSettings() {
      return updateVolumeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to renameVolume. */
    public UnaryCallSettings.Builder<RenameVolumeRequest, Volume> renameVolumeSettings() {
      return renameVolumeSettings;
    }

    /** Returns the builder for the settings used for calls to evictVolume. */
    public UnaryCallSettings.Builder<EvictVolumeRequest, Operation> evictVolumeSettings() {
      return evictVolumeSettings;
    }

    /** Returns the builder for the settings used for calls to evictVolume. */
    public OperationCallSettings.Builder<EvictVolumeRequest, Empty, OperationMetadata>
        evictVolumeOperationSettings() {
      return evictVolumeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to resizeVolume. */
    public UnaryCallSettings.Builder<ResizeVolumeRequest, Operation> resizeVolumeSettings() {
      return resizeVolumeSettings;
    }

    /** Returns the builder for the settings used for calls to resizeVolume. */
    public OperationCallSettings.Builder<ResizeVolumeRequest, Volume, OperationMetadata>
        resizeVolumeOperationSettings() {
      return resizeVolumeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listNetworks. */
    public PagedCallSettings.Builder<
            ListNetworksRequest, ListNetworksResponse, ListNetworksPagedResponse>
        listNetworksSettings() {
      return listNetworksSettings;
    }

    /** Returns the builder for the settings used for calls to listNetworkUsage. */
    public UnaryCallSettings.Builder<ListNetworkUsageRequest, ListNetworkUsageResponse>
        listNetworkUsageSettings() {
      return listNetworkUsageSettings;
    }

    /** Returns the builder for the settings used for calls to getNetwork. */
    public UnaryCallSettings.Builder<GetNetworkRequest, Network> getNetworkSettings() {
      return getNetworkSettings;
    }

    /** Returns the builder for the settings used for calls to updateNetwork. */
    public UnaryCallSettings.Builder<UpdateNetworkRequest, Operation> updateNetworkSettings() {
      return updateNetworkSettings;
    }

    /** Returns the builder for the settings used for calls to updateNetwork. */
    public OperationCallSettings.Builder<UpdateNetworkRequest, Network, OperationMetadata>
        updateNetworkOperationSettings() {
      return updateNetworkOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createVolumeSnapshot. */
    public UnaryCallSettings.Builder<CreateVolumeSnapshotRequest, VolumeSnapshot>
        createVolumeSnapshotSettings() {
      return createVolumeSnapshotSettings;
    }

    /** Returns the builder for the settings used for calls to restoreVolumeSnapshot. */
    public UnaryCallSettings.Builder<RestoreVolumeSnapshotRequest, Operation>
        restoreVolumeSnapshotSettings() {
      return restoreVolumeSnapshotSettings;
    }

    /** Returns the builder for the settings used for calls to restoreVolumeSnapshot. */
    public OperationCallSettings.Builder<
            RestoreVolumeSnapshotRequest, VolumeSnapshot, OperationMetadata>
        restoreVolumeSnapshotOperationSettings() {
      return restoreVolumeSnapshotOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteVolumeSnapshot. */
    public UnaryCallSettings.Builder<DeleteVolumeSnapshotRequest, Empty>
        deleteVolumeSnapshotSettings() {
      return deleteVolumeSnapshotSettings;
    }

    /** Returns the builder for the settings used for calls to getVolumeSnapshot. */
    public UnaryCallSettings.Builder<GetVolumeSnapshotRequest, VolumeSnapshot>
        getVolumeSnapshotSettings() {
      return getVolumeSnapshotSettings;
    }

    /** Returns the builder for the settings used for calls to listVolumeSnapshots. */
    public PagedCallSettings.Builder<
            ListVolumeSnapshotsRequest,
            ListVolumeSnapshotsResponse,
            ListVolumeSnapshotsPagedResponse>
        listVolumeSnapshotsSettings() {
      return listVolumeSnapshotsSettings;
    }

    /** Returns the builder for the settings used for calls to getLun. */
    public UnaryCallSettings.Builder<GetLunRequest, Lun> getLunSettings() {
      return getLunSettings;
    }

    /** Returns the builder for the settings used for calls to listLuns. */
    public PagedCallSettings.Builder<ListLunsRequest, ListLunsResponse, ListLunsPagedResponse>
        listLunsSettings() {
      return listLunsSettings;
    }

    /** Returns the builder for the settings used for calls to evictLun. */
    public UnaryCallSettings.Builder<EvictLunRequest, Operation> evictLunSettings() {
      return evictLunSettings;
    }

    /** Returns the builder for the settings used for calls to evictLun. */
    public OperationCallSettings.Builder<EvictLunRequest, Empty, OperationMetadata>
        evictLunOperationSettings() {
      return evictLunOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getNfsShare. */
    public UnaryCallSettings.Builder<GetNfsShareRequest, NfsShare> getNfsShareSettings() {
      return getNfsShareSettings;
    }

    /** Returns the builder for the settings used for calls to listNfsShares. */
    public PagedCallSettings.Builder<
            ListNfsSharesRequest, ListNfsSharesResponse, ListNfsSharesPagedResponse>
        listNfsSharesSettings() {
      return listNfsSharesSettings;
    }

    /** Returns the builder for the settings used for calls to updateNfsShare. */
    public UnaryCallSettings.Builder<UpdateNfsShareRequest, Operation> updateNfsShareSettings() {
      return updateNfsShareSettings;
    }

    /** Returns the builder for the settings used for calls to updateNfsShare. */
    public OperationCallSettings.Builder<UpdateNfsShareRequest, NfsShare, OperationMetadata>
        updateNfsShareOperationSettings() {
      return updateNfsShareOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createNfsShare. */
    public UnaryCallSettings.Builder<CreateNfsShareRequest, Operation> createNfsShareSettings() {
      return createNfsShareSettings;
    }

    /** Returns the builder for the settings used for calls to createNfsShare. */
    public OperationCallSettings.Builder<CreateNfsShareRequest, NfsShare, OperationMetadata>
        createNfsShareOperationSettings() {
      return createNfsShareOperationSettings;
    }

    /** Returns the builder for the settings used for calls to renameNfsShare. */
    public UnaryCallSettings.Builder<RenameNfsShareRequest, NfsShare> renameNfsShareSettings() {
      return renameNfsShareSettings;
    }

    /** Returns the builder for the settings used for calls to deleteNfsShare. */
    public UnaryCallSettings.Builder<DeleteNfsShareRequest, Operation> deleteNfsShareSettings() {
      return deleteNfsShareSettings;
    }

    /** Returns the builder for the settings used for calls to deleteNfsShare. */
    public OperationCallSettings.Builder<DeleteNfsShareRequest, Empty, OperationMetadata>
        deleteNfsShareOperationSettings() {
      return deleteNfsShareOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listProvisioningQuotas. */
    public PagedCallSettings.Builder<
            ListProvisioningQuotasRequest,
            ListProvisioningQuotasResponse,
            ListProvisioningQuotasPagedResponse>
        listProvisioningQuotasSettings() {
      return listProvisioningQuotasSettings;
    }

    /** Returns the builder for the settings used for calls to submitProvisioningConfig. */
    public UnaryCallSettings.Builder<
            SubmitProvisioningConfigRequest, SubmitProvisioningConfigResponse>
        submitProvisioningConfigSettings() {
      return submitProvisioningConfigSettings;
    }

    /** Returns the builder for the settings used for calls to getProvisioningConfig. */
    public UnaryCallSettings.Builder<GetProvisioningConfigRequest, ProvisioningConfig>
        getProvisioningConfigSettings() {
      return getProvisioningConfigSettings;
    }

    /** Returns the builder for the settings used for calls to createProvisioningConfig. */
    public UnaryCallSettings.Builder<CreateProvisioningConfigRequest, ProvisioningConfig>
        createProvisioningConfigSettings() {
      return createProvisioningConfigSettings;
    }

    /** Returns the builder for the settings used for calls to updateProvisioningConfig. */
    public UnaryCallSettings.Builder<UpdateProvisioningConfigRequest, ProvisioningConfig>
        updateProvisioningConfigSettings() {
      return updateProvisioningConfigSettings;
    }

    /** Returns the builder for the settings used for calls to renameNetwork. */
    public UnaryCallSettings.Builder<RenameNetworkRequest, Network> renameNetworkSettings() {
      return renameNetworkSettings;
    }

    /** Returns the builder for the settings used for calls to listOSImages. */
    public PagedCallSettings.Builder<
            ListOSImagesRequest, ListOSImagesResponse, ListOSImagesPagedResponse>
        listOSImagesSettings() {
      return listOSImagesSettings;
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
    public BareMetalSolutionStubSettings build() throws IOException {
      return new BareMetalSolutionStubSettings(this);
    }
  }
}
