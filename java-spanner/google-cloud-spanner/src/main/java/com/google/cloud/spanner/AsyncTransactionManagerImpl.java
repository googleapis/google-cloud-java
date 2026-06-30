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

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.Options.TransactionOption;
import com.google.cloud.spanner.SessionImpl.SessionTransaction;
import com.google.cloud.spanner.TransactionContextFutureImpl.CommittableAsyncTransactionManager;
import com.google.cloud.spanner.TransactionManager.TransactionState;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.ByteString;

/** Implementation of {@link AsyncTransactionManager}. */
final class AsyncTransactionManagerImpl
    implements CommittableAsyncTransactionManager, SessionTransaction {

  private final SessionImpl session;
  private ISpan span;
  private final Options options;

  private TransactionRunnerImpl.TransactionContextImpl txn;
  private TransactionState txnState;
  private final SettableApiFuture<CommitResponse> commitResponse = SettableApiFuture.create();

  AsyncTransactionManagerImpl(SessionImpl session, ISpan span, TransactionOption... options) {
    this.session = session;
    this.span = span;
    this.options = Options.fromTransactionOptions(options);
  }

  @Override
  public void setSpan(ISpan span) {
    this.span = span;
  }

  @Override
  public void close() {
    SpannerApiFutures.get(closeAsync());
  }

  @Override
  public ApiFuture<Void> closeAsync() {
    ApiFuture<Void> res = null;
    if (txnState == TransactionState.STARTED) {
      res = rollbackAsync();
    }
    if (txn != null) {
      txn.close();
    }
    if (session != null) {
      session.onTransactionDone();
    }
    return MoreObjects.firstNonNull(res, ApiFutures.immediateFuture(null));
  }

  @Override
  public TransactionContextFutureImpl beginAsync() {
    Preconditions.checkState(txn == null, "begin can only be called once");
    return new TransactionContextFutureImpl(this, internalBeginAsync(true, ByteString.EMPTY));
  }

  @Override
  public TransactionContextFutureImpl beginAsync(AbortedException exception) {
    Preconditions.checkState(txn == null, "begin can only be called once");
    Preconditions.checkNotNull(exception, "AbortedException from the previous attempt is required");
    ByteString abortedTransactionId =
        exception.getTransactionID() != null ? exception.getTransactionID() : ByteString.EMPTY;
    return new TransactionContextFutureImpl(this, internalBeginAsync(true, abortedTransactionId));
  }

  private ApiFuture<TransactionContext> internalBeginAsync(
      boolean firstAttempt, ByteString abortedTransactionID) {
    txnState = TransactionState.STARTED;

    // Determine the latest transactionId when using a multiplexed session.
    ByteString multiplexedSessionPreviousTransactionId = ByteString.EMPTY;
    if (firstAttempt && session.getIsMultiplexed()) {
      multiplexedSessionPreviousTransactionId = abortedTransactionID;
    }
    if (txn != null && session.getIsMultiplexed() && !firstAttempt) {
      // Use the current transactionId if available, otherwise fallback to the previous aborted
      // transactionId.
      multiplexedSessionPreviousTransactionId =
          txn.transactionId != null ? txn.transactionId : txn.getPreviousTransactionId();
    }

    txn =
        session.newTransaction(
            options, /* previousTransactionId= */ multiplexedSessionPreviousTransactionId);
    if (firstAttempt) {
      session.setActive(this);
    }
    final SettableApiFuture<TransactionContext> res = SettableApiFuture.create();
    final ApiFuture<Void> fut;
    if (firstAttempt) {
      fut = ApiFutures.immediateFuture(null);
    } else {
      fut = txn.ensureTxnAsync();
    }
    ApiFutures.addCallback(
        fut,
        new ApiFutureCallback<Void>() {
          @Override
          public void onFailure(Throwable t) {
            onError(t);
            res.setException(SpannerExceptionFactory.asSpannerException(t));
          }

          @Override
          public void onSuccess(Void result) {
            res.set(txn);
          }
        },
        MoreExecutors.directExecutor());
    return res;
  }

  @Override
  public void onError(Throwable t) {
    if (t instanceof AbortedException) {
      txnState = TransactionState.ABORTED;
    }
  }

  @Override
  public ApiFuture<Timestamp> commitAsync() {
    Preconditions.checkState(
        txnState == TransactionState.STARTED,
        "commit can only be invoked if the transaction is in progress. Current state: " + txnState);
    if (txn.isAborted()) {
      txnState = TransactionState.ABORTED;
      return ApiFutures.immediateFailedFuture(
          SpannerExceptionFactory.newSpannerException(
              ErrorCode.ABORTED, "Transaction already aborted"));
    }
    ApiFuture<CommitResponse> commitResponseFuture = txn.commitAsync();
    txnState = TransactionState.COMMITTED;

    ApiFutures.addCallback(
        commitResponseFuture,
        new ApiFutureCallback<CommitResponse>() {
          @Override
          public void onFailure(Throwable t) {
            if (t instanceof AbortedException) {
              txnState = TransactionState.ABORTED;
            } else {
              txnState = TransactionState.COMMIT_FAILED;
              if (span != null) {
                span.setStatus(t);
                span.end();
              }
              commitResponse.setException(t);
            }
          }

          @Override
          public void onSuccess(CommitResponse result) {
            if (span != null) {
              span.end();
            }
            commitResponse.set(result);
          }
        },
        MoreExecutors.directExecutor());
    return ApiFutures.transform(
        commitResponseFuture, CommitResponse::getCommitTimestamp, MoreExecutors.directExecutor());
  }

  @Override
  public ApiFuture<Void> rollbackAsync() {
    Preconditions.checkState(
        txnState == TransactionState.STARTED,
        "rollback can only be called if the transaction is in progress");
    try {
      return ApiFutures.transformAsync(
          txn.rollbackAsync(),
          ignored -> ApiFutures.immediateFuture(null),
          MoreExecutors.directExecutor());
    } finally {
      if (span != null) {
        span.addAnnotation("Transaction rolled back");
        span.end();
      }
      txnState = TransactionState.ROLLED_BACK;
    }
  }

  @Override
  public TransactionContextFuture resetForRetryAsync() {
    if (txn == null || !txn.isAborted() && txnState != TransactionState.ABORTED) {
      throw new IllegalStateException(
          "resetForRetry can only be called if the previous attempt aborted");
    }
    return new TransactionContextFutureImpl(this, internalBeginAsync(false, ByteString.EMPTY));
  }

  @Override
  public TransactionState getState() {
    return txnState;
  }

  @Override
  public ApiFuture<CommitResponse> getCommitResponse() {
    Preconditions.checkState(
        txnState == TransactionState.COMMITTED,
        "getCommitResponse can only be invoked if the transaction was successfully committed");
    return commitResponse;
  }

  @Override
  public void invalidate() {
    if (txnState == TransactionState.STARTED || txnState == null) {
      txnState = TransactionState.ROLLED_BACK;
    }
  }
}
