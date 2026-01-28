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
import java.sql.SQLFeatureNotSupportedException;

public class BigQueryJdbcSqlFeatureNotSupportedException extends SQLFeatureNotSupportedException {
  /**
   * Constructs a new BigQueryJdbcSqlFeatureNotSupportedException with the given message.
   *
   * @param message The detail message.
   */
  public BigQueryJdbcSqlFeatureNotSupportedException(String message) {
    super(message);
  }

  /**
   * Constructs a new BigQueryJdbcSqlFeatureNotSupportedException from BigQueryException
   *
   * @param ex The BigQueryException to be thrown.
   */
  public BigQueryJdbcSqlFeatureNotSupportedException(BigQueryException ex) {
    super(ex);
  }
}
