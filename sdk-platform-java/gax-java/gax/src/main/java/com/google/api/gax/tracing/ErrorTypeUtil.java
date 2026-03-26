/*
 * Copyright 2026 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.tracing;

import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.DeadlineExceededException;
import com.google.api.gax.rpc.WatchdogTimeoutException;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;
import java.net.BindException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.channels.UnresolvedAddressException;
import java.security.GeneralSecurityException;
import java.util.Set;
import javax.annotation.Nullable;
import javax.net.ssl.SSLHandshakeException;

public class ErrorTypeUtil {

  public enum ErrorType {
    CLIENT_TIMEOUT,
    CLIENT_CONNECTION_ERROR,
    CLIENT_REQUEST_ERROR,
    /** Placeholder for potential future request body errors. */
    CLIENT_REQUEST_BODY_ERROR,
    /** Placeholder for potential future response decode errors. */
    CLIENT_RESPONSE_DECODE_ERROR,
    /** Placeholder for potential future redirect errors. */
    CLIENT_REDIRECT_ERROR,
    CLIENT_AUTHENTICATION_ERROR,
    /** Placeholder for potential future unknown errors. */
    CLIENT_UNKNOWN_ERROR,
    INTERNAL;
  }

  private static final Set<Class<? extends Throwable>> AUTHENTICATION_EXCEPTION_CLASSES =
      ImmutableSet.of(GeneralSecurityException.class);

  private static final Set<Class<? extends Throwable>> CLIENT_TIMEOUT_EXCEPTION_CLASSES =
      ImmutableSet.of(
          SocketTimeoutException.class,
          WatchdogTimeoutException.class,
          DeadlineExceededException.class);

  private static final Set<Class<? extends Throwable>> CLIENT_CONNECTION_EXCEPTIONS =
      ImmutableSet.of(
          ConnectException.class,
          UnknownHostException.class,
          SSLHandshakeException.class,
          UnresolvedAddressException.class,
          NoRouteToHostException.class,
          BindException.class);

  /**
   * Extracts a low-cardinality string representing the specific classification of the error to be
   * used in the {@link ObservabilityAttributes#ERROR_TYPE_ATTRIBUTE} attribute.
   *
   * <p>This value is determined based on the following priority:
   *
   * <ol>
   *   <li><b>{@code google.rpc.ErrorInfo.reason}:</b> If the error response from the service
   *       includes {@code google.rpc.ErrorInfo} details, the reason field (e.g.,
   *       "RATE_LIMIT_EXCEEDED", "SERVICE_DISABLED") will be used. This offers the most precise
   *       error cause.
   *   <li><b>Client-Side Network/Operational Errors:</b> For errors occurring within the client
   *       library or network stack, mapping to specific enum representations from {@link
   *       ErrorType}. This includes checking the cause chain for diagnostic markers (e.g., {@code
   *       ConnectException} or {@code SocketTimeoutException}).
   *   <li><b>Specific Server Error Code:</b> If no {@code ErrorInfo.reason} is available and it is
   *       not a client-side failure, but a server error code was received:
   *       <ul>
   *         <li>For HTTP: The HTTP status code (e.g., "403", "503").
   *         <li>For gRPC: The gRPC status code name (e.g., "PERMISSION_DENIED", "UNAVAILABLE").
   *       </ul>
   *   <li><b>Language-specific error type:</b> The class or struct name of the exception or error
   *       if available. This must be low-cardinality, meaning it returns the short name of the
   *       exception class (e.g. {@code "IllegalStateException"}) rather than its message.
   *   <li><b>Internal Fallback:</b> If the error doesn't fit any of the above categories, {@code
   *       "INTERNAL"} will be used, indicating an unexpected issue within the client library's own
   *       logic.
   * </ol>
   *
   * @param error the Throwable from which to extract the error type string.
   * @return a low-cardinality string representing the specific error type, or {@code ErrorType.INTERNAL.toString()} if the
   *     provided error is {@code null}.
   */
  public static String extractErrorType(@Nullable Throwable error) {
    if (error == null) {
      // No information about the error; we default to INTERNAL.
      return ErrorType.INTERNAL.toString();
    }

    // 1. Extract error info reason (most specific server-side info)
    if (error instanceof ApiException) {
      String reason = ((ApiException) error).getReason();
      if (!Strings.isNullOrEmpty(reason)) {
        return reason;
      }
    }

    // 2. Attempt client side error (includes checking cause chains)
    String clientError = getClientSideError(error);
    if (clientError != null) {
      return clientError;
    }

    // 3. Extract server status code if available
    if (error instanceof ApiException) {
      String errorCode = extractServerErrorCode((ApiException) error);
      if (errorCode != null) {
        return errorCode;
      }
    }

    // 4. Language-specific error type fallback
    String exceptionName = error.getClass().getSimpleName();
    if (!Strings.isNullOrEmpty(exceptionName)) {
      return exceptionName;
    }

    // 5. Internal Fallback
    return ErrorType.INTERNAL.toString();
  }

  /**
   * Extracts the server error code from an ApiException.
   *
   * @param apiException The ApiException to extract the error code from.
   * @return A string representing the error code, or null if no specific code can be determined.
   */
  @Nullable
  private static String extractServerErrorCode(ApiException apiException) {
    if (apiException.getStatusCode() != null) {
      Object transportCode = apiException.getStatusCode().getTransportCode();
      if (transportCode instanceof Integer) {
        // HTTP Status Code
        return String.valueOf(transportCode);
      } else if (apiException.getStatusCode().getCode() != null) {
        // gRPC Status Code name
        return apiException.getStatusCode().getCode().name();
      }
    }
    return null;
  }

  /**
   * Determines the client-side error type based on the provided Throwable. This method checks for
   * various network and client-specific exceptions.
   *
   * @param error The Throwable to analyze.
   * @return A string representing the client-side error type, or null if not matched.
   */
  @Nullable
  private static String getClientSideError(Throwable error) {
    if (isClientTimeout(error)) {
      return ErrorType.CLIENT_TIMEOUT.toString();
    }
    if (isClientConnectionError(error)) {
      return ErrorType.CLIENT_CONNECTION_ERROR.toString();
    }
    if (isClientAuthenticationError(error)) {
      return ErrorType.CLIENT_AUTHENTICATION_ERROR.toString();
    }
    // This covers CLIENT_REQUEST_ERROR for general illegal arguments in client requests.
    if (error instanceof IllegalArgumentException) {
      return ErrorType.CLIENT_REQUEST_ERROR.toString();
    }
    return null;
  }

  /**
   * Checks if the given Throwable represents a client-side timeout error. This includes socket
   * timeouts and GAX-specific watchdog timeouts.
   *
   * @param e The Throwable to check.
   * @return true if the error is a client timeout, false otherwise.
   */
  private static boolean isClientTimeout(Throwable e) {
    return hasErrorClassInCauseChain(e, CLIENT_TIMEOUT_EXCEPTION_CLASSES);
  }

  /**
   * Checks if the given Throwable represents a client-side connection error. This includes issues
   * with establishing connections, unknown hosts, SSL handshakes, and unresolved addresses.
   *
   * @param e The Throwable to check.
   * @return true if the error is a client connection error, false otherwise.
   */
  private static boolean isClientConnectionError(Throwable e) {
    return hasErrorClassInCauseChain(e, CLIENT_CONNECTION_EXCEPTIONS);
  }

  private static boolean isClientAuthenticationError(Throwable e) {
    return hasErrorClassInCauseChain(e, AUTHENTICATION_EXCEPTION_CLASSES);
  }

  /**
   * Recursively checks the throwable and its cause chain for any of the specified error classes.
   *
   * @param t The Throwable to check.
   * @param errorClasses A set of class objects to check against.
   * @return true if an error from the set is found in the cause chain, false otherwise.
   */
  private static boolean hasErrorClassInCauseChain(
      Throwable t, Set<Class<? extends Throwable>> errorClasses) {
    Throwable current = t;
    while (current != null) {
      for (Class<? extends Throwable> errorClass : errorClasses) {
        if (errorClass.isInstance(current)) {
          return true;
        }
      }
      current = current.getCause();
    }
    return false;
  }
}
