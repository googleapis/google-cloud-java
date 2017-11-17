/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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
import io.opencensus.trace.samplers.Samplers;

import java.util.Arrays;

class DatabaseClientImpl implements DatabaseClient {
  private static final String READ_WRITE_TRANSACTION = "CloudSpanner.ReadWriteTransaction";
  private static final String READ_ONLY_TRANSACTION = "CloudSpanner.ReadOnlyTransaction";
  private static final Tracer tracer = Tracing.getTracer();
  
  static {
    Tracing.getExportComponent().getSampledSpanStore().registerSpanNamesForCollection(
        Arrays.asList(READ_WRITE_TRANSACTION, READ_ONLY_TRANSACTION));
  }
  
  private final SessionPool pool;

  DatabaseClientImpl(SessionPool pool) {
    this.pool = pool;
  }

  @Override
  public Timestamp write(Iterable<Mutation> mutations) throws SpannerException {
    try (Scope s = tracer.spanBuilder(READ_WRITE_TRANSACTION).startScopedSpan()) {
      return pool.getReadWriteSession().write(mutations);
    }
  }

  @Override
  public Timestamp writeAtLeastOnce(Iterable<Mutation> mutations) throws SpannerException {
    try (Scope s = tracer.spanBuilder(READ_WRITE_TRANSACTION).startScopedSpan()) {
      return pool.getReadSession().writeAtLeastOnce(mutations);
    }
  }

  @Override
  public ReadContext singleUse() {
    Span span = tracer.spanBuilder(READ_ONLY_TRANSACTION).startSpan();
    try (Scope s = tracer.withSpan(span)){
      return pool.getReadSession().singleUse();
    }
  }

  @Override
  public ReadContext singleUse(TimestampBound bound) {
    try (Scope s = tracer.spanBuilder(READ_ONLY_TRANSACTION).startScopedSpan()) {
      return pool.getReadSession().singleUse(bound);
    }
  }

  @Override
  public ReadOnlyTransaction singleUseReadOnlyTransaction() {
    try (Scope s = tracer.spanBuilder(READ_ONLY_TRANSACTION).startScopedSpan()) {
      return pool.getReadSession().singleUseReadOnlyTransaction();
    }
  }

  @Override
  public ReadOnlyTransaction singleUseReadOnlyTransaction(TimestampBound bound) {
    try (Scope s = tracer.spanBuilder(READ_ONLY_TRANSACTION).startScopedSpan()) {
      return pool.getReadSession().singleUseReadOnlyTransaction(bound);
    }
  }

  @Override
  public ReadOnlyTransaction readOnlyTransaction() {
    try (Scope s = tracer.spanBuilder(READ_ONLY_TRANSACTION).startScopedSpan()) {
      return pool.getReadSession().readOnlyTransaction();
    }
  }

  @Override
  public ReadOnlyTransaction readOnlyTransaction(TimestampBound bound) {
    try (Scope s = tracer.spanBuilder(READ_ONLY_TRANSACTION).startScopedSpan()) {
      return pool.getReadSession().readOnlyTransaction(bound);
    }
  }

  @Override
  public TransactionRunner readWriteTransaction() {
    try (Scope s = tracer.spanBuilder(READ_WRITE_TRANSACTION).startScopedSpan()) {
      return pool.getReadWriteSession().readWriteTransaction();
    }
  }

  ListenableFuture<Void> closeAsync() {
    return pool.closeAsync();
  }
}
