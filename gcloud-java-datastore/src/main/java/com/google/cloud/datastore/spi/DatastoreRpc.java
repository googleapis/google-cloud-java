/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.cloud.datastore.spi;

import com.google.datastore.v1beta3.AllocateIdsRequest;
import com.google.datastore.v1beta3.AllocateIdsResponse;
import com.google.datastore.v1beta3.BeginTransactionRequest;
import com.google.datastore.v1beta3.BeginTransactionResponse;
import com.google.datastore.v1beta3.CommitRequest;
import com.google.datastore.v1beta3.CommitResponse;
import com.google.datastore.v1beta3.LookupRequest;
import com.google.datastore.v1beta3.LookupResponse;
import com.google.datastore.v1beta3.RollbackRequest;
import com.google.datastore.v1beta3.RollbackResponse;
import com.google.datastore.v1beta3.RunQueryRequest;
import com.google.datastore.v1beta3.RunQueryResponse;
import com.google.cloud.datastore.DatastoreException;

/**
 * Provides access to the remote Datastore service.
 */
public interface DatastoreRpc {

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
}
