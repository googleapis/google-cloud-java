/*
 * Copyright 2024 Google LLC
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
import com.google.api.core.ApiFutures;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.Options.ReadOption;
import com.google.common.base.Suppliers;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.ExecutionException;
import javax.annotation.Nullable;

/**
 * Represents a {@link ReadContext} using a multiplexed session that is not yet ready. The execution
 * will be delayed until the multiplexed session has been created and is ready. This class is only
 * used during the startup of the client and the multiplexed session has not yet been created. This
 * ensures that the creation of {@link DatabaseClient} is non-blocking.
 */
class DelayedReadContext<T extends ReadContext> implements ReadContext {

  private final ApiFuture<T> readContextFuture;

  DelayedReadContext(ApiFuture<T> readContextFuture) {
    this.readContextFuture = readContextFuture;
  }

  T getReadContext() {
    try {
      return this.readContextFuture.get();
    } catch (ExecutionException executionException) {
      throw SpannerExceptionFactory.causeAsRunTimeException(executionException);
    } catch (InterruptedException interruptedException) {
      throw SpannerExceptionFactory.propagateInterrupt(interruptedException);
    }
  }

  @Override
  public ResultSet read(
      String table, KeySet keys, Iterable<String> columns, ReadOption... options) {
    return new ForwardingResultSet(
        Suppliers.memoize(() -> getReadContext().read(table, keys, columns, options)));
  }

  @Override
  public AsyncResultSet readAsync(
      String table, KeySet keys, Iterable<String> columns, ReadOption... options) {
    return new ForwardingAsyncResultSet(
        Suppliers.memoize(() -> getReadContext().readAsync(table, keys, columns, options)));
  }

  @Override
  public ResultSet readUsingIndex(
      String table, String index, KeySet keys, Iterable<String> columns, ReadOption... options) {
    return new ForwardingResultSet(
        Suppliers.memoize(
            () -> getReadContext().readUsingIndex(table, index, keys, columns, options)));
  }

  @Override
  public AsyncResultSet readUsingIndexAsync(
      String table, String index, KeySet keys, Iterable<String> columns, ReadOption... options) {
    return new ForwardingAsyncResultSet(
        Suppliers.memoize(
            () -> getReadContext().readUsingIndexAsync(table, index, keys, columns, options)));
  }

  @Nullable
  @Override
  public Struct readRow(String table, Key key, Iterable<String> columns) {
    // This is allowed to be blocking.
    return getReadContext().readRow(table, key, columns);
  }

  @Override
  public ApiFuture<Struct> readRowAsync(String table, Key key, Iterable<String> columns) {
    return ApiFutures.transformAsync(
        this.readContextFuture,
        readContext -> readContext.readRowAsync(table, key, columns),
        MoreExecutors.directExecutor());
  }

  @Nullable
  @Override
  public Struct readRowUsingIndex(String table, String index, Key key, Iterable<String> columns) {
    // This is allowed to be blocking.
    return getReadContext().readRowUsingIndex(table, index, key, columns);
  }

  @Override
  public ApiFuture<Struct> readRowUsingIndexAsync(
      String table, String index, Key key, Iterable<String> columns) {
    return ApiFutures.transformAsync(
        this.readContextFuture,
        readContext -> readContext.readRowUsingIndexAsync(table, index, key, columns),
        MoreExecutors.directExecutor());
  }

  @Override
  public ResultSet executeQuery(Statement statement, QueryOption... options) {
    return new ForwardingResultSet(
        Suppliers.memoize(() -> getReadContext().executeQuery(statement, options)));
  }

  @Override
  public AsyncResultSet executeQueryAsync(Statement statement, QueryOption... options) {
    return new ForwardingAsyncResultSet(
        Suppliers.memoize(() -> getReadContext().executeQueryAsync(statement, options)));
  }

  @Override
  public ResultSet analyzeQuery(Statement statement, QueryAnalyzeMode queryMode) {
    return new ForwardingResultSet(
        Suppliers.memoize(() -> getReadContext().analyzeQuery(statement, queryMode)));
  }

  @Override
  public void close() {
    try {
      this.readContextFuture.get().close();
    } catch (Throwable ignore) {
      // Ignore any errors during close, as this error has already propagated to the user through
      // other means.
    }
  }

  /**
   * Represents a {@link ReadContext} using a multiplexed session that is not yet ready. The
   * execution will be delayed until the multiplexed session has been created and is ready.
   */
  static class DelayedReadOnlyTransaction extends DelayedReadContext<ReadOnlyTransaction>
      implements ReadOnlyTransaction {
    DelayedReadOnlyTransaction(ApiFuture<ReadOnlyTransaction> readContextFuture) {
      super(readContextFuture);
    }

    @Override
    public Timestamp getReadTimestamp() {
      return getReadContext().getReadTimestamp();
    }
  }
}
