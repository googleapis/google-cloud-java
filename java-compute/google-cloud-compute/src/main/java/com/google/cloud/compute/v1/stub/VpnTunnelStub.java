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

import static com.google.cloud.compute.v1.VpnTunnelClient.AggregatedListVpnTunnelsPagedResponse;
import static com.google.cloud.compute.v1.VpnTunnelClient.ListVpnTunnelsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AggregatedListVpnTunnelsHttpRequest;
import com.google.cloud.compute.v1.DeleteVpnTunnelHttpRequest;
import com.google.cloud.compute.v1.GetVpnTunnelHttpRequest;
import com.google.cloud.compute.v1.InsertVpnTunnelHttpRequest;
import com.google.cloud.compute.v1.ListVpnTunnelsHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.VpnTunnel;
import com.google.cloud.compute.v1.VpnTunnelAggregatedList;
import com.google.cloud.compute.v1.VpnTunnelList;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class VpnTunnelStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<AggregatedListVpnTunnelsHttpRequest, AggregatedListVpnTunnelsPagedResponse>
      aggregatedListVpnTunnelsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: aggregatedListVpnTunnelsPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<AggregatedListVpnTunnelsHttpRequest, VpnTunnelAggregatedList>
      aggregatedListVpnTunnelsCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListVpnTunnelsCallable()");
  }

  @BetaApi
  public UnaryCallable<DeleteVpnTunnelHttpRequest, Operation> deleteVpnTunnelCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteVpnTunnelCallable()");
  }

  @BetaApi
  public UnaryCallable<GetVpnTunnelHttpRequest, VpnTunnel> getVpnTunnelCallable() {
    throw new UnsupportedOperationException("Not implemented: getVpnTunnelCallable()");
  }

  @BetaApi
  public UnaryCallable<InsertVpnTunnelHttpRequest, Operation> insertVpnTunnelCallable() {
    throw new UnsupportedOperationException("Not implemented: insertVpnTunnelCallable()");
  }

  @BetaApi
  public UnaryCallable<ListVpnTunnelsHttpRequest, ListVpnTunnelsPagedResponse>
      listVpnTunnelsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listVpnTunnelsPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListVpnTunnelsHttpRequest, VpnTunnelList> listVpnTunnelsCallable() {
    throw new UnsupportedOperationException("Not implemented: listVpnTunnelsCallable()");
  }

  @Override
  public abstract void close();
}
