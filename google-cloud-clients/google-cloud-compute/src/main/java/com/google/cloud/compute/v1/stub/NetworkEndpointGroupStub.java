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

import static com.google.cloud.compute.v1.NetworkEndpointGroupClient.AggregatedListNetworkEndpointGroupsPagedResponse;
import static com.google.cloud.compute.v1.NetworkEndpointGroupClient.ListNetworkEndpointGroupsPagedResponse;
import static com.google.cloud.compute.v1.NetworkEndpointGroupClient.ListNetworkEndpointsNetworkEndpointGroupsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AggregatedListNetworkEndpointGroupsHttpRequest;
import com.google.cloud.compute.v1.AttachNetworkEndpointsNetworkEndpointGroupHttpRequest;
import com.google.cloud.compute.v1.DeleteNetworkEndpointGroupHttpRequest;
import com.google.cloud.compute.v1.DetachNetworkEndpointsNetworkEndpointGroupHttpRequest;
import com.google.cloud.compute.v1.GetNetworkEndpointGroupHttpRequest;
import com.google.cloud.compute.v1.InsertNetworkEndpointGroupHttpRequest;
import com.google.cloud.compute.v1.ListNetworkEndpointGroupsHttpRequest;
import com.google.cloud.compute.v1.ListNetworkEndpointsNetworkEndpointGroupsHttpRequest;
import com.google.cloud.compute.v1.NetworkEndpointGroup;
import com.google.cloud.compute.v1.NetworkEndpointGroupAggregatedList;
import com.google.cloud.compute.v1.NetworkEndpointGroupList;
import com.google.cloud.compute.v1.NetworkEndpointGroupsListNetworkEndpoints;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.TestIamPermissionsNetworkEndpointGroupHttpRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class NetworkEndpointGroupStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<
          AggregatedListNetworkEndpointGroupsHttpRequest,
          AggregatedListNetworkEndpointGroupsPagedResponse>
      aggregatedListNetworkEndpointGroupsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: aggregatedListNetworkEndpointGroupsPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<
          AggregatedListNetworkEndpointGroupsHttpRequest, NetworkEndpointGroupAggregatedList>
      aggregatedListNetworkEndpointGroupsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: aggregatedListNetworkEndpointGroupsCallable()");
  }

  @BetaApi
  public UnaryCallable<AttachNetworkEndpointsNetworkEndpointGroupHttpRequest, Operation>
      attachNetworkEndpointsNetworkEndpointGroupCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: attachNetworkEndpointsNetworkEndpointGroupCallable()");
  }

  @BetaApi
  public UnaryCallable<DeleteNetworkEndpointGroupHttpRequest, Operation>
      deleteNetworkEndpointGroupCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteNetworkEndpointGroupCallable()");
  }

  @BetaApi
  public UnaryCallable<DetachNetworkEndpointsNetworkEndpointGroupHttpRequest, Operation>
      detachNetworkEndpointsNetworkEndpointGroupCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: detachNetworkEndpointsNetworkEndpointGroupCallable()");
  }

  @BetaApi
  public UnaryCallable<GetNetworkEndpointGroupHttpRequest, NetworkEndpointGroup>
      getNetworkEndpointGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: getNetworkEndpointGroupCallable()");
  }

  @BetaApi
  public UnaryCallable<InsertNetworkEndpointGroupHttpRequest, Operation>
      insertNetworkEndpointGroupCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: insertNetworkEndpointGroupCallable()");
  }

  @BetaApi
  public UnaryCallable<ListNetworkEndpointGroupsHttpRequest, ListNetworkEndpointGroupsPagedResponse>
      listNetworkEndpointGroupsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listNetworkEndpointGroupsPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListNetworkEndpointGroupsHttpRequest, NetworkEndpointGroupList>
      listNetworkEndpointGroupsCallable() {
    throw new UnsupportedOperationException("Not implemented: listNetworkEndpointGroupsCallable()");
  }

  @BetaApi
  public UnaryCallable<
          ListNetworkEndpointsNetworkEndpointGroupsHttpRequest,
          ListNetworkEndpointsNetworkEndpointGroupsPagedResponse>
      listNetworkEndpointsNetworkEndpointGroupsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listNetworkEndpointsNetworkEndpointGroupsPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<
          ListNetworkEndpointsNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupsListNetworkEndpoints>
      listNetworkEndpointsNetworkEndpointGroupsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listNetworkEndpointsNetworkEndpointGroupsCallable()");
  }

  @BetaApi
  public UnaryCallable<TestIamPermissionsNetworkEndpointGroupHttpRequest, TestPermissionsResponse>
      testIamPermissionsNetworkEndpointGroupCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: testIamPermissionsNetworkEndpointGroupCallable()");
  }

  @Override
  public abstract void close();
}
