/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.bigquery;

import java.sql.SQLException;
import java.util.List;

/**
 * BigQuery service exception.
 *
 * @see <a href="https://cloud.google.com/bigquery/troubleshooting-errors">Google Cloud BigQuery
 *     error codes</a>
 */
public final class BigQuerySQLException extends SQLException {

  private static final long serialVersionUID = -5006625989225438209L;
  private final List<BigQueryError> errors;

  public BigQuerySQLException() {
    this.errors = null;
  }

  public BigQuerySQLException(
      String msg) { // overloaded constructor with just message as an argument
    super(msg);
    this.errors = null;
  }

  public BigQuerySQLException(List<BigQueryError> errors) {
    this.errors = errors;
  }

  public BigQuerySQLException(List<BigQueryError> errors, Throwable cause) {
    super(cause != null ? cause.toString() : null);
    this.errors = errors;
  }

  public BigQuerySQLException(String reason, List<BigQueryError> errors) {
    super(reason);
    this.errors = errors;
  }

  public BigQuerySQLException(String reason, Throwable cause, List<BigQueryError> errors) {
    super(reason, cause);
    this.errors = errors;
  }

  public BigQuerySQLException(String reason, String sqlState, List<BigQueryError> errors) {
    super(reason, sqlState);
    this.errors = errors;
  }

  public BigQuerySQLException(
      String reason, String sqlState, int errorCode, List<BigQueryError> errors) {
    super(reason, sqlState, errorCode);
    this.errors = errors;
  }

  public BigQuerySQLException(
      String reason, String sqlState, int errorCode, Throwable cause, List<BigQueryError> errors) {
    super(reason, sqlState, errorCode, cause);
    this.errors = errors;
  }

  /**
   * Returns a list of {@link BigQueryError}s that caused this exception. Returns {@code null} if
   * none exists.
   */
  public List<BigQueryError> getErrors() {
    return errors;
  }
}
