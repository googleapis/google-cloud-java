/*
 * Copyright 2015 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.datastore.spi.v1;

import com.google.cloud.ServiceRpc;
import com.google.cloud.datastore.DatastoreException;
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

/** Provides access to the remote Datastore service. */
public interface DatastoreRpc extends ServiceRpc {

  /**
   * Sends an allocate IDs request.
   *
   * @throws DatastoreException upon failure
   */
  AllocateIdsResponse allocateIds(AllocateIdsRequest request);

  /**
   * Sends a begin transaction request.
   *
   * @throws DatastoreException upon failure
   */
  BeginTransactionResponse beginTransaction(BeginTransactionRequest request)
      throws DatastoreException;

  /**
   * Sends a commit request.
   *
   * @throws DatastoreException upon failure
   */
  CommitResponse commit(CommitRequest request);

  /**
   * Sends a lookup request.
   *
   * @throws DatastoreException upon failure
   */
  LookupResponse lookup(LookupRequest request);

  /**
   * Sends a reserveIds request.
   *
   * @throws DatastoreException upon failure
   */
  ReserveIdsResponse reserveIds(ReserveIdsRequest request);

  /**
   * Sends a rollback request.
   *
   * @throws DatastoreException upon failure
   */
  RollbackResponse rollback(RollbackRequest request);

  /**
   * Sends a request to run a query.
   *
   * @throws DatastoreException upon failure
   */
  RunQueryResponse runQuery(RunQueryRequest request);

  /**
   * Sends a request to run an aggregation query.
   *
   * @throws DatastoreException upon failure
   */
  default RunAggregationQueryResponse runAggregationQuery(RunAggregationQueryRequest request) {
    throw new UnsupportedOperationException("Not implemented.");
  }
}
