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
package com.google.cloud.bigtable.admin.v2.stub;

import static com.google.cloud.bigtable.admin.v2.BaseBigtableTableAdminClient.ListSnapshotsPagedResponse;
import static com.google.cloud.bigtable.admin.v2.BaseBigtableTableAdminClient.ListTablesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.bigtable.admin.v2.CheckConsistencyRequest;
import com.google.bigtable.admin.v2.CheckConsistencyResponse;
import com.google.bigtable.admin.v2.CreateTableFromSnapshotMetadata;
import com.google.bigtable.admin.v2.CreateTableFromSnapshotRequest;
import com.google.bigtable.admin.v2.CreateTableRequest;
import com.google.bigtable.admin.v2.DeleteSnapshotRequest;
import com.google.bigtable.admin.v2.DeleteTableRequest;
import com.google.bigtable.admin.v2.DropRowRangeRequest;
import com.google.bigtable.admin.v2.GenerateConsistencyTokenRequest;
import com.google.bigtable.admin.v2.GenerateConsistencyTokenResponse;
import com.google.bigtable.admin.v2.GetSnapshotRequest;
import com.google.bigtable.admin.v2.GetTableRequest;
import com.google.bigtable.admin.v2.ListSnapshotsRequest;
import com.google.bigtable.admin.v2.ListSnapshotsResponse;
import com.google.bigtable.admin.v2.ListTablesRequest;
import com.google.bigtable.admin.v2.ListTablesResponse;
import com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest;
import com.google.bigtable.admin.v2.Snapshot;
import com.google.bigtable.admin.v2.SnapshotTableMetadata;
import com.google.bigtable.admin.v2.SnapshotTableRequest;
import com.google.bigtable.admin.v2.Table;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for Cloud Bigtable Admin API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class BigtableTableAdminStub implements BackgroundResource {

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<CreateTableRequest, Table> createTableCallable() {
    throw new UnsupportedOperationException("Not implemented: createTableCallable()");
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<CreateTableFromSnapshotRequest, Table, CreateTableFromSnapshotMetadata>
      createTableFromSnapshotOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createTableFromSnapshotOperationCallable()");
  }

  public UnaryCallable<CreateTableFromSnapshotRequest, Operation>
      createTableFromSnapshotCallable() {
    throw new UnsupportedOperationException("Not implemented: createTableFromSnapshotCallable()");
  }

  public UnaryCallable<ListTablesRequest, ListTablesPagedResponse> listTablesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTablesPagedCallable()");
  }

  public UnaryCallable<ListTablesRequest, ListTablesResponse> listTablesCallable() {
    throw new UnsupportedOperationException("Not implemented: listTablesCallable()");
  }

  public UnaryCallable<GetTableRequest, Table> getTableCallable() {
    throw new UnsupportedOperationException("Not implemented: getTableCallable()");
  }

  public UnaryCallable<DeleteTableRequest, Empty> deleteTableCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTableCallable()");
  }

  public UnaryCallable<ModifyColumnFamiliesRequest, Table> modifyColumnFamiliesCallable() {
    throw new UnsupportedOperationException("Not implemented: modifyColumnFamiliesCallable()");
  }

  public UnaryCallable<DropRowRangeRequest, Empty> dropRowRangeCallable() {
    throw new UnsupportedOperationException("Not implemented: dropRowRangeCallable()");
  }

  public UnaryCallable<GenerateConsistencyTokenRequest, GenerateConsistencyTokenResponse>
      generateConsistencyTokenCallable() {
    throw new UnsupportedOperationException("Not implemented: generateConsistencyTokenCallable()");
  }

  public UnaryCallable<CheckConsistencyRequest, CheckConsistencyResponse>
      checkConsistencyCallable() {
    throw new UnsupportedOperationException("Not implemented: checkConsistencyCallable()");
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<SnapshotTableRequest, Snapshot, SnapshotTableMetadata>
      snapshotTableOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: snapshotTableOperationCallable()");
  }

  public UnaryCallable<SnapshotTableRequest, Operation> snapshotTableCallable() {
    throw new UnsupportedOperationException("Not implemented: snapshotTableCallable()");
  }

  public UnaryCallable<GetSnapshotRequest, Snapshot> getSnapshotCallable() {
    throw new UnsupportedOperationException("Not implemented: getSnapshotCallable()");
  }

  public UnaryCallable<ListSnapshotsRequest, ListSnapshotsPagedResponse>
      listSnapshotsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSnapshotsPagedCallable()");
  }

  public UnaryCallable<ListSnapshotsRequest, ListSnapshotsResponse> listSnapshotsCallable() {
    throw new UnsupportedOperationException("Not implemented: listSnapshotsCallable()");
  }

  public UnaryCallable<DeleteSnapshotRequest, Empty> deleteSnapshotCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSnapshotCallable()");
  }

  @Override
  public abstract void close();
}
