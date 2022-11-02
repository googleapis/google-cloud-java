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

package com.google.cloud.dataproc.v1.stub;

import static com.google.cloud.dataproc.v1.BatchControllerClient.ListBatchesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataproc.v1.Batch;
import com.google.cloud.dataproc.v1.BatchOperationMetadata;
import com.google.cloud.dataproc.v1.CreateBatchRequest;
import com.google.cloud.dataproc.v1.DeleteBatchRequest;
import com.google.cloud.dataproc.v1.GetBatchRequest;
import com.google.cloud.dataproc.v1.ListBatchesRequest;
import com.google.cloud.dataproc.v1.ListBatchesResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the BatchController service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class BatchControllerStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<CreateBatchRequest, Batch, BatchOperationMetadata>
      createBatchOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createBatchOperationCallable()");
  }

  public UnaryCallable<CreateBatchRequest, Operation> createBatchCallable() {
    throw new UnsupportedOperationException("Not implemented: createBatchCallable()");
  }

  public UnaryCallable<GetBatchRequest, Batch> getBatchCallable() {
    throw new UnsupportedOperationException("Not implemented: getBatchCallable()");
  }

  public UnaryCallable<ListBatchesRequest, ListBatchesPagedResponse> listBatchesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listBatchesPagedCallable()");
  }

  public UnaryCallable<ListBatchesRequest, ListBatchesResponse> listBatchesCallable() {
    throw new UnsupportedOperationException("Not implemented: listBatchesCallable()");
  }

  public UnaryCallable<DeleteBatchRequest, Empty> deleteBatchCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteBatchCallable()");
  }

  @Override
  public abstract void close();
}
