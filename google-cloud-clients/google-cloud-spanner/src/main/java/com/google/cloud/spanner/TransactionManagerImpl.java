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

package com.google.cloud.spanner;

import com.google.cloud.Timestamp;
import com.google.cloud.spanner.SpannerImpl.SessionImpl;
import com.google.cloud.spanner.SpannerImpl.SessionTransaction;
import com.google.common.base.Preconditions;
import io.opencensus.common.Scope;
import io.opencensus.trace.Span;
import io.opencensus.trace.Tracer;
import io.opencensus.trace.Tracing;

/** Implementation of {@link TransactionManager}. */
final class TransactionManagerImpl implements TransactionManager, SessionTransaction {
  private static final Tracer tracer = Tracing.getTracer();

  private final SessionImpl session;
  private final Span span;

  private SpannerImpl.TransactionContextImpl txn;
  private TransactionState txnState;

  TransactionManagerImpl(SessionImpl session) {
    this.session = session;
    this.span = Tracing.getTracer().getCurrentSpan();
  }

  @Override
  public TransactionContext begin() {
    Preconditions.checkState(txn == null, "begin can only be called once");
    try (Scope s = tracer.withSpan(span)) {
      txn = session.newTransaction();
      session.setActive(this);
      txn.ensureTxn();
      txnState = TransactionState.STARTED;
      return txn;
    }
  }

  @Override
  public void commit() {
    Preconditions.checkState(
        txnState == TransactionState.STARTED,
        "commit can only be invoked if" + " the transaction is in progress");
    if (txn.isAborted()) {
      txnState = TransactionState.ABORTED;
      throw SpannerExceptionFactory.newSpannerException(
          ErrorCode.ABORTED, "Transaction already aborted");
    }
    try {
      txn.commit();
      txnState = TransactionState.COMMITTED;
    } catch (AbortedException e1) {
      txnState = TransactionState.ABORTED;
      throw e1;
    } catch (SpannerException e2) {
      txnState = TransactionState.COMMIT_FAILED;
      throw e2;
    }
  }

  @Override
  public void rollback() {
    Preconditions.checkState(
        txnState == TransactionState.STARTED,
        "rollback can only be called if the transaction is in progress");
    try {
      txn.rollback();
    } finally {
      txnState = TransactionState.ROLLED_BACK;
    }
  }

  @Override
  public TransactionContext resetForRetry() {
    if (txn == null || !txn.isAborted() && txnState != TransactionState.ABORTED) {
      throw new IllegalStateException(
          "resetForRetry can only be called if the previous attempt" + " aborted");
    }
    try (Scope s = tracer.withSpan(span)) {
      txn = session.newTransaction();
      txn.ensureTxn();
      txnState = TransactionState.STARTED;
      return txn;
    }
  }

  @Override
  public Timestamp getCommitTimestamp() {
    Preconditions.checkState(
        txnState == TransactionState.COMMITTED,
        "getCommitTimestamp can only be invoked if the transaction committed successfully");
    return txn.commitTimestamp();
  }

  @Override
  public void close() {
    try {
      if (txnState == TransactionState.STARTED && !txn.isAborted()) {
        txn.rollback();
        txnState = TransactionState.ROLLED_BACK;
      }
    } finally {
      span.end();
    }
  }

  @Override
  public TransactionState getState() {
    return txnState;
  }

  @Override
  public void invalidate() {
    close();
  }
}
