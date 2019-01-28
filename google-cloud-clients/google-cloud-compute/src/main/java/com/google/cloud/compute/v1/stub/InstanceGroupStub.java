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

import static com.google.cloud.compute.v1.InstanceGroupClient.AggregatedListInstanceGroupsPagedResponse;
import static com.google.cloud.compute.v1.InstanceGroupClient.ListInstanceGroupsPagedResponse;
import static com.google.cloud.compute.v1.InstanceGroupClient.ListInstancesInstanceGroupsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AddInstancesInstanceGroupHttpRequest;
import com.google.cloud.compute.v1.AggregatedListInstanceGroupsHttpRequest;
import com.google.cloud.compute.v1.DeleteInstanceGroupHttpRequest;
import com.google.cloud.compute.v1.GetInstanceGroupHttpRequest;
import com.google.cloud.compute.v1.InsertInstanceGroupHttpRequest;
import com.google.cloud.compute.v1.InstanceGroup;
import com.google.cloud.compute.v1.InstanceGroupAggregatedList;
import com.google.cloud.compute.v1.InstanceGroupList;
import com.google.cloud.compute.v1.InstanceGroupsListInstances;
import com.google.cloud.compute.v1.ListInstanceGroupsHttpRequest;
import com.google.cloud.compute.v1.ListInstancesInstanceGroupsHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.RemoveInstancesInstanceGroupHttpRequest;
import com.google.cloud.compute.v1.SetNamedPortsInstanceGroupHttpRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class InstanceGroupStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<AddInstancesInstanceGroupHttpRequest, Operation>
      addInstancesInstanceGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: addInstancesInstanceGroupCallable()");
  }

  @BetaApi
  public UnaryCallable<
          AggregatedListInstanceGroupsHttpRequest, AggregatedListInstanceGroupsPagedResponse>
      aggregatedListInstanceGroupsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: aggregatedListInstanceGroupsPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<AggregatedListInstanceGroupsHttpRequest, InstanceGroupAggregatedList>
      aggregatedListInstanceGroupsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: aggregatedListInstanceGroupsCallable()");
  }

  @BetaApi
  public UnaryCallable<DeleteInstanceGroupHttpRequest, Operation> deleteInstanceGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteInstanceGroupCallable()");
  }

  @BetaApi
  public UnaryCallable<GetInstanceGroupHttpRequest, InstanceGroup> getInstanceGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: getInstanceGroupCallable()");
  }

  @BetaApi
  public UnaryCallable<InsertInstanceGroupHttpRequest, Operation> insertInstanceGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: insertInstanceGroupCallable()");
  }

  @BetaApi
  public UnaryCallable<ListInstanceGroupsHttpRequest, ListInstanceGroupsPagedResponse>
      listInstanceGroupsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listInstanceGroupsPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListInstanceGroupsHttpRequest, InstanceGroupList>
      listInstanceGroupsCallable() {
    throw new UnsupportedOperationException("Not implemented: listInstanceGroupsCallable()");
  }

  @BetaApi
  public UnaryCallable<
          ListInstancesInstanceGroupsHttpRequest, ListInstancesInstanceGroupsPagedResponse>
      listInstancesInstanceGroupsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listInstancesInstanceGroupsPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListInstancesInstanceGroupsHttpRequest, InstanceGroupsListInstances>
      listInstancesInstanceGroupsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listInstancesInstanceGroupsCallable()");
  }

  @BetaApi
  public UnaryCallable<RemoveInstancesInstanceGroupHttpRequest, Operation>
      removeInstancesInstanceGroupCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: removeInstancesInstanceGroupCallable()");
  }

  @BetaApi
  public UnaryCallable<SetNamedPortsInstanceGroupHttpRequest, Operation>
      setNamedPortsInstanceGroupCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: setNamedPortsInstanceGroupCallable()");
  }

  @Override
  public abstract void close();
}
