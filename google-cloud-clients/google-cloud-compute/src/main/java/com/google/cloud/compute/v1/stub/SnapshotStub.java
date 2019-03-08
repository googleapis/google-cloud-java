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

import static com.google.cloud.compute.v1.SnapshotClient.ListSnapshotsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.DeleteSnapshotHttpRequest;
import com.google.cloud.compute.v1.GetIamPolicySnapshotHttpRequest;
import com.google.cloud.compute.v1.GetSnapshotHttpRequest;
import com.google.cloud.compute.v1.ListSnapshotsHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.SetIamPolicySnapshotHttpRequest;
import com.google.cloud.compute.v1.SetLabelsSnapshotHttpRequest;
import com.google.cloud.compute.v1.Snapshot;
import com.google.cloud.compute.v1.SnapshotList;
import com.google.cloud.compute.v1.TestIamPermissionsSnapshotHttpRequest;
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
public abstract class SnapshotStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<DeleteSnapshotHttpRequest, Operation> deleteSnapshotCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSnapshotCallable()");
  }

  @BetaApi
  public UnaryCallable<GetSnapshotHttpRequest, Snapshot> getSnapshotCallable() {
    throw new UnsupportedOperationException("Not implemented: getSnapshotCallable()");
  }

  @BetaApi
  public UnaryCallable<GetIamPolicySnapshotHttpRequest, Policy> getIamPolicySnapshotCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicySnapshotCallable()");
  }

  @BetaApi
  public UnaryCallable<ListSnapshotsHttpRequest, ListSnapshotsPagedResponse>
      listSnapshotsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSnapshotsPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListSnapshotsHttpRequest, SnapshotList> listSnapshotsCallable() {
    throw new UnsupportedOperationException("Not implemented: listSnapshotsCallable()");
  }

  @BetaApi
  public UnaryCallable<SetIamPolicySnapshotHttpRequest, Policy> setIamPolicySnapshotCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicySnapshotCallable()");
  }

  @BetaApi
  public UnaryCallable<SetLabelsSnapshotHttpRequest, Operation> setLabelsSnapshotCallable() {
    throw new UnsupportedOperationException("Not implemented: setLabelsSnapshotCallable()");
  }

  @BetaApi
  public UnaryCallable<TestIamPermissionsSnapshotHttpRequest, TestPermissionsResponse>
      testIamPermissionsSnapshotCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: testIamPermissionsSnapshotCallable()");
  }

  @Override
  public abstract void close();
}
