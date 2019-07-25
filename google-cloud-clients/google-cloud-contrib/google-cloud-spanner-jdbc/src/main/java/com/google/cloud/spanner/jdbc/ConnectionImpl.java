package com.google.cloud.spanner.jdbc;

import com.google.cloud.Timestamp;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.ReadContext.QueryAnalyzeMode;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.TimestampBound;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/**
 * This is just a stub class to prevent compile errors. This class will be replaced with the actual
 * class in a separate PR.
 */
class ConnectionImpl implements Connection {
  ConnectionImpl(ConnectionOptions options) {}

  @Override
  public void close() {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean isClosed() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void setAutocommit(boolean autocommit) {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean isAutocommit() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void setReadOnly(boolean readOnly) {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean isReadOnly() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void setStatementTimeout(long timeout, TimeUnit unit) {
    // TODO Auto-generated method stub

  }

  @Override
  public void clearStatementTimeout() {
    // TODO Auto-generated method stub

  }

  @Override
  public long getStatementTimeout(TimeUnit unit) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public boolean hasStatementTimeout() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void cancel() {
    // TODO Auto-generated method stub

  }

  @Override
  public void beginTransaction() {
    // TODO Auto-generated method stub

  }

  @Override
  public void setTransactionMode(TransactionMode transactionMode) {
    // TODO Auto-generated method stub

  }

  @Override
  public TransactionMode getTransactionMode() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean isRetryAbortsInternally() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void setRetryAbortsInternally(boolean retryAbortsInternally) {
    // TODO Auto-generated method stub

  }

  @Override
  public void addTransactionRetryListener(TransactionRetryListener listener) {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean removeTransactionRetryListener(TransactionRetryListener listener) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public Iterator<TransactionRetryListener> getTransactionRetryListeners() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void setAutocommitDmlMode(AutocommitDmlMode mode) {
    // TODO Auto-generated method stub

  }

  @Override
  public AutocommitDmlMode getAutocommitDmlMode() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void setReadOnlyStaleness(TimestampBound staleness) {
    // TODO Auto-generated method stub

  }

  @Override
  public TimestampBound getReadOnlyStaleness() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void commit() {
    // TODO Auto-generated method stub

  }

  @Override
  public void rollback() {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean isInTransaction() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean isTransactionStarted() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public Timestamp getReadTimestamp() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Timestamp getCommitTimestamp() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void startBatchDdl() {
    // TODO Auto-generated method stub

  }

  @Override
  public void startBatchDml() {
    // TODO Auto-generated method stub

  }

  @Override
  public long[] runBatch() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void abortBatch() {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean isDdlBatchActive() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean isDmlBatchActive() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public StatementResult execute(Statement statement) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ResultSet executeQuery(Statement query, QueryOption... options) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ResultSet analyzeQuery(Statement query, QueryAnalyzeMode queryMode) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public long executeUpdate(Statement update) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public long[] executeBatchUpdate(Iterable<Statement> updates) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void write(Mutation mutation) {
    // TODO Auto-generated method stub

  }

  @Override
  public void write(Iterable<Mutation> mutations) {
    // TODO Auto-generated method stub

  }

  @Override
  public void bufferedWrite(Mutation mutation) {
    // TODO Auto-generated method stub

  }

  @Override
  public void bufferedWrite(Iterable<Mutation> mutations) {
    // TODO Auto-generated method stub

  }
}
