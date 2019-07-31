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
import com.google.cloud.spanner.SpannerBatchUpdateException;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.jdbc.ReadWriteTransaction.RetriableStatement;
import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.Objects;

/**
 * A batch update that failed with a {@link SpannerException} on a {@link ReadWriteTransaction}. The
 * batch update can be retried if the transaction is aborted, and should throw the same exception
 * during retry as during the original transaction.
 */
final class FailedBatchUpdate implements RetriableStatement {
  private final ReadWriteTransaction transaction;
  private final SpannerException exception;
  private final Iterable<Statement> statements;

  FailedBatchUpdate(
      ReadWriteTransaction transaction,
      SpannerException exception,
      Iterable<Statement> statements) {
    Preconditions.checkNotNull(transaction);
    Preconditions.checkNotNull(exception);
    Preconditions.checkNotNull(statements);
    this.transaction = transaction;
    this.exception = exception;
    this.statements = statements;
  }

  @Override
  public void retry(AbortedException aborted) throws AbortedException {
    transaction
        .getStatementExecutor()
        .invokeInterceptors(
            ReadWriteTransaction.EXECUTE_BATCH_UPDATE_STATEMENT,
            StatementExecutionStep.RETRY_STATEMENT,
            transaction);
    try {
      transaction.getReadContext().batchUpdate(statements);
    } catch (SpannerBatchUpdateException e) {
      // Check that we got the same exception as in the original transaction.
      if (exception instanceof SpannerBatchUpdateException
          && e.getErrorCode() == exception.getErrorCode()
          && Objects.equals(e.getMessage(), exception.getMessage())) {
        // Check that the returned update counts are equal.
        if (Arrays.equals(
            e.getUpdateCounts(), ((SpannerBatchUpdateException) exception).getUpdateCounts())) {
          return;
        }
      }
      throw SpannerExceptionFactory.newAbortedDueToConcurrentModificationException(aborted, e);
    } catch (SpannerException e) {
      // Check that we got the same exception as in the original transaction.
      if (e.getErrorCode() == exception.getErrorCode()
          && Objects.equals(e.getMessage(), exception.getMessage())) {
        return;
      }
      throw SpannerExceptionFactory.newAbortedDueToConcurrentModificationException(aborted, e);
    }
    throw SpannerExceptionFactory.newAbortedDueToConcurrentModificationException(aborted);
  }
}
