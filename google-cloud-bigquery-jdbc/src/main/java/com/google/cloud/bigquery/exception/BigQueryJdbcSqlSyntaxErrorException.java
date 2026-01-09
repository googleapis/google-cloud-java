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

import com.google.cloud.bigquery.BigQueryException;
import java.sql.SQLSyntaxErrorException;

/**
 * Specific {@link SQLSyntaxErrorException} thrown when the SQLState class value is '42', or under
 * vendor-specified conditions. This indicates that the in-progress query has violated SQL syntax
 * rules.
 */
public class BigQueryJdbcSqlSyntaxErrorException extends SQLSyntaxErrorException {
  /**
   * Constructs a new BigQueryJdbcSqlSyntaxErrorException from BigQueryException
   *
   * @param ex The BigQueryException to be thrown.
   */
  public BigQueryJdbcSqlSyntaxErrorException(BigQueryException ex) {
    super(ex.getMessage(), "Incorrect SQL syntax.");
  }
}
