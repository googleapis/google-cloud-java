/*
 * Copyright 2016 Google LLC
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

import com.google.api.core.ApiFunction;
import com.google.cloud.StringEnumType;
import com.google.cloud.StringEnumValue;
import java.util.HashMap;
import java.util.Map;

/**
 * A type used in legacy SQL contexts. NOTE: some contexts use a mix of types; for example, for
 * queries that use standard SQL, the return types are the legacy SQL types.
 *
 * @see <a
 *     href="https://cloud.google.com/bigquery/data-types">https://cloud.google.com/bigquery/data-types</a>
 */
public final class LegacySQLTypeName extends StringEnumValue {
  private static final long serialVersionUID = 1421040468991161123L;

  private static final ApiFunction<String, LegacySQLTypeName> CONSTRUCTOR =
      new ApiFunction<String, LegacySQLTypeName>() {
        @Override
        public LegacySQLTypeName apply(String constant) {
          return new LegacySQLTypeName(constant);
        }
      };

  private static final StringEnumType<LegacySQLTypeName> type =
      new StringEnumType<LegacySQLTypeName>(LegacySQLTypeName.class, CONSTRUCTOR);

  /** Variable-length binary data. */
  public static final LegacySQLTypeName BYTES =
      type.createAndRegister("BYTES").setStandardType(StandardSQLTypeName.BYTES);
  /** Variable-length character (Unicode) data. */
  public static final LegacySQLTypeName STRING =
      type.createAndRegister("STRING").setStandardType(StandardSQLTypeName.STRING);
  /** A 64-bit signed integer value. */
  public static final LegacySQLTypeName INTEGER =
      type.createAndRegister("INTEGER").setStandardType(StandardSQLTypeName.INT64);
  /** A 64-bit IEEE binary floating-point value. */
  public static final LegacySQLTypeName FLOAT =
      type.createAndRegister("FLOAT").setStandardType(StandardSQLTypeName.FLOAT64);
  /**
   * A decimal value with 38 digits of precision and 9 digits of scale. Note, support for this type
   * is limited in legacy SQL.
   */
  public static final LegacySQLTypeName NUMERIC =
      type.createAndRegister("NUMERIC").setStandardType(StandardSQLTypeName.NUMERIC);
  /**
   * A decimal value with 76+ digits of precision (the 77th digit is partial) and 38 digits of scale
   */
  public static final LegacySQLTypeName BIGNUMERIC =
      type.createAndRegister("BIGNUMERIC").setStandardType(StandardSQLTypeName.BIGNUMERIC);
  /** A Boolean value (true or false). */
  public static final LegacySQLTypeName BOOLEAN =
      type.createAndRegister("BOOLEAN").setStandardType(StandardSQLTypeName.BOOL);
  /** Represents an absolute point in time, with microsecond precision. */
  public static final LegacySQLTypeName TIMESTAMP =
      type.createAndRegister("TIMESTAMP").setStandardType(StandardSQLTypeName.TIMESTAMP);
  /** Represents a logical calendar date. Note, support for this type is limited in legacy SQL. */
  public static final LegacySQLTypeName DATE =
      type.createAndRegister("DATE").setStandardType(StandardSQLTypeName.DATE);
  /** Represents a set of geographic points, represented as a Well Known Text (WKT) string. */
  public static final LegacySQLTypeName GEOGRAPHY =
      type.createAndRegister("GEOGRAPHY").setStandardType(StandardSQLTypeName.GEOGRAPHY);
  /**
   * Represents a time, independent of a specific date, to microsecond precision. Note, support for
   * this type is limited in legacy SQL.
   */
  public static final LegacySQLTypeName TIME =
      type.createAndRegister("TIME").setStandardType(StandardSQLTypeName.TIME);
  /**
   * Represents a year, month, day, hour, minute, second, and subsecond (microsecond precision).
   * Note, support for this type is limited in legacy SQL.
   */
  public static final LegacySQLTypeName DATETIME =
      type.createAndRegister("DATETIME").setStandardType(StandardSQLTypeName.DATETIME);
  /** A record type with a nested schema. */
  public static final LegacySQLTypeName RECORD =
      type.createAndRegister("RECORD").setStandardType(StandardSQLTypeName.STRUCT);

  private static Map<StandardSQLTypeName, LegacySQLTypeName> standardToLegacyMap = new HashMap<>();

  static {
    for (LegacySQLTypeName legacySqlTypeName : LegacySQLTypeName.values()) {
      standardToLegacyMap.put(legacySqlTypeName.equivalent, legacySqlTypeName);
    }
  }

  private StandardSQLTypeName equivalent;

  private LegacySQLTypeName setStandardType(StandardSQLTypeName equivalent) {
    this.equivalent = equivalent;
    return this;
  }

  /** Provides the standard SQL type name equivalent to this type name. */
  public StandardSQLTypeName getStandardType() {
    return equivalent;
  }

  /** Converts StandardSQLTypeName to LegacySQLTypeName */
  public static LegacySQLTypeName legacySQLTypeName(StandardSQLTypeName type) {
    return standardToLegacyMap.get(type);
  }

  private LegacySQLTypeName(String constant) {
    super(constant);
  }

  /**
   * Get the LegacySQLTypeName for the given String constant, and throw an exception if the constant
   * is not recognized.
   */
  public static LegacySQLTypeName valueOfStrict(String constant) {
    return type.valueOfStrict(constant);
  }

  /** Get the LegacySQLTypeName for the given String constant, and allow unrecognized values. */
  public static LegacySQLTypeName valueOf(String constant) {
    return type.valueOf(constant);
  }

  /** Return the known values for LegacySQLTypeName. */
  public static LegacySQLTypeName[] values() {
    return type.values();
  }
}
