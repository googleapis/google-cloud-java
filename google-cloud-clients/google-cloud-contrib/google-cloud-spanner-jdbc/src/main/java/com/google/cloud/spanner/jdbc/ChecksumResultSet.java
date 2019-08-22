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

import com.google.cloud.ByteArray;
import com.google.cloud.Date;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.AbortedException;
import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.Type.Code;
import com.google.cloud.spanner.jdbc.ReadWriteTransaction.RetriableStatement;
import com.google.cloud.spanner.jdbc.StatementParser.ParsedStatement;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.hash.Funnel;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import com.google.common.hash.PrimitiveSink;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * {@link ResultSet} implementation that keeps a running checksum that can be used to determine
 * whether a transaction retry is possible or not. The checksum is based on all the rows that have
 * actually been consumed by the user. If the user has not yet consumed any part of the result set
 * (i.e. never called next()), the checksum will be <code>null</code> and retry will always be
 * allowed.
 *
 * <p>If all the rows in the result set have been consumed, the checksum will be based on the values
 * of all those rows, and a retry will only be possible if the query returns the exact same results
 * during the retry as during the original transaction.
 *
 * <p>If some of the rows in the result set have been consumed, the checksum will be based on the
 * values of the rows that have been consumed. A retry will succeed if the query returns the same
 * results for the already consumed rows.
 *
 * <p>The checksum of a {@link ResultSet} is the SHA256 checksum of the current row together with
 * the previous checksum value of the result set. The calculation of the checksum is executed in a
 * separate {@link Thread} to allow the checksum calculation to lag behind the actual consumption of
 * rows, and catch up again if the client slows down the consumption of rows, for example while
 * waiting for more data from Cloud Spanner. If the checksum calculation queue contains more than
 * {@link ChecksumExecutor#MAX_IN_CHECKSUM_QUEUE} items that have not yet been calculated, calls to
 * {@link ResultSet#next()} will slow down in order to allow the calculation to catch up.
 */
@VisibleForTesting
class ChecksumResultSet extends ReplaceableForwardingResultSet implements RetriableStatement {
  private final ReadWriteTransaction transaction;
  private long numberOfNextCalls;
  private final ParsedStatement statement;
  private final AnalyzeMode analyzeMode;
  private final QueryOption[] options;
  private final ChecksumResultSet.ChecksumCalculator checksumCalculator = new ChecksumCalculator();

  ChecksumResultSet(
      ReadWriteTransaction transaction,
      ResultSet delegate,
      ParsedStatement statement,
      AnalyzeMode analyzeMode,
      QueryOption... options) {
    super(delegate);
    Preconditions.checkNotNull(transaction);
    Preconditions.checkNotNull(delegate);
    Preconditions.checkNotNull(statement);
    Preconditions.checkNotNull(statement.getStatement());
    Preconditions.checkNotNull(statement.getStatement().getSql());
    this.transaction = transaction;
    this.statement = statement;
    this.analyzeMode = analyzeMode;
    this.options = options;
  }

  /** Simple {@link Callable} for calling {@link ResultSet#next()} */
  private final class NextCallable implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {
      transaction
          .getStatementExecutor()
          .invokeInterceptors(
              statement, StatementExecutionStep.CALL_NEXT_ON_RESULT_SET, transaction);
      return ChecksumResultSet.super.next();
    }
  }

  private final NextCallable nextCallable = new NextCallable();

  @Override
  public boolean next() {
    // Call next() with retry.
    boolean res = transaction.runWithRetry(nextCallable);
    // Only update the checksum if there was another row to be consumed.
    if (res) {
      checksumCalculator.calculateNextChecksum(getCurrentRowAsStruct());
    }
    numberOfNextCalls++;
    return res;
  }

  @VisibleForTesting
  HashCode getChecksum() throws InterruptedException, ExecutionException {
    // HashCode is immutable and can be safely returned.
    return checksumCalculator.getChecksum();
  }

  /**
   * Execute the same query as in the original transaction and consume the {@link ResultSet} to the
   * same point as the original {@link ResultSet}. The {@link HashCode} of the new {@link ResultSet}
   * is compared with the {@link HashCode} of the original {@link ResultSet} at the point where the
   * consumption of the {@link ResultSet} stopped.
   */
  @Override
  public void retry(AbortedException aborted) throws AbortedException {
    // Execute the same query and consume the result set to the same point as the original.
    ChecksumResultSet.ChecksumCalculator newChecksumCalculator = new ChecksumCalculator();
    ResultSet resultSet = null;
    long counter = 0L;
    try {
      transaction
          .getStatementExecutor()
          .invokeInterceptors(statement, StatementExecutionStep.RETRY_STATEMENT, transaction);
      resultSet =
          DirectExecuteResultSet.ofResultSet(
              transaction.internalExecuteQuery(statement, analyzeMode, options));
      boolean next = true;
      while (counter < numberOfNextCalls && next) {
        transaction
            .getStatementExecutor()
            .invokeInterceptors(
                statement, StatementExecutionStep.RETRY_NEXT_ON_RESULT_SET, transaction);
        next = resultSet.next();
        if (next) {
          newChecksumCalculator.calculateNextChecksum(resultSet.getCurrentRowAsStruct());
        }
        counter++;
      }
    } catch (Throwable e) {
      if (resultSet != null) {
        resultSet.close();
      }
      // If it was a SpannerException other than an AbortedException, the retry should fail
      // because of different results from the database.
      if (e instanceof SpannerException && !(e instanceof AbortedException)) {
        throw SpannerExceptionFactory.newAbortedDueToConcurrentModificationException(
            aborted, (SpannerException) e);
      }
      // For other types of exceptions we should just re-throw the exception.
      throw e;
    }
    // Check that we have the same number of rows and the same checksum.
    HashCode newChecksum = newChecksumCalculator.getChecksum();
    HashCode currentChecksum = checksumCalculator.getChecksum();
    if (counter == numberOfNextCalls && Objects.equals(newChecksum, currentChecksum)) {
      // Checksum is ok, we only need to replace the delegate result set if it's still open.
      if (isClosed()) {
        resultSet.close();
      } else {
        replaceDelegate(resultSet);
      }
    } else {
      // The results are not equal, there is an actual concurrent modification, so we cannot
      // continue the transaction.
      throw SpannerExceptionFactory.newAbortedDueToConcurrentModificationException(aborted);
    }
  }

  /** Calculates and keeps the current checksum of a {@link ChecksumResultSet} */
  private static final class ChecksumCalculator {
    private static final HashFunction SHA256_FUNCTION = Hashing.sha256();
    private HashCode currentChecksum;

    private void calculateNextChecksum(Struct row) {
      Hasher hasher = SHA256_FUNCTION.newHasher();
      if (currentChecksum != null) {
        hasher.putBytes(currentChecksum.asBytes());
      }
      hasher.putObject(row, StructFunnel.INSTANCE);
      currentChecksum = hasher.hash();
    }

    private HashCode getChecksum() {
      return currentChecksum;
    }
  }

  /**
   * A {@link Funnel} implementation for calculating a {@link HashCode} for each row in a {@link
   * ResultSet}.
   */
  private enum StructFunnel implements Funnel<Struct> {
    INSTANCE;
    private static final String NULL = "null";

    @Override
    public void funnel(Struct row, PrimitiveSink into) {
      for (int i = 0; i < row.getColumnCount(); i++) {
        if (row.isNull(i)) {
          funnelValue(Code.STRING, null, into);
        } else {
          Code type = row.getColumnType(i).getCode();
          switch (type) {
            case ARRAY:
              funnelArray(row.getColumnType(i).getArrayElementType().getCode(), row, i, into);
              break;
            case BOOL:
              funnelValue(type, row.getBoolean(i), into);
              break;
            case BYTES:
              funnelValue(type, row.getBytes(i), into);
              break;
            case DATE:
              funnelValue(type, row.getDate(i), into);
              break;
            case FLOAT64:
              funnelValue(type, row.getDouble(i), into);
              break;
            case INT64:
              funnelValue(type, row.getLong(i), into);
              break;
            case STRING:
              funnelValue(type, row.getString(i), into);
              break;
            case TIMESTAMP:
              funnelValue(type, row.getTimestamp(i), into);
              break;

            case STRUCT:
            default:
              throw new IllegalArgumentException("unsupported row type");
          }
        }
      }
    }

    private void funnelArray(
        Code arrayElementType, Struct row, int columnIndex, PrimitiveSink into) {
      funnelValue(Code.STRING, "BeginArray", into);
      switch (arrayElementType) {
        case BOOL:
          into.putInt(row.getBooleanList(columnIndex).size());
          for (Boolean value : row.getBooleanList(columnIndex)) {
            funnelValue(Code.BOOL, value, into);
          }
          break;
        case BYTES:
          into.putInt(row.getBytesList(columnIndex).size());
          for (ByteArray value : row.getBytesList(columnIndex)) {
            funnelValue(Code.BYTES, value, into);
          }
          break;
        case DATE:
          into.putInt(row.getDateList(columnIndex).size());
          for (Date value : row.getDateList(columnIndex)) {
            funnelValue(Code.DATE, value, into);
          }
          break;
        case FLOAT64:
          into.putInt(row.getDoubleList(columnIndex).size());
          for (Double value : row.getDoubleList(columnIndex)) {
            funnelValue(Code.FLOAT64, value, into);
          }
          break;
        case INT64:
          into.putInt(row.getLongList(columnIndex).size());
          for (Long value : row.getLongList(columnIndex)) {
            funnelValue(Code.INT64, value, into);
          }
          break;
        case STRING:
          into.putInt(row.getStringList(columnIndex).size());
          for (String value : row.getStringList(columnIndex)) {
            funnelValue(Code.STRING, value, into);
          }
          break;
        case TIMESTAMP:
          into.putInt(row.getTimestampList(columnIndex).size());
          for (Timestamp value : row.getTimestampList(columnIndex)) {
            funnelValue(Code.TIMESTAMP, value, into);
          }
          break;

        case ARRAY:
        case STRUCT:
        default:
          throw new IllegalArgumentException("unsupported array element type");
      }
      funnelValue(Code.STRING, "EndArray", into);
    }

    private <T> void funnelValue(Code type, T value, PrimitiveSink into) {
      // Include the type name in case the type of a column has changed.
      into.putUnencodedChars(type.name());
      if (value == null) {
        if (type == Code.BYTES || type == Code.STRING) {
          // Put length -1 to distinguish from the string value 'null'.
          into.putInt(-1);
        }
        into.putUnencodedChars(NULL);
      } else {
        switch (type) {
          case BOOL:
            into.putBoolean((Boolean) value);
            break;
          case BYTES:
            ByteArray byteArray = (ByteArray) value;
            into.putInt(byteArray.length());
            into.putBytes(byteArray.toByteArray());
            break;
          case DATE:
            Date date = (Date) value;
            into.putInt(date.getYear()).putInt(date.getMonth()).putInt(date.getDayOfMonth());
            break;
          case FLOAT64:
            into.putDouble((Double) value);
            break;
          case INT64:
            into.putLong((Long) value);
            break;
          case STRING:
            String stringValue = (String) value;
            into.putInt(stringValue.length());
            into.putUnencodedChars(stringValue);
            break;
          case TIMESTAMP:
            Timestamp timestamp = (Timestamp) value;
            into.putLong(timestamp.getSeconds()).putInt(timestamp.getNanos());
            break;
          case ARRAY:
          case STRUCT:
          default:
            throw new IllegalArgumentException("invalid type for single value");
        }
      }
    }
  }
}
