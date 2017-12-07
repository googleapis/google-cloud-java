/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package com.google.cloud.firestore.spi.v1beta1;

import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.ServiceRpc;
import com.google.cloud.firestore.v1beta1.PagedResponseWrappers.ListCollectionIdsPagedResponse;
import com.google.firestore.v1beta1.BatchGetDocumentsRequest;
import com.google.firestore.v1beta1.BatchGetDocumentsResponse;
import com.google.firestore.v1beta1.BeginTransactionRequest;
import com.google.firestore.v1beta1.BeginTransactionResponse;
import com.google.firestore.v1beta1.CommitRequest;
import com.google.firestore.v1beta1.CommitResponse;
import com.google.firestore.v1beta1.ListCollectionIdsRequest;
import com.google.firestore.v1beta1.RollbackRequest;
import com.google.firestore.v1beta1.RunQueryRequest;
import com.google.firestore.v1beta1.RunQueryResponse;
import com.google.protobuf.Empty;
import java.util.concurrent.Executor;

/** Contains the RPC stubs used by the manual Cloud Firestore client. */
public interface FirestoreRpc extends AutoCloseable, ServiceRpc {

  /** Commits a transaction, while optionally updating documents. */
  UnaryCallable<CommitRequest, CommitResponse> commitCallable();

  /** Gets multiple documents. */
  ServerStreamingCallable<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
      batchGetDocumentsCallable();

  /** Returns the executor used by the GAPIC client. */
  Executor getExecutor();

  /** Runs a query. */
  ServerStreamingCallable<RunQueryRequest, RunQueryResponse> runQueryCallable();

  /** Starts a new transaction. */
  UnaryCallable<BeginTransactionRequest, BeginTransactionResponse> beginTransactionCallable();

  /** Rolls back a transaction. */
  UnaryCallable<RollbackRequest, Empty> rollbackCallable();

  /** Returns a list of collections IDs. */
  UnaryCallable<ListCollectionIdsRequest, ListCollectionIdsPagedResponse>
      listCollectionIdsPagedCallable();
}
