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

package com.google.cloud.datastore;

import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiException;
import com.google.cloud.datastore.DatastoreException.DoNotConstructDirectly;
import com.google.common.base.MoreObjects;
import com.google.common.base.Predicate;
import io.grpc.Context;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;
import javax.net.ssl.SSLHandshakeException;

/**
 * A factory for creating instances of {@link DatastoreException} and its subtypes. All creation of
 * these exceptions is directed through the factory. This ensures that particular types of errors
 * are always expressed as the same concrete exception type.
 *
 */
public final class DatastoreExceptionFactory {
  public static DatastoreException newDatastoreException(ErrorCode code, @Nullable String message) {
    return newDatastoreException(code, message, null);
  }

  public static DatastoreException newDatastoreException(
      ErrorCode code, @Nullable String message, @Nullable Throwable cause) {
    return newDatastoreExceptionPreformatted(code, formatMessage(code, message), cause);
  }

  public static DatastoreException propagateInterrupt(InterruptedException e) {
    Thread.currentThread().interrupt();
    return DatastoreExceptionFactory.newDatastoreException(ErrorCode.CANCELLED, "Interrupted", e);
  }

  /**
   * Transforms a {@code TimeoutException} to a {@code SpannerException}.
   *
   * <pre>
   * <code>
   * try {
   *   Spanner spanner = SpannerOptions.getDefaultInstance();
   *   spanner
   *       .getDatabaseAdminClient()
   *       .createDatabase("[INSTANCE_ID]", "[DATABASE_ID]", [STATEMENTS])
   *       .get();
   * } catch (TimeoutException e) {
   *   propagateTimeout(e);
   * }
   * </code>
   * </pre>
   */
  public static DatastoreException propagateTimeout(TimeoutException e) {
    return DatastoreExceptionFactory.newDatastoreException(
        ErrorCode.DEADLINE_EXCEEDED, "Operation did not complete in the given time", e);
  }

  /**
   * Creates a new exception based on {@code cause}.
   *
   * <p>Intended for internal library use; user code should use {@link
   * #newDatastoreException(ErrorCode, String)} instead of this method.
   */
  public static DatastoreException newDatastoreException(Throwable cause) {
    return newDatastoreException(null, cause);
  }

  /**
   * Creates a new exception based on {@code cause}. If {@code cause} indicates cancellation, {@code
   * context} will be inspected to establish the type of cancellation.
   *
   * <p>Intended for internal library use; user code should use {@link
   * #newDatastoreException(ErrorCode, String)} instead of this method.
   */
  public static DatastoreException newDatastoreException(@Nullable Context context, Throwable cause) {
    if (cause instanceof DatastoreException) {
      DatastoreException e = (DatastoreException) cause;
      return newDatastoreExceptionPreformatted(e.getErrorCode(), e.getMessage(), e);
    } else if (cause instanceof CancellationException) {
      return newDatastoreExceptionForCancellation(context, cause);
    } else if (cause instanceof ApiException) {
      return fromApiException((ApiException) cause);
    }
    // Extract gRPC status.  This will produce "UNKNOWN" for non-gRPC exceptions.
    Status status = Status.fromThrowable(cause);
    if (status.getCode() == Status.Code.CANCELLED) {
      return newDatastoreExceptionForCancellation(context, cause);
    }
    return newDatastoreException(ErrorCode.fromGrpcStatus(status), cause.getMessage(), cause);
  }

  static DatastoreException newDatastoreExceptionForCancellation(
      @Nullable Context context, @Nullable Throwable cause) {
    if (context != null && context.isCancelled()) {
      Throwable cancellationCause = context.cancellationCause();
      if (cancellationCause instanceof TimeoutException) {
        return newDatastoreException(
            ErrorCode.DEADLINE_EXCEEDED,
            "Current context exceeded deadline",
            MoreObjects.firstNonNull(cause, cancellationCause));
      } else {
        return newDatastoreException(
            ErrorCode.CANCELLED,
            "Current context was cancelled",
            MoreObjects.firstNonNull(cause, cancellationCause));
      }
    }
    return newDatastoreException(
        ErrorCode.CANCELLED, cause == null ? "Cancelled" : cause.getMessage(), cause);
  }

  private static String formatMessage(ErrorCode code, @Nullable String message) {
    if (message == null) {
      return code.toString();
    }
    // gRPC exceptions already start with the code, which happens to be the same prefix we use.
    return message.startsWith(code.toString()) ? message : code + ": " + message;
  }

  private static DatastoreException newDatastoreExceptionPreformatted(
      ErrorCode code, @Nullable String message, @Nullable Throwable cause) {
    DoNotConstructDirectly token = DoNotConstructDirectly.ALLOWED;
    return new DatastoreException(token, code, isRetryable(code, cause), message, cause);
  }

  private static DatastoreException fromApiException(ApiException exception) {
    Status.Code code = ((GrpcStatusCode) exception.getStatusCode()).getTransportCode();
    ErrorCode errorCode = ErrorCode.fromGrpcStatus(Status.fromCode(code));
    if (exception.getCause() != null) {
      return DatastoreExceptionFactory.newDatastoreException(
          errorCode, exception.getMessage(), exception.getCause());
    } else {
      return DatastoreExceptionFactory.newDatastoreException(errorCode, exception.getMessage());
    }
  }

  private static boolean isRetryable(ErrorCode code, @Nullable Throwable cause) {
    switch (code) {
      case INTERNAL:
        return hasCauseMatching(cause, Matchers.isRetryableInternalError);
      case UNAVAILABLE:
        // SSLHandshakeException is (probably) not retryable, as it is an indication that the server
        // certificate was not accepted by the client.
        return !hasCauseMatching(cause, Matchers.isSSLHandshakeException);
      case RESOURCE_EXHAUSTED:
        return DatastoreException.extractRetryDelay(cause) > 0;
      default:
        return false;
    }
  }

  private static boolean hasCauseMatching(
      @Nullable Throwable cause, Predicate<? super Throwable> matcher) {
    while (cause != null) {
      if (matcher.apply(cause)) {
        return true;
      }
      cause = cause.getCause();
    }
    return false;
  }

  private static class Matchers {
    static final Predicate<Throwable> isRetryableInternalError =
        new Predicate<Throwable>() {
          @Override
          public boolean apply(Throwable cause) {
            if (cause instanceof StatusRuntimeException
                && ((StatusRuntimeException) cause).getStatus().getCode() == Status.Code.INTERNAL) {
              if (cause.getMessage().contains("HTTP/2 error code: INTERNAL_ERROR")) {
                // See b/25451313.
                return true;
              }
              if (cause.getMessage().contains("Connection closed with unknown cause")) {
                // See b/27794742.
                return true;
              }
              if (cause
                  .getMessage()
                  .contains("Received unexpected EOS on DATA frame from server")) {
                return true;
              }
            }
            return false;
          }
        };
    static final Predicate<Throwable> isSSLHandshakeException =
        new Predicate<Throwable>() {
          @Override
          public boolean apply(Throwable input) {
            return input instanceof SSLHandshakeException;
          }
        };
  }
}
