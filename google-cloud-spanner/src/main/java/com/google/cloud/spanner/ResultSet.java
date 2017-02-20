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

import com.google.spanner.v1.ResultSetStats;

/**
 * Provides access to the data returned by a Cloud Spanner read or query. {@code ResultSet} allows a
 * single row to be inspected at a time through the methods from the {@link StructReader} interface,
 * in the order that the rows were returned by the read or query. The result set can be positioned
 * over the next row, if one exists, by calling {@link #next()}; this method returns {@code false}
 * when all rows returned have been seen. The result set is initially positioned before the first
 * row, so a call to {@code next()} is required before the first row can be inspected.
 *
 * <p>{@code ResultSet} implementations may buffer data ahead and/or maintain a persistent streaming
 * connection to the remote service until all data has been returned or the resultSet closed. As
 * such, it is important that all uses of {@code ResultSet} either fully consume it (that is, call
 * {@code next()} until {@code false} is returned or it throws an exception) or explicitly call
 * {@link #close()}: failure to do so may result in wasted work or leaked resources.
 *
 * <p>{@code ResultSet} implementations are not required to be thread-safe: if methods are called
 * from multiple threads, external synchronization must be used.
 */
public interface ResultSet extends AutoCloseable, StructReader {
  /**
   * Advances the result set to the next row, returning false if no such row exists. This method may
   * block.
   */
  boolean next() throws SpannerException;

  /**
   * Creates an immutable version of the row that the result set is positioned over. This may
   * involve copying internal data structures, and so converting all rows to {@code Struct} objects
   * is generally more expensive than processing the {@code ResultSet} directly.
   */
  Struct getCurrentRowAsStruct();

  /**
   * Explicitly close the result set, releasing any associated resources. This must always be called
   * when disposing of a {@code ResultSet} before {@link #next()} has returned {@code false} or
   * raised an exception. Calling {@code close()} is also allowed if the result set has been fully
   * consumed, so a recommended practice is to unconditionally close the result set once it is done
   * with, typically using a try-with-resources construct.
   */
  @Override
  void close();

  /**
   * Returns the {@link ResultSetStats} for the query only if the query was executed in either the
   * {@code PLAN} or the {@code PROFILE} mode via the {@link ReadContext#analyzeQuery(Statement,
   * com.google.cloud.spanner.ReadContext.QueryAnalyzeMode)} method. Attempts to call this method on
   * a {@code ResultSet} not obtained from {@code analyzeQuery} result in an {@code
   * UnsupportedOperationException}. This method must be called after {@link #next()} has
   * returned @{code false}. Calling it before that will result in an {@code IllegalStateException}.
   */
  ResultSetStats getStats();
}
