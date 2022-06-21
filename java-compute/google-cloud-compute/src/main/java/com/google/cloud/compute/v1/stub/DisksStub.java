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

import static com.google.cloud.compute.v1.DisksClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.DisksClient.ListPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AddResourcePoliciesDiskRequest;
import com.google.cloud.compute.v1.AggregatedListDisksRequest;
import com.google.cloud.compute.v1.CreateSnapshotDiskRequest;
import com.google.cloud.compute.v1.DeleteDiskRequest;
import com.google.cloud.compute.v1.Disk;
import com.google.cloud.compute.v1.DiskAggregatedList;
import com.google.cloud.compute.v1.DiskList;
import com.google.cloud.compute.v1.GetDiskRequest;
import com.google.cloud.compute.v1.GetIamPolicyDiskRequest;
import com.google.cloud.compute.v1.InsertDiskRequest;
import com.google.cloud.compute.v1.ListDisksRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.RemoveResourcePoliciesDiskRequest;
import com.google.cloud.compute.v1.ResizeDiskRequest;
import com.google.cloud.compute.v1.SetIamPolicyDiskRequest;
import com.google.cloud.compute.v1.SetLabelsDiskRequest;
import com.google.cloud.compute.v1.TestIamPermissionsDiskRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Disks service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class DisksStub implements BackgroundResource {

  public OperationCallable<AddResourcePoliciesDiskRequest, Operation, Operation>
      addResourcePoliciesOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: addResourcePoliciesOperationCallable()");
  }

  public UnaryCallable<AddResourcePoliciesDiskRequest, Operation> addResourcePoliciesCallable() {
    throw new UnsupportedOperationException("Not implemented: addResourcePoliciesCallable()");
  }

  public UnaryCallable<AggregatedListDisksRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListPagedCallable()");
  }

  public UnaryCallable<AggregatedListDisksRequest, DiskAggregatedList> aggregatedListCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListCallable()");
  }

  public OperationCallable<CreateSnapshotDiskRequest, Operation, Operation>
      createSnapshotOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createSnapshotOperationCallable()");
  }

  public UnaryCallable<CreateSnapshotDiskRequest, Operation> createSnapshotCallable() {
    throw new UnsupportedOperationException("Not implemented: createSnapshotCallable()");
  }

  public OperationCallable<DeleteDiskRequest, Operation, Operation> deleteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOperationCallable()");
  }

  public UnaryCallable<DeleteDiskRequest, Operation> deleteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallable()");
  }

  public UnaryCallable<GetDiskRequest, Disk> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public UnaryCallable<GetIamPolicyDiskRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public OperationCallable<InsertDiskRequest, Operation, Operation> insertOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: insertOperationCallable()");
  }

  public UnaryCallable<InsertDiskRequest, Operation> insertCallable() {
    throw new UnsupportedOperationException("Not implemented: insertCallable()");
  }

  public UnaryCallable<ListDisksRequest, ListPagedResponse> listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListDisksRequest, DiskList> listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  public OperationCallable<RemoveResourcePoliciesDiskRequest, Operation, Operation>
      removeResourcePoliciesOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: removeResourcePoliciesOperationCallable()");
  }

  public UnaryCallable<RemoveResourcePoliciesDiskRequest, Operation>
      removeResourcePoliciesCallable() {
    throw new UnsupportedOperationException("Not implemented: removeResourcePoliciesCallable()");
  }

  public OperationCallable<ResizeDiskRequest, Operation, Operation> resizeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: resizeOperationCallable()");
  }

  public UnaryCallable<ResizeDiskRequest, Operation> resizeCallable() {
    throw new UnsupportedOperationException("Not implemented: resizeCallable()");
  }

  public UnaryCallable<SetIamPolicyDiskRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public OperationCallable<SetLabelsDiskRequest, Operation, Operation>
      setLabelsOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: setLabelsOperationCallable()");
  }

  public UnaryCallable<SetLabelsDiskRequest, Operation> setLabelsCallable() {
    throw new UnsupportedOperationException("Not implemented: setLabelsCallable()");
  }

  public UnaryCallable<TestIamPermissionsDiskRequest, TestPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
