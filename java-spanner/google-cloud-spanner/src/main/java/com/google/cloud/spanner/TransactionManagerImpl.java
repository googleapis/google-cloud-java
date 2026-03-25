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
import com.google.cloud.spanner.Options.TransactionOption;
import com.google.cloud.spanner.SessionImpl.SessionTransaction;
import com.google.common.base.Preconditions;
import com.google.protobuf.ByteString;

/** Implementation of {@link TransactionManager}. */
final class TransactionManagerImpl implements TransactionManager, SessionTransaction {
  private final TraceWrapper tracer;

  private final SessionImpl session;
  private ISpan span;
  private final Options options;

  private TransactionRunnerImpl.TransactionContextImpl txn;
  private TransactionState txnState;

  TransactionManagerImpl(
      SessionImpl session, ISpan span, TraceWrapper tracer, TransactionOption... options) {
    this.session = session;
    this.span = span;
    this.tracer = tracer;
    this.options = Options.fromTransactionOptions(options);
  }

  ISpan getSpan() {
    return span;
  }

  @Override
  public void setSpan(ISpan span) {
    this.span = span;
  }

  @Override
  public TransactionContext begin() {
    Preconditions.checkState(txn == null, "begin can only be called once");
    return begin(ByteString.EMPTY);
  }

  @Override
  public TransactionContext begin(AbortedException exception) {
    Preconditions.checkState(txn == null, "begin can only be called once");
    Preconditions.checkNotNull(exception, "AbortedException from the previous attempt is required");
    ByteString previousAbortedTransactionID =
        exception.getTransactionID() != null ? exception.getTransactionID() : ByteString.EMPTY;
    return begin(previousAbortedTransactionID);
  }

  TransactionContext begin(ByteString previousTransactionId) {
    try (IScope s = tracer.withSpan(span)) {
      txn = session.newTransaction(options, previousTransactionId);
      session.setActive(this);
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
    } finally {
      // At this point, if the TransactionState is not ABORTED, then the transaction has reached an
      // end state.
      // We can safely call close() to release resources.
      if (getState() != TransactionState.ABORTED) {
        close();
      }
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
      // At this point, the TransactionState is ROLLED_BACK which is an end state.
      // We can safely call close() to release resources.
      close();
    }
  }

  @Override
  public TransactionContext resetForRetry() {
    if (txn == null || !txn.isAborted() && txnState != TransactionState.ABORTED) {
      throw new IllegalStateException(
          "resetForRetry can only be called if the previous attempt aborted");
    }
    try (IScope s = tracer.withSpan(span)) {
      boolean useInlinedBegin = txn.transactionId != null;

      // Determine the latest transactionId when using a multiplexed session.
      ByteString multiplexedSessionPreviousTransactionId = ByteString.EMPTY;
      if (session.getIsMultiplexed()) {
        // Use the current transactionId if available, otherwise fallback to the previous aborted
        // transactionId.
        multiplexedSessionPreviousTransactionId =
            txn.transactionId != null ? txn.transactionId : txn.getPreviousTransactionId();
      }
      txn =
          session.newTransaction(
              options, /* previousTransactionId= */ multiplexedSessionPreviousTransactionId);
      if (!useInlinedBegin) {
        txn.ensureTxn();
      }
      txnState = TransactionState.STARTED;
      return txn;
    }
  }

  @Override
  public Timestamp getCommitTimestamp() {
    Preconditions.checkState(
        txnState == TransactionState.COMMITTED,
        "getCommitTimestamp can only be invoked if the transaction committed successfully");
    return txn.getCommitResponse().getCommitTimestamp();
  }

  @Override
  public CommitResponse getCommitResponse() {
    Preconditions.checkState(
        txnState == TransactionState.COMMITTED,
        "getCommitResponse can only be invoked if the transaction committed successfully");
    return txn.getCommitResponse();
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
      session.onTransactionDone();
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
