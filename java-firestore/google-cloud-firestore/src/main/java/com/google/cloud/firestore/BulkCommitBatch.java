/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.firestore;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.rpc.ApiException;
import com.google.cloud.Timestamp;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.firestore.v1.BatchWriteRequest;
import com.google.firestore.v1.BatchWriteResponse;
import io.grpc.Status;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;

/** Used to represent a batch that contains scheduled BulkWriterOperations. */
class BulkCommitBatch extends UpdateBuilder<ApiFuture<WriteResult>> {

  final List<BulkWriterOperation> pendingOperations = new ArrayList<>();
  private final Set<DocumentReference> documents = new CopyOnWriteArraySet<>();
  private final Executor executor;
  private int maxBatchSize;

  BulkCommitBatch(FirestoreImpl firestore, Executor executor, int maxBatchSize) {
    super(firestore);
    this.executor = executor;
    this.maxBatchSize = maxBatchSize;
  }

  int getMaxBatchSize() {
    return maxBatchSize;
  }

  void setMaxBatchSize(int size) {
    Preconditions.checkState(
        getMutationsSize() <= size,
        "New batch size cannot be less than the number of enqueued writes");
    this.maxBatchSize = size;
  }

  ApiFuture<WriteResult> wrapResult(int writeIndex) {
    return pendingOperations.get(writeIndex).getFuture();
  }

  /**
   * Commits all pending operations to the database and verifies all preconditions.
   *
   * <p>The writes in the batch are not applied atomically and can be applied out of order.
   */
  ApiFuture<Void> bulkCommit() {
    // Follows same thread safety logic as `UpdateBuilder::commit`.
    committed = true;
    BatchWriteRequest request = buildBatchWriteRequest();

    ApiFuture<BatchWriteResponse> response =
        processExceptions(
            firestore.sendRequest(request, firestore.getClient().batchWriteCallable()));

    return ApiFutures.transformAsync(
        response,
        batchWriteResponse -> {
          List<ApiFuture<Void>> pendingUserCallbacks = new ArrayList<>();

          List<com.google.firestore.v1.WriteResult> writeResults =
              batchWriteResponse.getWriteResultsList();
          List<com.google.rpc.Status> statuses = batchWriteResponse.getStatusList();

          for (int i = 0; i < writeResults.size(); ++i) {
            com.google.firestore.v1.WriteResult writeResult = writeResults.get(i);
            com.google.rpc.Status status = statuses.get(i);
            BulkWriterOperation operation = pendingOperations.get(i);
            Status code = Status.fromCodeValue(status.getCode());
            if (code == Status.OK) {
              pendingUserCallbacks.add(
                  operation.onSuccess(
                      new WriteResult(Timestamp.fromProto(writeResult.getUpdateTime()))));
            } else {
              pendingUserCallbacks.add(
                  operation.onException(
                      FirestoreException.forServerRejection(code, status.getMessage())));
            }
          }
          return BulkWriter.silenceFuture(ApiFutures.allAsList(pendingUserCallbacks));
        },
        executor);
  }

  private BatchWriteRequest buildBatchWriteRequest() {
    BatchWriteRequest.Builder builder = BatchWriteRequest.newBuilder();
    builder.setDatabase(firestore.getDatabaseName());
    forEachWrite(builder::addWrites);
    return builder.build();
  }

  /** Maps an RPC failure to each individual write's result. */
  private ApiFuture<BatchWriteResponse> processExceptions(ApiFuture<BatchWriteResponse> response) {
    return ApiFutures.catching(
        response,
        ApiException.class,
        exception -> {
          com.google.rpc.Status.Builder status =
              com.google.rpc.Status.newBuilder()
                  .setCode(exception.getStatusCode().getCode().ordinal())
                  .setMessage(exception.getMessage());
          BatchWriteResponse.Builder responseBuilder = BatchWriteResponse.newBuilder();
          for (int i = 0; i < pendingOperations.size(); ++i) {
            responseBuilder.addWriteResults(
                com.google.firestore.v1.WriteResult.getDefaultInstance());
            responseBuilder.addStatus(status);
          }
          return responseBuilder.build();
        },
        MoreExecutors.directExecutor());
  }

  void enqueueOperation(BulkWriterOperation operation) {
    boolean added = documents.add(operation.getDocumentReference());
    Preconditions.checkState(added, "Batch should not contain writes to the same document");
    pendingOperations.add(operation);
  }

  boolean has(DocumentReference documentReference) {
    return documents.contains(documentReference);
  }
}
