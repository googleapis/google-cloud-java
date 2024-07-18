/*
 * Copyright 2024 Google LLC
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
import com.google.cloud.firestore.telemetry.TraceUtil;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Timestamp;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * The ReadTimeTransaction is a ready-only Transaction that specifies a ReadTime. Unlike a
 * `ServerSideTransaction`, we do not need a `transactionId` since we provide a `readTime` on all
 * requests. No concurrency control is required, since data in the past is immutable. As with all
 * `read-only` transactions, we do not allow any write request.
 *
 * @see Transaction
 */
final class ReadTimeTransaction extends Transaction {

  public static final String WRITE_EXCEPTION_MSG =
      "Firestore ready-only transactions do not support writes";
  private final Timestamp readTime;

  ReadTimeTransaction(FirestoreImpl firestore, Timestamp readTime) {
    super(firestore);
    Preconditions.checkNotNull(readTime, "readTime cannot be null");
    this.readTime = readTime;
  }

  @Override
  public boolean hasTransactionId() {
    return false;
  }

  @Nonnull
  @Override
  public ApiFuture<DocumentSnapshot> get(@Nonnull DocumentReference documentRef) {
    TraceUtil.Span span =
        getTraceUtil()
            .startSpan(TraceUtil.SPAN_NAME_TRANSACTION_GET_DOCUMENT, transactionTraceContext);
    try (TraceUtil.Scope ignored = span.makeCurrent()) {
      ApiFuture<DocumentSnapshot> result =
          ApiFutures.transform(
              firestore.getAll(
                  new DocumentReference[] {documentRef}, /* fieldMask= */ null, readTime),
              snapshots -> snapshots.isEmpty() ? null : snapshots.get(0),
              MoreExecutors.directExecutor());
      span.endAtFuture(result);
      return result;
    } catch (Exception error) {
      span.end(error);
      throw error;
    }
  }

  @Nonnull
  @Override
  public ApiFuture<List<DocumentSnapshot>> getAll(
      @Nonnull DocumentReference... documentReferences) {
    TraceUtil.Span span =
        getTraceUtil()
            .startSpan(TraceUtil.SPAN_NAME_TRANSACTION_GET_DOCUMENTS, transactionTraceContext);
    try (TraceUtil.Scope ignored = span.makeCurrent()) {
      ApiFuture<List<DocumentSnapshot>> result =
          firestore.getAll(documentReferences, /* fieldMask= */ null, readTime);
      span.endAtFuture(result);
      return result;
    } catch (Exception error) {
      span.end(error);
      throw error;
    }
  }

  @Nonnull
  @Override
  public ApiFuture<List<DocumentSnapshot>> getAll(
      @Nonnull DocumentReference[] documentReferences, @Nullable FieldMask fieldMask) {
    TraceUtil.Span span =
        getTraceUtil()
            .startSpan(TraceUtil.SPAN_NAME_TRANSACTION_GET_DOCUMENTS, transactionTraceContext);
    try (TraceUtil.Scope ignored = span.makeCurrent()) {
      ApiFuture<List<DocumentSnapshot>> result =
          firestore.getAll(documentReferences, /* fieldMask= */ null, readTime);
      span.endAtFuture(result);
      return result;
    } catch (Exception error) {
      span.end(error);
      throw error;
    }
  }

  @Nonnull
  @Override
  public ApiFuture<QuerySnapshot> get(@Nonnull Query query) {
    try (TraceUtil.Scope ignored = transactionTraceContext.makeCurrent()) {
      return query.get(null, com.google.cloud.Timestamp.fromProto(readTime));
    }
  }

  @Nonnull
  @Override
  public ApiFuture<AggregateQuerySnapshot> get(@Nonnull AggregateQuery query) {
    try (TraceUtil.Scope ignored = transactionTraceContext.makeCurrent()) {
      return query.get(null, readTime);
    }
  }

  @Nonnull
  @Override
  public Transaction create(
      @Nonnull DocumentReference documentReference, @Nonnull Map<String, Object> fields) {
    throw new IllegalStateException(WRITE_EXCEPTION_MSG);
  }

  @Nonnull
  @Override
  public Transaction create(@Nonnull DocumentReference documentReference, @Nonnull Object pojo) {
    throw new IllegalStateException(WRITE_EXCEPTION_MSG);
  }

  @Nonnull
  @Override
  public Transaction set(
      @Nonnull DocumentReference documentReference, @Nonnull Map<String, Object> fields) {
    throw new IllegalStateException(WRITE_EXCEPTION_MSG);
  }

  @Nonnull
  @Override
  public Transaction set(
      @Nonnull DocumentReference documentReference,
      @Nonnull Map<String, Object> fields,
      @Nonnull SetOptions options) {
    throw new IllegalStateException(WRITE_EXCEPTION_MSG);
  }

  @Nonnull
  @Override
  public Transaction set(@Nonnull DocumentReference documentReference, @Nonnull Object pojo) {
    throw new IllegalStateException(WRITE_EXCEPTION_MSG);
  }

  @Nonnull
  @Override
  public Transaction set(
      @Nonnull DocumentReference documentReference,
      @Nonnull Object pojo,
      @Nonnull SetOptions options) {
    throw new IllegalStateException(WRITE_EXCEPTION_MSG);
  }

  @Nonnull
  @Override
  public Transaction update(
      @Nonnull DocumentReference documentReference, @Nonnull Map<String, Object> fields) {
    throw new IllegalStateException(WRITE_EXCEPTION_MSG);
  }

  @Nonnull
  @Override
  public Transaction update(
      @Nonnull DocumentReference documentReference,
      @Nonnull Map<String, Object> fields,
      Precondition precondition) {
    throw new IllegalStateException(WRITE_EXCEPTION_MSG);
  }

  @Nonnull
  @Override
  public Transaction update(
      @Nonnull DocumentReference documentReference,
      @Nonnull String field,
      @Nullable Object value,
      Object... moreFieldsAndValues) {
    throw new IllegalStateException(WRITE_EXCEPTION_MSG);
  }

  @Nonnull
  @Override
  public Transaction update(
      @Nonnull DocumentReference documentReference,
      @Nonnull FieldPath fieldPath,
      @Nullable Object value,
      Object... moreFieldsAndValues) {
    throw new IllegalStateException(WRITE_EXCEPTION_MSG);
  }

  @Nonnull
  @Override
  public Transaction update(
      @Nonnull DocumentReference documentReference,
      @Nonnull Precondition precondition,
      @Nonnull String field,
      @Nullable Object value,
      Object... moreFieldsAndValues) {
    throw new IllegalStateException(WRITE_EXCEPTION_MSG);
  }

  @Nonnull
  @Override
  public Transaction update(
      @Nonnull DocumentReference documentReference,
      @Nonnull Precondition precondition,
      @Nonnull FieldPath fieldPath,
      @Nullable Object value,
      Object... moreFieldsAndValues) {
    throw new IllegalStateException(WRITE_EXCEPTION_MSG);
  }

  @Nonnull
  @Override
  public Transaction delete(
      @Nonnull DocumentReference documentReference, @Nonnull Precondition precondition) {
    throw new IllegalStateException(WRITE_EXCEPTION_MSG);
  }

  @Nonnull
  @Override
  public Transaction delete(@Nonnull DocumentReference documentReference) {
    throw new IllegalStateException(WRITE_EXCEPTION_MSG);
  }

  @Override
  public String toString() {
    return String.format("%s{readTime=%s}", getClass().getSimpleName(), readTime);
  }
}
