/*
 * Copyright 2024 Google LLC
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

import com.google.cloud.bigquery.jdbc.BigQueryJdbcCustomLogger;

public class BigQueryJdbcRuntimeException extends RuntimeException {

  private static final BigQueryJdbcCustomLogger LOG =
      new BigQueryJdbcCustomLogger(BigQueryJdbcRuntimeException.class.getName());

  /**
   * Constructs a new BigQueryJdbcRuntimeException with the given message.
   *
   * @param message The detail message.
   */
  public BigQueryJdbcRuntimeException(String message) {
    super(message);
    LOG.severe(message, this);
  }

  /**
   * Constructs a new BigQueryJdbcRuntimeException from a Throwable exception.
   *
   * @param ex Throwable to be thrown.
   */
  public BigQueryJdbcRuntimeException(Throwable ex) {
    super(ex);
    LOG.severe(ex.getMessage(), this);
  }

  /**
   * Constructs a new BigQueryJdbcRuntimeException from a Throwable exception and a message.
   *
   * @param message The detail message.
   * @param ex Throwable to be thrown.
   */
  public BigQueryJdbcRuntimeException(String message, InterruptedException ex) {
    super(message, ex);
    LOG.severe(message, this);
  }

  public BigQueryJdbcRuntimeException(String message, Throwable ex) {
    super(message, ex);
    LOG.severe(message, this);
  }
}
