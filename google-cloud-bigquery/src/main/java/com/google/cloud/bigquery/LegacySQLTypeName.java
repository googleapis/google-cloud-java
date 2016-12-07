/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.cloud.bigquery;

/**
 * A type used in legacy SQL contexts. NOTE: some contexts use a mix of types; for example,
 * for queries that use standard SQL, the return types are the legacy SQL types.
 *
 * @see <a href="https://cloud.google.com/bigquery/data-types">https://cloud.google.com/bigquery/data-types</a>
 */
public enum LegacySQLTypeName {
  /** Variable-length binary data. */
  BYTES(StandardSQLTypeName.BYTES),
  /** Variable-length character (Unicode) data. */
  STRING(StandardSQLTypeName.STRING),
  /** A 64-bit signed integer value. */
  INTEGER(StandardSQLTypeName.INT64),
  /** A 64-bit IEEE binary floating-point value. */
  FLOAT(StandardSQLTypeName.FLOAT64),
  /** A Boolean value (true or false). */
  BOOLEAN(StandardSQLTypeName.BOOL),
  /** Represents an absolute point in time, with microsecond precision. */
  TIMESTAMP(StandardSQLTypeName.TIMESTAMP),
  /** Represents a logical calendar date. Note, support for this type is limited in legacy SQL. */
  DATE(StandardSQLTypeName.DATE),
  /**
   * Represents a time, independent of a specific date, to microsecond precision. Note, support for
   * this type is limited in legacy SQL.
   */
  TIME(StandardSQLTypeName.TIME),
  /**
   * Represents a year, month, day, hour, minute, second, and subsecond (microsecond precision).
   * Note, support for this type is limited in legacy SQL.
   */
  DATETIME(StandardSQLTypeName.DATETIME),
  /** A record type with a nested schema. */
  RECORD(StandardSQLTypeName.STRUCT);

  private StandardSQLTypeName equivalent;

  LegacySQLTypeName(StandardSQLTypeName equivalent) {
    this.equivalent = equivalent;
  }

  /**
   * Provides the standard SQL type name equivalent to this type name.
   */
  public StandardSQLTypeName getStandardType() {
    return equivalent;
  }
}
