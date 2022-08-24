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

import static com.google.cloud.compute.v1.ProjectsClient.GetXpnResourcesPagedResponse;
import static com.google.cloud.compute.v1.ProjectsClient.ListXpnHostsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.DisableXpnHostProjectRequest;
import com.google.cloud.compute.v1.DisableXpnResourceProjectRequest;
import com.google.cloud.compute.v1.EnableXpnHostProjectRequest;
import com.google.cloud.compute.v1.EnableXpnResourceProjectRequest;
import com.google.cloud.compute.v1.GetProjectRequest;
import com.google.cloud.compute.v1.GetXpnHostProjectRequest;
import com.google.cloud.compute.v1.GetXpnResourcesProjectsRequest;
import com.google.cloud.compute.v1.ListXpnHostsProjectsRequest;
import com.google.cloud.compute.v1.MoveDiskProjectRequest;
import com.google.cloud.compute.v1.MoveInstanceProjectRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Project;
import com.google.cloud.compute.v1.ProjectsGetXpnResources;
import com.google.cloud.compute.v1.SetCommonInstanceMetadataProjectRequest;
import com.google.cloud.compute.v1.SetDefaultNetworkTierProjectRequest;
import com.google.cloud.compute.v1.SetUsageExportBucketProjectRequest;
import com.google.cloud.compute.v1.XpnHostList;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Projects service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ProjectsStub implements BackgroundResource {

  public OperationCallable<DisableXpnHostProjectRequest, Operation, Operation>
      disableXpnHostOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: disableXpnHostOperationCallable()");
  }

  public UnaryCallable<DisableXpnHostProjectRequest, Operation> disableXpnHostCallable() {
    throw new UnsupportedOperationException("Not implemented: disableXpnHostCallable()");
  }

  public OperationCallable<DisableXpnResourceProjectRequest, Operation, Operation>
      disableXpnResourceOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: disableXpnResourceOperationCallable()");
  }

  public UnaryCallable<DisableXpnResourceProjectRequest, Operation> disableXpnResourceCallable() {
    throw new UnsupportedOperationException("Not implemented: disableXpnResourceCallable()");
  }

  public OperationCallable<EnableXpnHostProjectRequest, Operation, Operation>
      enableXpnHostOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: enableXpnHostOperationCallable()");
  }

  public UnaryCallable<EnableXpnHostProjectRequest, Operation> enableXpnHostCallable() {
    throw new UnsupportedOperationException("Not implemented: enableXpnHostCallable()");
  }

  public OperationCallable<EnableXpnResourceProjectRequest, Operation, Operation>
      enableXpnResourceOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: enableXpnResourceOperationCallable()");
  }

  public UnaryCallable<EnableXpnResourceProjectRequest, Operation> enableXpnResourceCallable() {
    throw new UnsupportedOperationException("Not implemented: enableXpnResourceCallable()");
  }

  public UnaryCallable<GetProjectRequest, Project> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public UnaryCallable<GetXpnHostProjectRequest, Project> getXpnHostCallable() {
    throw new UnsupportedOperationException("Not implemented: getXpnHostCallable()");
  }

  public UnaryCallable<GetXpnResourcesProjectsRequest, GetXpnResourcesPagedResponse>
      getXpnResourcesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: getXpnResourcesPagedCallable()");
  }

  public UnaryCallable<GetXpnResourcesProjectsRequest, ProjectsGetXpnResources>
      getXpnResourcesCallable() {
    throw new UnsupportedOperationException("Not implemented: getXpnResourcesCallable()");
  }

  public UnaryCallable<ListXpnHostsProjectsRequest, ListXpnHostsPagedResponse>
      listXpnHostsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listXpnHostsPagedCallable()");
  }

  public UnaryCallable<ListXpnHostsProjectsRequest, XpnHostList> listXpnHostsCallable() {
    throw new UnsupportedOperationException("Not implemented: listXpnHostsCallable()");
  }

  public OperationCallable<MoveDiskProjectRequest, Operation, Operation>
      moveDiskOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: moveDiskOperationCallable()");
  }

  public UnaryCallable<MoveDiskProjectRequest, Operation> moveDiskCallable() {
    throw new UnsupportedOperationException("Not implemented: moveDiskCallable()");
  }

  public OperationCallable<MoveInstanceProjectRequest, Operation, Operation>
      moveInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: moveInstanceOperationCallable()");
  }

  public UnaryCallable<MoveInstanceProjectRequest, Operation> moveInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: moveInstanceCallable()");
  }

  public OperationCallable<SetCommonInstanceMetadataProjectRequest, Operation, Operation>
      setCommonInstanceMetadataOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: setCommonInstanceMetadataOperationCallable()");
  }

  public UnaryCallable<SetCommonInstanceMetadataProjectRequest, Operation>
      setCommonInstanceMetadataCallable() {
    throw new UnsupportedOperationException("Not implemented: setCommonInstanceMetadataCallable()");
  }

  public OperationCallable<SetDefaultNetworkTierProjectRequest, Operation, Operation>
      setDefaultNetworkTierOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: setDefaultNetworkTierOperationCallable()");
  }

  public UnaryCallable<SetDefaultNetworkTierProjectRequest, Operation>
      setDefaultNetworkTierCallable() {
    throw new UnsupportedOperationException("Not implemented: setDefaultNetworkTierCallable()");
  }

  public OperationCallable<SetUsageExportBucketProjectRequest, Operation, Operation>
      setUsageExportBucketOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: setUsageExportBucketOperationCallable()");
  }

  public UnaryCallable<SetUsageExportBucketProjectRequest, Operation>
      setUsageExportBucketCallable() {
    throw new UnsupportedOperationException("Not implemented: setUsageExportBucketCallable()");
  }

  @Override
  public abstract void close();
}
