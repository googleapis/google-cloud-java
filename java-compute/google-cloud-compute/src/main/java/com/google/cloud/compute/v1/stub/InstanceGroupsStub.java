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

import static com.google.cloud.compute.v1.InstanceGroupsClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.InstanceGroupsClient.ListInstancesPagedResponse;
import static com.google.cloud.compute.v1.InstanceGroupsClient.ListPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AddInstancesInstanceGroupRequest;
import com.google.cloud.compute.v1.AggregatedListInstanceGroupsRequest;
import com.google.cloud.compute.v1.DeleteInstanceGroupRequest;
import com.google.cloud.compute.v1.GetInstanceGroupRequest;
import com.google.cloud.compute.v1.InsertInstanceGroupRequest;
import com.google.cloud.compute.v1.InstanceGroup;
import com.google.cloud.compute.v1.InstanceGroupAggregatedList;
import com.google.cloud.compute.v1.InstanceGroupList;
import com.google.cloud.compute.v1.InstanceGroupsListInstances;
import com.google.cloud.compute.v1.ListInstanceGroupsRequest;
import com.google.cloud.compute.v1.ListInstancesInstanceGroupsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.RemoveInstancesInstanceGroupRequest;
import com.google.cloud.compute.v1.SetNamedPortsInstanceGroupRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the InstanceGroups service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class InstanceGroupsStub implements BackgroundResource {

  public OperationCallable<AddInstancesInstanceGroupRequest, Operation, Operation>
      addInstancesOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: addInstancesOperationCallable()");
  }

  public UnaryCallable<AddInstancesInstanceGroupRequest, Operation> addInstancesCallable() {
    throw new UnsupportedOperationException("Not implemented: addInstancesCallable()");
  }

  public UnaryCallable<AggregatedListInstanceGroupsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListPagedCallable()");
  }

  public UnaryCallable<AggregatedListInstanceGroupsRequest, InstanceGroupAggregatedList>
      aggregatedListCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListCallable()");
  }

  public OperationCallable<DeleteInstanceGroupRequest, Operation, Operation>
      deleteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOperationCallable()");
  }

  public UnaryCallable<DeleteInstanceGroupRequest, Operation> deleteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallable()");
  }

  public UnaryCallable<GetInstanceGroupRequest, InstanceGroup> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public OperationCallable<InsertInstanceGroupRequest, Operation, Operation>
      insertOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: insertOperationCallable()");
  }

  public UnaryCallable<InsertInstanceGroupRequest, Operation> insertCallable() {
    throw new UnsupportedOperationException("Not implemented: insertCallable()");
  }

  public UnaryCallable<ListInstanceGroupsRequest, ListPagedResponse> listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListInstanceGroupsRequest, InstanceGroupList> listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  public UnaryCallable<ListInstancesInstanceGroupsRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listInstancesPagedCallable()");
  }

  public UnaryCallable<ListInstancesInstanceGroupsRequest, InstanceGroupsListInstances>
      listInstancesCallable() {
    throw new UnsupportedOperationException("Not implemented: listInstancesCallable()");
  }

  public OperationCallable<RemoveInstancesInstanceGroupRequest, Operation, Operation>
      removeInstancesOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: removeInstancesOperationCallable()");
  }

  public UnaryCallable<RemoveInstancesInstanceGroupRequest, Operation> removeInstancesCallable() {
    throw new UnsupportedOperationException("Not implemented: removeInstancesCallable()");
  }

  public OperationCallable<SetNamedPortsInstanceGroupRequest, Operation, Operation>
      setNamedPortsOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: setNamedPortsOperationCallable()");
  }

  public UnaryCallable<SetNamedPortsInstanceGroupRequest, Operation> setNamedPortsCallable() {
    throw new UnsupportedOperationException("Not implemented: setNamedPortsCallable()");
  }

  @Override
  public abstract void close();
}
