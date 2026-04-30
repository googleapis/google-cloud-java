/*
 * Copyright 2026 Google LLC
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

import static com.google.cloud.compute.v1.RegionSnapshotsClient.ListPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.DeleteRegionSnapshotRequest;
import com.google.cloud.compute.v1.GetIamPolicyRegionSnapshotRequest;
import com.google.cloud.compute.v1.GetRegionSnapshotRequest;
import com.google.cloud.compute.v1.InsertRegionSnapshotRequest;
import com.google.cloud.compute.v1.ListRegionSnapshotsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.SetIamPolicyRegionSnapshotRequest;
import com.google.cloud.compute.v1.SetLabelsRegionSnapshotRequest;
import com.google.cloud.compute.v1.Snapshot;
import com.google.cloud.compute.v1.SnapshotList;
import com.google.cloud.compute.v1.TestIamPermissionsRegionSnapshotRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import com.google.cloud.compute.v1.UpdateKmsKeyRegionSnapshotRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the RegionSnapshots service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class RegionSnapshotsStub implements BackgroundResource {

  public OperationCallable<DeleteRegionSnapshotRequest, Operation, Operation>
      deleteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOperationCallable()");
  }

  public UnaryCallable<DeleteRegionSnapshotRequest, Operation> deleteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallable()");
  }

  public UnaryCallable<GetRegionSnapshotRequest, Snapshot> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public UnaryCallable<GetIamPolicyRegionSnapshotRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public OperationCallable<InsertRegionSnapshotRequest, Operation, Operation>
      insertOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: insertOperationCallable()");
  }

  public UnaryCallable<InsertRegionSnapshotRequest, Operation> insertCallable() {
    throw new UnsupportedOperationException("Not implemented: insertCallable()");
  }

  public UnaryCallable<ListRegionSnapshotsRequest, ListPagedResponse> listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListRegionSnapshotsRequest, SnapshotList> listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  public UnaryCallable<SetIamPolicyRegionSnapshotRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public OperationCallable<SetLabelsRegionSnapshotRequest, Operation, Operation>
      setLabelsOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: setLabelsOperationCallable()");
  }

  public UnaryCallable<SetLabelsRegionSnapshotRequest, Operation> setLabelsCallable() {
    throw new UnsupportedOperationException("Not implemented: setLabelsCallable()");
  }

  public UnaryCallable<TestIamPermissionsRegionSnapshotRequest, TestPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  public OperationCallable<UpdateKmsKeyRegionSnapshotRequest, Operation, Operation>
      updateKmsKeyOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateKmsKeyOperationCallable()");
  }

  public UnaryCallable<UpdateKmsKeyRegionSnapshotRequest, Operation> updateKmsKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: updateKmsKeyCallable()");
  }

  @Override
  public abstract void close();
}
