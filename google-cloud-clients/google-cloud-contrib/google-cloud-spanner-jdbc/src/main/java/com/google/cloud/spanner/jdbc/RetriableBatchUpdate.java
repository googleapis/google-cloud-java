package com.google.cloud.spanner.jdbc;

import java.util.Arrays;
import com.google.cloud.spanner.AbortedException;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.jdbc.ReadWriteTransaction.RetriableStatement;
import com.google.common.base.Preconditions;

/**
 * Retriable batch of DML statements. The check whether the statements had the same effect during
 * retry is done by comparing the number of records affected.
 */
final class RetriableBatchUpdate implements RetriableStatement {
  private final ReadWriteTransaction transaction;
  private final Iterable<Statement> statements;
  private final long[] updateCounts;

  RetriableBatchUpdate(
      ReadWriteTransaction transaction,
      Iterable<Statement> statements,
      long[] updateCounts) {
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