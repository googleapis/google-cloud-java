package com.google.cloud.spanner;

import com.google.cloud.Timestamp;
import com.google.common.base.Preconditions;

final class TransactionManagerImpl implements TransactionManager {
  
  private enum State {
    STARTED,
    COMMITTED,
    COMMIT_FAILED,
    ABORTED,
    ROLLED_BACK
  }

  private Session session;
  private final SpannerImpl.TransactionContextImpl txn;
  private State txnState;
  private boolean txnBegun;
  
  TransactionManagerImpl(Session session,SpannerImpl.TransactionContextImpl txn) {
    this.session = session;
    this.txn = txn;
  }
  
  @Override
  public TransactionContext begin() {
    Preconditions.checkState(!txnBegun, "begin can only be called once");
    txnBegun = true;
    txnState = State.STARTED;
    return txn;
  }

  @Override
  public void commit() {
    Preconditions.checkState(txnState == State.STARTED, "commit can only be invoked if"
        + " the transaction is in progress");
    if (txn.isAborted()) {
      txnState = State.ABORTED;
      throw SpannerExceptionFactory.newSpannerException(ErrorCode.ABORTED,
          "Transaction already aborted");
    }
    try {
      txn.commit();
      txnState = State.COMMITTED;
      closeSession();
    } catch (SpannerException e) {
      if (!(e instanceof AbortedException)) {
        txnState = State.COMMIT_FAILED;
        closeSession();
      } else {
        txnState = State.ABORTED;
      }
      throw e;
    }
  }

  @Override
  public void rollback() {
    Preconditions.checkState(txnState == State.STARTED, "rollback can only be called if the"
        + " transaction is in progress");
    try {
      txn.rollback();
    } finally {
      txnState = State.ROLLED_BACK;
      closeSession();
    }
  }

  @Override
  public TransactionContext resetForRetry() {
    if (txn.isAborted() || txnState == State.ABORTED) {
      throw new IllegalStateException("resetForRetry can only be called if the previous attempt"
          + " aborted");
    }
    txn.ensureTxn();
    txnState = State.STARTED;
    return txn;
  }

  @Override
  public Timestamp getCommitTimestamp() {
    Preconditions.checkState(txnState == State.COMMITTED, "getCommitTimestamp can only be"
        + " invoked if the transaction committed successfully");
    return txn.commitTimestamp();
  }

  @Override
  public void close() {
    if (txnState == State.STARTED && !txn.isAborted()) {
      txn.rollback();
    }
    closeSession();
  }

  private void closeSession() {
    if (session != null) {
      session.close();
      session = null;
    }
  }
}
