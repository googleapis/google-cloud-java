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
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.ProtobufResultSet;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.Type;
import com.google.cloud.spanner.Type.Code;
import com.google.cloud.spanner.Type.StructField;
import com.google.cloud.spanner.connection.AbstractStatementParser.ParsedStatement;
import com.google.cloud.spanner.connection.ReadWriteTransaction.RetriableStatement;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;
import com.google.protobuf.Value;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;

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
  private final AtomicLong numberOfNextCalls = new AtomicLong();
  private final ParsedStatement statement;
  private final AnalyzeMode analyzeMode;
  private final QueryOption[] options;
  private final ChecksumCalculator checksumCalculator = new ChecksumCalculator();

  ChecksumResultSet(
      ReadWriteTransaction transaction,
      ProtobufResultSet delegate,
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

  @Override
  public Value getProtobufValue(int columnIndex) {
    // We can safely cast to ProtobufResultSet here, as the constructor of this class only accepts
    // instances of ProtobufResultSet.
    return ((ProtobufResultSet) getDelegate()).getProtobufValue(columnIndex);
  }

  /** Simple {@link Callable} for calling {@link ResultSet#next()} */
  private final class NextCallable implements Callable<Boolean> {
    @Override
    public Boolean call() {
      transaction
          .getStatementExecutor()
          .invokeInterceptors(
              statement, StatementExecutionStep.CALL_NEXT_ON_RESULT_SET, transaction);
      boolean res = ChecksumResultSet.super.next();
      // Only update the checksum if there was another row to be consumed.
      if (res) {
        checksumCalculator.calculateNextChecksum(ChecksumResultSet.this);
      }
      numberOfNextCalls.incrementAndGet();
      return res;
    }
  }

  private final NextCallable nextCallable = new NextCallable();

  @Override
  public boolean next() {
    // Call next() with retry.
    return transaction.runWithRetry(nextCallable);
  }

  @VisibleForTesting
  byte[] getChecksum() {
    // Getting the checksum from the checksumCalculator will create a clone of the current digest
    // and return the checksum from the clone, so it is safe to return this value.
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
    ChecksumCalculator newChecksumCalculator = new ChecksumCalculator();
    ProtobufResultSet resultSet = null;
    long counter = 0L;
    try {
      transaction
          .getStatementExecutor()
          .invokeInterceptors(statement, StatementExecutionStep.RETRY_STATEMENT, transaction);
      resultSet =
          DirectExecuteResultSet.ofResultSet(
              transaction.internalExecuteQuery(statement, analyzeMode, options));
      boolean next = true;
      while (counter < numberOfNextCalls.get() && next) {
        transaction
            .getStatementExecutor()
            .invokeInterceptors(
                statement, StatementExecutionStep.RETRY_NEXT_ON_RESULT_SET, transaction);
        next = resultSet.next();
        if (next) {
          newChecksumCalculator.calculateNextChecksum(resultSet);
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
    byte[] newChecksum = newChecksumCalculator.getChecksum();
    byte[] currentChecksum = checksumCalculator.getChecksum();
    if (counter == numberOfNextCalls.get() && Arrays.equals(newChecksum, currentChecksum)) {
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

  /**
   * Calculates a running checksum for all the data that has been seen sofar in this result set. The
   * calculation is performed on the protobuf values that were returned by Cloud Spanner, which
   * means that no decoding of the results is needed (or allowed!) before calculating the checksum.
   * This is more efficient, both in terms of CPU usage and memory consumption, especially if the
   * consumer of the result set does not read all values, or is only reading the underlying protobuf
   * values.
   */
  private static final class ChecksumCalculator {
    // Use a buffer of max 1Mb to hash string data. This means that strings of up to 1Mb in size
    // will be hashed in one go, while strings larger than 1Mb will be chunked into pieces of at
    // most 1Mb and then fed into the digest. The digest internally creates a copy of the string
    // that is being hashed, so chunking large strings prevents them from being loaded into memory
    // twice.
    private static final int MAX_BUFFER_SIZE = 1 << 20;

    private boolean firstRow = true;
    private final MessageDigest digest;
    private ByteBuffer buffer;
    private ByteBuffer float64Buffer;

    ChecksumCalculator() {
      try {
        // This is safe, as all Java implementations are required to have MD5 implemented.
        // See https://docs.oracle.com/javase/8/docs/api/java/security/MessageDigest.html
        // MD5 requires less CPU power than SHA-256, and still offers a low enough collision
        // probability for the use case at hand here.
        digest = MessageDigest.getInstance("MD5");
      } catch (Throwable t) {
        throw SpannerExceptionFactory.asSpannerException(t);
      }
    }

    private byte[] getChecksum() {
      try {
        // This is safe, as the MD5 MessageDigest is known to be cloneable.
        MessageDigest clone = (MessageDigest) digest.clone();
        return clone.digest();
      } catch (CloneNotSupportedException e) {
        throw SpannerExceptionFactory.asSpannerException(e);
      }
    }

    private void calculateNextChecksum(ProtobufResultSet resultSet) {
      if (firstRow) {
        for (StructField field : resultSet.getType().getStructFields()) {
          digest.update(field.getType().toString().getBytes(StandardCharsets.UTF_8));
        }
      }
      for (int col = 0; col < resultSet.getColumnCount(); col++) {
        Type type = resultSet.getColumnType(col);
        if (resultSet.canGetProtobufValue(col)) {
          Value value = resultSet.getProtobufValue(col);
          digest.update((byte) value.getKindCase().getNumber());
          pushValue(type, value);
        } else {
          // This will normally not happen, unless the user explicitly sets the decoding mode to
          // DIRECT for a query in a read/write transaction. The default decoding mode in the
          // Connection API is set to LAZY_PER_COL.
          throw SpannerExceptionFactory.newSpannerException(
              ErrorCode.FAILED_PRECONDITION,
              "Failed to get the underlying protobuf value for the column "
                  + resultSet.getMetadata().getRowType().getFields(col).getName()
                  + ". Executing queries with DecodeMode#DIRECT is not supported in read/write"
                  + " transactions.");
        }
      }
      firstRow = false;
    }

    private void pushValue(Type type, Value value) {
      // Protobuf Value has a very limited set of possible types of values. All Cloud Spanner types
      // are mapped to one of the protobuf values listed here, meaning that no changes are needed to
      // this calculation when a new type is added to Cloud Spanner.
      switch (value.getKindCase()) {
        case NULL_VALUE:
          // nothing needed, writing the KindCase is enough.
          break;
        case BOOL_VALUE:
          digest.update(value.getBoolValue() ? (byte) 1 : 0);
          break;
        case STRING_VALUE:
          putString(value.getStringValue());
          break;
        case NUMBER_VALUE:
          if (float64Buffer == null) {
            // Create an 8-byte buffer that can be re-used for all float64 values in this result
            // set.
            float64Buffer = ByteBuffer.allocate(Double.BYTES);
          } else {
            float64Buffer.clear();
          }
          float64Buffer.putDouble(value.getNumberValue());
          float64Buffer.flip();
          digest.update(float64Buffer);
          break;
        case LIST_VALUE:
          if (type.getCode() == Code.ARRAY) {
            for (Value item : value.getListValue().getValuesList()) {
              digest.update((byte) item.getKindCase().getNumber());
              pushValue(type.getArrayElementType(), item);
            }
          } else {
            // This should not be possible.
            throw SpannerExceptionFactory.newSpannerException(
                ErrorCode.FAILED_PRECONDITION,
                "List values that are not an ARRAY are not supported");
          }
          break;
        case STRUCT_VALUE:
          if (type.getCode() == Code.STRUCT) {
            for (int col = 0; col < type.getStructFields().size(); col++) {
              String name = type.getStructFields().get(col).getName();
              putString(name);
              Value item = value.getStructValue().getFieldsMap().get(name);
              digest.update((byte) item.getKindCase().getNumber());
              pushValue(type.getStructFields().get(col).getType(), item);
            }
          } else {
            // This should not be possible.
            throw SpannerExceptionFactory.newSpannerException(
                ErrorCode.FAILED_PRECONDITION,
                "Struct values without a struct type are not supported");
          }
          break;
        default:
          throw SpannerExceptionFactory.newSpannerException(
              ErrorCode.UNIMPLEMENTED, "Unsupported protobuf value: " + value.getKindCase());
      }
    }

    /** Hashes a string value in blocks of max MAX_BUFFER_SIZE. */
    private void putString(String stringValue) {
      int length = stringValue.length();
      if (buffer == null || (buffer.capacity() < MAX_BUFFER_SIZE && buffer.capacity() < length)) {
        // Create a ByteBuffer with a maximum buffer size.
        // This buffer is re-used for all string values in the result set.
        buffer = ByteBuffer.allocate(Math.min(MAX_BUFFER_SIZE, length));
      } else {
        buffer.clear();
      }

      // Wrap the string in a CharBuffer. This allows us to read from the string in sections without
      // creating a new copy of (a part of) the string. E.g. using something like substring(..)
      // would create a copy of that part of the string, using CharBuffer.wrap(..) does not.
      CharBuffer source = CharBuffer.wrap(stringValue);
      CharsetEncoder encoder = StandardCharsets.UTF_8.newEncoder();
      // source.hasRemaining() returns false when all the characters in the string have been
      // processed.
      while (source.hasRemaining()) {
        // Encode the string into bytes and write them into the byte buffer.
        // At most MAX_BUFFER_SIZE bytes will be written.
        encoder.encode(source, buffer, false);
        // Flip the buffer so we can read from the start.
        buffer.flip();
        // Put the bytes from the buffer into the digest.
        digest.update(buffer);
        // Flip the buffer again, so we can repeat and write to the start of the buffer again.
        buffer.flip();
      }
    }
  }
}
