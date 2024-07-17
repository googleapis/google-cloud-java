/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.models.sql;

import com.google.api.core.BetaApi;

/**
 * A set of SQL data, generated as the result of an ExecuteQuery request.
 *
 * <p>This allows access to the data of one row at a time using the methods from the {@code
 * StructReader} interface. The rows are read in the order of the query results. To advance to the
 * next row call {@link #next}. This returns {@code false} once all the rows have been iterated
 * over. The result set is initially positioned before the first row, so {@link #next} must be
 * called before reading any data.
 *
 * <p>{@link #getMetadata()} may be called before calling next. It will block until the metadata has
 * been received.
 *
 * <p>{@code ResultSet} implementations may buffer data ahead and/or maintain a persistent streaming
 * connection to the remote service until all data has been returned or the resultSet closed. As
 * such, it is important that all uses of {@code ResultSet} either fully consume it (that is, call
 * {@code next()} until {@code false} is returned or it throws an exception) or explicitly call
 * {@link #close()}: failure to do so may result in wasted work or leaked resources.
 *
 * <p>{@code ResultSet} implementations are not required to be thread-safe: the thread that asked
 * for a ResultSet must be the one that interacts with it.
 */
@BetaApi
public interface ResultSet extends StructReader, AutoCloseable {

  /**
   * Advances the result set to the next row, returning {@code false} if no such row exists. Calls
   * to data access methods will throw an exception after next has returned {@code False}.
   */
  boolean next();

  /**
   * Returns the {@link ResultSetMetadata} for the ResultSet. Blocks until the underlying request
   * receives the metadata.
   */
  ResultSetMetadata getMetadata();

  /**
   * Closes the result set and cancels the underlying request if it is still open. This must always
   * be called when disposing of a {@code ResultSet} before {@link #next()} has returned {@code
   * false} or raised an exception. Calling {@code close()} is also allowed if the result set has
   * been fully consumed, so a recommended practice is to unconditionally close the result set once
   * it is done with, typically using a try-with-resources construct.
   */
  @Override
  void close();
}
