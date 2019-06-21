/*
 * Copyright 2019 Google LLC
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

import static com.google.cloud.spanner.SpannerExceptionFactory.newSpannerBatchUpdateException;
import static com.google.cloud.spanner.SpannerExceptionFactory.newSpannerException;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import com.google.api.client.util.BackOff;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.SessionImpl.SessionTransaction;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.ByteString;
import com.google.rpc.Code;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.CommitResponse;
import com.google.spanner.v1.ExecuteBatchDmlRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.ExecuteSqlRequest.QueryMode;
import com.google.spanner.v1.RollbackRequest;
import com.google.spanner.v1.TransactionSelector;
import io.opencensus.common.Scope;
import io.opencensus.trace.AttributeValue;
import io.opencensus.trace.Span;
import io.opencensus.trace.Tracer;
import io.opencensus.trace.Tracing;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/** Default implementation of {@link TransactionRunner}. */
class TransactionRunnerImpl implements SessionTransaction, TransactionRunner {
  private static final Tracer tracer = Tracing.getTracer();
  private static final Logger txnLogger = Logger.getLogger(TransactionRunner.class.getName());

  @VisibleForTesting
  static class TransactionContextImpl extends AbstractReadContext implements TransactionContext {
    @GuardedBy("lock")
    private List<Mutation> mutations = new ArrayList<>();

    @GuardedBy("lock")
    private boolean aborted;

    /** Default to -1 to indicate not available. */
    @GuardedBy("lock")
    private long retryDelayInMillis = -1L;

    private ByteString transactionId;
    private Timestamp commitTimestamp;

    TransactionContextImpl(
        SessionImpl session,
        @Nullable ByteString transactionId,
        SpannerRpc rpc,
        int defaultPrefetchChunks) {
      super(session, rpc, defaultPrefetchChunks);
      this.transactionId = transactionId;
    }

    void ensureTxn() {
      if (transactionId == null) {
        span.addAnnotation("Creating Transaction");
        try {
          transactionId = session.beginTransaction();
          span.addAnnotation(
              "Transaction Creation Done",
              ImmutableMap.of(
                  "Id", AttributeValue.stringAttributeValue(transactionId.toStringUtf8())));
          txnLogger.log(
              Level.FINER,
              "Started transaction {0}",
              txnLogger.isLoggable(Level.FINER) ? transactionId.asReadOnlyByteBuffer() : null);
        } catch (SpannerException e) {
          span.addAnnotation("Transaction Creation Failed", TraceUtil.getExceptionAnnotations(e));
          throw e;
        }
      } else {
        span.addAnnotation(
            "Transaction Initialized",
            ImmutableMap.of(
                "Id", AttributeValue.stringAttributeValue(transactionId.toStringUtf8())));
        txnLogger.log(
            Level.FINER,
            "Using prepared transaction {0}",
            txnLogger.isLoggable(Level.FINER) ? transactionId.asReadOnlyByteBuffer() : null);
      }
    }

    void commit() {
      span.addAnnotation("Starting Commit");
      CommitRequest.Builder builder =
          CommitRequest.newBuilder().setSession(session.getName()).setTransactionId(transactionId);
      synchronized (lock) {
        if (!mutations.isEmpty()) {
          List<com.google.spanner.v1.Mutation> mutationsProto = new ArrayList<>();
          Mutation.toProto(mutations, mutationsProto);
          builder.addAllMutations(mutationsProto);
        }
        // Ensure that no call to buffer mutations that would be lost can succeed.
        mutations = null;
      }
      final CommitRequest commitRequest = builder.build();
      Span opSpan = tracer.spanBuilderWithExplicitParent(SpannerImpl.COMMIT, span).startSpan();
      try (Scope s = tracer.withSpan(opSpan)) {
        CommitResponse commitResponse = rpc.commit(commitRequest, session.getOptions());
        if (!commitResponse.hasCommitTimestamp()) {
          throw newSpannerException(
              ErrorCode.INTERNAL, "Missing commitTimestamp:\n" + session.getName());
        }
        commitTimestamp = Timestamp.fromProto(commitResponse.getCommitTimestamp());
        opSpan.end();
      } catch (RuntimeException e) {
        span.addAnnotation("Commit Failed", TraceUtil.getExceptionAnnotations(e));
        TraceUtil.endSpanWithFailure(opSpan, e);
        throw e;
      }
      span.addAnnotation("Commit Done");
    }

    Timestamp commitTimestamp() {
      checkState(commitTimestamp != null, "run() has not yet returned normally");
      return commitTimestamp;
    }

    boolean isAborted() {
      synchronized (lock) {
        return aborted;
      }
    }

    /** Return the delay in milliseconds between requests to Cloud Spanner. */
    long getRetryDelayInMillis(BackOff backoff) {
      long delay = SpannerImpl.nextBackOffMillis(backoff);
      synchronized (lock) {
        if (retryDelayInMillis >= 0) {
          return retryDelayInMillis;
        }
      }
      return delay;
    }

    void rollback() {
      // We're exiting early due to a user exception, but the transaction is still active.
      // Send a rollback for the transaction to release any locks held.
      // TODO(user): Make this an async fire-and-forget request.
      try {
        // Note that we're not retrying this request since we don't particularly care about the
        // response.  Normally, the next thing that will happen is that we will make a fresh
        // transaction attempt, which should implicitly abort this one.
        span.addAnnotation("Starting Rollback");
        rpc.rollback(
            RollbackRequest.newBuilder()
                .setSession(session.getName())
                .setTransactionId(transactionId)
                .build(),
            session.getOptions());
        span.addAnnotation("Rollback Done");
      } catch (SpannerException e) {
        txnLogger.log(Level.FINE, "Exception during rollback", e);
        span.addAnnotation("Rollback Failed", TraceUtil.getExceptionAnnotations(e));
      }
    }

    @Nullable
    @Override
    TransactionSelector getTransactionSelector() {
      return TransactionSelector.newBuilder().setId(transactionId).build();
    }

    @Override
    public void onError(SpannerException e) {
      if (e.getErrorCode() == ErrorCode.ABORTED) {
        long delay = -1L;
        if (e instanceof AbortedException) {
          delay = ((AbortedException) e).getRetryDelayInMillis();
        }
        if (delay == -1L) {
          txnLogger.log(Level.FINE, "Retry duration is missing from the exception.", e);
        }

        synchronized (lock) {
          retryDelayInMillis = delay;
          aborted = true;
        }
      }
    }

    @Override
    public void buffer(Mutation mutation) {
      synchronized (lock) {
        checkNotNull(mutations, "Context is closed");
        mutations.add(checkNotNull(mutation));
      }
    }

    @Override
    public void buffer(Iterable<Mutation> mutations) {
      synchronized (lock) {
        checkNotNull(this.mutations, "Context is closed");
        for (Mutation mutation : mutations) {
          this.mutations.add(checkNotNull(mutation));
        }
      }
    }

    @Override
    public long executeUpdate(Statement statement) {
      beforeReadOrQuery();
      final ExecuteSqlRequest.Builder builder =
          getExecuteSqlRequestBuilder(statement, QueryMode.NORMAL);
      com.google.spanner.v1.ResultSet resultSet =
          rpc.executeQuery(builder.build(), session.getOptions());
      if (!resultSet.hasStats()) {
        throw new IllegalArgumentException(
            "DML response missing stats possibly due to non-DML statement as input");
      }
      // For standard DML, using the exact row count.
      return resultSet.getStats().getRowCountExact();
    }

    @Override
    public long[] batchUpdate(Iterable<Statement> statements) {
      beforeReadOrQuery();
      final ExecuteBatchDmlRequest.Builder builder = getExecuteBatchDmlRequestBuilder(statements);
      com.google.spanner.v1.ExecuteBatchDmlResponse response =
          rpc.executeBatchDml(builder.build(), session.getOptions());
      long[] results = new long[response.getResultSetsCount()];
      for (int i = 0; i < response.getResultSetsCount(); ++i) {
        results[i] = response.getResultSets(i).getStats().getRowCountExact();
      }

      // If one of the DML statements was aborted, we should throw an aborted exception.
      // In all other cases, we should throw a BatchUpdateException.
      if (response.getStatus().getCode() == Code.ABORTED_VALUE) {
        throw newSpannerException(
            ErrorCode.fromRpcStatus(response.getStatus()), response.getStatus().getMessage());
      } else if (response.getStatus().getCode() != 0) {
        throw newSpannerBatchUpdateException(
            ErrorCode.fromRpcStatus(response.getStatus()),
            response.getStatus().getMessage(),
            results);
      }
      return results;
    }
  }

  private boolean blockNestedTxn = true;
  private final SessionImpl session;
  private final Span span;
  private TransactionContextImpl txn;
  private volatile boolean isValid = true;

  @Override
  public TransactionRunner allowNestedTransaction() {
    blockNestedTxn = false;
    return this;
  }

  TransactionRunnerImpl(SessionImpl session, SpannerRpc rpc, int defaultPrefetchChunks) {
    this.session = session;
    this.span = Tracing.getTracer().getCurrentSpan();
  }

  @Nullable
  @Override
  public <T> T run(TransactionCallable<T> callable) {
    try (Scope s = tracer.withSpan(span)) {
      if (blockNestedTxn) {
        SessionImpl.hasPendingTransaction.set(Boolean.TRUE);
      }
      return runInternal(callable);
    } catch (RuntimeException e) {
      TraceUtil.endSpanWithFailure(span, e);
      throw e;
    } finally {
      // Remove threadLocal rather than set to FALSE to avoid a possible memory leak.
      // We also do this unconditionally in case a user has modified the flag when the transaction
      // was running.
      SessionImpl.hasPendingTransaction.remove();
    }
  }

  private <T> T runInternal(final TransactionCallable<T> txCallable) {
    final AtomicInteger attempt = new AtomicInteger();
    Callable<T> retryCallable =
        new Callable<T>() {
          @Override
          public T call() {
            txn = session.newTransaction();
            checkState(
                isValid,
                "TransactionRunner has been invalidated by a new operation on the session");
            attempt.incrementAndGet();
            // TODO(user): When using streaming reads, consider using the first read to begin
            // the txn.
            span.addAnnotation(
                "Starting Transaction Attempt",
                ImmutableMap.of("Attempt", AttributeValue.longAttributeValue(attempt.longValue())));
            txn.ensureTxn();

            T result;
            boolean shouldRollback = true;
            try {
              result = txCallable.run(txn);
              shouldRollback = false;
            } catch (Exception e) {
              txnLogger.log(Level.FINE, "User-provided TransactionCallable raised exception", e);
              if (txn.isAborted() || (e instanceof AbortedException)) {
                span.addAnnotation(
                    "Transaction Attempt Aborted in user operation. Retrying",
                    ImmutableMap.of(
                        "Attempt", AttributeValue.longAttributeValue(attempt.longValue())));
                shouldRollback = false;
                if (e instanceof AbortedException) {
                  throw (AbortedException) e;
                }
                throw SpannerExceptionFactory.newSpannerException(
                    ErrorCode.ABORTED, e.getMessage(), e);
              }
              SpannerException toThrow;
              if (e instanceof SpannerException) {
                toThrow = (SpannerException) e;
              } else {
                toThrow = newSpannerException(ErrorCode.UNKNOWN, e.getMessage(), e);
              }
              span.addAnnotation(
                  "Transaction Attempt Failed in user operation",
                  ImmutableMap.<String, AttributeValue>builder()
                      .putAll(TraceUtil.getExceptionAnnotations(toThrow))
                      .put("Attempt", AttributeValue.longAttributeValue(attempt.longValue()))
                      .build());
              throw toThrow;
            } finally {
              if (shouldRollback) {
                txn.rollback();
              }
            }

            try {
              txn.commit();
              span.addAnnotation(
                  "Transaction Attempt Succeeded",
                  ImmutableMap.of(
                      "Attempt", AttributeValue.longAttributeValue(attempt.longValue())));
              return result;
            } catch (AbortedException e) {
              txnLogger.log(Level.FINE, "Commit aborted", e);
              span.addAnnotation(
                  "Transaction Attempt Aborted in Commit. Retrying",
                  ImmutableMap.of(
                      "Attempt", AttributeValue.longAttributeValue(attempt.longValue())));
              throw e;
            } catch (SpannerException e) {
              span.addAnnotation(
                  "Transaction Attempt Failed in Commit",
                  ImmutableMap.<String, AttributeValue>builder()
                      .putAll(TraceUtil.getExceptionAnnotations(e))
                      .put("Attempt", AttributeValue.longAttributeValue(attempt.longValue()))
                      .build());
              throw e;
            }
          }
        };
    return SpannerRetryHelper.runTxWithRetriesOnAborted(retryCallable);
  }

  @Override
  public Timestamp getCommitTimestamp() {
    checkState(txn != null, "run() has not yet returned normally");
    return txn.commitTimestamp();
  }

  @Override
  public void invalidate() {
    isValid = false;
  }
}
