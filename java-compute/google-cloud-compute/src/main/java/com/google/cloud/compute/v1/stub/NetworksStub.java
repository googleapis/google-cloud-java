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

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.NetworksClient.ListPagedResponse;
import static com.google.cloud.compute.v1.NetworksClient.ListPeeringRoutesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AddPeeringNetworkRequest;
import com.google.cloud.compute.v1.DeleteNetworkRequest;
import com.google.cloud.compute.v1.ExchangedPeeringRoutesList;
import com.google.cloud.compute.v1.GetEffectiveFirewallsNetworkRequest;
import com.google.cloud.compute.v1.GetNetworkRequest;
import com.google.cloud.compute.v1.InsertNetworkRequest;
import com.google.cloud.compute.v1.ListNetworksRequest;
import com.google.cloud.compute.v1.ListPeeringRoutesNetworksRequest;
import com.google.cloud.compute.v1.Network;
import com.google.cloud.compute.v1.NetworkList;
import com.google.cloud.compute.v1.NetworksGetEffectiveFirewallsResponse;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchNetworkRequest;
import com.google.cloud.compute.v1.RemovePeeringNetworkRequest;
import com.google.cloud.compute.v1.SwitchToCustomModeNetworkRequest;
import com.google.cloud.compute.v1.UpdatePeeringNetworkRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Networks service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class NetworksStub implements BackgroundResource {

  public OperationCallable<AddPeeringNetworkRequest, Operation, Operation>
      addPeeringOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: addPeeringOperationCallable()");
  }

  public UnaryCallable<AddPeeringNetworkRequest, Operation> addPeeringCallable() {
    throw new UnsupportedOperationException("Not implemented: addPeeringCallable()");
  }

  public OperationCallable<DeleteNetworkRequest, Operation, Operation> deleteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOperationCallable()");
  }

  public UnaryCallable<DeleteNetworkRequest, Operation> deleteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallable()");
  }

  public UnaryCallable<GetNetworkRequest, Network> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public UnaryCallable<GetEffectiveFirewallsNetworkRequest, NetworksGetEffectiveFirewallsResponse>
      getEffectiveFirewallsCallable() {
    throw new UnsupportedOperationException("Not implemented: getEffectiveFirewallsCallable()");
  }

  public OperationCallable<InsertNetworkRequest, Operation, Operation> insertOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: insertOperationCallable()");
  }

  public UnaryCallable<InsertNetworkRequest, Operation> insertCallable() {
    throw new UnsupportedOperationException("Not implemented: insertCallable()");
  }

  public UnaryCallable<ListNetworksRequest, ListPagedResponse> listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListNetworksRequest, NetworkList> listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  public UnaryCallable<ListPeeringRoutesNetworksRequest, ListPeeringRoutesPagedResponse>
      listPeeringRoutesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPeeringRoutesPagedCallable()");
  }

  public UnaryCallable<ListPeeringRoutesNetworksRequest, ExchangedPeeringRoutesList>
      listPeeringRoutesCallable() {
    throw new UnsupportedOperationException("Not implemented: listPeeringRoutesCallable()");
  }

  public OperationCallable<PatchNetworkRequest, Operation, Operation> patchOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: patchOperationCallable()");
  }

  public UnaryCallable<PatchNetworkRequest, Operation> patchCallable() {
    throw new UnsupportedOperationException("Not implemented: patchCallable()");
  }

  public OperationCallable<RemovePeeringNetworkRequest, Operation, Operation>
      removePeeringOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: removePeeringOperationCallable()");
  }

  public UnaryCallable<RemovePeeringNetworkRequest, Operation> removePeeringCallable() {
    throw new UnsupportedOperationException("Not implemented: removePeeringCallable()");
  }

  public OperationCallable<SwitchToCustomModeNetworkRequest, Operation, Operation>
      switchToCustomModeOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: switchToCustomModeOperationCallable()");
  }

  public UnaryCallable<SwitchToCustomModeNetworkRequest, Operation> switchToCustomModeCallable() {
    throw new UnsupportedOperationException("Not implemented: switchToCustomModeCallable()");
  }

  public OperationCallable<UpdatePeeringNetworkRequest, Operation, Operation>
      updatePeeringOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updatePeeringOperationCallable()");
  }

  public UnaryCallable<UpdatePeeringNetworkRequest, Operation> updatePeeringCallable() {
    throw new UnsupportedOperationException("Not implemented: updatePeeringCallable()");
  }

  @Override
  public abstract void close();
}
