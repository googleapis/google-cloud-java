/*
 * Copyright 2023 Google LLC
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

import static com.google.cloud.compute.v1.RegionDisksClient.ListPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AddResourcePoliciesRegionDiskRequest;
import com.google.cloud.compute.v1.BulkInsertRegionDiskRequest;
import com.google.cloud.compute.v1.CreateSnapshotRegionDiskRequest;
import com.google.cloud.compute.v1.DeleteRegionDiskRequest;
import com.google.cloud.compute.v1.Disk;
import com.google.cloud.compute.v1.DiskList;
import com.google.cloud.compute.v1.GetIamPolicyRegionDiskRequest;
import com.google.cloud.compute.v1.GetRegionDiskRequest;
import com.google.cloud.compute.v1.InsertRegionDiskRequest;
import com.google.cloud.compute.v1.ListRegionDisksRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.RemoveResourcePoliciesRegionDiskRequest;
import com.google.cloud.compute.v1.ResizeRegionDiskRequest;
import com.google.cloud.compute.v1.SetIamPolicyRegionDiskRequest;
import com.google.cloud.compute.v1.SetLabelsRegionDiskRequest;
import com.google.cloud.compute.v1.StartAsyncReplicationRegionDiskRequest;
import com.google.cloud.compute.v1.StopAsyncReplicationRegionDiskRequest;
import com.google.cloud.compute.v1.StopGroupAsyncReplicationRegionDiskRequest;
import com.google.cloud.compute.v1.TestIamPermissionsRegionDiskRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import com.google.cloud.compute.v1.UpdateRegionDiskRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the RegionDisks service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class RegionDisksStub implements BackgroundResource {

  public OperationCallable<AddResourcePoliciesRegionDiskRequest, Operation, Operation>
      addResourcePoliciesOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: addResourcePoliciesOperationCallable()");
  }

  public UnaryCallable<AddResourcePoliciesRegionDiskRequest, Operation>
      addResourcePoliciesCallable() {
    throw new UnsupportedOperationException("Not implemented: addResourcePoliciesCallable()");
  }

  public OperationCallable<BulkInsertRegionDiskRequest, Operation, Operation>
      bulkInsertOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: bulkInsertOperationCallable()");
  }

  public UnaryCallable<BulkInsertRegionDiskRequest, Operation> bulkInsertCallable() {
    throw new UnsupportedOperationException("Not implemented: bulkInsertCallable()");
  }

  public OperationCallable<CreateSnapshotRegionDiskRequest, Operation, Operation>
      createSnapshotOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createSnapshotOperationCallable()");
  }

  public UnaryCallable<CreateSnapshotRegionDiskRequest, Operation> createSnapshotCallable() {
    throw new UnsupportedOperationException("Not implemented: createSnapshotCallable()");
  }

  public OperationCallable<DeleteRegionDiskRequest, Operation, Operation>
      deleteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOperationCallable()");
  }

  public UnaryCallable<DeleteRegionDiskRequest, Operation> deleteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallable()");
  }

  public UnaryCallable<GetRegionDiskRequest, Disk> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public UnaryCallable<GetIamPolicyRegionDiskRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public OperationCallable<InsertRegionDiskRequest, Operation, Operation>
      insertOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: insertOperationCallable()");
  }

  public UnaryCallable<InsertRegionDiskRequest, Operation> insertCallable() {
    throw new UnsupportedOperationException("Not implemented: insertCallable()");
  }

  public UnaryCallable<ListRegionDisksRequest, ListPagedResponse> listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListRegionDisksRequest, DiskList> listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  public OperationCallable<RemoveResourcePoliciesRegionDiskRequest, Operation, Operation>
      removeResourcePoliciesOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: removeResourcePoliciesOperationCallable()");
  }

  public UnaryCallable<RemoveResourcePoliciesRegionDiskRequest, Operation>
      removeResourcePoliciesCallable() {
    throw new UnsupportedOperationException("Not implemented: removeResourcePoliciesCallable()");
  }

  public OperationCallable<ResizeRegionDiskRequest, Operation, Operation>
      resizeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: resizeOperationCallable()");
  }

  public UnaryCallable<ResizeRegionDiskRequest, Operation> resizeCallable() {
    throw new UnsupportedOperationException("Not implemented: resizeCallable()");
  }

  public UnaryCallable<SetIamPolicyRegionDiskRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public OperationCallable<SetLabelsRegionDiskRequest, Operation, Operation>
      setLabelsOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: setLabelsOperationCallable()");
  }

  public UnaryCallable<SetLabelsRegionDiskRequest, Operation> setLabelsCallable() {
    throw new UnsupportedOperationException("Not implemented: setLabelsCallable()");
  }

  public OperationCallable<StartAsyncReplicationRegionDiskRequest, Operation, Operation>
      startAsyncReplicationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: startAsyncReplicationOperationCallable()");
  }

  public UnaryCallable<StartAsyncReplicationRegionDiskRequest, Operation>
      startAsyncReplicationCallable() {
    throw new UnsupportedOperationException("Not implemented: startAsyncReplicationCallable()");
  }

  public OperationCallable<StopAsyncReplicationRegionDiskRequest, Operation, Operation>
      stopAsyncReplicationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: stopAsyncReplicationOperationCallable()");
  }

  public UnaryCallable<StopAsyncReplicationRegionDiskRequest, Operation>
      stopAsyncReplicationCallable() {
    throw new UnsupportedOperationException("Not implemented: stopAsyncReplicationCallable()");
  }

  public OperationCallable<StopGroupAsyncReplicationRegionDiskRequest, Operation, Operation>
      stopGroupAsyncReplicationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: stopGroupAsyncReplicationOperationCallable()");
  }

  public UnaryCallable<StopGroupAsyncReplicationRegionDiskRequest, Operation>
      stopGroupAsyncReplicationCallable() {
    throw new UnsupportedOperationException("Not implemented: stopGroupAsyncReplicationCallable()");
  }

  public UnaryCallable<TestIamPermissionsRegionDiskRequest, TestPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  public OperationCallable<UpdateRegionDiskRequest, Operation, Operation>
      updateOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateOperationCallable()");
  }

  public UnaryCallable<UpdateRegionDiskRequest, Operation> updateCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCallable()");
  }

  @Override
  public abstract void close();
}
