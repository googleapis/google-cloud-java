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
import java.sql.SQLException;

public class BigQueryJdbcException extends SQLException {
  private BigQueryException bigQueryException = null;

  /**
   * Constructs a new BigQueryJdbcException with the given message.
   *
   * @param message The detail message.
   */
  public BigQueryJdbcException(String message) {
    super(message);
  }

  /**
   * Constructs a new BigQueryJdbcException from InterruptedException
   *
   * @param ex The InterruptedException to be thrown.
   */
  public BigQueryJdbcException(InterruptedException ex) {
    super(ex);
  }

  /**
   * Constructs a new BigQueryJdbcException from BigQueryException
   *
   * @param ex The BigQueryException to be thrown.
   */
  public BigQueryJdbcException(BigQueryException ex) {
    super(ex);
    this.bigQueryException = ex;
  }

  /**
   * Construct a new BigQueryJdbcException with the cause.
   *
   * @param message Specific message that is being added to the Exception.
   * @param cause Throwable that is being converted.
   */
  public BigQueryJdbcException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * Constructs a new BigQueryJdbcException with the specified cause and a detail message of
   * (cause==null ? null : cause.toString())
   *
   * @param cause Throwable that is being converted.
   */
  public BigQueryJdbcException(Throwable cause) {
    super(cause);
  }

  public BigQueryException getBigQueryException() {
    return bigQueryException;
  }
}
