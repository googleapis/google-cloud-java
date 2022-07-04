/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.aiplatform.v1.stub;

import static com.google.cloud.aiplatform.v1.IndexServiceClient.ListIndexesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1.CreateIndexOperationMetadata;
import com.google.cloud.aiplatform.v1.CreateIndexRequest;
import com.google.cloud.aiplatform.v1.DeleteIndexRequest;
import com.google.cloud.aiplatform.v1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1.GetIndexRequest;
import com.google.cloud.aiplatform.v1.Index;
import com.google.cloud.aiplatform.v1.ListIndexesRequest;
import com.google.cloud.aiplatform.v1.ListIndexesResponse;
import com.google.cloud.aiplatform.v1.UpdateIndexOperationMetadata;
import com.google.cloud.aiplatform.v1.UpdateIndexRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the IndexService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class IndexServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public OperationCallable<CreateIndexRequest, Index, CreateIndexOperationMetadata>
      createIndexOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createIndexOperationCallable()");
  }

  public UnaryCallable<CreateIndexRequest, Operation> createIndexCallable() {
    throw new UnsupportedOperationException("Not implemented: createIndexCallable()");
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

  public OperationCallable<UpdateIndexRequest, Index, UpdateIndexOperationMetadata>
      updateIndexOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateIndexOperationCallable()");
  }

  public UnaryCallable<UpdateIndexRequest, Operation> updateIndexCallable() {
    throw new UnsupportedOperationException("Not implemented: updateIndexCallable()");
  }

  public OperationCallable<DeleteIndexRequest, Empty, DeleteOperationMetadata>
      deleteIndexOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteIndexOperationCallable()");
  }

  public UnaryCallable<DeleteIndexRequest, Operation> deleteIndexCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteIndexCallable()");
  }

  @Override
  public abstract void close();
}
