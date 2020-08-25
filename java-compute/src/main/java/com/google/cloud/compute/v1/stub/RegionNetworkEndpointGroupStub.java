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

import static com.google.cloud.compute.v1.RegionNetworkEndpointGroupClient.ListRegionNetworkEndpointGroupsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.DeleteRegionNetworkEndpointGroupHttpRequest;
import com.google.cloud.compute.v1.GetRegionNetworkEndpointGroupHttpRequest;
import com.google.cloud.compute.v1.InsertRegionNetworkEndpointGroupHttpRequest;
import com.google.cloud.compute.v1.ListRegionNetworkEndpointGroupsHttpRequest;
import com.google.cloud.compute.v1.NetworkEndpointGroup;
import com.google.cloud.compute.v1.NetworkEndpointGroupList;
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
public abstract class RegionNetworkEndpointGroupStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<DeleteRegionNetworkEndpointGroupHttpRequest, Operation>
      deleteRegionNetworkEndpointGroupCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteRegionNetworkEndpointGroupCallable()");
  }

  @BetaApi
  public UnaryCallable<GetRegionNetworkEndpointGroupHttpRequest, NetworkEndpointGroup>
      getRegionNetworkEndpointGroupCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getRegionNetworkEndpointGroupCallable()");
  }

  @BetaApi
  public UnaryCallable<InsertRegionNetworkEndpointGroupHttpRequest, Operation>
      insertRegionNetworkEndpointGroupCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: insertRegionNetworkEndpointGroupCallable()");
  }

  @BetaApi
  public UnaryCallable<
          ListRegionNetworkEndpointGroupsHttpRequest, ListRegionNetworkEndpointGroupsPagedResponse>
      listRegionNetworkEndpointGroupsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listRegionNetworkEndpointGroupsPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListRegionNetworkEndpointGroupsHttpRequest, NetworkEndpointGroupList>
      listRegionNetworkEndpointGroupsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listRegionNetworkEndpointGroupsCallable()");
  }

  @Override
  public abstract void close();
}
