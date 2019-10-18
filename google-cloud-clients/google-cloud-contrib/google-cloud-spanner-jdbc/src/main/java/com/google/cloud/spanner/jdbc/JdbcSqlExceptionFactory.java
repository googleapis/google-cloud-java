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

import com.google.cloud.spanner.AbortedDueToConcurrentModificationException;
import com.google.cloud.spanner.AbortedException;
import com.google.cloud.spanner.SpannerBatchUpdateException;
import com.google.cloud.spanner.SpannerException;
import com.google.rpc.Code;
import java.sql.BatchUpdateException;
import java.sql.ClientInfoStatus;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.SQLTimeoutException;
import java.util.Collections;

/** Factory class for creating {@link SQLException}s for Cloud Spanner */
public final class JdbcSqlExceptionFactory {

  /** Base {@link SQLException} for Cloud Spanner */
  public static class JdbcSqlExceptionImpl extends SQLException implements JdbcSqlException {
    private static final long serialVersionUID = 235381453830069910L;
    private final Code code;

    private JdbcSqlExceptionImpl(String message, Code code) {
      super(message, null, code.getNumber(), null);
      this.code = code;
    }

    private JdbcSqlExceptionImpl(String message, Code code, Throwable cause) {
      super(message, null, code.getNumber(), cause);
      this.code = code;
    }

    private JdbcSqlExceptionImpl(SpannerException e) {
      super(e.getMessage(), null, e.getCode(), e);
      this.code = Code.forNumber(e.getCode());
    }

    private JdbcSqlExceptionImpl(String message, SpannerException e) {
      super(message, null, e.getCode(), e);
      this.code = Code.forNumber(e.getCode());
    }

    @Override
    public Code getCode() {
      return code;
    }
  }

  /** Specific {@link SQLException} that is thrown when a statement times out */
  public static class JdbcSqlTimeoutException extends SQLTimeoutException
      implements JdbcSqlException {
    private static final long serialVersionUID = 2363793358642102814L;

    private JdbcSqlTimeoutException(String message) {
      super(message, "Timed out", Code.DEADLINE_EXCEEDED_VALUE);
    }

    @Override
    public Code getCode() {
      return Code.DEADLINE_EXCEEDED;
    }
  }

  /** Specific {@link SQLException} that is thrown when setting client info on a connection */
  public static class JdbcSqlClientInfoException extends SQLClientInfoException
      implements JdbcSqlException {
    private static final long serialVersionUID = 5341238042343668540L;
    private final Code code;

    private JdbcSqlClientInfoException(String message, Code code) {
      super(message, Collections.<String, ClientInfoStatus>emptyMap());
      this.code = code;
    }

    @Override
    public Code getCode() {
      return code;
    }
  }

  /** Specific {@link SQLException} that is thrown for unsupported methods and values */
  public static class JdbcSqlFeatureNotSupportedException extends SQLFeatureNotSupportedException
      implements JdbcSqlException {
    private static final long serialVersionUID = 2363793358642102814L;

    private JdbcSqlFeatureNotSupportedException(String message) {
      super(message, "not supported", Code.UNIMPLEMENTED_VALUE);
    }

    @Override
    public Code getCode() {
      return Code.UNIMPLEMENTED;
    }
  }

  /**
   * Specific {@link SQLException} that is thrown when a {@link SpannerBatchUpdateException} occurs.
   */
  public static class JdbcSqlBatchUpdateException extends BatchUpdateException
      implements JdbcSqlException {
    private static final long serialVersionUID = 8894995110837971444L;
    private final Code code;

    private JdbcSqlBatchUpdateException(int[] updateCounts, SpannerBatchUpdateException cause) {
      super(cause.getMessage(), updateCounts, cause);
      this.code = Code.forNumber(cause.getCode());
    }

    @Override
    public Code getCode() {
      return code;
    }
  }

  /**
   * Specific {@link SQLException} that is thrown when a transaction was aborted and could not be
   * successfully retried.
   */
  public static class JdbcAbortedException extends JdbcSqlExceptionImpl {
    private JdbcAbortedException(AbortedException cause) {
      super(cause);
    }

    private JdbcAbortedException(String message) {
      super(message, Code.ABORTED);
    }

    private JdbcAbortedException(String message, AbortedException cause) {
      super(message, cause);
    }

    @Override
    public synchronized AbortedException getCause() {
      return (AbortedException) super.getCause();
    }
  }

  /**
   * Specific {@link SQLException} that is thrown when a transaction was aborted and could not be
   * retried due to a concurrent modification.
   */
  public static class JdbcAbortedDueToConcurrentModificationException extends JdbcAbortedException {
    private JdbcAbortedDueToConcurrentModificationException(
        AbortedDueToConcurrentModificationException cause) {
      super(cause);
    }

    private JdbcAbortedDueToConcurrentModificationException(
        String message, AbortedDueToConcurrentModificationException cause) {
      super(message, cause);
    }

    @Override
    public synchronized AbortedDueToConcurrentModificationException getCause() {
      return (AbortedDueToConcurrentModificationException) super.getCause();
    }

    public SpannerException getDatabaseErrorDuringRetry() {
      return getCause().getDatabaseErrorDuringRetry();
    }
  }

  /** Creates a {@link JdbcSqlException} from the given {@link SpannerException}. */
  static SQLException of(SpannerException e) {
    switch (e.getErrorCode()) {
      case ABORTED:
        if (e instanceof AbortedDueToConcurrentModificationException) {
          return new JdbcAbortedDueToConcurrentModificationException(
              (AbortedDueToConcurrentModificationException) e);
        } else if (e instanceof AbortedException) {
          return new JdbcAbortedException((AbortedException) e);
        }
      case DEADLINE_EXCEEDED:
        return new JdbcSqlTimeoutException(e.getMessage());
      case ALREADY_EXISTS:
      case CANCELLED:
      case DATA_LOSS:
      case FAILED_PRECONDITION:
      case INTERNAL:
      case INVALID_ARGUMENT:
      case NOT_FOUND:
      case OUT_OF_RANGE:
      case PERMISSION_DENIED:
      case RESOURCE_EXHAUSTED:
      case UNAUTHENTICATED:
      case UNAVAILABLE:
      case UNIMPLEMENTED:
      case UNKNOWN:
      default:
    }
    return new JdbcSqlExceptionImpl(e);
  }

  /** Creates a {@link JdbcSqlException} with the given message and error code. */
  static SQLException of(String message, Code code) {
    switch (code) {
      case ABORTED:
        return new JdbcAbortedException(code.name() + ": " + message);
      case DEADLINE_EXCEEDED:
        return new JdbcSqlTimeoutException(code.name() + ": " + message);
      case ALREADY_EXISTS:
      case CANCELLED:
      case DATA_LOSS:
      case FAILED_PRECONDITION:
      case INTERNAL:
      case INVALID_ARGUMENT:
      case NOT_FOUND:
      case OUT_OF_RANGE:
      case PERMISSION_DENIED:
      case RESOURCE_EXHAUSTED:
      case UNAUTHENTICATED:
      case UNAVAILABLE:
      case UNIMPLEMENTED:
      case UNKNOWN:
      default:
    }
    return new JdbcSqlExceptionImpl(code.name() + ": " + message, code);
  }

  /** Creates a {@link JdbcSqlException} with the given message and cause. */
  static SQLException of(String message, SpannerException e) {
    switch (e.getErrorCode()) {
      case ABORTED:
        if (e instanceof AbortedDueToConcurrentModificationException) {
          return new JdbcAbortedDueToConcurrentModificationException(
              message, (AbortedDueToConcurrentModificationException) e);
        } else if (e instanceof AbortedException) {
          return new JdbcAbortedException(message, (AbortedException) e);
        }
      case DEADLINE_EXCEEDED:
        return new JdbcSqlTimeoutException(e.getErrorCode().name() + ": " + message);
      case ALREADY_EXISTS:
      case CANCELLED:
      case DATA_LOSS:
      case FAILED_PRECONDITION:
      case INTERNAL:
      case INVALID_ARGUMENT:
      case NOT_FOUND:
      case OUT_OF_RANGE:
      case PERMISSION_DENIED:
      case RESOURCE_EXHAUSTED:
      case UNAUTHENTICATED:
      case UNAVAILABLE:
      case UNIMPLEMENTED:
      case UNKNOWN:
      default:
    }
    return new JdbcSqlExceptionImpl(e.getErrorCode().name() + ": " + message, e);
  }

  /** Creates a {@link JdbcSqlException} with the given message, error code and cause. */
  static SQLException of(String message, Code code, Throwable cause) {
    switch (code) {
      case ABORTED:
        if (cause instanceof AbortedDueToConcurrentModificationException) {
          return new JdbcAbortedDueToConcurrentModificationException(
              message, (AbortedDueToConcurrentModificationException) cause);
        } else if (cause instanceof AbortedException) {
          return new JdbcAbortedException(message, (AbortedException) cause);
        }
      case DEADLINE_EXCEEDED:
        return new JdbcSqlTimeoutException(code.name() + ": " + message);
      case ALREADY_EXISTS:
      case CANCELLED:
      case DATA_LOSS:
      case FAILED_PRECONDITION:
      case INTERNAL:
      case INVALID_ARGUMENT:
      case NOT_FOUND:
      case OUT_OF_RANGE:
      case PERMISSION_DENIED:
      case RESOURCE_EXHAUSTED:
      case UNAUTHENTICATED:
      case UNAVAILABLE:
      case UNIMPLEMENTED:
      case UNKNOWN:
      default:
    }
    return new JdbcSqlExceptionImpl(code.name() + ": " + message, code, cause);
  }

  /** Creates a {@link JdbcSqlException} for unsupported methods/values. */
  static SQLFeatureNotSupportedException unsupported(String message) {
    return new JdbcSqlFeatureNotSupportedException(message);
  }

  /** Creates a {@link JdbcSqlException} for client info exceptions. */
  static SQLClientInfoException clientInfoException(String message, Code code) {
    return new JdbcSqlClientInfoException(code.name() + ": " + message, code);
  }

  /** Creates a {@link JdbcSqlException} for batch update exceptions. */
  static BatchUpdateException batchException(
      int[] updateCounts, SpannerBatchUpdateException cause) {
    return new JdbcSqlBatchUpdateException(updateCounts, cause);
  }
}
