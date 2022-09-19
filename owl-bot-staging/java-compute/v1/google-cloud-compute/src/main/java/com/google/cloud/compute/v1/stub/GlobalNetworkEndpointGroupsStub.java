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

import static com.google.cloud.compute.v1.GlobalNetworkEndpointGroupsClient.ListNetworkEndpointsPagedResponse;
import static com.google.cloud.compute.v1.GlobalNetworkEndpointGroupsClient.ListPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest;
import com.google.cloud.compute.v1.DeleteGlobalNetworkEndpointGroupRequest;
import com.google.cloud.compute.v1.DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest;
import com.google.cloud.compute.v1.GetGlobalNetworkEndpointGroupRequest;
import com.google.cloud.compute.v1.InsertGlobalNetworkEndpointGroupRequest;
import com.google.cloud.compute.v1.ListGlobalNetworkEndpointGroupsRequest;
import com.google.cloud.compute.v1.ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest;
import com.google.cloud.compute.v1.NetworkEndpointGroup;
import com.google.cloud.compute.v1.NetworkEndpointGroupList;
import com.google.cloud.compute.v1.NetworkEndpointGroupsListNetworkEndpoints;
import com.google.cloud.compute.v1.Operation;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the GlobalNetworkEndpointGroups service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class GlobalNetworkEndpointGroupsStub implements BackgroundResource {

  public OperationCallable<
          AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation, Operation>
      attachNetworkEndpointsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: attachNetworkEndpointsOperationCallable()");
  }

  public UnaryCallable<AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation>
      attachNetworkEndpointsCallable() {
    throw new UnsupportedOperationException("Not implemented: attachNetworkEndpointsCallable()");
  }

  public OperationCallable<DeleteGlobalNetworkEndpointGroupRequest, Operation, Operation>
      deleteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOperationCallable()");
  }

  public UnaryCallable<DeleteGlobalNetworkEndpointGroupRequest, Operation> deleteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallable()");
  }

  public OperationCallable<
          DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation, Operation>
      detachNetworkEndpointsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: detachNetworkEndpointsOperationCallable()");
  }

  public UnaryCallable<DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation>
      detachNetworkEndpointsCallable() {
    throw new UnsupportedOperationException("Not implemented: detachNetworkEndpointsCallable()");
  }

  public UnaryCallable<GetGlobalNetworkEndpointGroupRequest, NetworkEndpointGroup> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public OperationCallable<InsertGlobalNetworkEndpointGroupRequest, Operation, Operation>
      insertOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: insertOperationCallable()");
  }

  public UnaryCallable<InsertGlobalNetworkEndpointGroupRequest, Operation> insertCallable() {
    throw new UnsupportedOperationException("Not implemented: insertCallable()");
  }

  public UnaryCallable<ListGlobalNetworkEndpointGroupsRequest, ListPagedResponse>
      listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListGlobalNetworkEndpointGroupsRequest, NetworkEndpointGroupList>
      listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  public UnaryCallable<
          ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest, ListNetworkEndpointsPagedResponse>
      listNetworkEndpointsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listNetworkEndpointsPagedCallable()");
  }

  public UnaryCallable<
          ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest,
          NetworkEndpointGroupsListNetworkEndpoints>
      listNetworkEndpointsCallable() {
    throw new UnsupportedOperationException("Not implemented: listNetworkEndpointsCallable()");
  }

  @Override
  public abstract void close();
}
