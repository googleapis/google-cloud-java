/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.datastore.admin.v1.stub;

import static com.google.cloud.datastore.admin.v1.DatastoreAdminClient.ListIndexesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.datastore.admin.v1.CreateIndexRequest;
import com.google.datastore.admin.v1.DeleteIndexRequest;
import com.google.datastore.admin.v1.ExportEntitiesMetadata;
import com.google.datastore.admin.v1.ExportEntitiesRequest;
import com.google.datastore.admin.v1.ExportEntitiesResponse;
import com.google.datastore.admin.v1.GetIndexRequest;
import com.google.datastore.admin.v1.ImportEntitiesMetadata;
import com.google.datastore.admin.v1.ImportEntitiesRequest;
import com.google.datastore.admin.v1.Index;
import com.google.datastore.admin.v1.IndexOperationMetadata;
import com.google.datastore.admin.v1.ListIndexesRequest;
import com.google.datastore.admin.v1.ListIndexesResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the DatastoreAdmin service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class DatastoreAdminStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<ExportEntitiesRequest, ExportEntitiesResponse, ExportEntitiesMetadata>
      exportEntitiesOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: exportEntitiesOperationCallable()");
  }

  public UnaryCallable<ExportEntitiesRequest, Operation> exportEntitiesCallable() {
    throw new UnsupportedOperationException("Not implemented: exportEntitiesCallable()");
  }

  public OperationCallable<ImportEntitiesRequest, Empty, ImportEntitiesMetadata>
      importEntitiesOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: importEntitiesOperationCallable()");
  }

  public UnaryCallable<ImportEntitiesRequest, Operation> importEntitiesCallable() {
    throw new UnsupportedOperationException("Not implemented: importEntitiesCallable()");
  }

  public OperationCallable<CreateIndexRequest, Index, IndexOperationMetadata>
      createIndexOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createIndexOperationCallable()");
  }

  public UnaryCallable<CreateIndexRequest, Operation> createIndexCallable() {
    throw new UnsupportedOperationException("Not implemented: createIndexCallable()");
  }

  public OperationCallable<DeleteIndexRequest, Index, IndexOperationMetadata>
      deleteIndexOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteIndexOperationCallable()");
  }

  public UnaryCallable<DeleteIndexRequest, Operation> deleteIndexCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteIndexCallable()");
  }

  public UnaryCallable<GetIndexRequest, Index> getIndexCallable() {
    throw new UnsupportedOperationException("Not implemented: getIndexCallable()");
  }

  public UnaryCallable<ListIndexesRequest, ListIndexesPagedResponse> listIndexesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listIndexesPagedCallable()");
  }

  public UnaryCallable<ListIndexesRequest, ListIndexesResponse> listIndexesCallable() {
    throw new UnsupportedOperationException("Not implemented: listIndexesCallable()");
  }

  @Override
  public abstract void close();
}
