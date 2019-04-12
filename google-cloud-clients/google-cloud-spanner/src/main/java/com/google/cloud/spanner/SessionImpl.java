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

import static com.google.cloud.spanner.SpannerExceptionFactory.newSpannerException;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.cloud.Timestamp;
import com.google.cloud.spanner.AbstractReadContext.MultiUseReadOnlyTransaction;
import com.google.cloud.spanner.AbstractReadContext.SingleReadContext;
import com.google.cloud.spanner.AbstractReadContext.SingleUseReadOnlyTransaction;
import com.google.cloud.spanner.TransactionRunnerImpl.TransactionContextImpl;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.common.collect.Lists;
import com.google.protobuf.ByteString;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.CommitResponse;
import com.google.spanner.v1.Transaction;
import com.google.spanner.v1.TransactionOptions;
import io.opencensus.common.Scope;
import io.opencensus.trace.Span;
import io.opencensus.trace.Tracer;
import io.opencensus.trace.Tracing;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;

/**
 * Implementation of {@link Session}. Sessions are managed internally by the client library, and
 * users need not be aware of the actual session management, pooling and handling.
 */
class SessionImpl implements Session {
  private static final Tracer tracer = Tracing.getTracer();

  /** Keep track of running transactions on this session per thread. */
  static final ThreadLocal<Boolean> hasPendingTransaction =
      new ThreadLocal<Boolean>() {
        @Override
        protected Boolean initialValue() {
          return false;
        }
      };

  static void throwIfTransactionsPending() {
    if (hasPendingTransaction.get() == Boolean.TRUE) {
      throw newSpannerException(ErrorCode.INTERNAL, "Nested transactions are not supported");
    }
  }

  /**
   * Represents a transaction within a session. "Transaction" here is used in the general sense,
   * which covers standalone reads, standalone writes, single-use and multi-use read-only
   * transactions, and read-write transactions. The defining characteristic is that a session may
   * only have one such transaction active at a time.
   */
  static interface SessionTransaction {
    /** Invalidates the transaction, generally because a new one has been started on the session. */
    void invalidate();
  }

  private final SpannerImpl spanner;
  private final String name;
  private SessionTransaction activeTransaction;
  private ByteString readyTransactionId;
  private final Map<SpannerRpc.Option, ?> options;

  SessionImpl(SpannerImpl spanner, String name, Map<SpannerRpc.Option, ?> options) {
    this.spanner = spanner;
    this.options = options;
    this.name = checkNotNull(name);
  }

  @Override
  public String getName() {
    return name;
  }

  Map<SpannerRpc.Option, ?> getOptions() {
    return options;
  }

  @Override
  public long executePartitionedUpdate(Statement stmt) {
    setActive(null);
    PartitionedDMLTransaction txn = new PartitionedDMLTransaction(this, spanner.getRpc());
    return txn.executePartitionedUpdate(stmt);
  }

  @Override
  public Timestamp write(Iterable<Mutation> mutations) throws SpannerException {
    TransactionRunner runner = readWriteTransaction();
    final Collection<Mutation> finalMutations =
        mutations instanceof java.util.Collection<?>
            ? (Collection<Mutation>) mutations
            : Lists.newArrayList(mutations);
    runner.run(
        new TransactionRunner.TransactionCallable<Void>() {
          @Override
          public Void run(TransactionContext ctx) {
            ctx.buffer(finalMutations);
            return null;
          }
        });
    return runner.getCommitTimestamp();
  }

  @Override
  public Timestamp writeAtLeastOnce(Iterable<Mutation> mutations) throws SpannerException {
    setActive(null);
    List<com.google.spanner.v1.Mutation> mutationsProto = new ArrayList<>();
    Mutation.toProto(mutations, mutationsProto);
    final CommitRequest request =
        CommitRequest.newBuilder()
            .setSession(name)
            .addAllMutations(mutationsProto)
            .setSingleUseTransaction(
                TransactionOptions.newBuilder()
                    .setReadWrite(TransactionOptions.ReadWrite.getDefaultInstance()))
            .build();
    Span span = tracer.spanBuilder(SpannerImpl.COMMIT).startSpan();
    try (Scope s = tracer.withSpan(span)) {
      CommitResponse response =
          SpannerImpl.runWithRetries(
              new Callable<CommitResponse>() {
                @Override
                public CommitResponse call() throws Exception {
                  return spanner.getRpc().commit(request, options);
                }
              });
      Timestamp t = Timestamp.fromProto(response.getCommitTimestamp());
      span.end();
      return t;
    } catch (IllegalArgumentException e) {
      TraceUtil.endSpanWithFailure(span, e);
      throw newSpannerException(ErrorCode.INTERNAL, "Could not parse commit timestamp", e);
    } catch (RuntimeException e) {
      TraceUtil.endSpanWithFailure(span, e);
      throw e;
    }
  }

  @Override
  public ReadContext singleUse() {
    return singleUse(TimestampBound.strong());
  }

  @Override
  public ReadContext singleUse(TimestampBound bound) {
    return setActive(
        new SingleReadContext(this, bound, spanner.getRpc(), spanner.getDefaultPrefetchChunks()));
  }

  @Override
  public ReadOnlyTransaction singleUseReadOnlyTransaction() {
    return singleUseReadOnlyTransaction(TimestampBound.strong());
  }

  @Override
  public ReadOnlyTransaction singleUseReadOnlyTransaction(TimestampBound bound) {
    return setActive(
        new SingleUseReadOnlyTransaction(
            this, bound, spanner.getRpc(), spanner.getDefaultPrefetchChunks()));
  }

  @Override
  public ReadOnlyTransaction readOnlyTransaction() {
    return readOnlyTransaction(TimestampBound.strong());
  }

  @Override
  public ReadOnlyTransaction readOnlyTransaction(TimestampBound bound) {
    return setActive(
        new MultiUseReadOnlyTransaction(
            this, bound, spanner.getRpc(), spanner.getDefaultPrefetchChunks()));
  }

  @Override
  public TransactionRunner readWriteTransaction() {
    return setActive(
        new TransactionRunnerImpl(this, spanner.getRpc(), spanner.getDefaultPrefetchChunks()));
  }

  @Override
  public void prepareReadWriteTransaction() {
    setActive(null);
    readyTransactionId = beginTransaction();
  }

  @Override
  public void close() {
    Span span = tracer.spanBuilder(SpannerImpl.DELETE_SESSION).startSpan();
    try (Scope s = tracer.withSpan(span)) {
      SpannerImpl.runWithRetries(
          new Callable<Void>() {
            @Override
            public Void call() throws Exception {
              spanner.getRpc().deleteSession(name, options);
              return null;
            }
          });
      span.end();
    } catch (RuntimeException e) {
      TraceUtil.endSpanWithFailure(span, e);
      throw e;
    }
  }

  ByteString beginTransaction() {
    Span span = tracer.spanBuilder(SpannerImpl.BEGIN_TRANSACTION).startSpan();
    try (Scope s = tracer.withSpan(span)) {
      final BeginTransactionRequest request =
          BeginTransactionRequest.newBuilder()
              .setSession(name)
              .setOptions(
                  TransactionOptions.newBuilder()
                      .setReadWrite(TransactionOptions.ReadWrite.getDefaultInstance()))
              .build();
      Transaction txn =
          SpannerImpl.runWithRetries(
              new Callable<Transaction>() {
                @Override
                public Transaction call() throws Exception {
                  return spanner.getRpc().beginTransaction(request, options);
                }
              });
      if (txn.getId().isEmpty()) {
        throw newSpannerException(ErrorCode.INTERNAL, "Missing id in transaction\n" + getName());
      }
      span.end();
      return txn.getId();
    } catch (RuntimeException e) {
      TraceUtil.endSpanWithFailure(span, e);
      throw e;
    }
  }

  TransactionContextImpl newTransaction() {
    TransactionContextImpl txn =
        new TransactionContextImpl(
            this, readyTransactionId, spanner.getRpc(), spanner.getDefaultPrefetchChunks());
    return txn;
  }

  <T extends SessionTransaction> T setActive(@Nullable T ctx) {
    throwIfTransactionsPending();

    if (activeTransaction != null) {
      activeTransaction.invalidate();
    }
    activeTransaction = ctx;
    readyTransactionId = null;
    return ctx;
  }

  @Override
  public TransactionManager transactionManager() {
    return new TransactionManagerImpl(this);
  }
}
