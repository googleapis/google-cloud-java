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

  static {
    TraceUtil.exportSpans(READ_WRITE_TRANSACTION, READ_ONLY_TRANSACTION, PARTITION_DML_TRANSACTION);
  }

  private final SessionPool pool;

  DatabaseClientImpl(SessionPool pool) {
    this.pool = pool;
  }

  @Override
  public Timestamp write(Iterable<Mutation> mutations) throws SpannerException {
    Span span = tracer.spanBuilder(READ_WRITE_TRANSACTION).startSpan();
    try (Scope s = tracer.withSpan(span)) {
      return pool.getReadWriteSession().write(mutations);
    } catch (RuntimeException e) {
      TraceUtil.endSpanWithFailure(span, e);
      throw e;
    } finally {
      span.end();
    }
  }

  @Override
  public Timestamp writeAtLeastOnce(Iterable<Mutation> mutations) throws SpannerException {
    Span span = tracer.spanBuilder(READ_WRITE_TRANSACTION).startSpan();
    try (Scope s = tracer.withSpan(span)) {
      return pool.getReadWriteSession().writeAtLeastOnce(mutations);
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
      return pool.getReadSession().singleUse();
    } catch (RuntimeException e) {
      TraceUtil.endSpanWithFailure(span, e);
      throw e;
    }
  }

  @Override
  public ReadContext singleUse(TimestampBound bound) {
    Span span = tracer.spanBuilder(READ_ONLY_TRANSACTION).startSpan();
    try (Scope s = tracer.withSpan(span)) {
      return pool.getReadSession().singleUse(bound);
    } catch (RuntimeException e) {
      TraceUtil.endSpanWithFailure(span, e);
      throw e;
    }
  }

  @Override
  public ReadOnlyTransaction singleUseReadOnlyTransaction() {
    Span span = tracer.spanBuilder(READ_ONLY_TRANSACTION).startSpan();
    try (Scope s = tracer.withSpan(span)) {
      return pool.getReadSession().singleUseReadOnlyTransaction();
    } catch (RuntimeException e) {
      TraceUtil.endSpanWithFailure(span, e);
      throw e;
    }
  }

  @Override
  public ReadOnlyTransaction singleUseReadOnlyTransaction(TimestampBound bound) {
    Span span = tracer.spanBuilder(READ_ONLY_TRANSACTION).startSpan();
    try (Scope s = tracer.withSpan(span)) {
      return pool.getReadSession().singleUseReadOnlyTransaction(bound);
    } catch (RuntimeException e) {
      TraceUtil.endSpanWithFailure(span, e);
      throw e;
    }
  }

  @Override
  public ReadOnlyTransaction readOnlyTransaction() {
    Span span = tracer.spanBuilder(READ_ONLY_TRANSACTION).startSpan();
    try (Scope s = tracer.withSpan(span)) {
      return pool.getReadSession().readOnlyTransaction();
    } catch (RuntimeException e) {
      TraceUtil.endSpanWithFailure(span, e);
      throw e;
    }
  }

  @Override
  public ReadOnlyTransaction readOnlyTransaction(TimestampBound bound) {
    Span span = tracer.spanBuilder(READ_ONLY_TRANSACTION).startSpan();
    try (Scope s = tracer.withSpan(span)) {
      return pool.getReadSession().readOnlyTransaction(bound);
    } catch (RuntimeException e) {
      TraceUtil.endSpanWithFailure(span, e);
      throw e;
    }
  }

  @Override
  public TransactionRunner readWriteTransaction() {
    Span span = tracer.spanBuilder(READ_WRITE_TRANSACTION).startSpan();
    try (Scope s = tracer.withSpan(span)) {
      return pool.getReadWriteSession().readWriteTransaction();
    } catch (RuntimeException e) {
      TraceUtil.endSpanWithFailure(span, e);
      throw e;
    }
  }

  @Override
  public TransactionManager transactionManager() {
    Span span = tracer.spanBuilder(READ_WRITE_TRANSACTION).startSpan();
    try (Scope s = tracer.withSpan(span)) {
      return pool.getReadWriteSession().transactionManager();
    } catch (RuntimeException e) {
      TraceUtil.endSpanWithFailure(span, e);
      throw e;
    }
  }

  @Override
  public long executePartitionedUpdate(Statement stmt) {
    Span span = tracer.spanBuilder(PARTITION_DML_TRANSACTION).startSpan();
    try (Scope s = tracer.withSpan(span)) {
      return pool.getReadWriteSession().executePartitionedUpdate(stmt);
    } catch (RuntimeException e) {
      TraceUtil.endSpanWithFailure(span, e);
      throw e;
    }
  }

  ListenableFuture<Void> closeAsync() {
    return pool.closeAsync();
  }
}
