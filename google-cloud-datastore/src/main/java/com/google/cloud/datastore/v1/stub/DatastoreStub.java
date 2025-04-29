/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.datastore.v1.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.datastore.v1.AllocateIdsRequest;
import com.google.datastore.v1.AllocateIdsResponse;
import com.google.datastore.v1.BeginTransactionRequest;
import com.google.datastore.v1.BeginTransactionResponse;
import com.google.datastore.v1.CommitRequest;
import com.google.datastore.v1.CommitResponse;
import com.google.datastore.v1.LookupRequest;
import com.google.datastore.v1.LookupResponse;
import com.google.datastore.v1.ReserveIdsRequest;
import com.google.datastore.v1.ReserveIdsResponse;
import com.google.datastore.v1.RollbackRequest;
import com.google.datastore.v1.RollbackResponse;
import com.google.datastore.v1.RunAggregationQueryRequest;
import com.google.datastore.v1.RunAggregationQueryResponse;
import com.google.datastore.v1.RunQueryRequest;
import com.google.datastore.v1.RunQueryResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Datastore service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class DatastoreStub implements BackgroundResource {

  public UnaryCallable<LookupRequest, LookupResponse> lookupCallable() {
    throw new UnsupportedOperationException("Not implemented: lookupCallable()");
  }

  public UnaryCallable<RunQueryRequest, RunQueryResponse> runQueryCallable() {
    throw new UnsupportedOperationException("Not implemented: runQueryCallable()");
  }

  public UnaryCallable<RunAggregationQueryRequest, RunAggregationQueryResponse>
      runAggregationQueryCallable() {
    throw new UnsupportedOperationException("Not implemented: runAggregationQueryCallable()");
  }

  public UnaryCallable<BeginTransactionRequest, BeginTransactionResponse>
      beginTransactionCallable() {
    throw new UnsupportedOperationException("Not implemented: beginTransactionCallable()");
  }

  public UnaryCallable<CommitRequest, CommitResponse> commitCallable() {
    throw new UnsupportedOperationException("Not implemented: commitCallable()");
  }

  public UnaryCallable<RollbackRequest, RollbackResponse> rollbackCallable() {
    throw new UnsupportedOperationException("Not implemented: rollbackCallable()");
  }

  public UnaryCallable<AllocateIdsRequest, AllocateIdsResponse> allocateIdsCallable() {
    throw new UnsupportedOperationException("Not implemented: allocateIdsCallable()");
  }

  public UnaryCallable<ReserveIdsRequest, ReserveIdsResponse> reserveIdsCallable() {
    throw new UnsupportedOperationException("Not implemented: reserveIdsCallable()");
  }

  @Override
  public abstract void close();
}
