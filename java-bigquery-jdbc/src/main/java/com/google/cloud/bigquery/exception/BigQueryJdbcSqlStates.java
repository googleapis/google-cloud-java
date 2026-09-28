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

/**
 * Standard SQL:2003 SQLState codes used by the driver.
 *
 * <p>A SQLState is a 5-character code: a 2-character class followed by a 3-character subclass.
 * These values are defined by the SQL standard and are portable across databases; nothing here is
 * BigQuery-specific. {@code BigQueryDatabaseMetaData.getSQLStateType()} declares that the driver
 * emits SQL:2003 states, so do not mix in X/Open or ODBC-only codes.
 */
final class BigQueryJdbcSqlStates {

  /** 08 — connection exception. */
  static final String CONNECTION_EXCEPTION = "08006";

  /** 0A — feature not supported. */
  static final String FEATURE_NOT_SUPPORTED = "0A000";

  /** 22 — data exception (bad value, failed conversion). */
  static final String DATA_EXCEPTION = "22000";

  /** 28 — invalid authorization specification (authentication failed). */
  static final String INVALID_AUTHORIZATION = "28000";

  /** 42 — syntax error or access rule violation. */
  static final String SYNTAX_ERROR_OR_ACCESS_RULE_VIOLATION = "42000";

  static final String INSUFFICIENT_PRIVILEGE = "42501";

  /** 53 — insufficient resources. */
  static final String INSUFFICIENT_RESOURCES = "53000";

  /** 54 — program limit exceeded. */
  static final String PROGRAM_LIMIT_EXCEEDED = "54000";

  /** 57 — operator intervention. */
  static final String QUERY_CANCELED = "57014";

  /** 58 — system error. */
  static final String SYSTEM_ERROR = "58000";

  /** HY — general error; the fallback when nothing more specific applies. */
  static final String GENERAL_ERROR = "HY000";

  private BigQueryJdbcSqlStates() {
    // Utility class, prevent instantiation
  }
}
