/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.NetworkClient.ListNetworksPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AddPeeringNetworkHttpRequest;
import com.google.cloud.compute.v1.DeleteNetworkHttpRequest;
import com.google.cloud.compute.v1.GetNetworkHttpRequest;
import com.google.cloud.compute.v1.InsertNetworkHttpRequest;
import com.google.cloud.compute.v1.ListNetworksHttpRequest;
import com.google.cloud.compute.v1.Network;
import com.google.cloud.compute.v1.NetworkList;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchNetworkHttpRequest;
import com.google.cloud.compute.v1.RemovePeeringNetworkHttpRequest;
import com.google.cloud.compute.v1.SwitchToCustomModeNetworkHttpRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class NetworkStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<AddPeeringNetworkHttpRequest, Operation> addPeeringNetworkCallable() {
    throw new UnsupportedOperationException("Not implemented: addPeeringNetworkCallable()");
  }

  @BetaApi
  public UnaryCallable<DeleteNetworkHttpRequest, Operation> deleteNetworkCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteNetworkCallable()");
  }

  @BetaApi
  public UnaryCallable<GetNetworkHttpRequest, Network> getNetworkCallable() {
    throw new UnsupportedOperationException("Not implemented: getNetworkCallable()");
  }

  @BetaApi
  public UnaryCallable<InsertNetworkHttpRequest, Operation> insertNetworkCallable() {
    throw new UnsupportedOperationException("Not implemented: insertNetworkCallable()");
  }

  @BetaApi
  public UnaryCallable<ListNetworksHttpRequest, ListNetworksPagedResponse>
      listNetworksPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listNetworksPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListNetworksHttpRequest, NetworkList> listNetworksCallable() {
    throw new UnsupportedOperationException("Not implemented: listNetworksCallable()");
  }

  @BetaApi
  public UnaryCallable<PatchNetworkHttpRequest, Operation> patchNetworkCallable() {
    throw new UnsupportedOperationException("Not implemented: patchNetworkCallable()");
  }

  @BetaApi
  public UnaryCallable<RemovePeeringNetworkHttpRequest, Operation> removePeeringNetworkCallable() {
    throw new UnsupportedOperationException("Not implemented: removePeeringNetworkCallable()");
  }

  @BetaApi
  public UnaryCallable<SwitchToCustomModeNetworkHttpRequest, Operation>
      switchToCustomModeNetworkCallable() {
    throw new UnsupportedOperationException("Not implemented: switchToCustomModeNetworkCallable()");
  }

  @Override
  public abstract void close();
}
