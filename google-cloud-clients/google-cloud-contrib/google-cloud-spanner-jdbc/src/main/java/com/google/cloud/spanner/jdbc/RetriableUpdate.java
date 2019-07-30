package com.google.cloud.spanner.jdbc;

import com.google.cloud.spanner.AbortedException;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.jdbc.ReadWriteTransaction.RetriableStatement;
import com.google.cloud.spanner.jdbc.StatementParser.ParsedStatement;
import com.google.common.base.Preconditions;

/**
 * Retriable DML statement. The check whether the statement had the same effect during retry is
 * done by comparing the number of records affected.
 */
final class RetriableUpdate implements RetriableStatement {
  private final ReadWriteTransaction transaction;
  private final ParsedStatement statement;
  private final long updateCount;

  RetriableUpdate(
      ReadWriteTransaction transaction,
      ParsedStatement statement,
      long updateCount) {
    Preconditions.checkNotNull(transaction);
    Preconditions.checkNotNull(statement);
    this.transaction = transaction;
    this.statement = statement;
    this.updateCount = updateCount;
  }

  @Override
  public void retry(AbortedException aborted) throws AbortedException {
    long newCount = -1;
    try {
      transaction
          .getStatementExecutor()
          .invokeInterceptors(
              statement, StatementExecutionStep.RETRY_STATEMENT, transaction);
      newCount = transaction.getReadContext().executeUpdate(statement.getStatement());
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