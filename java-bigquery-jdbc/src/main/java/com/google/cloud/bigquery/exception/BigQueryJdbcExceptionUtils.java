/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.exception;

import com.google.cloud.bigquery.BigQueryException;

/** Utility class for JDBC exceptions. */
final class BigQueryJdbcExceptionUtils {

  private BigQueryJdbcExceptionUtils() {
    // Utility class, prevent instantiation
  }

  /**
   * Formats the exception message by appending the cause's message (or toString if null) on a
   * newline.
   *
   * @param message The custom detail message.
   * @param cause The underlying cause of the exception.
   * @return The formatted message.
   */
  public static String formatMessage(String message, Throwable cause) {
    return message
        + (cause != null
            ? "\n" + (cause.getMessage() != null ? cause.getMessage() : cause.toString())
            : "");
  }

  /**
   * Maps a cause to a standard SQL:2003 SQLState.
   *
   * <p>Returns {@code HY000} (general error) for anything unrecognised, so the result is always a
   * valid 5-character state and never null.
   *
   * @param cause the underlying cause, may be null.
   * @return a 5-character SQLState.
   */
  static String sqlStateForCause(Throwable cause) {
    if (!(cause instanceof BigQueryException)) {
      return BigQueryJdbcSqlStates.GENERAL_ERROR;
    }
    String reason = ((BigQueryException) cause).getReason();
    if (reason == null) {
      return BigQueryJdbcSqlStates.GENERAL_ERROR;
    }
    switch (reason) {
      case "invalidQuery":
      case "invalid":
      case "badRequest":
        return BigQueryJdbcSqlStates.SYNTAX_ERROR_OR_ACCESS_RULE_VIOLATION;
      case "accessDenied":
        return BigQueryJdbcSqlStates.INSUFFICIENT_PRIVILEGE;
      case "invalidUser":
        return BigQueryJdbcSqlStates.INVALID_AUTHORIZATION;
      case "quotaExceeded":
      case "rateLimitExceeded":
      case "resourcesExceeded":
        return BigQueryJdbcSqlStates.INSUFFICIENT_RESOURCES;
      case "responseTooLarge":
        return BigQueryJdbcSqlStates.PROGRAM_LIMIT_EXCEEDED;
      case "stopped":
        return BigQueryJdbcSqlStates.QUERY_CANCELED;
      case "backendError":
      case "internalError":
      case "jobInternalError":
        return BigQueryJdbcSqlStates.SYSTEM_ERROR;
      case "notImplemented":
        return BigQueryJdbcSqlStates.FEATURE_NOT_SUPPORTED;
      default:
        return BigQueryJdbcSqlStates.GENERAL_ERROR;
    }
  }
}
