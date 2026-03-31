/*
 * Copyright 2017 Google LLC
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

package com.google.cloud.spanner;

import static com.google.cloud.spanner.MissingDefaultSequenceKindException.isMissingDefaultSequenceKindException;
import static com.google.cloud.spanner.TransactionMutationLimitExceededException.isTransactionMutationLimitException;

import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ErrorDetails;
import com.google.api.gax.rpc.WatchdogTimeoutException;
import com.google.cloud.spanner.SpannerException.DoNotConstructDirectly;
import com.google.common.base.MoreObjects;
import com.google.common.base.Predicate;
import com.google.rpc.ErrorInfo;
import com.google.rpc.ResourceInfo;
import com.google.rpc.RetryInfo;
import io.grpc.Context;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.protobuf.ProtoUtils;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;

/**
 * A factory for creating instances of {@link SpannerException} and its subtypes. All creation of
 * these exceptions is directed through the factory. This ensures that particular types of errors
 * are always expressed as the same concrete exception type. For example, exceptions of type {@link
 * ErrorCode#ABORTED} are always represented by {@link AbortedException}.
 */
public final class SpannerExceptionFactory {

  static final String SESSION_RESOURCE_TYPE = "type.googleapis.com/google.spanner.v1.Session";
  static final String DATABASE_RESOURCE_TYPE =
      "type.googleapis.com/google.spanner.admin.database.v1.Database";
  static final String INSTANCE_RESOURCE_TYPE =
      "type.googleapis.com/google.spanner.admin.instance.v1.Instance";
  private static final Metadata.Key<ResourceInfo> KEY_RESOURCE_INFO =
      ProtoUtils.keyForProto(ResourceInfo.getDefaultInstance());
  private static final Metadata.Key<ErrorInfo> KEY_ERROR_INFO =
      ProtoUtils.keyForProto(ErrorInfo.getDefaultInstance());

  public static SpannerException newSpannerException(ErrorCode code, @Nullable String message) {
    return newSpannerException(code, message, null);
  }

  public static SpannerException newSpannerException(
      ErrorCode code, @Nullable String message, @Nullable Throwable cause) {
    return newSpannerExceptionPreformatted(code, formatMessage(code, message), cause, null);
  }

  public static SpannerException propagateInterrupt(InterruptedException e) {
    Thread.currentThread().interrupt();
    return SpannerExceptionFactory.newSpannerException(ErrorCode.CANCELLED, "Interrupted", e);
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
  public static SpannerException propagateTimeout(TimeoutException e) {
    return SpannerExceptionFactory.newSpannerException(
        ErrorCode.DEADLINE_EXCEEDED, "Operation did not complete in the given time", e);
  }

  /**
   * Converts the given {@link Throwable} to a {@link SpannerException}. If <code>t</code> is
   * already a (subclass of a) {@link SpannerException}, <code>t</code> is returned unaltered.
   * Otherwise, a new {@link SpannerException} is created with <code>t</code> as its cause.
   */
  public static SpannerException asSpannerException(Throwable t) {
    if (t instanceof SpannerException) {
      return (SpannerException) t;
    }
    return newSpannerException(t);
  }

  /**
   * Creates a new exception based on {@code cause}.
   *
   * <p>Intended for internal library use; user code should use {@link
   * #newSpannerException(ErrorCode, String)} instead of this method.
   */
  public static SpannerException newSpannerException(Throwable cause) {
    return newSpannerException(null, cause);
  }

  public static SpannerBatchUpdateException newSpannerBatchUpdateException(
      ErrorCode code, String message, long[] updateCounts) {
    DoNotConstructDirectly token = DoNotConstructDirectly.ALLOWED;
    SpannerException cause = null;
    if (isTransactionMutationLimitException(code, message)) {
      cause = new TransactionMutationLimitExceededException(token, code, message, null, null);
    }
    return new SpannerBatchUpdateException(token, code, message, updateCounts, cause);
  }

  /** Constructs a specific error that */
  public static DmlBatchUpdateCountVerificationFailedException
      newDmlBatchUpdateCountVerificationFailedException(long[] expected, long[] actual) {
    return new DmlBatchUpdateCountVerificationFailedException(
        DoNotConstructDirectly.ALLOWED, expected, actual);
  }

  /**
   * Constructs a specific aborted exception that should only be thrown by a connection after an
   * internal retry aborted due to concurrent modifications.
   */
  public static AbortedDueToConcurrentModificationException
      newAbortedDueToConcurrentModificationException(AbortedException cause) {
    return new AbortedDueToConcurrentModificationException(
        DoNotConstructDirectly.ALLOWED,
        "The transaction was aborted and could not be retried due to a concurrent modification",
        cause);
  }

  /**
   * Constructs a specific aborted exception that should only be thrown by a connection after an
   * internal retry aborted because a database call caused an exception that did not happen during
   * the original attempt.
   */
  public static AbortedDueToConcurrentModificationException
      newAbortedDueToConcurrentModificationException(
          AbortedException cause, SpannerException databaseError) {
    return new AbortedDueToConcurrentModificationException(
        DoNotConstructDirectly.ALLOWED,
        "The transaction was aborted and could not be retried due to a database error during the"
            + " retry",
        cause,
        databaseError);
  }

  /**
   * Constructs a new {@link AbortedDueToConcurrentModificationException} that can be re-thrown for
   * a transaction that had already been aborted, but that the client application tried to use for
   * additional statements.
   */
  public static AbortedDueToConcurrentModificationException
      newAbortedDueToConcurrentModificationException(
          AbortedDueToConcurrentModificationException cause) {
    return new AbortedDueToConcurrentModificationException(
        DoNotConstructDirectly.ALLOWED,
        "This transaction has already been aborted and could not be retried due to a concurrent"
            + " modification. Rollback this transaction to start a new one.",
        cause);
  }

  /**
   * Creates a new exception based on {@code cause}. If {@code cause} indicates cancellation, {@code
   * context} will be inspected to establish the type of cancellation.
   *
   * <p>Intended for internal library use; user code should use {@link
   * #newSpannerException(ErrorCode, String)} instead of this method.
   */
  public static SpannerException newSpannerException(@Nullable Context context, Throwable cause) {
    if (cause instanceof SpannerException) {
      SpannerException e = (SpannerException) cause;
      return newSpannerExceptionPreformatted(e.getErrorCode(), e.getMessage(), e, null);
    } else if (cause instanceof CancellationException) {
      return newSpannerExceptionForCancellation(context, cause);
    } else if (cause instanceof ApiException) {
      return fromApiException((ApiException) cause);
    }
    // Extract gRPC status.  This will produce "UNKNOWN" for non-gRPC exceptions.
    Status status = Status.fromThrowable(cause);
    if (status.getCode() == Status.Code.CANCELLED) {
      return newSpannerExceptionForCancellation(context, cause);
    }
    return newSpannerException(ErrorCode.fromGrpcStatus(status), cause.getMessage(), cause);
  }

  public static RuntimeException causeAsRunTimeException(ExecutionException executionException) {
    // Propagate the underlying exception as a RuntimeException (SpannerException is also a
    // RuntimeException).
    if (executionException.getCause() instanceof RuntimeException) {
      throw (RuntimeException) executionException.getCause();
    }
    throw asSpannerException(executionException.getCause());
  }

  /**
   * Creates a new SpannerException that indicates that the RPC or transaction should be retried on
   * a different gRPC channel. This is an experimental feature that can be removed in the future.
   * The exception should not be surfaced to the client application, and should instead be caught
   * and handled in the client library.
   */
  static SpannerException newRetryOnDifferentGrpcChannelException(
      String message, int channel, Throwable cause) {
    return new RetryOnDifferentGrpcChannelException(message, channel, cause);
  }

  static SpannerException newSpannerExceptionForCancellation(
      @Nullable Context context, @Nullable Throwable cause) {
    if (context != null && context.isCancelled()) {
      Throwable cancellationCause = context.cancellationCause();
      Throwable throwable =
          cause == null && cancellationCause == null
              ? null
              : MoreObjects.firstNonNull(cause, cancellationCause);
      if (cancellationCause instanceof TimeoutException) {
        return newSpannerException(
            ErrorCode.DEADLINE_EXCEEDED, "Current context exceeded deadline", throwable);
      } else {
        return newSpannerException(ErrorCode.CANCELLED, "Current context was cancelled", throwable);
      }
    }
    return newSpannerException(
        ErrorCode.CANCELLED, cause == null ? "Cancelled" : cause.getMessage(), cause);
  }

  private static String formatMessage(ErrorCode code, @Nullable String message) {
    if (message == null) {
      return code.toString();
    }
    // gRPC exceptions already start with the code, which happens to be the same prefix we use.
    return message.startsWith(code.toString()) ? message : code + ": " + message;
  }

  private static ResourceInfo extractResourceInfo(Throwable cause) {
    if (cause != null) {
      Metadata trailers = Status.trailersFromThrowable(cause);
      if (trailers != null) {
        return trailers.get(KEY_RESOURCE_INFO);
      }
    }
    return null;
  }

  private static ErrorInfo extractErrorInfo(Throwable cause, ApiException apiException) {
    if (apiException != null && apiException.getErrorDetails() != null) {
      return apiException.getErrorDetails().getErrorInfo();
    }
    if (cause != null) {
      Metadata trailers = Status.trailersFromThrowable(cause);
      if (trailers != null) {
        return trailers.get(KEY_ERROR_INFO);
      }
    }
    return null;
  }

  static ErrorDetails extractErrorDetails(Throwable cause, ApiException apiException) {
    if (apiException != null && apiException.getErrorDetails() != null) {
      return apiException.getErrorDetails();
    }

    Throwable prevCause = null;
    while (cause != null && cause != prevCause) {
      if (cause instanceof ApiException) {
        return ((ApiException) cause).getErrorDetails();
      }
      if (cause instanceof SpannerException) {
        return ((SpannerException) cause).getErrorDetails();
      }
      prevCause = cause;
      cause = cause.getCause();
    }
    return null;
  }

  /**
   * Creates a {@link StatusRuntimeException} that contains a {@link RetryInfo} with the specified
   * retry delay.
   */
  static StatusRuntimeException createAbortedExceptionWithRetryDelay(
      String message, Throwable cause, long retryDelaySeconds, int retryDelayNanos) {
    Metadata.Key<RetryInfo> key = ProtoUtils.keyForProto(RetryInfo.getDefaultInstance());
    Metadata trailers = new Metadata();
    RetryInfo retryInfo =
        RetryInfo.newBuilder()
            .setRetryDelay(
                com.google.protobuf.Duration.newBuilder()
                    .setNanos(retryDelayNanos)
                    .setSeconds(retryDelaySeconds))
            .build();
    trailers.put(key, retryInfo);
    return io.grpc.Status.ABORTED
        .withDescription(message)
        .withCause(cause)
        .asRuntimeException(trailers);
  }

  static SpannerException newSpannerExceptionPreformatted(
      ErrorCode code,
      @Nullable String message,
      @Nullable Throwable cause,
      @Nullable ApiException apiException) {
    // This is the one place in the codebase that is allowed to call constructors directly.
    DoNotConstructDirectly token = DoNotConstructDirectly.ALLOWED;
    switch (code) {
      case ABORTED:
        return new AbortedException(token, message, cause, apiException);
      case RESOURCE_EXHAUSTED:
        ErrorInfo info = extractErrorInfo(cause, apiException);
        if (info != null
            && info.getMetadataMap()
                .containsKey(AdminRequestsPerMinuteExceededException.ADMIN_REQUESTS_LIMIT_KEY)
            && AdminRequestsPerMinuteExceededException.ADMIN_REQUESTS_LIMIT_VALUE.equals(
                info.getMetadataMap()
                    .get(AdminRequestsPerMinuteExceededException.ADMIN_REQUESTS_LIMIT_KEY))) {
          return new AdminRequestsPerMinuteExceededException(token, message, cause, apiException);
        }
      case NOT_FOUND:
        ResourceInfo resourceInfo = extractResourceInfo(cause);
        if (resourceInfo != null) {
          switch (resourceInfo.getResourceType()) {
            case SESSION_RESOURCE_TYPE:
              return new SessionNotFoundException(
                  token, message, resourceInfo, cause, apiException);
            case DATABASE_RESOURCE_TYPE:
              return new DatabaseNotFoundException(
                  token, message, resourceInfo, cause, apiException);
            case INSTANCE_RESOURCE_TYPE:
              return new InstanceNotFoundException(
                  token, message, resourceInfo, cause, apiException);
          }
        }
      case INVALID_ARGUMENT:
        if (isTransactionMutationLimitException(cause, apiException)) {
          return new TransactionMutationLimitExceededException(
              token, code, message, cause, apiException);
        }
        if (isMissingDefaultSequenceKindException(apiException)) {
          return new MissingDefaultSequenceKindException(token, code, message, cause, apiException);
        }
      // Fall through to the default.
      default:
        return new SpannerException(
            token, code, isRetryable(code, cause), message, cause, apiException);
    }
  }

  static SpannerException newSpannerExceptionPreformatted(
      ErrorCode code, @Nullable String message, @Nullable Throwable cause) {
    return newSpannerExceptionPreformatted(code, message, cause, null);
  }

  private static SpannerException fromApiException(ApiException exception) {
    Status.Code code;
    if (exception.getStatusCode() instanceof GrpcStatusCode) {
      code = ((GrpcStatusCode) exception.getStatusCode()).getTransportCode();
    } else if (exception instanceof WatchdogTimeoutException) {
      code = Status.Code.DEADLINE_EXCEEDED;
    } else {
      code = Status.Code.UNKNOWN;
    }
    ErrorCode errorCode = ErrorCode.fromGrpcStatus(Status.fromCode(code));

    return SpannerExceptionFactory.newSpannerExceptionPreformatted(
        errorCode,
        formatMessage(errorCode, exception.getMessage()),
        exception.getCause(),
        exception);
  }

  private static boolean isRetryable(ErrorCode code, @Nullable Throwable cause) {
    switch (code) {
      case INTERNAL:
        return hasCauseMatching(cause, Matchers.isRetryableInternalError);
      case UNAVAILABLE:
        // SSLHandshakeException is (probably) not retryable, as it is an indication that the server
        // certificate was not accepted by the client.
        // Channel shutdown is also not a retryable exception.
        return !(hasCauseMatching(cause, Matchers.isSSLHandshakeException)
            || hasCauseMatching(cause, Matchers.IS_CHANNEL_SHUTDOWN_EXCEPTION));
      case RESOURCE_EXHAUSTED:
        return SpannerException.extractRetryDelay(cause) > 0;
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

    static final Predicate<Throwable> isRetryableInternalError = new IsRetryableInternalError();
    static final Predicate<Throwable> isSSLHandshakeException = new IsSslHandshakeException();

    static final Predicate<Throwable> IS_CHANNEL_SHUTDOWN_EXCEPTION =
        new IsChannelShutdownException();
  }
}
