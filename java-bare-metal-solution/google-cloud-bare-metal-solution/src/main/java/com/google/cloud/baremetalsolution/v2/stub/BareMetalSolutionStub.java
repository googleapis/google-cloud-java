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

package com.google.cloud.baremetalsolution.v2.stub;

import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListInstancesPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListLunsPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListNetworksPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListNfsSharesPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListVolumesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.baremetalsolution.v2.DetachLunRequest;
import com.google.cloud.baremetalsolution.v2.GetInstanceRequest;
import com.google.cloud.baremetalsolution.v2.GetLunRequest;
import com.google.cloud.baremetalsolution.v2.GetNetworkRequest;
import com.google.cloud.baremetalsolution.v2.GetNfsShareRequest;
import com.google.cloud.baremetalsolution.v2.GetVolumeRequest;
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
import com.google.cloud.baremetalsolution.v2.ListVolumesRequest;
import com.google.cloud.baremetalsolution.v2.ListVolumesResponse;
import com.google.cloud.baremetalsolution.v2.Lun;
import com.google.cloud.baremetalsolution.v2.Network;
import com.google.cloud.baremetalsolution.v2.NfsShare;
import com.google.cloud.baremetalsolution.v2.OperationMetadata;
import com.google.cloud.baremetalsolution.v2.ResetInstanceRequest;
import com.google.cloud.baremetalsolution.v2.ResetInstanceResponse;
import com.google.cloud.baremetalsolution.v2.ResizeVolumeRequest;
import com.google.cloud.baremetalsolution.v2.StartInstanceRequest;
import com.google.cloud.baremetalsolution.v2.StartInstanceResponse;
import com.google.cloud.baremetalsolution.v2.StopInstanceRequest;
import com.google.cloud.baremetalsolution.v2.StopInstanceResponse;
import com.google.cloud.baremetalsolution.v2.UpdateInstanceRequest;
import com.google.cloud.baremetalsolution.v2.UpdateNetworkRequest;
import com.google.cloud.baremetalsolution.v2.UpdateNfsShareRequest;
import com.google.cloud.baremetalsolution.v2.UpdateVolumeRequest;
import com.google.cloud.baremetalsolution.v2.Volume;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
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

  public OperationCallable<DetachLunRequest, Instance, OperationMetadata>
      detachLunOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: detachLunOperationCallable()");
  }

  public UnaryCallable<DetachLunRequest, Operation> detachLunCallable() {
    throw new UnsupportedOperationException("Not implemented: detachLunCallable()");
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

  public UnaryCallable<GetLunRequest, Lun> getLunCallable() {
    throw new UnsupportedOperationException("Not implemented: getLunCallable()");
  }

  public UnaryCallable<ListLunsRequest, ListLunsPagedResponse> listLunsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLunsPagedCallable()");
  }

  public UnaryCallable<ListLunsRequest, ListLunsResponse> listLunsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLunsCallable()");
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

  @Override
  public abstract void close();
}
