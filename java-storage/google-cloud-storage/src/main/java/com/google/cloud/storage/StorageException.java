/*
 * Copyright 2015 Google LLC
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

package com.google.cloud.storage;

import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.InternalApi;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptions;
import com.google.api.gax.rpc.ErrorDetails;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.BaseServiceException;
import com.google.cloud.RetryHelper.RetryHelperException;
import com.google.cloud.http.BaseHttpServiceException;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.TextFormat;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Storage service exception.
 *
 * @see <a href="https://cloud.google.com/storage/docs/json_api/v1/status-codes">Google Cloud
 *     Storage error codes</a>
 */
@InternalApi
public final class StorageException extends BaseHttpServiceException {
  private static final String INTERNAL_ERROR = "internalError";
  private static final String CONNECTION_CLOSED_PREMATURELY = "connectionClosedPrematurely";

  // see: https://cloud.google.com/storage/docs/resumable-uploads-xml#practices
  static final Set<Error> RETRYABLE_ERRORS =
      ImmutableSet.of(
          new Error(504, null),
          new Error(503, null),
          new Error(502, null),
          new Error(500, null),
          new Error(429, null),
          new Error(408, null),
          new Error(null, INTERNAL_ERROR),
          new Error(null, CONNECTION_CLOSED_PREMATURELY));

  private static final long serialVersionUID = 757915549325467990L;

  final ApiException apiExceptionCause;

  public StorageException(int code, String message) {
    this(code, message, null);
  }

  public StorageException(int code, String message, Throwable cause) {
    super(code, message, null, true, RETRYABLE_ERRORS, cause);
    this.apiExceptionCause = asApiExceptionOrNull(cause);
  }

  public StorageException(int code, String message, String reason, Throwable cause) {
    super(code, message, reason, true, RETRYABLE_ERRORS, cause);
    this.apiExceptionCause = asApiExceptionOrNull(cause);
  }

  public StorageException(IOException exception) {
    super(exception, true, RETRYABLE_ERRORS);
    this.apiExceptionCause = null;
  }

  public StorageException(GoogleJsonError error) {
    super(error, true, RETRYABLE_ERRORS);
    this.apiExceptionCause = null;
  }

  /**
   * Translate RetryHelperException to the StorageException that caused the error. This method will
   * always throw an exception.
   *
   * @throws StorageException when {@code ex} was caused by a {@code StorageException}
   */
  public static StorageException translateAndThrow(RetryHelperException ex) {
    BaseServiceException.translate(ex);
    throw getStorageException(ex);
  }

  private static StorageException getStorageException(Throwable t) {
    // unwrap a RetryHelperException if that is what is being translated
    if (t instanceof RetryHelperException) {
      Throwable cause = t.getCause();
      return new StorageException(UNKNOWN_CODE, cause != null ? cause.getMessage() : "", cause);
    }
    return new StorageException(UNKNOWN_CODE, t.getMessage(), t);
  }

  /**
   * Attempt to find an Exception which is a {@link BaseServiceException} If neither {@code t} or
   * {@code t.getCause()} are a {@code BaseServiceException} a {@link StorageException} will be
   * created with an unknown status code.
   */
  static BaseServiceException coalesce(Throwable t) {
    if (t instanceof BaseServiceException) {
      return (BaseServiceException) t;
    }
    if (t.getCause() instanceof BaseServiceException) {
      return (BaseServiceException) t.getCause();
    }
    if (t instanceof ApiException) {
      return asStorageException((ApiException) t);
    }
    if (t.getCause() instanceof ApiException) {
      return asStorageException((ApiException) t.getCause());
    }
    return getStorageException(t);
  }

  static <T> ApiFuture<T> coalesceAsync(ApiFuture<T> originalFuture) {
    return ApiFutures.catchingAsync(
        originalFuture,
        Throwable.class,
        throwable -> ApiFutures.immediateFailedFuture(coalesce(throwable)),
        MoreExecutors.directExecutor());
  }

  static StorageException asStorageException(ApiException apiEx) {
    // https://cloud.google.com/storage/docs/json_api/v1/status-codes
    // https://cloud.google.com/apis/design/errors#http_mapping
    int httpStatusCode = 0;
    StatusCode statusCode = apiEx.getStatusCode();
    if (statusCode instanceof GrpcStatusCode) {
      GrpcStatusCode gsc = (GrpcStatusCode) statusCode;
      httpStatusCode =
          GrpcToHttpStatusCodeTranslation.grpcCodeToHttpStatusCode(gsc.getTransportCode());
    }
    // If there is a gRPC exception in our cause change pull it's error message up to be our
    // message otherwise, create a generic error message with the status code.
    String message = null;
    if (apiEx.getCause() != null) {
      Throwable cause = apiEx.getCause();
      if (cause instanceof StatusRuntimeException || cause instanceof StatusException) {
        message = cause.getMessage();
      }
      // if not a grpc exception fall through to the default handling
    }
    if (message == null && apiEx.getMessage() != null) {
      message = apiEx.getMessage();
    }
    if (message == null) {
      String statusCodeName = statusCode.getCode().name();
      message = "Error: " + statusCodeName;
    }

    // https://cloud.google.com/apis/design/errors#error_payloads
    attachErrorDetails(apiEx);

    // It'd be better to use ExceptionData and BaseServiceException#<init>(ExceptionData) but,
    // BaseHttpServiceException does not pass that through so we're stuck using this for now.
    // TODO: When we can break the coupling to BaseHttpServiceException replace this
    return new StorageException(httpStatusCode, message, apiEx.getReason(), apiEx);
  }

  private static void attachErrorDetails(ApiException ae) {
    if (ae != null && ae.getErrorDetails() != null && !errorDetailsAttached(ae)) {
      StringBuilder sb = new StringBuilder();
      ErrorDetails ed = ae.getErrorDetails();
      sb.append("ErrorDetails {\n");
      Stream.of(
              ed.getErrorInfo(),
              ed.getDebugInfo(),
              ed.getQuotaFailure(),
              ed.getPreconditionFailure(),
              ed.getBadRequest(),
              ed.getHelp())
          .filter(Objects::nonNull)
          .forEach(
              msg ->
                  sb.append("\t\t")
                      .append(msg.getClass().getSimpleName())
                      .append(": { ")
                      .append(TextFormat.printer().shortDebugString(msg))
                      .append(" }\n"));
      sb.append("\t}");

      ae.addSuppressed(new ApiExceptionErrorDetailsComment(sb.toString()));
    }
  }

  private static boolean errorDetailsAttached(ApiException ae) {
    Throwable[] suppressed = ae.getSuppressed();
    for (Throwable throwable : suppressed) {
      if (throwable instanceof ApiExceptionErrorDetailsComment) {
        return true;
      }
    }
    return false;
  }

  /**
   * Translate IOException to a StorageException representing the cause of the error. This method
   * defaults to idempotent always being {@code true}. Additionally, this method translates
   * transient issues Connection Closed Prematurely as a retryable error.
   *
   * @return {@code StorageException}
   */
  public static StorageException translate(IOException exception) {
    String message = exception.getMessage();
    if (message != null
        && (message.contains("Connection closed prematurely")
            || message.contains("Premature EOF"))) {
      return new StorageException(0, message, CONNECTION_CLOSED_PREMATURELY, exception);
    } else {
      // default
      return new StorageException(exception);
    }
  }

  static <T> T wrapIOException(IOExceptionCallable<T> c) {
    try {
      return c.call();
    } catch (IOException e) {
      throw StorageException.coalesce(e);
    }
  }

  static void wrapIOException(IOExceptionRunnable r) {
    try {
      r.run();
    } catch (IOException e) {
      throw StorageException.coalesce(e);
    }
  }

  static <T> T wrapFutureGet(ApiFuture<T> f) {
    try {
      return ApiExceptions.callAndTranslateApiException(f);
    } catch (Exception e) {
      throw StorageException.coalesce(e);
    }
  }

  @Nullable
  private static ApiException asApiExceptionOrNull(Throwable cause) {
    if (cause instanceof ApiException) {
      return (ApiException) cause;
    } else {
      return null;
    }
  }

  @FunctionalInterface
  interface IOExceptionCallable<T> {
    T call() throws IOException;
  }

  @FunctionalInterface
  interface IOExceptionRunnable {
    void run() throws IOException;
  }

  static Runnable liftToRunnable(IOExceptionRunnable ioer) {
    return () -> {
      try {
        ioer.run();
      } catch (IOException e) {
        throw StorageException.coalesce(e);
      }
    };
  }

  private static final class ApiExceptionErrorDetailsComment extends Throwable {
    private ApiExceptionErrorDetailsComment(String message) {
      super(message, null, true, false);
    }
  }
}
