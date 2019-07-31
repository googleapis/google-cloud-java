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

import com.google.cloud.spanner.AbortedException;
import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.jdbc.ReadWriteTransaction.RetriableStatement;
import com.google.cloud.spanner.jdbc.StatementParser.ParsedStatement;
import com.google.common.base.Preconditions;
import java.util.Objects;

/**
 * A query that failed with a {@link SpannerException} on a {@link ReadWriteTransaction}. The query
 * can be retried if the transaction is aborted, and should throw the same exception during retry as
 * during the original transaction.
 */
final class FailedQuery implements RetriableStatement {
  private final ReadWriteTransaction transaction;
  private final SpannerException exception;
  private final ParsedStatement statement;
  private final AnalyzeMode analyzeMode;
  private final QueryOption[] options;

  FailedQuery(
      ReadWriteTransaction transaction,
      SpannerException exception,
      ParsedStatement statement,
      AnalyzeMode analyzeMode,
      QueryOption... options) {
    Preconditions.checkNotNull(transaction);
    Preconditions.checkNotNull(exception);
    Preconditions.checkNotNull(statement);
    this.transaction = transaction;
    this.exception = exception;
    this.statement = statement;
    this.analyzeMode = analyzeMode;
    this.options = options;
  }

  @Override
  public void retry(AbortedException aborted) throws AbortedException {
    transaction
        .getStatementExecutor()
        .invokeInterceptors(statement, StatementExecutionStep.RETRY_STATEMENT, transaction);
    try {
      transaction
          .getStatementExecutor()
          .invokeInterceptors(statement, StatementExecutionStep.RETRY_STATEMENT, transaction);
      try (ResultSet rs =
          DirectExecuteResultSet.ofResultSet(
              transaction.internalExecuteQuery(statement, analyzeMode, options))) {
        // Do nothing with the results, we are only interested in whether the statement throws the
        // same exception as in the original transaction.
      }
    } catch (SpannerException e) {
      // Check that we got the same exception as in the original transaction
      if (e.getErrorCode() == exception.getErrorCode()
          && Objects.equals(e.getMessage(), exception.getMessage())) {
        return;
      }
      throw SpannerExceptionFactory.newAbortedDueToConcurrentModificationException(aborted, e);
    }
    throw SpannerExceptionFactory.newAbortedDueToConcurrentModificationException(aborted);
  }
}
