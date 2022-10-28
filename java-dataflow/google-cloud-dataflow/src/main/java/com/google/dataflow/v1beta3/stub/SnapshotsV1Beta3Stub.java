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

package com.google.dataflow.v1beta3.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.dataflow.v1beta3.DeleteSnapshotRequest;
import com.google.dataflow.v1beta3.DeleteSnapshotResponse;
import com.google.dataflow.v1beta3.GetSnapshotRequest;
import com.google.dataflow.v1beta3.ListSnapshotsRequest;
import com.google.dataflow.v1beta3.ListSnapshotsResponse;
import com.google.dataflow.v1beta3.Snapshot;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the SnapshotsV1Beta3 service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class SnapshotsV1Beta3Stub implements BackgroundResource {

  public UnaryCallable<GetSnapshotRequest, Snapshot> getSnapshotCallable() {
    throw new UnsupportedOperationException("Not implemented: getSnapshotCallable()");
  }

  public UnaryCallable<DeleteSnapshotRequest, DeleteSnapshotResponse> deleteSnapshotCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSnapshotCallable()");
  }

  public UnaryCallable<ListSnapshotsRequest, ListSnapshotsResponse> listSnapshotsCallable() {
    throw new UnsupportedOperationException("Not implemented: listSnapshotsCallable()");
  }

  @Override
  public abstract void close();
}
