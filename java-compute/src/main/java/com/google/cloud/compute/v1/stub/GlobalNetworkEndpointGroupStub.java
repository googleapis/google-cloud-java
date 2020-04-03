/*
 * Copyright 2020 Google LLC
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

import static com.google.cloud.compute.v1.GlobalNetworkEndpointGroupClient.ListGlobalNetworkEndpointGroupsPagedResponse;
import static com.google.cloud.compute.v1.GlobalNetworkEndpointGroupClient.ListNetworkEndpointsGlobalNetworkEndpointGroupsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AttachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest;
import com.google.cloud.compute.v1.DeleteGlobalNetworkEndpointGroupHttpRequest;
import com.google.cloud.compute.v1.DetachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest;
import com.google.cloud.compute.v1.GetGlobalNetworkEndpointGroupHttpRequest;
import com.google.cloud.compute.v1.InsertGlobalNetworkEndpointGroupHttpRequest;
import com.google.cloud.compute.v1.ListGlobalNetworkEndpointGroupsHttpRequest;
import com.google.cloud.compute.v1.ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest;
import com.google.cloud.compute.v1.NetworkEndpointGroup;
import com.google.cloud.compute.v1.NetworkEndpointGroupList;
import com.google.cloud.compute.v1.NetworkEndpointGroupsListNetworkEndpoints;
import com.google.cloud.compute.v1.Operation;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class GlobalNetworkEndpointGroupStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<AttachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest, Operation>
      attachNetworkEndpointsGlobalNetworkEndpointGroupCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: attachNetworkEndpointsGlobalNetworkEndpointGroupCallable()");
  }

  @BetaApi
  public UnaryCallable<DeleteGlobalNetworkEndpointGroupHttpRequest, Operation>
      deleteGlobalNetworkEndpointGroupCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteGlobalNetworkEndpointGroupCallable()");
  }

  @BetaApi
  public UnaryCallable<DetachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest, Operation>
      detachNetworkEndpointsGlobalNetworkEndpointGroupCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: detachNetworkEndpointsGlobalNetworkEndpointGroupCallable()");
  }

  @BetaApi
  public UnaryCallable<GetGlobalNetworkEndpointGroupHttpRequest, NetworkEndpointGroup>
      getGlobalNetworkEndpointGroupCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getGlobalNetworkEndpointGroupCallable()");
  }

  @BetaApi
  public UnaryCallable<InsertGlobalNetworkEndpointGroupHttpRequest, Operation>
      insertGlobalNetworkEndpointGroupCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: insertGlobalNetworkEndpointGroupCallable()");
  }

  @BetaApi
  public UnaryCallable<
          ListGlobalNetworkEndpointGroupsHttpRequest, ListGlobalNetworkEndpointGroupsPagedResponse>
      listGlobalNetworkEndpointGroupsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listGlobalNetworkEndpointGroupsPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListGlobalNetworkEndpointGroupsHttpRequest, NetworkEndpointGroupList>
      listGlobalNetworkEndpointGroupsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listGlobalNetworkEndpointGroupsCallable()");
  }

  @BetaApi
  public UnaryCallable<
          ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest,
          ListNetworkEndpointsGlobalNetworkEndpointGroupsPagedResponse>
      listNetworkEndpointsGlobalNetworkEndpointGroupsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listNetworkEndpointsGlobalNetworkEndpointGroupsPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<
          ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupsListNetworkEndpoints>
      listNetworkEndpointsGlobalNetworkEndpointGroupsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listNetworkEndpointsGlobalNetworkEndpointGroupsCallable()");
  }

  @Override
  public abstract void close();
}
