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
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.jdbc.ReadWriteTransaction.RetriableStatement;
import com.google.common.base.Preconditions;
import java.util.Arrays;

/**
 * Retriable batch of DML statements. The check whether the statements had the same effect during
 * retry is done by comparing the number of records affected.
 */
final class RetriableBatchUpdate implements RetriableStatement {
  private final ReadWriteTransaction transaction;
  private final Iterable<Statement> statements;
  private final long[] updateCounts;

  RetriableBatchUpdate(
      ReadWriteTransaction transaction, Iterable<Statement> statements, long[] updateCounts) {
    Preconditions.checkNotNull(transaction);
    Preconditions.checkNotNull(statements);
    this.transaction = transaction;
    this.statements = statements;
    this.updateCounts = updateCounts;
  }

  @Override
  public void retry(AbortedException aborted) throws AbortedException {
    long[] newCount = null;
    try {
      transaction
          .getStatementExecutor()
          .invokeInterceptors(
              ReadWriteTransaction.EXECUTE_BATCH_UPDATE_STATEMENT,
              StatementExecutionStep.RETRY_STATEMENT,
              transaction);
      newCount = transaction.getReadContext().batchUpdate(statements);
    } catch (AbortedException e) {
      // Just re-throw the AbortedException and let the retry logic determine whether another try
      // should be executed or not.
      throw e;
    } catch (SpannerException e) {
      // Unexpected database error that is different from the original transaction.
      throw SpannerExceptionFactory.newAbortedDueToConcurrentModificationException(aborted, e);
    }
    if (newCount == null || !Arrays.equals(updateCounts, newCount)) {
      // The update counts do not match, we cannot retry the transaction.
      throw SpannerExceptionFactory.newAbortedDueToConcurrentModificationException(aborted);
    }
  }
}
