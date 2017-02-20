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

import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.Options.ReadOption;
import javax.annotation.Nullable;

/**
 * A concurrency context in which to run a read or SQL statement. All {@code ReadContext}s are
 * implicitly bound to a {@link Session} and therefore a particular {@link Database}.
 */
public interface ReadContext extends AutoCloseable {
  /**
   * Used to specify the mode in which the query should be analyzed by {@link
   * ReadContext#analyzeQuery(Statement,QueryAnalyzeMode)}.
   */
  enum QueryAnalyzeMode {
    /** Retrieves only the query plan information. No result data is returned. */
    PLAN,
    /** Retrieves both query plan and query execution statistics along with the result data. */
    PROFILE
  }
  /**
   * Reads zero or more rows from a database.
   *
   * <p>Implementations may or may not block in the initial {@code read(...)} call; for those that
   * do not, the remote call will be initiated immediately but blocking on the response is deferred
   * to the first {@link ResultSet#next()} call. Regardless of blocking behavior, any {@link
   * SpannerException} is deferred to the first or subsequent {@link ResultSet#next()} call.
   *
   * <p>TODO(user): Code examples.
   *
   * @param table the name of the table to read
   * @param keys the keys and ranges of rows to read. Regardless of ordering in {@code keys}, rows
   *     are returned in their natural key order.
   * @param columns the columns to read
   * @param options the options to configure the read
   */
  ResultSet read(String table, KeySet keys, Iterable<String> columns, ReadOption... options);

  /**
   * Reads zero or more rows from a database using an index.
   *
   * <p>Implementations may or may not block in the initial {@code read(...)} call; for those that
   * do not, the remote call will be initiated immediately but blocking on the response is deferred
   * to the first {@link ResultSet#next()} call. Regardless of blocking behavior, any {@link
   * SpannerException} is deferred to the first or subsequent {@link ResultSet#next()} call.
   *
   * @param table the name of the table to read
   * @param index the name of the index on {@code table} to use
   * @param keys the keys and ranges of index rows to read. Regardless of ordering in {@code keys},
   *     rows are returned in the natural key order of the index.
   * @param columns the columns to read
   * @param options the options to configure the read
   */
  ResultSet readUsingIndex(
      String table, String index, KeySet keys, Iterable<String> columns, ReadOption... options);

  /**
   * Reads a single row from a database, returning {@code null} if the row does not exist.
   *
   * @param table the name of the table to read
   * @param key the row to read
   * @param columns the columns to return
   */
  @Nullable
  Struct readRow(String table, Key key, Iterable<String> columns);

  /**
   * Reads a single row from a database using an index, returning {@code null} if the row does not
   * exist.
   *
   * @param table the name of the table to read
   * @param index the name of the index on {@code table} to use
   * @param key the index row to read
   * @param columns the columns to return
   */
  @Nullable
  Struct readRowUsingIndex(String table, String index, Key key, Iterable<String> columns);

  /**
   * Executes a query against the database.
   *
   * <p>Implementations may or may not block in the initial {@code executeQuery(...)} call; for
   * those that do not, the remote call will be initiated immediately but blocking on the response
   * is deferred to the first {@link ResultSet#next()} call. Regardless of blocking behavior, any
   * {@link SpannerException} is deferred to the first or subsequent {@link ResultSet#next()} call.
   *
   * @param statement the query statement to execute
   * @param options the options to configure the query
   */
  ResultSet executeQuery(Statement statement, QueryOption... options);

  /**
   * Analyzes a query and returns query plan and/or query execution statistics information.
   *
   * <p>The query plan and query statistics information is contained in {@link
   * com.google.spanner.v1.ResultSetStats} that can be accessed by calling {@link
   * ResultSet#getStats()} on the returned {@code ResultSet}.
   *
   * @param statement the query statement to execute
   * @param queryMode the mode in which to execute the query
   */
  ResultSet analyzeQuery(Statement statement, QueryAnalyzeMode queryMode);

  /** Closes this read context and frees up the underlying resources. */
  @Override
  public void close();
}
