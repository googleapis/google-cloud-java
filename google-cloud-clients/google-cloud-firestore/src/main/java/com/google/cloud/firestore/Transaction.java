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

package com.google.cloud.firestore;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.common.base.Preconditions;
import com.google.firestore.v1beta1.BeginTransactionRequest;
import com.google.firestore.v1beta1.BeginTransactionResponse;
import com.google.firestore.v1beta1.RollbackRequest;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * A Transaction is passed to a Function to provide the methods to read and write data within the
 * transaction context.
 *
 * @see Firestore#runTransaction(Function)
 */
public final class Transaction extends UpdateBuilder<Transaction> {

  private static final String READ_BEFORE_WRITE_ERROR_MSG =
      "Firestore transactions require all reads to be executed before all writes";

  /**
   * User callback that takes a Firestore Transaction
   *
   * @param <T> The result type of the user callback.
   */
  public interface Function<T> {

    T updateCallback(Transaction transaction) throws Exception;
  }

  private final ByteString previousTransactionId;
  private ByteString transactionId;
  private boolean pending;

  Transaction(FirestoreImpl firestore, @Nullable ByteString previousTransactionId) {
    super(firestore);
    this.previousTransactionId = previousTransactionId;
  }

  @Nullable
  ByteString getTransactionId() {
    return transactionId;
  }

  boolean isPending() {
    return pending;
  }

  /** Starts a transaction and obtains the transaction id from the server. */
  ApiFuture<Void> begin() {
    BeginTransactionRequest.Builder beginTransaction = BeginTransactionRequest.newBuilder();
    beginTransaction.setDatabase(firestore.getDatabaseName());

    if (previousTransactionId != null) {
      beginTransaction
          .getOptionsBuilder()
          .getReadWriteBuilder()
          .setRetryTransaction(previousTransactionId);
    }

    ApiFuture<BeginTransactionResponse> transactionBeginFuture =
        firestore.sendRequest(
            beginTransaction.build(), firestore.getClient().beginTransactionCallable());

    return ApiFutures.transform(
        transactionBeginFuture,
        new ApiFunction<BeginTransactionResponse, Void>() {
          @Override
          public Void apply(BeginTransactionResponse beginTransactionResponse) {
            transactionId = beginTransactionResponse.getTransaction();
            pending = true;
            return null;
          }
        });
  }

  /** Commits a transaction. */
  ApiFuture<List<WriteResult>> commit() {
    pending = false;
    return super.commit(transactionId);
  }

  /** Rolls a transaction back and releases all read locks. */
  ApiFuture<Void> rollback() {
    pending = false;

    RollbackRequest.Builder reqBuilder = RollbackRequest.newBuilder();
    reqBuilder.setTransaction(transactionId);
    reqBuilder.setDatabase(firestore.getDatabaseName());

    ApiFuture<Empty> rollbackFuture =
        firestore.sendRequest(reqBuilder.build(), firestore.getClient().rollbackCallable());

    return ApiFutures.transform(
        rollbackFuture,
        new ApiFunction<Empty, Void>() {
          @Override
          public Void apply(Empty beginTransactionResponse) {
            return null;
          }
        });
  }

  /**
   * Reads the document referred to by the provided DocumentReference. Holds a pessimistic lock on
   * the returned document.
   *
   * @return The contents of the Document at this DocumentReference.
   */
  @Nonnull
  public ApiFuture<DocumentSnapshot> get(@Nonnull DocumentReference documentRef) {
    Preconditions.checkState(isEmpty(), READ_BEFORE_WRITE_ERROR_MSG);

    return ApiFutures.transform(
        firestore.getAll(new DocumentReference[] {documentRef}, /*fieldMask=*/ null, transactionId),
        new ApiFunction<List<DocumentSnapshot>, DocumentSnapshot>() {
          @Override
          public DocumentSnapshot apply(List<DocumentSnapshot> snapshots) {
            return snapshots.isEmpty() ? null : snapshots.get(0);
          }
        });
  }

  /**
   * Retrieves multiple documents from Firestore. Holds a pessimistic lock on all returned
   * documents.
   *
   * @param documentReferences List of Document References to fetch.
   */
  @Nonnull
  public ApiFuture<List<DocumentSnapshot>> getAll(
      @Nonnull DocumentReference... documentReferences) {
    Preconditions.checkState(isEmpty(), READ_BEFORE_WRITE_ERROR_MSG);

    return firestore.getAll(documentReferences, /*fieldMask=*/ null, transactionId);
  }

  /**
   * Retrieves multiple documents from Firestore, while optionally applying a field mask to reduce
   * the amount of data transmitted from the backend. Holds a pessimistic lock on all returned
   * documents.
   *
   * @param documentReferences Array with Document References to fetch.
   * @param fieldMask If set, specifies the subset of fields to return.
   */
  @Nonnull
  public ApiFuture<List<DocumentSnapshot>> getAll(
      @Nonnull DocumentReference[] documentReferences, @Nullable FieldMask fieldMask) {
    Preconditions.checkState(isEmpty(), READ_BEFORE_WRITE_ERROR_MSG);

    return firestore.getAll(documentReferences, fieldMask, transactionId);
  }

  /**
   * Returns the result set from the provided query. Holds a pessimistic lock on all returned
   * documents.
   *
   * @return The contents of the Document at this DocumentReference.
   */
  @Nonnull
  public ApiFuture<QuerySnapshot> get(@Nonnull Query query) {
    Preconditions.checkState(isEmpty(), READ_BEFORE_WRITE_ERROR_MSG);

    return query.get(transactionId);
  }
}
