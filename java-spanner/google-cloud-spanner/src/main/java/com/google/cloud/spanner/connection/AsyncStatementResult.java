/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.spanner.connection;

import com.google.api.core.ApiFuture;
import com.google.api.core.InternalApi;
import com.google.cloud.spanner.AsyncResultSet;
import com.google.cloud.spanner.connection.StatementResult.ResultType;

@InternalApi
public interface AsyncStatementResult extends StatementResult {
  /**
   * Returns the {@link AsyncResultSet} held by this result. May only be called if the type of this
   * result is {@link ResultType#RESULT_SET}.
   *
   * @return the {@link AsyncResultSet} held by this result.
   */
  AsyncResultSet getResultSetAsync();

  /**
   * Returns the update count held by this result. May only be called if the type of this result is
   * {@link ResultType#UPDATE_COUNT}.
   *
   * @return the update count held by this result.
   */
  ApiFuture<Long> getUpdateCountAsync();

  /**
   * Returns a future that tracks the progress of a statement that returns no result. This could be
   * a DDL statement or a client side statement that does not return a result.
   */
  ApiFuture<Void> getNoResultAsync();
}
