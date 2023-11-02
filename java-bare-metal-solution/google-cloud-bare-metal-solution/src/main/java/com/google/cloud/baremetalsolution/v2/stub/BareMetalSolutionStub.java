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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
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
import com.google.cloud.baremetalsolution.v2.OperationMetadata;
import com.google.cloud.baremetalsolution.v2.ProvisioningConfig;
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
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the BareMetalSolution service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class BareMetalSolutionStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listInstancesPagedCallable()");
  }

  public UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    throw new UnsupportedOperationException("Not implemented: listInstancesCallable()");
  }

  public UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: getInstanceCallable()");
  }

  public OperationCallable<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateInstanceOperationCallable()");
  }

  public UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: updateInstanceCallable()");
  }

  public UnaryCallable<RenameInstanceRequest, Instance> renameInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: renameInstanceCallable()");
  }

  public OperationCallable<ResetInstanceRequest, ResetInstanceResponse, OperationMetadata>
      resetInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: resetInstanceOperationCallable()");
  }

  public UnaryCallable<ResetInstanceRequest, Operation> resetInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: resetInstanceCallable()");
  }

  public OperationCallable<StartInstanceRequest, StartInstanceResponse, OperationMetadata>
      startInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: startInstanceOperationCallable()");
  }

  public UnaryCallable<StartInstanceRequest, Operation> startInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: startInstanceCallable()");
  }

  public OperationCallable<StopInstanceRequest, StopInstanceResponse, OperationMetadata>
      stopInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: stopInstanceOperationCallable()");
  }

  public UnaryCallable<StopInstanceRequest, Operation> stopInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: stopInstanceCallable()");
  }

  public OperationCallable<
          EnableInteractiveSerialConsoleRequest,
          EnableInteractiveSerialConsoleResponse,
          OperationMetadata>
      enableInteractiveSerialConsoleOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: enableInteractiveSerialConsoleOperationCallable()");
  }

  public UnaryCallable<EnableInteractiveSerialConsoleRequest, Operation>
      enableInteractiveSerialConsoleCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: enableInteractiveSerialConsoleCallable()");
  }

  public OperationCallable<
          DisableInteractiveSerialConsoleRequest,
          DisableInteractiveSerialConsoleResponse,
          OperationMetadata>
      disableInteractiveSerialConsoleOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: disableInteractiveSerialConsoleOperationCallable()");
  }

  public UnaryCallable<DisableInteractiveSerialConsoleRequest, Operation>
      disableInteractiveSerialConsoleCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: disableInteractiveSerialConsoleCallable()");
  }

  public OperationCallable<DetachLunRequest, Instance, OperationMetadata>
      detachLunOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: detachLunOperationCallable()");
  }

  public UnaryCallable<DetachLunRequest, Operation> detachLunCallable() {
    throw new UnsupportedOperationException("Not implemented: detachLunCallable()");
  }

  public UnaryCallable<ListSSHKeysRequest, ListSSHKeysPagedResponse> listSSHKeysPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSSHKeysPagedCallable()");
  }

  public UnaryCallable<ListSSHKeysRequest, ListSSHKeysResponse> listSSHKeysCallable() {
    throw new UnsupportedOperationException("Not implemented: listSSHKeysCallable()");
  }

  public UnaryCallable<CreateSSHKeyRequest, SSHKey> createSSHKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: createSSHKeyCallable()");
  }

  public UnaryCallable<DeleteSSHKeyRequest, Empty> deleteSSHKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSSHKeyCallable()");
  }

  public UnaryCallable<ListVolumesRequest, ListVolumesPagedResponse> listVolumesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listVolumesPagedCallable()");
  }

  public UnaryCallable<ListVolumesRequest, ListVolumesResponse> listVolumesCallable() {
    throw new UnsupportedOperationException("Not implemented: listVolumesCallable()");
  }

  public UnaryCallable<GetVolumeRequest, Volume> getVolumeCallable() {
    throw new UnsupportedOperationException("Not implemented: getVolumeCallable()");
  }

  public OperationCallable<UpdateVolumeRequest, Volume, OperationMetadata>
      updateVolumeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateVolumeOperationCallable()");
  }

  public UnaryCallable<UpdateVolumeRequest, Operation> updateVolumeCallable() {
    throw new UnsupportedOperationException("Not implemented: updateVolumeCallable()");
  }

  public UnaryCallable<RenameVolumeRequest, Volume> renameVolumeCallable() {
    throw new UnsupportedOperationException("Not implemented: renameVolumeCallable()");
  }

  public OperationCallable<EvictVolumeRequest, Empty, OperationMetadata>
      evictVolumeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: evictVolumeOperationCallable()");
  }

  public UnaryCallable<EvictVolumeRequest, Operation> evictVolumeCallable() {
    throw new UnsupportedOperationException("Not implemented: evictVolumeCallable()");
  }

  public OperationCallable<ResizeVolumeRequest, Volume, OperationMetadata>
      resizeVolumeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: resizeVolumeOperationCallable()");
  }

  public UnaryCallable<ResizeVolumeRequest, Operation> resizeVolumeCallable() {
    throw new UnsupportedOperationException("Not implemented: resizeVolumeCallable()");
  }

  public UnaryCallable<ListNetworksRequest, ListNetworksPagedResponse> listNetworksPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listNetworksPagedCallable()");
  }

  public UnaryCallable<ListNetworksRequest, ListNetworksResponse> listNetworksCallable() {
    throw new UnsupportedOperationException("Not implemented: listNetworksCallable()");
  }

  public UnaryCallable<ListNetworkUsageRequest, ListNetworkUsageResponse>
      listNetworkUsageCallable() {
    throw new UnsupportedOperationException("Not implemented: listNetworkUsageCallable()");
  }

  public UnaryCallable<GetNetworkRequest, Network> getNetworkCallable() {
    throw new UnsupportedOperationException("Not implemented: getNetworkCallable()");
  }

  public OperationCallable<UpdateNetworkRequest, Network, OperationMetadata>
      updateNetworkOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateNetworkOperationCallable()");
  }

  public UnaryCallable<UpdateNetworkRequest, Operation> updateNetworkCallable() {
    throw new UnsupportedOperationException("Not implemented: updateNetworkCallable()");
  }

  public UnaryCallable<CreateVolumeSnapshotRequest, VolumeSnapshot> createVolumeSnapshotCallable() {
    throw new UnsupportedOperationException("Not implemented: createVolumeSnapshotCallable()");
  }

  public OperationCallable<RestoreVolumeSnapshotRequest, VolumeSnapshot, OperationMetadata>
      restoreVolumeSnapshotOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: restoreVolumeSnapshotOperationCallable()");
  }

  public UnaryCallable<RestoreVolumeSnapshotRequest, Operation> restoreVolumeSnapshotCallable() {
    throw new UnsupportedOperationException("Not implemented: restoreVolumeSnapshotCallable()");
  }

  public UnaryCallable<DeleteVolumeSnapshotRequest, Empty> deleteVolumeSnapshotCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteVolumeSnapshotCallable()");
  }

  public UnaryCallable<GetVolumeSnapshotRequest, VolumeSnapshot> getVolumeSnapshotCallable() {
    throw new UnsupportedOperationException("Not implemented: getVolumeSnapshotCallable()");
  }

  public UnaryCallable<ListVolumeSnapshotsRequest, ListVolumeSnapshotsPagedResponse>
      listVolumeSnapshotsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listVolumeSnapshotsPagedCallable()");
  }

  public UnaryCallable<ListVolumeSnapshotsRequest, ListVolumeSnapshotsResponse>
      listVolumeSnapshotsCallable() {
    throw new UnsupportedOperationException("Not implemented: listVolumeSnapshotsCallable()");
  }

  public UnaryCallable<GetLunRequest, Lun> getLunCallable() {
    throw new UnsupportedOperationException("Not implemented: getLunCallable()");
  }

  public UnaryCallable<ListLunsRequest, ListLunsPagedResponse> listLunsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLunsPagedCallable()");
  }

  public UnaryCallable<ListLunsRequest, ListLunsResponse> listLunsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLunsCallable()");
  }

  public OperationCallable<EvictLunRequest, Empty, OperationMetadata> evictLunOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: evictLunOperationCallable()");
  }

  public UnaryCallable<EvictLunRequest, Operation> evictLunCallable() {
    throw new UnsupportedOperationException("Not implemented: evictLunCallable()");
  }

  public UnaryCallable<GetNfsShareRequest, NfsShare> getNfsShareCallable() {
    throw new UnsupportedOperationException("Not implemented: getNfsShareCallable()");
  }

  public UnaryCallable<ListNfsSharesRequest, ListNfsSharesPagedResponse>
      listNfsSharesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listNfsSharesPagedCallable()");
  }

  public UnaryCallable<ListNfsSharesRequest, ListNfsSharesResponse> listNfsSharesCallable() {
    throw new UnsupportedOperationException("Not implemented: listNfsSharesCallable()");
  }

  public OperationCallable<UpdateNfsShareRequest, NfsShare, OperationMetadata>
      updateNfsShareOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateNfsShareOperationCallable()");
  }

  public UnaryCallable<UpdateNfsShareRequest, Operation> updateNfsShareCallable() {
    throw new UnsupportedOperationException("Not implemented: updateNfsShareCallable()");
  }

  public OperationCallable<CreateNfsShareRequest, NfsShare, OperationMetadata>
      createNfsShareOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createNfsShareOperationCallable()");
  }

  public UnaryCallable<CreateNfsShareRequest, Operation> createNfsShareCallable() {
    throw new UnsupportedOperationException("Not implemented: createNfsShareCallable()");
  }

  public UnaryCallable<RenameNfsShareRequest, NfsShare> renameNfsShareCallable() {
    throw new UnsupportedOperationException("Not implemented: renameNfsShareCallable()");
  }

  public OperationCallable<DeleteNfsShareRequest, Empty, OperationMetadata>
      deleteNfsShareOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteNfsShareOperationCallable()");
  }

  public UnaryCallable<DeleteNfsShareRequest, Operation> deleteNfsShareCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteNfsShareCallable()");
  }

  public UnaryCallable<ListProvisioningQuotasRequest, ListProvisioningQuotasPagedResponse>
      listProvisioningQuotasPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listProvisioningQuotasPagedCallable()");
  }

  public UnaryCallable<ListProvisioningQuotasRequest, ListProvisioningQuotasResponse>
      listProvisioningQuotasCallable() {
    throw new UnsupportedOperationException("Not implemented: listProvisioningQuotasCallable()");
  }

  public UnaryCallable<SubmitProvisioningConfigRequest, SubmitProvisioningConfigResponse>
      submitProvisioningConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: submitProvisioningConfigCallable()");
  }

  public UnaryCallable<GetProvisioningConfigRequest, ProvisioningConfig>
      getProvisioningConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getProvisioningConfigCallable()");
  }

  public UnaryCallable<CreateProvisioningConfigRequest, ProvisioningConfig>
      createProvisioningConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: createProvisioningConfigCallable()");
  }

  public UnaryCallable<UpdateProvisioningConfigRequest, ProvisioningConfig>
      updateProvisioningConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: updateProvisioningConfigCallable()");
  }

  public UnaryCallable<RenameNetworkRequest, Network> renameNetworkCallable() {
    throw new UnsupportedOperationException("Not implemented: renameNetworkCallable()");
  }

  public UnaryCallable<ListOSImagesRequest, ListOSImagesPagedResponse> listOSImagesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listOSImagesPagedCallable()");
  }

  public UnaryCallable<ListOSImagesRequest, ListOSImagesResponse> listOSImagesCallable() {
    throw new UnsupportedOperationException("Not implemented: listOSImagesCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getLocationCallable()");
  }

  @Override
  public abstract void close();
}
