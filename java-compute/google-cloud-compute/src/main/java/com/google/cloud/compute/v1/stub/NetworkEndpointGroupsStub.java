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

import static com.google.cloud.compute.v1.NetworkEndpointGroupsClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.NetworkEndpointGroupsClient.ListNetworkEndpointsPagedResponse;
import static com.google.cloud.compute.v1.NetworkEndpointGroupsClient.ListPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AggregatedListNetworkEndpointGroupsRequest;
import com.google.cloud.compute.v1.AttachNetworkEndpointsNetworkEndpointGroupRequest;
import com.google.cloud.compute.v1.DeleteNetworkEndpointGroupRequest;
import com.google.cloud.compute.v1.DetachNetworkEndpointsNetworkEndpointGroupRequest;
import com.google.cloud.compute.v1.GetNetworkEndpointGroupRequest;
import com.google.cloud.compute.v1.InsertNetworkEndpointGroupRequest;
import com.google.cloud.compute.v1.ListNetworkEndpointGroupsRequest;
import com.google.cloud.compute.v1.ListNetworkEndpointsNetworkEndpointGroupsRequest;
import com.google.cloud.compute.v1.NetworkEndpointGroup;
import com.google.cloud.compute.v1.NetworkEndpointGroupAggregatedList;
import com.google.cloud.compute.v1.NetworkEndpointGroupList;
import com.google.cloud.compute.v1.NetworkEndpointGroupsListNetworkEndpoints;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.TestIamPermissionsNetworkEndpointGroupRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the NetworkEndpointGroups service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class NetworkEndpointGroupsStub implements BackgroundResource {

  public UnaryCallable<AggregatedListNetworkEndpointGroupsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListPagedCallable()");
  }

  public UnaryCallable<
          AggregatedListNetworkEndpointGroupsRequest, NetworkEndpointGroupAggregatedList>
      aggregatedListCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListCallable()");
  }

  public OperationCallable<AttachNetworkEndpointsNetworkEndpointGroupRequest, Operation, Operation>
      attachNetworkEndpointsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: attachNetworkEndpointsOperationCallable()");
  }

  public UnaryCallable<AttachNetworkEndpointsNetworkEndpointGroupRequest, Operation>
      attachNetworkEndpointsCallable() {
    throw new UnsupportedOperationException("Not implemented: attachNetworkEndpointsCallable()");
  }

  public OperationCallable<DeleteNetworkEndpointGroupRequest, Operation, Operation>
      deleteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOperationCallable()");
  }

  public UnaryCallable<DeleteNetworkEndpointGroupRequest, Operation> deleteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallable()");
  }

  public OperationCallable<DetachNetworkEndpointsNetworkEndpointGroupRequest, Operation, Operation>
      detachNetworkEndpointsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: detachNetworkEndpointsOperationCallable()");
  }

  public UnaryCallable<DetachNetworkEndpointsNetworkEndpointGroupRequest, Operation>
      detachNetworkEndpointsCallable() {
    throw new UnsupportedOperationException("Not implemented: detachNetworkEndpointsCallable()");
  }

  public UnaryCallable<GetNetworkEndpointGroupRequest, NetworkEndpointGroup> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public OperationCallable<InsertNetworkEndpointGroupRequest, Operation, Operation>
      insertOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: insertOperationCallable()");
  }

  public UnaryCallable<InsertNetworkEndpointGroupRequest, Operation> insertCallable() {
    throw new UnsupportedOperationException("Not implemented: insertCallable()");
  }

  public UnaryCallable<ListNetworkEndpointGroupsRequest, ListPagedResponse> listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListNetworkEndpointGroupsRequest, NetworkEndpointGroupList> listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  public UnaryCallable<
          ListNetworkEndpointsNetworkEndpointGroupsRequest, ListNetworkEndpointsPagedResponse>
      listNetworkEndpointsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listNetworkEndpointsPagedCallable()");
  }

  public UnaryCallable<
          ListNetworkEndpointsNetworkEndpointGroupsRequest,
          NetworkEndpointGroupsListNetworkEndpoints>
      listNetworkEndpointsCallable() {
    throw new UnsupportedOperationException("Not implemented: listNetworkEndpointsCallable()");
  }

  public UnaryCallable<TestIamPermissionsNetworkEndpointGroupRequest, TestPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
