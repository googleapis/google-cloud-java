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

import com.google.api.core.ApiFuture;
import com.google.api.core.InternalExtensionOnly;
import com.google.cloud.firestore.telemetry.TraceUtil;
import com.google.cloud.firestore.telemetry.TraceUtil.Context;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * A Transaction is passed to a Function to provide the methods to read and write data within the
 * transaction context.
 *
 * @see Firestore#runTransaction(Function)
 */
@InternalExtensionOnly
public abstract class Transaction extends UpdateBuilder<Transaction> {

  private static final Logger LOGGER = Logger.getLogger(Transaction.class.getName());
  private static final String READ_BEFORE_WRITE_ERROR_MSG =
      "Firestore transactions require all reads to be executed before all writes";
  protected @Nonnull Context transactionTraceContext;

  protected Transaction(FirestoreImpl firestore) {
    super(firestore);
    this.transactionTraceContext = firestore.getOptions().getTraceUtil().currentContext();
  }

  @Nonnull
  TraceUtil getTraceUtil() {
    return firestore.getOptions().getTraceUtil();
  }

  @Nonnull
  Context setTransactionTraceContext(Context context) {
    return transactionTraceContext = context;
  }

  /**
   * User callback that takes a Firestore Transaction.
   *
   * @param <T> The result type of the user callback.
   */
  public interface Function<T> {

    T updateCallback(Transaction transaction) throws Exception;
  }

  /**
   * User callback that takes a Firestore Async Transaction.
   *
   * @param <T> The result type of the user async callback.
   */
  public interface AsyncFunction<T> {

    ApiFuture<T> updateCallback(Transaction transaction);
  }

  @Override
  protected String className() {
    return "Transaction";
  }

  public abstract boolean hasTransactionId();

  @Override
  Transaction wrapResult(int writeIndex) {
    return this;
  }

  /**
   * Reads the document referred to by the provided DocumentReference. Holds a pessimistic lock on
   * the returned document.
   *
   * @return The contents of the Document at this DocumentReference.
   */
  @Nonnull
  public abstract ApiFuture<DocumentSnapshot> get(@Nonnull DocumentReference documentRef);

  /**
   * Retrieves multiple documents from Firestore. Holds a pessimistic lock on all returned
   * documents.
   *
   * @param documentReferences List of Document References to fetch.
   */
  @Nonnull
  public abstract ApiFuture<List<DocumentSnapshot>> getAll(
      @Nonnull DocumentReference... documentReferences);

  /**
   * Retrieves multiple documents from Firestore, while optionally applying a field mask to reduce
   * the amount of data transmitted from the backend. Holds a pessimistic lock on all returned
   * documents.
   *
   * @param documentReferences Array with Document References to fetch.
   * @param fieldMask If set, specifies the subset of fields to return.
   */
  @Nonnull
  public abstract ApiFuture<List<DocumentSnapshot>> getAll(
      @Nonnull DocumentReference[] documentReferences, @Nullable FieldMask fieldMask);

  /**
   * Returns the result set from the provided query. Holds a pessimistic lock on all returned
   * documents.
   *
   * @return The contents of the Document at this DocumentReference.
   */
  @Nonnull
  public abstract ApiFuture<QuerySnapshot> get(@Nonnull Query query);

  /**
   * Returns the result from the provided aggregate query. Holds a pessimistic lock on all accessed
   * documents.
   *
   * @return The result of the aggregation.
   */
  @Nonnull
  public abstract ApiFuture<AggregateQuerySnapshot> get(@Nonnull AggregateQuery query);
}
