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

package com.google.cloud.spanner.connection;

import com.google.cloud.spanner.AbortedException;
import com.google.cloud.spanner.Options.UpdateOption;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.connection.AbstractStatementParser.ParsedStatement;
import com.google.cloud.spanner.connection.ReadWriteTransaction.RetriableStatement;
import com.google.common.base.Preconditions;

/**
 * Retriable DML statement. The check whether the statement had the same effect during retry is done
 * by comparing the number of records affected.
 */
final class RetriableUpdate implements RetriableStatement {
  private final ReadWriteTransaction transaction;
  private final ParsedStatement statement;
  private final AnalyzeMode analyzeMode;
  private final long updateCount;
  private final UpdateOption[] options;

  RetriableUpdate(
      ReadWriteTransaction transaction,
      ParsedStatement statement,
      AnalyzeMode analyzeMode,
      long updateCount,
      UpdateOption... options) {
    this.transaction = Preconditions.checkNotNull(transaction);
    this.statement = Preconditions.checkNotNull(statement);
    this.analyzeMode = Preconditions.checkNotNull(analyzeMode);
    this.updateCount = updateCount;
    this.options = options;
  }

  @Override
  public void retry(AbortedException aborted) throws AbortedException {
    long newCount = -1;
    try {
      transaction
          .getStatementExecutor()
          .invokeInterceptors(statement, StatementExecutionStep.RETRY_STATEMENT, transaction);
      if (analyzeMode == AnalyzeMode.NONE) {
        newCount =
            transaction.getTransactionContext().executeUpdate(statement.getStatement(), options);
      } else {
        newCount =
            transaction
                .getTransactionContext()
                .analyzeUpdate(statement.getStatement(), analyzeMode.getQueryAnalyzeMode())
                .getRowCountExact();
      }
    } catch (AbortedException e) {
      // Just re-throw the AbortedException and let the retry logic determine whether another try
      // should be executed or not.
      throw e;
    } catch (SpannerException e) {
      // Unexpected database error that is different from the original transaction.
      throw SpannerExceptionFactory.newAbortedDueToConcurrentModificationException(aborted, e);
    }
    if (newCount != updateCount) {
      // The update counts do not match, we cannot retry the transaction.
      throw SpannerExceptionFactory.newAbortedDueToConcurrentModificationException(aborted);
    }
  }
}
