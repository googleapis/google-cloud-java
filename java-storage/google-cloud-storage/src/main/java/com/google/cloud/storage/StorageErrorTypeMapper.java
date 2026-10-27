/*
 * Copyright 2026 Google LLC
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

import com.google.api.client.http.HttpResponseException;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.DeadlineExceededException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.WatchdogTimeoutException;
import com.google.common.base.Ascii;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.SSLException;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Centralized package-private utility mapping exceptions and status codes to the standard HLD
 * uppercase canonical error strings.
 */
final class StorageErrorTypeMapper {

  static final String STATUS_OK = "OK";
  static final String STATUS_CANCELLED = "CANCELLED";
  static final String STATUS_UNKNOWN = "UNKNOWN";
  static final String STATUS_NOT_FOUND = "NOT_FOUND";
  static final String STATUS_UNAVAILABLE = "UNAVAILABLE";

  private static final String STATUS_INVALID_ARGUMENT = "INVALID_ARGUMENT";
  private static final String STATUS_ALREADY_EXISTS = "ALREADY_EXISTS";
  private static final String STATUS_PERMISSION_DENIED = "PERMISSION_DENIED";
  private static final String STATUS_RESOURCE_EXHAUSTED = "RESOURCE_EXHAUSTED";
  private static final String STATUS_FAILED_PRECONDITION = "FAILED_PRECONDITION";
  private static final String STATUS_OUT_OF_RANGE = "OUT_OF_RANGE";
  private static final String STATUS_UNIMPLEMENTED = "UNIMPLEMENTED";
  private static final String STATUS_INTERNAL = "INTERNAL";
  private static final String STATUS_UNAUTHENTICATED = "UNAUTHENTICATED";

  static final String STATUS_TIMEOUT = "TIMEOUT";
  static final String STATUS_DNS_FAILURE = "DNS_FAILURE";
  static final String STATUS_CONNECTION_REFUSED = "CONNECTION_REFUSED";
  static final String STATUS_CONNECTION_RESET = "CONNECTION_RESET";
  static final String STATUS_TLS_FAILURE = "TLS_FAILURE";
  static final String STATUS_CONNECTIVITY = "CONNECTIVITY";
  static final String STATUS_AUTHENTICATION_ERROR = "AUTHENTICATION_ERROR";
  static final String STATUS_CHECKSUM_MISMATCH = "CHECKSUM_MISMATCH";

  static String mapGrpcStatus(@Nullable Status status) {
    if (status == null || status.getCode() == Status.Code.UNKNOWN) {
      return STATUS_UNKNOWN;
    }
    if (status.getCode() == Status.Code.DEADLINE_EXCEEDED) {
      return STATUS_TIMEOUT;
    }
    return status.getCode().name();
  }

  private static String mapGaxStatusCode(StatusCode.@Nullable Code code) {
    if (code == null || code == StatusCode.Code.UNKNOWN) {
      return STATUS_UNKNOWN;
    }
    if (code == StatusCode.Code.DEADLINE_EXCEEDED) {
      return STATUS_TIMEOUT;
    }
    return code.name();
  }

  static String mapHttpResponseCode(int statusCode) {
    if (statusCode >= 200 && statusCode < 300) {
      return STATUS_OK;
    }
    switch (statusCode) {
      case 400:
        return STATUS_INVALID_ARGUMENT;
      case 401:
        return STATUS_UNAUTHENTICATED;
      case 403:
        return STATUS_PERMISSION_DENIED;
      case 404:
        return STATUS_NOT_FOUND;
      case 408:
        return STATUS_TIMEOUT;
      case 409:
        return STATUS_ALREADY_EXISTS;
      case 412:
        return STATUS_FAILED_PRECONDITION;
      case 416:
        return STATUS_OUT_OF_RANGE;
      case 429:
        return STATUS_RESOURCE_EXHAUSTED;
      case 499:
        return STATUS_CANCELLED;
      case 500:
        return STATUS_INTERNAL;
      case 501:
        return STATUS_UNIMPLEMENTED;
      case 502:
      case 503:
        return STATUS_UNAVAILABLE;
      case 504:
        return STATUS_TIMEOUT;
      default:
        if (statusCode >= 400 && statusCode < 600) {
          return String.valueOf(statusCode);
        }
        return STATUS_UNKNOWN;
    }
  }

  static String mapThrowable(@Nullable Throwable t) {
    if (t == null) {
      return STATUS_OK;
    }

    while ((t instanceof ExecutionException || t instanceof CompletionException)
        && t.getCause() != null
        && t.getCause() != t) {
      t = t.getCause();
    }

    if (isChecksumMismatch(t)) {
      return STATUS_CHECKSUM_MISMATCH;
    }

    if (t instanceof CancellationException) {
      return STATUS_CANCELLED;
    }

    if (t instanceof StatusRuntimeException) {
      String mappedCause = mapSpecificClientCause(t, /* includeAuth= */ true);
      if (mappedCause != null) {
        return mappedCause;
      }
      return mapGrpcStatus(((StatusRuntimeException) t).getStatus());
    }

    if (t instanceof StatusException) {
      String mappedCause = mapSpecificClientCause(t, /* includeAuth= */ true);
      if (mappedCause != null) {
        return mappedCause;
      }
      return mapGrpcStatus(((StatusException) t).getStatus());
    }

    if (t instanceof WatchdogTimeoutException
        || t instanceof DeadlineExceededException
        || t instanceof SocketTimeoutException
        || t instanceof TimeoutException) {
      return STATUS_TIMEOUT;
    }

    if (t instanceof ApiException) {
      String mappedCause = mapSpecificClientCause(t, /* includeAuth= */ true);
      if (mappedCause != null) {
        return mappedCause;
      }
      ApiException apiException = (ApiException) t;
      StatusCode statusCode = apiException.getStatusCode();
      String mapped = mapGaxStatusCode(statusCode != null ? statusCode.getCode() : null);
      if (!STATUS_UNKNOWN.equals(mapped)) {
        return mapped;
      }
    }

    if (t instanceof HttpResponseException) {
      String mappedCause = mapSpecificClientCause(t, /* includeAuth= */ true);
      if (mappedCause != null) {
        return mappedCause;
      }
      return mapHttpResponseCode(((HttpResponseException) t).getStatusCode());
    }

    if (t instanceof StorageException) {
      StorageException se = (StorageException) t;
      Throwable cause = se.getCause();
      if (cause != null
          && cause != se
          && (cause instanceof ApiException
              || cause instanceof StatusRuntimeException
              || cause instanceof StatusException
              || hasSpecificClientCause(cause, /* includeAuth= */ true))) {
        String mappedCause = mapKnownCause(se, cause);
        if (mappedCause != null) {
          return mappedCause;
        }
      }
      if (se.getCode() > 0) {
        return mapHttpResponseCode(se.getCode());
      }
    }

    if (isAuthException(t)) {
      String mappedCause = mapSpecificClientCause(t, /* includeAuth= */ false);
      if (mappedCause != null) {
        return mappedCause;
      }
      return STATUS_AUTHENTICATION_ERROR;
    }

    if (t instanceof UnknownHostException) {
      return STATUS_DNS_FAILURE;
    }

    if (t instanceof ConnectException) {
      return STATUS_CONNECTION_REFUSED;
    }

    if (t instanceof SocketException) {
      String message = t.getMessage();
      if (message != null && Ascii.toLowerCase(message).contains("reset")) {
        return STATUS_CONNECTION_RESET;
      }
      return STATUS_CONNECTIVITY;
    }

    if (t instanceof SSLException) {
      return STATUS_TLS_FAILURE;
    }

    if (t instanceof IOException) {
      String mappedCause = mapSpecificClientCause(t, /* includeAuth= */ true);
      if (mappedCause != null) {
        return mappedCause;
      }
      return STATUS_CONNECTIVITY;
    }

    String causeMapping = mapKnownCause(t, t.getCause());
    if (causeMapping != null) {
      return causeMapping;
    }

    return STATUS_UNKNOWN;
  }

  private static @Nullable String mapSpecificClientCause(Throwable t, boolean includeAuth) {
    Throwable cause = t.getCause();
    if (cause != null && cause != t && hasSpecificClientCause(cause, includeAuth)) {
      return mapKnownCause(t, cause);
    }
    return null;
  }

  private static @Nullable String mapKnownCause(
      @Nullable Throwable parent, @Nullable Throwable cause) {
    if (cause != null && cause != parent) {
      String mappedCause = mapThrowable(cause);
      if (!STATUS_UNKNOWN.equals(mappedCause)) {
        return mappedCause;
      }
    }
    return null;
  }

  private static boolean hasSpecificClientCause(@Nullable Throwable t, boolean includeAuth) {
    Throwable current = t;
    while (current != null) {
      if (current instanceof WatchdogTimeoutException
          || current instanceof DeadlineExceededException
          || current instanceof SocketTimeoutException
          || current instanceof TimeoutException
          || current instanceof UnknownHostException
          || current instanceof ConnectException
          || current instanceof SocketException
          || current instanceof SSLException
          || current instanceof CancellationException
          || isChecksumMismatch(current)
          || (includeAuth && isAuthException(current))) {
        return true;
      }
      Throwable next = current.getCause();
      if (next == current) {
        break;
      }
      current = next;
    }
    return false;
  }

  private static boolean isChecksumMismatch(Throwable t) {
    if (t instanceof Hasher.ChecksumMismatchException
        || t instanceof Hasher.UncheckedChecksumMismatchException) {
      return true;
    }
    String message = t.getMessage();
    if (message != null) {
      String lower = Ascii.toLowerCase(message);
      if (lower.contains("mismatch checksum") || lower.contains("checksum mismatch")) {
        return true;
      }
    }
    return false;
  }

  private static boolean isAuthException(Throwable t) {
    for (Class<?> cls = t.getClass();
        cls != null && cls != Throwable.class;
        cls = cls.getSuperclass()) {
      String className = cls.getName();
      String simpleName = cls.getSimpleName();
      if (className.startsWith("com.google.auth.")
          || className.startsWith("com.google.api.client.auth.")
          || className.contains("GoogleAuthException")
          || simpleName.equals("OAuth2Exception")
          || simpleName.equals("AuthenticationException")) {
        return true;
      }
    }
    return false;
  }

  private StorageErrorTypeMapper() {}
}
