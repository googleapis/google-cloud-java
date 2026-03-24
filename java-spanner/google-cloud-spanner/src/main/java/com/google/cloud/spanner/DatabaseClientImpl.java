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

import com.google.api.gax.rpc.ServerStream;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.Options.TransactionOption;
import com.google.cloud.spanner.Options.UpdateOption;
import com.google.cloud.spanner.SpannerImpl.ClosedException;
import com.google.cloud.spanner.Statement.StatementFactory;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.spanner.v1.BatchWriteResponse;
import io.opentelemetry.api.common.Attributes;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

class DatabaseClientImpl implements DatabaseClient {
  private static final String READ_WRITE_TRANSACTION = "CloudSpanner.ReadWriteTransaction";
  private static final String READ_ONLY_TRANSACTION = "CloudSpanner.ReadOnlyTransaction";
  private static final String PARTITION_DML_TRANSACTION = "CloudSpanner.PartitionDMLTransaction";
  private final TraceWrapper tracer;
  private final Attributes databaseAttributes;
  @VisibleForTesting final String clientId;
  @VisibleForTesting final MultiplexedSessionDatabaseClient multiplexedSessionDatabaseClient;
  @VisibleForTesting final int dbId;
  private final AtomicInteger nthRequest;
  private final Map<String, Integer> clientIdToOrdinalMap;

  DatabaseClientImpl(
      String clientId,
      MultiplexedSessionDatabaseClient multiplexedSessionDatabaseClient,
      TraceWrapper tracer,
      Attributes databaseAttributes) {
    this.clientId = clientId;
    this.multiplexedSessionDatabaseClient = multiplexedSessionDatabaseClient;
    this.tracer = tracer;
    this.databaseAttributes = databaseAttributes;

    this.clientIdToOrdinalMap = new HashMap<String, Integer>();
    this.dbId = this.dbIdFromClientId(this.clientId);
    this.nthRequest = new AtomicInteger(0);
  }

  @VisibleForTesting
  synchronized int dbIdFromClientId(String clientId) {
    Integer id = this.clientIdToOrdinalMap.get(clientId);
    if (id == null) {
      id = this.clientIdToOrdinalMap.size() + 1;
      this.clientIdToOrdinalMap.put(clientId, id);
    }
    return id;
  }

  @VisibleForTesting
  DatabaseClient getMultiplexedSession() {
    return this.multiplexedSessionDatabaseClient;
  }

  @Override
  public Dialect getDialect() {
    return this.multiplexedSessionDatabaseClient.getDialect();
  }

  private final AbstractLazyInitializer<StatementFactory> statementFactorySupplier =
      new AbstractLazyInitializer<StatementFactory>() {
        @Override
        protected StatementFactory initialize() {
          try {
            Dialect dialect = getDialectAsync().get(30, TimeUnit.SECONDS);
            return new StatementFactory(dialect);
          } catch (ExecutionException | TimeoutException e) {
            throw SpannerExceptionFactory.asSpannerException(e);
          } catch (InterruptedException e) {
            throw SpannerExceptionFactory.propagateInterrupt(e);
          }
        }
      };

  @Override
  public StatementFactory getStatementFactory() {
    try {
      return statementFactorySupplier.get();
    } catch (Exception exception) {
      throw SpannerExceptionFactory.asSpannerException(exception);
    }
  }

  @Override
  @Nullable
  public String getDatabaseRole() {
    return multiplexedSessionDatabaseClient.getDatabaseRole();
  }

  @Override
  public Timestamp write(final Iterable<Mutation> mutations) throws SpannerException {
    return writeWithOptions(mutations).getCommitTimestamp();
  }

  @Override
  public CommitResponse writeWithOptions(
      final Iterable<Mutation> mutations, final TransactionOption... options)
      throws SpannerException {
    ISpan span = tracer.spanBuilder(READ_WRITE_TRANSACTION, databaseAttributes, options);
    try (IScope s = tracer.withSpan(span)) {
      return multiplexedSessionDatabaseClient.writeWithOptions(mutations, options);
    } catch (RuntimeException e) {
      span.setStatus(e);
      throw e;
    } finally {
      span.end();
    }
  }

  @Override
  public Timestamp writeAtLeastOnce(final Iterable<Mutation> mutations) throws SpannerException {
    return writeAtLeastOnceWithOptions(mutations).getCommitTimestamp();
  }

  @Override
  public CommitResponse writeAtLeastOnceWithOptions(
      final Iterable<Mutation> mutations, final TransactionOption... options)
      throws SpannerException {
    ISpan span = tracer.spanBuilder(READ_WRITE_TRANSACTION, databaseAttributes, options);
    try (IScope s = tracer.withSpan(span)) {
      return multiplexedSessionDatabaseClient.writeAtLeastOnceWithOptions(mutations, options);
    } catch (RuntimeException e) {
      span.setStatus(e);
      throw e;
    } finally {
      span.end();
    }
  }

  @Override
  public ServerStream<BatchWriteResponse> batchWriteAtLeastOnce(
      final Iterable<MutationGroup> mutationGroups, final TransactionOption... options)
      throws SpannerException {
    ISpan span = tracer.spanBuilder(READ_WRITE_TRANSACTION, databaseAttributes, options);
    try (IScope s = tracer.withSpan(span)) {
      return multiplexedSessionDatabaseClient.batchWriteAtLeastOnce(mutationGroups, options);
    } catch (RuntimeException e) {
      span.setStatus(e);
      throw e;
    } finally {
      span.end();
    }
  }

  @Override
  public ReadContext singleUse() {
    ISpan span = tracer.spanBuilder(READ_ONLY_TRANSACTION, databaseAttributes);
    try (IScope s = tracer.withSpan(span)) {
      return getMultiplexedSession().singleUse();
    } catch (RuntimeException e) {
      span.setStatus(e);
      span.end();
      throw e;
    }
  }

  @Override
  public ReadContext singleUse(TimestampBound bound) {
    ISpan span = tracer.spanBuilder(READ_ONLY_TRANSACTION, databaseAttributes);
    try (IScope s = tracer.withSpan(span)) {
      return getMultiplexedSession().singleUse(bound);
    } catch (RuntimeException e) {
      span.setStatus(e);
      span.end();
      throw e;
    }
  }

  @Override
  public ReadOnlyTransaction singleUseReadOnlyTransaction() {
    ISpan span = tracer.spanBuilder(READ_ONLY_TRANSACTION, databaseAttributes);
    try (IScope s = tracer.withSpan(span)) {
      return getMultiplexedSession().singleUseReadOnlyTransaction();
    } catch (RuntimeException e) {
      span.setStatus(e);
      span.end();
      throw e;
    }
  }

  @Override
  public ReadOnlyTransaction singleUseReadOnlyTransaction(TimestampBound bound) {
    ISpan span = tracer.spanBuilder(READ_ONLY_TRANSACTION, databaseAttributes);
    try (IScope s = tracer.withSpan(span)) {
      return getMultiplexedSession().singleUseReadOnlyTransaction(bound);
    } catch (RuntimeException e) {
      span.setStatus(e);
      span.end();
      throw e;
    }
  }

  @Override
  public ReadOnlyTransaction readOnlyTransaction() {
    ISpan span = tracer.spanBuilder(READ_ONLY_TRANSACTION, databaseAttributes);
    try (IScope s = tracer.withSpan(span)) {
      return getMultiplexedSession().readOnlyTransaction();
    } catch (RuntimeException e) {
      span.setStatus(e);
      span.end();
      throw e;
    }
  }

  @Override
  public ReadOnlyTransaction readOnlyTransaction(TimestampBound bound) {
    ISpan span = tracer.spanBuilder(READ_ONLY_TRANSACTION, databaseAttributes);
    try (IScope s = tracer.withSpan(span)) {
      return getMultiplexedSession().readOnlyTransaction(bound);
    } catch (RuntimeException e) {
      span.setStatus(e);
      span.end();
      throw e;
    }
  }

  @Override
  public TransactionRunner readWriteTransaction(TransactionOption... options) {
    ISpan span = tracer.spanBuilder(READ_WRITE_TRANSACTION, databaseAttributes, options);
    try (IScope s = tracer.withSpan(span)) {
      return multiplexedSessionDatabaseClient.readWriteTransaction(options);
    } catch (RuntimeException e) {
      span.setStatus(e);
      span.end();
      throw e;
    }
  }

  @Override
  public TransactionManager transactionManager(TransactionOption... options) {
    ISpan span = tracer.spanBuilder(READ_WRITE_TRANSACTION, databaseAttributes, options);
    try (IScope s = tracer.withSpan(span)) {
      return multiplexedSessionDatabaseClient.transactionManager(options);
    } catch (RuntimeException e) {
      span.setStatus(e);
      span.end();
      throw e;
    }
  }

  @Override
  public AsyncRunner runAsync(TransactionOption... options) {
    ISpan span = tracer.spanBuilder(READ_WRITE_TRANSACTION, databaseAttributes, options);
    try (IScope s = tracer.withSpan(span)) {
      return multiplexedSessionDatabaseClient.runAsync(options);
    } catch (RuntimeException e) {
      span.setStatus(e);
      span.end();
      throw e;
    }
  }

  @Override
  public AsyncTransactionManager transactionManagerAsync(TransactionOption... options) {
    ISpan span = tracer.spanBuilder(READ_WRITE_TRANSACTION, databaseAttributes, options);
    try (IScope s = tracer.withSpan(span)) {
      return multiplexedSessionDatabaseClient.transactionManagerAsync(options);
    } catch (RuntimeException e) {
      span.setStatus(e);
      span.end();
      throw e;
    }
  }

  @Override
  public long executePartitionedUpdate(final Statement stmt, final UpdateOption... options) {
    return multiplexedSessionDatabaseClient.executePartitionedUpdate(stmt, options);
  }

  private Future<Dialect> getDialectAsync() {
    return multiplexedSessionDatabaseClient.getDialectAsync();
  }

  boolean isValid() {
    return multiplexedSessionDatabaseClient.isValid();
  }

  ListenableFuture<Void> closeAsync(ClosedException closedException) {
    // This method is non-blocking.
    this.multiplexedSessionDatabaseClient.close();
    return Futures.immediateVoidFuture();
  }
}
