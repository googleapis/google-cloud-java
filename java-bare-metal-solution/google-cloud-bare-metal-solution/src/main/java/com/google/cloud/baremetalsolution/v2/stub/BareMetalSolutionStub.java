/*
 * Copyright 2021 Google LLC
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
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListLunsPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListNetworksPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListSnapshotSchedulePoliciesPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListVolumeSnapshotsPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListVolumesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.baremetalsolution.v2.CreateSnapshotSchedulePolicyRequest;
import com.google.cloud.baremetalsolution.v2.CreateVolumeSnapshotRequest;
import com.google.cloud.baremetalsolution.v2.DeleteSnapshotSchedulePolicyRequest;
import com.google.cloud.baremetalsolution.v2.DeleteVolumeSnapshotRequest;
import com.google.cloud.baremetalsolution.v2.GetInstanceRequest;
import com.google.cloud.baremetalsolution.v2.GetLunRequest;
import com.google.cloud.baremetalsolution.v2.GetNetworkRequest;
import com.google.cloud.baremetalsolution.v2.GetSnapshotSchedulePolicyRequest;
import com.google.cloud.baremetalsolution.v2.GetVolumeRequest;
import com.google.cloud.baremetalsolution.v2.GetVolumeSnapshotRequest;
import com.google.cloud.baremetalsolution.v2.Instance;
import com.google.cloud.baremetalsolution.v2.ListInstancesRequest;
import com.google.cloud.baremetalsolution.v2.ListInstancesResponse;
import com.google.cloud.baremetalsolution.v2.ListLunsRequest;
import com.google.cloud.baremetalsolution.v2.ListLunsResponse;
import com.google.cloud.baremetalsolution.v2.ListNetworksRequest;
import com.google.cloud.baremetalsolution.v2.ListNetworksResponse;
import com.google.cloud.baremetalsolution.v2.ListSnapshotSchedulePoliciesRequest;
import com.google.cloud.baremetalsolution.v2.ListSnapshotSchedulePoliciesResponse;
import com.google.cloud.baremetalsolution.v2.ListVolumeSnapshotsRequest;
import com.google.cloud.baremetalsolution.v2.ListVolumeSnapshotsResponse;
import com.google.cloud.baremetalsolution.v2.ListVolumesRequest;
import com.google.cloud.baremetalsolution.v2.ListVolumesResponse;
import com.google.cloud.baremetalsolution.v2.Lun;
import com.google.cloud.baremetalsolution.v2.Network;
import com.google.cloud.baremetalsolution.v2.OperationMetadata;
import com.google.cloud.baremetalsolution.v2.ResetInstanceRequest;
import com.google.cloud.baremetalsolution.v2.ResetInstanceResponse;
import com.google.cloud.baremetalsolution.v2.RestoreVolumeSnapshotRequest;
import com.google.cloud.baremetalsolution.v2.SnapshotSchedulePolicy;
import com.google.cloud.baremetalsolution.v2.UpdateSnapshotSchedulePolicyRequest;
import com.google.cloud.baremetalsolution.v2.UpdateVolumeRequest;
import com.google.cloud.baremetalsolution.v2.Volume;
import com.google.cloud.baremetalsolution.v2.VolumeSnapshot;
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
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
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

  public OperationCallable<ResetInstanceRequest, ResetInstanceResponse, OperationMetadata>
      resetInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: resetInstanceOperationCallable()");
  }

  public UnaryCallable<ResetInstanceRequest, Operation> resetInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: resetInstanceCallable()");
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

  public UnaryCallable<ListNetworksRequest, ListNetworksPagedResponse> listNetworksPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listNetworksPagedCallable()");
  }

  public UnaryCallable<ListNetworksRequest, ListNetworksResponse> listNetworksCallable() {
    throw new UnsupportedOperationException("Not implemented: listNetworksCallable()");
  }

  public UnaryCallable<GetNetworkRequest, Network> getNetworkCallable() {
    throw new UnsupportedOperationException("Not implemented: getNetworkCallable()");
  }

  public UnaryCallable<
          ListSnapshotSchedulePoliciesRequest, ListSnapshotSchedulePoliciesPagedResponse>
      listSnapshotSchedulePoliciesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listSnapshotSchedulePoliciesPagedCallable()");
  }

  public UnaryCallable<ListSnapshotSchedulePoliciesRequest, ListSnapshotSchedulePoliciesResponse>
      listSnapshotSchedulePoliciesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listSnapshotSchedulePoliciesCallable()");
  }

  public UnaryCallable<GetSnapshotSchedulePolicyRequest, SnapshotSchedulePolicy>
      getSnapshotSchedulePolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getSnapshotSchedulePolicyCallable()");
  }

  public UnaryCallable<CreateSnapshotSchedulePolicyRequest, SnapshotSchedulePolicy>
      createSnapshotSchedulePolicyCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createSnapshotSchedulePolicyCallable()");
  }

  public UnaryCallable<UpdateSnapshotSchedulePolicyRequest, SnapshotSchedulePolicy>
      updateSnapshotSchedulePolicyCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateSnapshotSchedulePolicyCallable()");
  }

  public UnaryCallable<DeleteSnapshotSchedulePolicyRequest, Empty>
      deleteSnapshotSchedulePolicyCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteSnapshotSchedulePolicyCallable()");
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

  @Override
  public abstract void close();
}
