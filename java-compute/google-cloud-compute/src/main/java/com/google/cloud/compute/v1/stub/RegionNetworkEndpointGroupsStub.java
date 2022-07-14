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

import static com.google.cloud.compute.v1.RegionNetworkEndpointGroupsClient.ListPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.DeleteRegionNetworkEndpointGroupRequest;
import com.google.cloud.compute.v1.GetRegionNetworkEndpointGroupRequest;
import com.google.cloud.compute.v1.InsertRegionNetworkEndpointGroupRequest;
import com.google.cloud.compute.v1.ListRegionNetworkEndpointGroupsRequest;
import com.google.cloud.compute.v1.NetworkEndpointGroup;
import com.google.cloud.compute.v1.NetworkEndpointGroupList;
import com.google.cloud.compute.v1.Operation;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the RegionNetworkEndpointGroups service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class RegionNetworkEndpointGroupsStub implements BackgroundResource {

  public OperationCallable<DeleteRegionNetworkEndpointGroupRequest, Operation, Operation>
      deleteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOperationCallable()");
  }

  public UnaryCallable<DeleteRegionNetworkEndpointGroupRequest, Operation> deleteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallable()");
  }

  public UnaryCallable<GetRegionNetworkEndpointGroupRequest, NetworkEndpointGroup> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public OperationCallable<InsertRegionNetworkEndpointGroupRequest, Operation, Operation>
      insertOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: insertOperationCallable()");
  }

  public UnaryCallable<InsertRegionNetworkEndpointGroupRequest, Operation> insertCallable() {
    throw new UnsupportedOperationException("Not implemented: insertCallable()");
  }

  public UnaryCallable<ListRegionNetworkEndpointGroupsRequest, ListPagedResponse>
      listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListRegionNetworkEndpointGroupsRequest, NetworkEndpointGroupList>
      listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  @Override
  public abstract void close();
}
