/*
 * Copyright 2018 Google LLC
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

import static com.google.cloud.compute.v1.RegionInstanceGroupClient.ListInstancesRegionInstanceGroupsPagedResponse;
import static com.google.cloud.compute.v1.RegionInstanceGroupClient.ListRegionInstanceGroupsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.GetRegionInstanceGroupHttpRequest;
import com.google.cloud.compute.v1.InstanceGroup;
import com.google.cloud.compute.v1.ListInstancesRegionInstanceGroupsHttpRequest;
import com.google.cloud.compute.v1.ListRegionInstanceGroupsHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.RegionInstanceGroupList;
import com.google.cloud.compute.v1.RegionInstanceGroupsListInstances;
import com.google.cloud.compute.v1.SetNamedPortsRegionInstanceGroupHttpRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class RegionInstanceGroupStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<GetRegionInstanceGroupHttpRequest, InstanceGroup>
      getRegionInstanceGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: getRegionInstanceGroupCallable()");
  }

  @BetaApi
  public UnaryCallable<ListRegionInstanceGroupsHttpRequest, ListRegionInstanceGroupsPagedResponse>
      listRegionInstanceGroupsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listRegionInstanceGroupsPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListRegionInstanceGroupsHttpRequest, RegionInstanceGroupList>
      listRegionInstanceGroupsCallable() {
    throw new UnsupportedOperationException("Not implemented: listRegionInstanceGroupsCallable()");
  }

  @BetaApi
  public UnaryCallable<
          ListInstancesRegionInstanceGroupsHttpRequest,
          ListInstancesRegionInstanceGroupsPagedResponse>
      listInstancesRegionInstanceGroupsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listInstancesRegionInstanceGroupsPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<
          ListInstancesRegionInstanceGroupsHttpRequest, RegionInstanceGroupsListInstances>
      listInstancesRegionInstanceGroupsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listInstancesRegionInstanceGroupsCallable()");
  }

  @BetaApi
  public UnaryCallable<SetNamedPortsRegionInstanceGroupHttpRequest, Operation>
      setNamedPortsRegionInstanceGroupCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: setNamedPortsRegionInstanceGroupCallable()");
  }

  @Override
  public abstract void close();
}
