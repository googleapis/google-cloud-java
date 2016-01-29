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

package com.google.gcloud.spi;

import com.google.gcloud.datastore.DatastoreException;

/**
 * Provides access to the remote Datastore service.
 */
public interface DatastoreRpc {

  com.google.datastore.v1beta3.AllocateIdsResponse allocateIds(
      com.google.datastore.v1beta3.AllocateIdsRequest request) throws DatastoreException;

  com.google.datastore.v1beta3.BeginTransactionResponse beginTransaction(
      com.google.datastore.v1beta3.BeginTransactionRequest request) throws DatastoreException;

  com.google.datastore.v1beta3.CommitResponse commit(
      com.google.datastore.v1beta3.CommitRequest request) throws DatastoreException;

  com.google.datastore.v1beta3.LookupResponse lookup(
      com.google.datastore.v1beta3.LookupRequest request) throws DatastoreException;

  com.google.datastore.v1beta3.RollbackResponse rollback(
      com.google.datastore.v1beta3.RollbackRequest request) throws DatastoreException;

  com.google.datastore.v1beta3.RunQueryResponse runQuery(
      com.google.datastore.v1beta3.RunQueryRequest request) throws DatastoreException;
}
