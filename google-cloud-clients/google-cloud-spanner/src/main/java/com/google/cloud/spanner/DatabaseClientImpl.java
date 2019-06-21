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
import com.google.cloud.spanner.SessionPool.PooledSession;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.util.concurrent.ListenableFuture;
import io.opencensus.common.Scope;
import io.opencensus.trace.Span;
import io.opencensus.trace.Tracer;
import io.opencensus.trace.Tracing;

class DatabaseClientImpl implements DatabaseClient {
  private static final String READ_WRITE_TRANSACTION = "CloudSpanner.ReadWriteTransaction";
  private static final String READ_ONLY_TRANSACTION = "CloudSpanner.ReadOnlyTransaction";
  private static final String PARTITION_DML_TRANSACTION = "CloudSpanner.PartitionDMLTransaction";
  private static final Tracer tracer = Tracing.getTracer();

  private enum SessionMode {
    READ,
    READ_WRITE
  }

  static {
    TraceUtil.exportSpans(READ_WRITE_TRANSACTION, READ_ONLY_TRANSACTION, PARTITION_DML_TRANSACTION);
  }

  @VisibleForTesting final SessionPool pool;

  DatabaseClientImpl(SessionPool pool) {
    this.pool = pool;
  }

  @VisibleForTesting
  PooledSession getReadSession() {
    return pool.getReadSession();
  }

  @VisibleForTesting
  PooledSession getReadWriteSession() {
    return pool.getReadWriteSession();
  }

  @Override
  public Timestamp write(final Iterable<Mutation> mutations) throws SpannerException {
    Span span = tracer.spanBuilder(READ_WRITE_TRANSACTION).startSpan();
    try (Scope s = tracer.withSpan(span)) {
      return runWithSessionRetry(
          SessionMode.READ_WRITE,
          new Function<Session, Timestamp>() {
            @Override
            public Timestamp apply(Session session) {
              return session.write(mutations);
            }
          });
    } catch (RuntimeException e) {
      TraceUtil.endSpanWithFailure(span, e);
      throw e;
    } finally {
      span.end();
    }
  }

  @Override
  public Timestamp writeAtLeastOnce(final Iterable<Mutation> mutations) throws SpannerException {
    Span span = tracer.spanBuilder(READ_WRITE_TRANSACTION).startSpan();
    try (Scope s = tracer.withSpan(span)) {
      return runWithSessionRetry(
          SessionMode.READ_WRITE,
          new Function<Session, Timestamp>() {
            @Override
            public Timestamp apply(Session session) {
              return session.writeAtLeastOnce(mutations);
            }
          });
    } catch (RuntimeException e) {
      TraceUtil.endSpanWithFailure(span, e);
      throw e;
    } finally {
      span.end();
    }
  }

  @Override
  public ReadContext singleUse() {
    Span span = tracer.spanBuilder(READ_ONLY_TRANSACTION).startSpan();
    try (Scope s = tracer.withSpan(span)) {
      return getReadSession().singleUse();
    } catch (RuntimeException e) {
      TraceUtil.endSpanWithFailure(span, e);
      throw e;
    }
  }

  @Override
  public ReadContext singleUse(TimestampBound bound) {
    Span span = tracer.spanBuilder(READ_ONLY_TRANSACTION).startSpan();
    try (Scope s = tracer.withSpan(span)) {
      return getReadSession().singleUse(bound);
    } catch (RuntimeException e) {
      TraceUtil.endSpanWithFailure(span, e);
      throw e;
    }
  }

  @Override
  public ReadOnlyTransaction singleUseReadOnlyTransaction() {
    Span span = tracer.spanBuilder(READ_ONLY_TRANSACTION).startSpan();
    try (Scope s = tracer.withSpan(span)) {
      return getReadSession().singleUseReadOnlyTransaction();
    } catch (RuntimeException e) {
      TraceUtil.endSpanWithFailure(span, e);
      throw e;
    }
  }

  @Override
  public ReadOnlyTransaction singleUseReadOnlyTransaction(TimestampBound bound) {
    Span span = tracer.spanBuilder(READ_ONLY_TRANSACTION).startSpan();
    try (Scope s = tracer.withSpan(span)) {
      return getReadSession().singleUseReadOnlyTransaction(bound);
    } catch (RuntimeException e) {
      TraceUtil.endSpanWithFailure(span, e);
      throw e;
    }
  }

  @Override
  public ReadOnlyTransaction readOnlyTransaction() {
    Span span = tracer.spanBuilder(READ_ONLY_TRANSACTION).startSpan();
    try (Scope s = tracer.withSpan(span)) {
      return getReadSession().readOnlyTransaction();
    } catch (RuntimeException e) {
      TraceUtil.endSpanWithFailure(span, e);
      throw e;
    }
  }

  @Override
  public ReadOnlyTransaction readOnlyTransaction(TimestampBound bound) {
    Span span = tracer.spanBuilder(READ_ONLY_TRANSACTION).startSpan();
    try (Scope s = tracer.withSpan(span)) {
      return getReadSession().readOnlyTransaction(bound);
    } catch (RuntimeException e) {
      TraceUtil.endSpanWithFailure(span, e);
      throw e;
    }
  }

  @Override
  public TransactionRunner readWriteTransaction() {
    Span span = tracer.spanBuilder(READ_WRITE_TRANSACTION).startSpan();
    try (Scope s = tracer.withSpan(span)) {
      return getReadWriteSession().readWriteTransaction();
    } catch (RuntimeException e) {
      TraceUtil.endSpanWithFailure(span, e);
      throw e;
    }
  }

  @Override
  public TransactionManager transactionManager() {
    Span span = tracer.spanBuilder(READ_WRITE_TRANSACTION).startSpan();
    try (Scope s = tracer.withSpan(span)) {
      return getReadWriteSession().transactionManager();
    } catch (RuntimeException e) {
      TraceUtil.endSpanWithFailure(span, e);
      throw e;
    }
  }

  @Override
  public long executePartitionedUpdate(final Statement stmt) {
    Span span = tracer.spanBuilder(PARTITION_DML_TRANSACTION).startSpan();
    try (Scope s = tracer.withSpan(span)) {
      // A partitioned update transaction does not need a prepared write session, as the transaction
      // object will start a new transaction with specific options anyway.
      return runWithSessionRetry(
          SessionMode.READ,
          new Function<Session, Long>() {
            @Override
            public Long apply(Session session) {
              return session.executePartitionedUpdate(stmt);
            }
          });
    } catch (RuntimeException e) {
      TraceUtil.endSpanWithFailure(span, e);
      throw e;
    }
  }

  private <T> T runWithSessionRetry(SessionMode mode, Function<Session, T> callable) {
    PooledSession session =
        mode == SessionMode.READ_WRITE ? getReadWriteSession() : getReadSession();
    while (true) {
      try {
        return callable.apply(session);
      } catch (SessionNotFoundException e) {
        session =
            mode == SessionMode.READ_WRITE
                ? pool.replaceReadWriteSession(e, session)
                : pool.replaceReadSession(e, session);
      }
    }
  }

  ListenableFuture<Void> closeAsync() {
    return pool.closeAsync();
  }
}
