/*
 * Copyright 2017 Google LLC
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

package com.google.cloud.firestore.spi.v1;

import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.ServiceRpc;
import com.google.cloud.firestore.v1.FirestoreClient.ListCollectionIdsPagedResponse;
import com.google.cloud.firestore.v1.FirestoreClient.ListDocumentsPagedResponse;
import com.google.firestore.v1.BatchGetDocumentsRequest;
import com.google.firestore.v1.BatchGetDocumentsResponse;
import com.google.firestore.v1.BeginTransactionRequest;
import com.google.firestore.v1.BeginTransactionResponse;
import com.google.firestore.v1.CommitRequest;
import com.google.firestore.v1.CommitResponse;
import com.google.firestore.v1.ListCollectionIdsRequest;
import com.google.firestore.v1.ListDocumentsRequest;
import com.google.firestore.v1.ListenRequest;
import com.google.firestore.v1.ListenResponse;
import com.google.firestore.v1.RollbackRequest;
import com.google.firestore.v1.RunQueryRequest;
import com.google.firestore.v1.RunQueryResponse;
import com.google.protobuf.Empty;
import java.util.concurrent.ScheduledExecutorService;

/** Contains the RPC stubs used by the manual Cloud Firestore client. */
public interface FirestoreRpc extends AutoCloseable, ServiceRpc {

  /** Commits a transaction, while optionally updating documents. */
  UnaryCallable<CommitRequest, CommitResponse> commitCallable();

  /** Gets multiple documents. */
  ServerStreamingCallable<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
      batchGetDocumentsCallable();

  /** Returns the executor used by the GAPIC client. */
  ScheduledExecutorService getExecutor();

  /** Runs a query. */
  ServerStreamingCallable<RunQueryRequest, RunQueryResponse> runQueryCallable();

  /** Starts a new transaction. */
  UnaryCallable<BeginTransactionRequest, BeginTransactionResponse> beginTransactionCallable();

  /** Rolls back a transaction. */
  UnaryCallable<RollbackRequest, Empty> rollbackCallable();

  /** Returns a list of collections IDs. */
  UnaryCallable<ListCollectionIdsRequest, ListCollectionIdsPagedResponse>
      listCollectionIdsPagedCallable();

  /** Returns a list of documents. */
  UnaryCallable<ListDocumentsRequest, ListDocumentsPagedResponse> listDocumentsPagedCallable();

  /** Returns a bi-directional watch stream. */
  BidiStreamingCallable<ListenRequest, ListenResponse> listenCallable();
}
