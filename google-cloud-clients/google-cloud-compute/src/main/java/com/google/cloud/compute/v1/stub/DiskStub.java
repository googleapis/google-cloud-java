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

import static com.google.cloud.compute.v1.DiskClient.AggregatedListDisksPagedResponse;
import static com.google.cloud.compute.v1.DiskClient.ListDisksPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AggregatedListDisksHttpRequest;
import com.google.cloud.compute.v1.CreateSnapshotDiskHttpRequest;
import com.google.cloud.compute.v1.DeleteDiskHttpRequest;
import com.google.cloud.compute.v1.Disk;
import com.google.cloud.compute.v1.DiskAggregatedList;
import com.google.cloud.compute.v1.DiskList;
import com.google.cloud.compute.v1.GetDiskHttpRequest;
import com.google.cloud.compute.v1.GetIamPolicyDiskHttpRequest;
import com.google.cloud.compute.v1.InsertDiskHttpRequest;
import com.google.cloud.compute.v1.ListDisksHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.ResizeDiskHttpRequest;
import com.google.cloud.compute.v1.SetIamPolicyDiskHttpRequest;
import com.google.cloud.compute.v1.SetLabelsDiskHttpRequest;
import com.google.cloud.compute.v1.TestIamPermissionsDiskHttpRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class DiskStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<AggregatedListDisksHttpRequest, AggregatedListDisksPagedResponse>
      aggregatedListDisksPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListDisksPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<AggregatedListDisksHttpRequest, DiskAggregatedList>
      aggregatedListDisksCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListDisksCallable()");
  }

  @BetaApi
  public UnaryCallable<CreateSnapshotDiskHttpRequest, Operation> createSnapshotDiskCallable() {
    throw new UnsupportedOperationException("Not implemented: createSnapshotDiskCallable()");
  }

  @BetaApi
  public UnaryCallable<DeleteDiskHttpRequest, Operation> deleteDiskCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDiskCallable()");
  }

  @BetaApi
  public UnaryCallable<GetDiskHttpRequest, Disk> getDiskCallable() {
    throw new UnsupportedOperationException("Not implemented: getDiskCallable()");
  }

  @BetaApi
  public UnaryCallable<GetIamPolicyDiskHttpRequest, Policy> getIamPolicyDiskCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyDiskCallable()");
  }

  @BetaApi
  public UnaryCallable<InsertDiskHttpRequest, Operation> insertDiskCallable() {
    throw new UnsupportedOperationException("Not implemented: insertDiskCallable()");
  }

  @BetaApi
  public UnaryCallable<ListDisksHttpRequest, ListDisksPagedResponse> listDisksPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDisksPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListDisksHttpRequest, DiskList> listDisksCallable() {
    throw new UnsupportedOperationException("Not implemented: listDisksCallable()");
  }

  @BetaApi
  public UnaryCallable<ResizeDiskHttpRequest, Operation> resizeDiskCallable() {
    throw new UnsupportedOperationException("Not implemented: resizeDiskCallable()");
  }

  @BetaApi
  public UnaryCallable<SetIamPolicyDiskHttpRequest, Policy> setIamPolicyDiskCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyDiskCallable()");
  }

  @BetaApi
  public UnaryCallable<SetLabelsDiskHttpRequest, Operation> setLabelsDiskCallable() {
    throw new UnsupportedOperationException("Not implemented: setLabelsDiskCallable()");
  }

  @BetaApi
  public UnaryCallable<TestIamPermissionsDiskHttpRequest, TestPermissionsResponse>
      testIamPermissionsDiskCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsDiskCallable()");
  }

  @Override
  public abstract void close();
}
