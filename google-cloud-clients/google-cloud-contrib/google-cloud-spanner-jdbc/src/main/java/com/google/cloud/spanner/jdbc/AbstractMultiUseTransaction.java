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

package com.google.cloud.spanner.jdbc;

import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.ReadContext;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.jdbc.StatementParser.ParsedStatement;
import com.google.common.base.Preconditions;
import java.util.concurrent.Callable;

/**
 * Base class for {@link Connection}-based transactions that can be used for multiple read and
 * read/write statements.
 */
abstract class AbstractMultiUseTransaction extends AbstractBaseUnitOfWork {

  AbstractMultiUseTransaction(Builder<?, ? extends AbstractMultiUseTransaction> builder) {
    super(builder);
  }

  @Override
  public Type getType() {
    return Type.TRANSACTION;
  }

  @Override
  public boolean isActive() {
    return getState().isActive();
  }

  /**
   * Check that the current transaction actually has a valid underlying transaction. If not, the
   * method will throw a {@link SpannerException}.
   */
  abstract void checkValidTransaction();

  /** Returns the {@link ReadContext} that can be used for queries on this transaction. */
  abstract ReadContext getReadContext();

  @Override
  public ResultSet executeQuery(
      final ParsedStatement statement,
      final AnalyzeMode analyzeMode,
      final QueryOption... options) {
    Preconditions.checkArgument(statement.isQuery(), "Statement is not a query");
    checkValidTransaction();
    return asyncExecuteStatement(
        statement,
        new Callable<ResultSet>() {
          @Override
          public ResultSet call() throws Exception {
            return DirectExecuteResultSet.ofResultSet(
                internalExecuteQuery(statement, analyzeMode, options));
          }
        });
  }

  ResultSet internalExecuteQuery(
      final ParsedStatement statement, AnalyzeMode analyzeMode, QueryOption... options) {
    if (analyzeMode == AnalyzeMode.NONE) {
      return getReadContext().executeQuery(statement.getStatement(), options);
    }
    return getReadContext()
        .analyzeQuery(statement.getStatement(), analyzeMode.getQueryAnalyzeMode());
  }

  @Override
  public long[] runBatch() {
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.FAILED_PRECONDITION, "Run batch is not supported for transactions");
  }

  @Override
  public void abortBatch() {
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.FAILED_PRECONDITION, "Run batch is not supported for transactions");
  }
}
