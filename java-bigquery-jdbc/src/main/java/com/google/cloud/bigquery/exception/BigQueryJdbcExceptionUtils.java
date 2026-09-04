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
}
